package com.jonlin.common.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 图片压缩处理
 */
@SuppressWarnings("restriction")
public class ImgCompress {
    private final Image img;
    private final int width;
    private final int height;

    /**
     *  构造函数
     * @param fileName
     * @throws IOException
     */
    public ImgCompress(String fileName) throws IOException {
        File file = new File(fileName);// 读入文件
        img = ImageIO.read(file);      // 构造Image对象
        width = img.getWidth(null);    // 得到源图宽
        height = img.getHeight(null);  // 得到源图长
    }
    /**
     * 按照宽度还是高度进行压缩
     * @param w int 最大宽度
     * @param h int 最大高度
     */
    public Map<String,Object> resizeFix(int w, int h) throws IOException {
        if (width / height > w / h) {
            return  resizeByWidth(w);
        } else {
            return  resizeByHeight(h);
        }
    }
    /**
     * 以宽度为基准，等比例放缩图片
     * @param w int 新宽度
     */
    public Map<String,Object> resizeByWidth(int w) throws IOException {
        int h = height * w / width;
        return resize(w, h);
    }
    /**
     * 以高度为基准，等比例缩放图片
     * @param h int 新高度
     */
    public Map<String,Object> resizeByHeight(int h) throws IOException {
        int w = width * h / height;
        return resize(w, h);
    }
    /**
     * 强制压缩/放大图片到固定的大小
     * @param w int 新宽度
     * @param h int 新高度
     */
    public Map<String,Object> resize(int w, int h) throws IOException {
        byte[] buffer = null;
        Map<String,Object> map =  new HashMap<String,Object>();
        // SCALE_SMOOTH 的缩略算法 生成缩略图片的平滑度的 优先级比速度高 生成的图片质量比较好 但速度慢
        BufferedImage image = new BufferedImage(w, h,BufferedImage.TYPE_INT_RGB );
        //image.getGraphics().drawImage(img, 0, 0, w, h, null); // 绘制缩小后的图
        image.getGraphics().drawImage(img.getScaledInstance(w, h, Image.SCALE_SMOOTH), 0, 0, null);
        String property = System.getProperties().getProperty("os.name");
        String fileName = null ;
        if(property.contains("Windows")){
            fileName = "C://temp";
        }else{
            fileName = "/tmp";
        }
        File destFile = new File(fileName);
        if (!destFile.exists() && !destFile.isDirectory()) {
            destFile.mkdir();
        }
        SimpleDateFormat  format = new SimpleDateFormat("HH");
        Date date = new Date();
        destFile = new File(destFile + "/" + format.format(date));
        if (!destFile.exists() && !destFile.isDirectory()) {
            destFile.mkdir();
        }
        format = new SimpleDateFormat("mm");
        destFile = new File(destFile + "/" + format.format(date));
        if (!destFile.exists() && !destFile.isDirectory()) {
            destFile.mkdir();
        }
        format = new SimpleDateFormat("ss");
        destFile = new File(destFile + "/" + format.format(date));
        if (!destFile.exists() && !destFile.isDirectory()) {
            destFile.mkdir();
        }
        destFile = new File(destFile + "/" + RandomUtil.getRandom(6)+".jpg");
        FileOutputStream out = new FileOutputStream(destFile); // 输出到文件流
        ImageIO.write(image,  "jpeg" ,out );
        image.flush();
        FileInputStream fis = new FileInputStream(destFile);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] b = new byte[1024];
        int n;
        while ((n = fis.read(b)) != -1)
        {
            bos.write(b, 0, n);
        }
        fis.close();
        bos.close();
        buffer = bos.toByteArray();
        map.put("file", destFile);
        map.put("byte", buffer);
        return map;
    }
}
