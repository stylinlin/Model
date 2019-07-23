package com.jonlin.common.utils;


import com.jonlin.common.annotation.ImportExcel;
import com.jonlin.common.model.ExcelEntity;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * excel导入工具类
 */
public class ImportExcelUtil {
    
    private static Logger logger = Logger.getLogger(ImportExcelUtil.class);
    
    private final static String xls = "xls";
    private final static String xlsx = "xlsx";
    
    /**
     * excel数据集合
     */
    private List list = null;
    
    public ImportExcelUtil(MultipartFile file, int rowIndex, Class c) {
        try {
            POIFSFileSystem fs = new POIFSFileSystem(file.getInputStream());    //写入流
            HSSFWorkbook workbook = new HSSFWorkbook(fs);   //创建workbook
            HSSFSheet sheet = workbook.getSheetAt(0);   //获取sheet页
            int rowNum = sheet.getPhysicalNumberOfRows();   //获取总行数
            HSSFRow row = null;
            HSSFCell cell = null;
            List<ExcelEntity> entitys = getExcelEntitys(c); //获取类注解信息
            this.list = new ArrayList();
            for (int i = rowIndex; i < rowNum; i++) {
                row = sheet.getRow(i);  //获取行
                Object objCla = c.newInstance();    //实例化对象
                for (ExcelEntity entity : entitys) {
                    cell = row.getCell(Integer.valueOf(entity.getSort()));  //根据注释下标获得对应的单元格
                    Method method = c.getMethod(entity.getFieldName(), entity.getClassType()); //获取属性的set方法
                    System.out.println(cell.getCellTypeEnum());
                    //获取属性set方法的返回值
                    if ("STRING".equals(cell.getCellTypeEnum().toString())) {
                        Object invoke = method.invoke(objCla, cell.getStringCellValue());
                    } else if ("NUMERIC".equals(cell.getCellTypeEnum().toString())) {
                        Object invoke = method.invoke(objCla, cell.getNumericCellValue() + "");
                    } else if ("BOOLEAN".equals(cell.getCellTypeEnum().toString())) {
                        Object invoke = method.invoke(objCla, cell.getBooleanCellValue() + "");
                    } else if ("DATE".equals(cell.getCellTypeEnum().toString())) {
                        Object invoke = method.invoke(objCla, DateUtils.format(cell.getDateCellValue()));
                    }
                }
                this.list.add(objCla);   //将excel获取的数据添加到集合当中。
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ImportExcelUtil(MultipartFile file, Class c) {
        try {
            Workbook workbook = getWorkBook(file);
            List<ExcelEntity> entitys = getExcelEntitys(c); //获取类注解信息
            this.list = new ArrayList();
            Cell cell = null;
            if (workbook != null) {
                Sheet sheet = workbook.getSheetAt(0);
                int firstRowNum = sheet.getFirstRowNum();
                int lastRowNum = sheet.getLastRowNum();
                for (int rowNum = firstRowNum + 1; rowNum <= lastRowNum; rowNum++) {
                    Row row = sheet.getRow(rowNum);
                    Object objCla = c.newInstance();    //实例化对象
                    for (ExcelEntity entity : entitys) {
                        cell = row.getCell(Integer.valueOf(entity.getSort()));  //根据注释下标获得对应的单元格
                        Method method = c.getMethod(entity.getFieldName(), entity.getClassType()); //获取属性的set方法
                        //System.out.println(cell.getCellTypeEnum());
                        //获取属性set方法的返回值
                        
                        Object invoke = method.invoke(objCla, getCellVal(cell));
                    }
                    
                    this.list.add(objCla);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 获取类注解信息
     */
    private List<ExcelEntity> getExcelEntitys(Class c) {
        List<ExcelEntity> list = new ArrayList<>();
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(ImportExcel.class)) {
                ImportExcel importExcel = field.getAnnotation(ImportExcel.class);
                list.add(new ExcelEntity(importExcel, field.getName(), field.getType()));
            }
        }
        return list;
    }
    
    public List getList() {
        return list;
    }
    
    public void setList(List list) {
        this.list = list;
    }
    
    public static List<String[]> readExcel(MultipartFile file) throws IOException {
        //检查文件
        checkFile(file);
        //获得Workbook工作薄对象
        Workbook workbook = getWorkBook(file);
        //创建返回对象，把每行中的值作为一个数组，所有行作为一个集合返回
        List<String[]> list = new ArrayList<String[]>();
        if (workbook != null) {
            for (int sheetNum = 0; sheetNum < workbook.getNumberOfSheets(); sheetNum++) {
                //获得当前sheet工作表
                Sheet sheet = workbook.getSheetAt(sheetNum);
                if (sheet == null) {
                    continue;
                }
                //获得当前sheet的开始行
                int firstRowNum = sheet.getFirstRowNum();
                //获得当前sheet的结束行
                int lastRowNum = sheet.getLastRowNum();
                //循环除了第一行的所有行
                for (int rowNum = firstRowNum + 1; rowNum <= lastRowNum; rowNum++) {
                    //获得当前行
                    Row row = sheet.getRow(rowNum);
                    if (row == null) {
                        continue;
                    }
                    //获得当前行的开始列
                    int firstCellNum = row.getFirstCellNum();
                    //获得当前行的列数
                    int lastCellNum = row.getPhysicalNumberOfCells();
                    String[] cells = new String[row.getPhysicalNumberOfCells()];
                    //循环当前行
                    for (int cellNum = firstCellNum; cellNum < lastCellNum; cellNum++) {
                        Cell cell = row.getCell(cellNum);
                        cells[cellNum] = getCellValue(cell);
                    }
                    list.add(cells);
                }
            }
            workbook.close();
        }
        return list;
    }
    
    public static void checkFile(MultipartFile file) throws IOException {
        //判断文件是否存在
        if (null == file) {
            logger.error("文件不存在！");
            throw new FileNotFoundException("文件不存在！");
        }
        //获得文件名
        String fileName = file.getOriginalFilename();
        //判断文件是否是excel文件
        if (!fileName.endsWith(xls) && !fileName.endsWith(xlsx)) {
            logger.error(fileName + "不是excel文件");
            throw new IOException(fileName + "不是excel文件");
        }
    }
    
    public static Workbook getWorkBook(MultipartFile file) {
        //获得文件名
        String fileName = file.getOriginalFilename();
        //创建Workbook工作薄对象，表示整个excel
        Workbook workbook = null;
        try {
            //获取excel文件的io流
            InputStream is = file.getInputStream();
            //根据文件后缀名不同(xls和xlsx)获得不同的Workbook实现类对象
            if (fileName.endsWith(xls)) {
                //2003
                workbook = new HSSFWorkbook(is);
            } else if (fileName.endsWith(xlsx)) {
                //2007
                workbook = new XSSFWorkbook(is);
            }
        } catch (IOException e) {
            logger.info(e.getMessage());
        }
        return workbook;
    }
    
    public static String getCellValue(Cell cell) {
        String cellValue = "";
        if (cell == null) {
            return cellValue;
        }
        //把数字当成String来读，避免出现1读成1.0的情况
        if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            cell.setCellType(Cell.CELL_TYPE_STRING);
        }
        //判断数据的类型
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_NUMERIC: //数字
                if(HSSFDateUtil.isCellDateFormatted(cell)) {
                    Date date = cell.getDateCellValue();
                    DateFormat formater = new SimpleDateFormat(
                            "yyyy-MM-dd");
                    cellValue = formater.format(date);
                } else {
                    cellValue = String.valueOf(cell.getNumericCellValue());
                }
                break;
            case Cell.CELL_TYPE_STRING: //字符串
                cellValue = String.valueOf(cell.getStringCellValue());
                break;
            case Cell.CELL_TYPE_BOOLEAN: //Boolean
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_FORMULA: //公式
                cellValue = String.valueOf(cell.getCellFormula());
                break;
            case Cell.CELL_TYPE_BLANK: //空值
                cellValue = "";
                break;
            case Cell.CELL_TYPE_ERROR: //故障
                cellValue = "非法字符";
                break;
            default:
                cellValue = "未知类型";
                break;
        }
        return cellValue;
    }
    
    public static String getCellVal(Cell cell) {
        String cellValue = "";
        if (cell == null) {
            return cellValue;
        }

        //判断数据的类型
        switch (cell.getCellTypeEnum().toString()) {
            case "NUMERIC": //数字
                if(HSSFDateUtil.isCellDateFormatted(cell)) {
                    Date date = cell.getDateCellValue();
                    DateFormat formater = new SimpleDateFormat(
                            "yyyy-MM-dd");
                    cellValue = formater.format(date);
                } else {
                    //  判断是否为科学计数法（包含E、e、+等符号）
                    if (("" + cell.getNumericCellValue()).indexOf("E") != -1 || ("" + cell.getNumericCellValue()).indexOf("e") != -1 || ("" + cell.getNumericCellValue()).indexOf("+") != -1) {
                        BigDecimal bd = new BigDecimal("" + cell.getNumericCellValue());
                        cellValue = bd.toPlainString();
                    } else {
                        cellValue = String.valueOf(cell.getNumericCellValue());
                    }

                    String [] str = cellValue.split("\\.");
                    if (str.length > 1) {
                        if(str[1].equals("0")) {
                            cellValue = str[0];
                        }
                    }
                }
                break;
            case "STRING": //字符串
                cellValue = String.valueOf(cell.getStringCellValue());
                break;
            case "BOOLEAN": //Boolean
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case "FORMULA": //公式
                cellValue = String.valueOf(cell.getCellFormula());
                break;
            case "BLANK": //空值
                cellValue = "";
                break;
            case "ERROR": //故障
                cellValue = "非法字符";
                break;
            default:
                cellValue = "未知类型";
                break;
        }
        
        return cellValue;
    }
}
