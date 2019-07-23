/**
 * Copyright 2018 人人开源 http://www.renren.io
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.jonlin.common.utils;

/**
 * Redis所有Keys
 *
 * @author Mark sunlightcs@gmail.com
 * @since 3.0.0 2017-07-18
 */
public class RedisKeys {

    public static String getSysConfigKey(String key){
        return "sys:config:" + key;
    }

    public static String getShiroSessionKey(String key){
        return "sessionid:" + key;
    }

    /**
     * 计划单 数字部分 key
     */
    public static String getOrderNoKey(){
        return "orderno";
    }

    /**
     * 经销商 数字部分 key
     */
    public static String getDealerKey(){
        return "dealer";
    }
    /**
     * 个体供应商 数字部分 key
     */
    public static String getIndividualSupplierKey(){
        return "individualSupplier";
    }
    /**
     * 供应商 数字部分 key
     */
    public static String getSupplierKey(){
        return "supplier";
    }
    /**
     * 用户 数字部分 key
     */
    public static String getUserKey(){
        return "user";
    }
    /**
     * 用户 数字部分 key
     */
    public static String getUnitKey(){
        return "unit";
    }

    /**
     * 司机code
     */
    public static String getDriverCode(){
        return "driver";
    }

    /**
     * 司机token key 前缀(调整后为中间部分，前面有hgtms:dev:,后面为UUID)
     * @param driverCode 司机code
     */
    public static String getDriverTokenKeyPrefix(String driverCode){
        return "APP_TOKEN_" + driverCode + "_";
    }

    /**
     * 智运令牌 token key
     */
    public static String getSinoiovTokenKey(){
        return "sinoiov_token";
    }
}
