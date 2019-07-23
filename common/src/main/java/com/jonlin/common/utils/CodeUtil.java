package com.jonlin.common.utils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 编号Util<br/>
 *  注意：redis的key统一转成了大写，不敏感，注意不能定义重复key值
 * @author hyz
 * @version [V1.0 2017-11-29 11:19]
 */
@Component
public class CodeUtil {
    @Autowired
    private RedisUtils redisUtils;

    private static String ORDER_PREFIX = "YH-HH"; // 计划单前缀

    private static String NUM_DEFAULT = "1"; // 递增起点

    private static String DEALER_PREFIX = "D"; // 经销商前缀

    private static String INDIVIDUALSUPPLIER_PREFIX = "IS"; // 个体供应商前缀

    private static String SUPPLIER_PREFIX = "S"; // 供应商前缀

    private static String USER_CODING = "EMP"; // 用户前缀

    private static String SETTLEMENT_UNIT = "UNIT"; // 结算单位

    private static String DRIVER_PREFIX = "HGSJ"; // 个体供应商前缀

    /**
     * 生成计划单编号
     */
    public String getOrderNo() {
        String key = RedisKeys.getOrderNoKey();//获得key  设置key 为orderNo
        String resultRedis = redisUtils.get(key);//value
        if (StringUtils.isEmpty(resultRedis)){
            redisUtils.set(key, NUM_DEFAULT, redisUtils.NOT_EXPIRE);
            resultRedis = redisUtils.get(key);//resultRedis=1
        }

        Integer newValue =  redisUtils.increase(resultRedis);//增加1
        redisUtils.set(key, newValue, redisUtils.NOT_EXPIRE); // 使用完增1,将增加后的再重新赋值

        String formatStr = String.format("%04d", newValue -1); // 不足四位补零
        String result = ORDER_PREFIX + formatStr;
        return result;
    }


    /**
     * 生成经销商Code
     */
    public String getDealerCode() {
        String key = RedisKeys.getDealerKey();
        String resultRedis = redisUtils.get(key);
        if (StringUtils.isEmpty(resultRedis)){
            redisUtils.set(key, NUM_DEFAULT, redisUtils.NOT_EXPIRE);
            resultRedis = redisUtils.get(key);
        }
        Integer newValue =  redisUtils.increase(resultRedis);
        redisUtils.set(key, newValue, redisUtils.NOT_EXPIRE); // 使用完增1

        String formatStr = String.format("%05d", newValue -1); // 不足五位补零
        String result = DEALER_PREFIX + formatStr;
        return result;
    }

    /**
     * 生成个体供应商code
     */
    public String getIndividualSupplierCode() {
        String key = RedisKeys.getIndividualSupplierKey();
        String resultRedis = redisUtils.get(key);
        if (StringUtils.isEmpty(resultRedis)){
            redisUtils.set(key, NUM_DEFAULT, redisUtils.NOT_EXPIRE);
            resultRedis = redisUtils.get(key);
        }
        Integer newValue =  redisUtils.increase(resultRedis);
        redisUtils.set(key, newValue, redisUtils.NOT_EXPIRE); // 使用完增1

        String formatStr = String.format("%05d", newValue -1); // 不足五位补零
        String result = INDIVIDUALSUPPLIER_PREFIX + formatStr;
        return result;
    }

    /**
     * 生成供应商code
     */
    public String getSupplierCode() {
        String key = RedisKeys.getSupplierKey();
        String resultRedis = redisUtils.get(key);
        if (StringUtils.isEmpty(resultRedis)){
            redisUtils.set(key, NUM_DEFAULT, redisUtils.NOT_EXPIRE);
            resultRedis = redisUtils.get(key);
        }
        Integer newValue =  redisUtils.increase(resultRedis);
        redisUtils.set(key, newValue, redisUtils.NOT_EXPIRE); // 使用完增1

        String formatStr = String.format("%05d", newValue -1); // 不足五位补零
        String result = SUPPLIER_PREFIX + formatStr;
        return result;
    }
    /**
     * 生成用户code
     */
    public String getUserCode() {
        String key = RedisKeys.getUserKey();
        String resultRedis = redisUtils.get(key);
        if (StringUtils.isEmpty(resultRedis)){
            redisUtils.set(key, NUM_DEFAULT, redisUtils.NOT_EXPIRE);
            resultRedis = redisUtils.get(key);
        }
        Integer newValue =  redisUtils.increase(resultRedis);
        redisUtils.set(key, newValue, redisUtils.NOT_EXPIRE); // 使用完增1

        String formatStr = String.format("%05d", newValue -1); // 不足五位补零
        String result = USER_CODING + formatStr;
        return result;
    }
    /**
     * 生成用户code
     */
    public String getUnitCode() {
        String key = RedisKeys.getUnitKey();
        String resultRedis = redisUtils.get(key);
        if (StringUtils.isEmpty(resultRedis)){
            redisUtils.set(key, NUM_DEFAULT, redisUtils.NOT_EXPIRE);
            resultRedis = redisUtils.get(key);
        }
        Integer newValue =  redisUtils.increase(resultRedis);
        redisUtils.set(key, newValue, redisUtils.NOT_EXPIRE); // 使用完增1

        String formatStr = String.format("%05d", newValue -1); // 不足五位补零
        String result = SETTLEMENT_UNIT + formatStr;
        return result;
    }

    /**
     * 生成司机code
     */
    public String getDriverCode() {
        String key = RedisKeys.getDriverCode();
        String resultRedis = redisUtils.get(key);
        if (StringUtils.isEmpty(resultRedis)){
            redisUtils.set(key, NUM_DEFAULT, redisUtils.NOT_EXPIRE);
            resultRedis = redisUtils.get(key);
        }
        Integer newValue =  redisUtils.increase(resultRedis);
        redisUtils.set(key, newValue, redisUtils.NOT_EXPIRE); // 使用完增1

        String formatStr = String.format("%05d", newValue -1); // 不足五位补零
        String result = DRIVER_PREFIX + formatStr;
        return result;
    }
}
