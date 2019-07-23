package com.jonlin.common.utils;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 错误码帮助类<br/>
 *
 * @author hyz
 * @version [V1.0 2017-08-04-12:18]
 */
public class ErrorCodeUtil {

    /**
     * 日志记录器
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(ErrorCodeUtil.class);

    /**
     * 错误信息配置文件
     */
    private final static String ERROR_CODE_PROP = "conf/error.properties";

    /**
     * 配置
     */
    private static PropertiesConfiguration properties = null;

    /**
     *
     * 功能描述: <br>
     * 加载配置文件
     *
     * @author hyz
     * @version [版本号, 2017年8月4日]
     */
    private static void loadProperties() {
        properties = new PropertiesConfiguration();
        properties.setEncoding("utf-8");
        properties.setFileName(ERROR_CODE_PROP);
        try {
            properties.load();
        } catch (Exception e) {
            LOGGER.error("------ 加载错误码配置文件出现异常 ------", e);
            try {
                properties.load();
            } catch (Exception e1) {
                LOGGER.error("------ 第二次尝试加载错误码配置文件出现异常 ------", e1);
            }
        }
    }

    /**
     *
     * 功能描述: <br>
     * 根据键来获取资源文件中的值
     *
     * @author hyz
     * @version [版本号, 2017年8月4日]
     * @param key : 键
     * @return 值
     */
    public static String get(String key) {
        // 判断配置文件是否加载过
        if (properties == null) {
            // 加载配置文件
            loadProperties();
        }
        // 获取
        String value = null;
        if (properties.containsKey(key)) {
            value = properties.getString(key);
        } else {
            LOGGER.error("------ 没有找到错误码对应的信息，key:" + key + " ------");
        }

        return value;
    }

    /**
     *
     * 功能描述: <br>
     * 获取动态提示信息
     *
     * @author hyz
     * @version [版本号, 2017年8月4日]
     * @param key 键
     * @param args 动态参数
     * @return 动态提示
     */
    public static String getArgs(String key, Object[] args) {
        // 判断配置文件是否加载过
        if (properties == null) {
            // 加载配置文件
            loadProperties();
        }
        // 获取
        String value = null;
        if (properties.containsKey(key)) {
            value = properties.getString(key);
            // 填入参数
            String.format(value, args);
        } else {
            LOGGER.error("------ 没有找到错误码对应的信息，key:" + key + " ------");
        }

        return value;
    }
}
