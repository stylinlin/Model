package com.jonlin.common.utils;//package com.hgtms.common.utils;
//
///**
// * <br/>
// * 中交信路api工具
// *
// * @author zl
// * @version [V1.0 2018-09-04 10:54]
// */
//
//import com.alibaba.fastjson.JSONArray;
//import com.google.gson.Gson;
//import com.hgtms.common.enums.SinoiovCodeEnum;
//import com.hgtms.common.model.*;
//import com.openapi.sdk.service.DataExchangeService;
//import com.openapi.sdk.service.TransCode;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.StringUtils;
//import org.json.JSONObject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
///***
// * 接口客户端调用示例
// * 该文件使用UTF-8编码格式
// * 执行该例子前，需要导入证书到运行环境：
// * keytool.exe -import -trustcacerts-alias testopen-file "D:\JavaTeam\
// 4__.95155.com.crt" -keystore "d:\JavaTeam\JavaHome\jdk1.6.0_18\jre\li
// b\security\cacerts" -storepasschangeit
// */
//@Slf4j
//@Component
//public class OpenapiUtil {
//    @Autowired
//    SinoiovConfig sinoiovConfig;
//    @Autowired
//    RedisUtils redisUtils;
//
//    public String testConfig() {
//        log.debug("ApiUrl----------------------->" + sinoiovConfig.getApiUrl());
//        return sinoiovConfig.getApiUrl();
//    }
//
//    /**
//     * 获取令牌
//     */
//    public SinoiovToken getToken() {
//        SinoiovToken sinoiovToken = new SinoiovToken();
//        String token = redisUtils.getOnly(RedisKeys.getSinoiovTokenKey());
//        sinoiovToken.setCode(SinoiovCodeEnum.CODE_1001.getCode());
//        sinoiovToken.setToken(token);
//
//        if (StringUtils.isBlank(token)) {
//            String sinoiovTokenValue = login();
//            if (StringUtils.isBlank(sinoiovTokenValue)) {
//                sinoiovToken.setCode(-1);
//                sinoiovToken.setToken("");
//                sinoiovToken.setMsg("获取token失败");
//            } else {
//                JSONObject jsonObject = new JSONObject(sinoiovTokenValue);
//                int code = jsonObject.optInt("status");
//                sinoiovToken.setCode(code);
//                if (code == SinoiovCodeEnum.CODE_1001.getCode()){
//                    sinoiovToken.setToken(jsonObject.optString("result"));
//                    sinoiovToken.setMsg(getErrorMsg(code));
//
//                    String sinoiovTokenKey = RedisKeys.getSinoiovTokenKey();
//                    redisUtils.set(sinoiovTokenKey, sinoiovToken.getToken(), redisUtils.SINOIOV_TOKEN_EXPIRE);
//                }else{
//                    sinoiovToken.setToken("");
//                    sinoiovToken.setMsg(getErrorMsg(code));
//                }
//            }
//        }
//
//        return sinoiovToken;
//    }
//
//    /**
//     * 用户登陆
//     * 用户首次调用接口，须先登录，认证通过后生成令牌。
//     * 令牌有效期默认为3天，登录后之前的令牌将立即失效，多服务调用业务接口时，建议由统一服
//     * 务调用登录接口将令牌缓存起来，多个服务统一从共享缓存中获取令牌。
//     * 令牌失效后再调用登录接口获取令牌，避免频繁调用登录接口，建议一天内登录次数不超过10
//     * 次，超过10次将触发安全系统报警。
//     */
//    private String login() {
//        try {
//            String p = "user=" + sinoiovConfig.getApiUser() + "&pwd=" + sinoiovConfig.getPassword();
//            log.debug("参数:" + p);
//            p = TransCode.encode(p);
//            String url = sinoiovConfig.getApiUrl() + "login/" + p + "?client_id=" + sinoiovConfig.getClient_id();
//            DataExchangeService des = new DataExchangeService(5000, 5000);
//            log.debug("请求地址:" + url);
//            String res = des.accessHttps(url, "POST");
//            log.debug("返回:" + res);
//
//            String decodeStr = TransCode.decode(res);
//
//            return decodeStr;
////            JSONObject sinoiovTokenObj = new JSONObject(decodeStr);
////            if (sinoiovTokenObj.optInt("status") == 1001) {
////                String sinoiovTokenValue = sinoiovTokenObj.optString("result");
////                String sinoiovTokenKey = RedisKeys.getSinoiovTokenKey();
////                redisUtils.set(sinoiovTokenKey, sinoiovTokenValue, redisUtils.SINOIOV_TOKEN_EXPIRE);
////                return sinoiovTokenValue;
////            } else {
////                return "";
////            }
//        } catch (Exception e) {
//            log.error(e.getMessage());
//            return "";
//        }
//
//    }
//
//    /**
//     * 一、 车辆最新位置查询（车牌号）接口
//     * 本接口提供指定车牌号的车辆最新位置查询。
//     * @param carNo 车牌号
//     * @param timeNearby 时间范围，单位:小时，指返回车辆最近时间范围内的最后定位信息
//     */
//    public SinoiovResult vLastLocationV3(String carNo, Integer timeNearby) {
//        SinoiovResult sinoiovResult = new SinoiovResult();
//        try {
//            for (int i = 0; i < 3; i++) {
////            String p = "token=您的令牌&vclN=陕YH0009&timeNearby=30";
//                // 获取token
//                SinoiovToken sinoiovToken = getToken();
//                if (SinoiovCodeEnum.CODE_1001.getCode() != sinoiovToken.getCode()){
//                    sinoiovResult.setCode(sinoiovToken.getCode());
//                    sinoiovResult.setMsg(getErrorMsg(sinoiovToken.getCode()));
//                    break;
////                    return ResultResponse.fail(sinoiovToken.getMsg());
//                }
//                String token = sinoiovToken.getToken();
//
//                String p = "token=" + token + "&vclN=" + carNo + "&timeNearby=" + timeNearby;
//
//                log.debug("参数:" + p);
//                p = TransCode.encode(p);
////            String url = "https://testopen.95155.com/apis/vLastLocation/ " + p+" ? client_id = 您的客户端ID ";
//                String url = sinoiovConfig.getApiUrl() + "vLastLocationV3/" + p + "?client_id=" + sinoiovConfig.getClient_id();
//                DataExchangeService des = new DataExchangeService(5000, 5000);
//                log.debug("请求地址:" + url);
//                String res = des.accessHttps(url, "POST");
//                log.debug("返回:" + res);
//
//                String decodeStr = TransCode.decode(res);
//                JSONObject sinoiovLocationObj = new JSONObject(decodeStr);
//                int code = sinoiovLocationObj.optInt("status");
//                if (code == SinoiovCodeEnum.CODE_1016.getCode()) {
//                    // 令牌失效，清空重试2次
//                    String sinoiovTokenKey = RedisKeys.getSinoiovTokenKey();
//                    redisUtils.delete(redisUtils.addPrefix(sinoiovTokenKey));
//                    if (i == 2){ // 重试两次失败，退出
//                        sinoiovResult.setCode(code);
//                        sinoiovResult.setMsg(getErrorMsg(code));
//                    }
//                } else {
//                    sinoiovResult.setCode(code);
//                    if (SinoiovCodeEnum.CODE_1001.getCode() != code) {
//                        sinoiovResult.setMsg(getErrorMsg(code));
//                    }else{
//                        String resultRP = sinoiovLocationObj.optString("result"); // 参考 LastLocationRP 说明
//                        Gson gson = new Gson();
//                        LastLocationRP lastLocationRP = gson.fromJson(resultRP, LastLocationRP.class);
//                        if (StringUtils.isNotBlank(lastLocationRP.getUtc())){ // 转时间
//                            long lt = new Long(lastLocationRP.getUtc());
//                            Date date = new Date(lt);
//                            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                            String resultUtc = format.format(date);
//                            lastLocationRP.setUtc(resultUtc);
//                        }
//                        sinoiovResult.setContent(lastLocationRP);
//                    }
//                    break;
//                }
//            }
//        } catch (Exception e) {
//            log.error("e:" + e.getMessage());
//            sinoiovResult.setCode(-1);
//            sinoiovResult.setMsg("获取车辆最新位置失败");
//        }
//
//        return sinoiovResult;
//    }
//
//    /**
//     * 一、 车辆最新位置查询（车牌号）接口
//     * 本接口提供指定车牌号的车辆最新位置查询。
//     * @param vin 车架号
//     * @param timeNearby 时间范围，单位:小时，指返回车辆最近时间范围内的最后定位信息
//     */
//    public SinoiovResult vLastLocationVinV3(String vin, Integer timeNearby) {
//        SinoiovResult sinoiovResult = new SinoiovResult();
//        try {
//            for (int i = 0; i < 3; i++) {
//                // 获取token
//                SinoiovToken sinoiovToken = getToken();
//                if (SinoiovCodeEnum.CODE_1001.getCode() != sinoiovToken.getCode()){
//                    sinoiovResult.setCode(sinoiovToken.getCode());
//                    sinoiovResult.setMsg(getErrorMsg(sinoiovToken.getCode()));
//                    break;
////                    return ResultResponse.fail(sinoiovToken.getMsg());
//                }
//                String token = sinoiovToken.getToken();
//
//                String p = "token=" + token + "&vin=" + vin + "&timeNearby=" + timeNearby;
//
//                log.debug("参数:" + p);
//                p = TransCode.encode(p);
////            String url = "https://testopen.95155.com/apis/vLastLocation/ " + p+" ? client_id = 您的客户端ID ";
//                String url = sinoiovConfig.getApiUrl() + "vLastLocationV3/" + p + "?client_id=" + sinoiovConfig.getClient_id();
//                DataExchangeService des = new DataExchangeService(5000, 5000);
//                log.debug("请求地址:" + url);
//                String res = des.accessHttps(url, "POST");
//                log.debug("返回:" + res);
//
//                String decodeStr = TransCode.decode(res);
//                JSONObject sinoiovLocationObj = new JSONObject(decodeStr);
//                int code = sinoiovLocationObj.optInt("status");
//                if (code == SinoiovCodeEnum.CODE_1016.getCode()) {
//                    // 令牌失效，清空重试2次
//                    String sinoiovTokenKey = RedisKeys.getSinoiovTokenKey();
//                    redisUtils.delete(redisUtils.addPrefix(sinoiovTokenKey));
//                    if (i == 2){ // 重试两次失败，退出
//                        sinoiovResult.setCode(code);
//                        sinoiovResult.setMsg(getErrorMsg(code));
//                    }
//                } else {
//                    sinoiovResult.setCode(code);
//                    if (SinoiovCodeEnum.CODE_1001.getCode() != code) {
//                        sinoiovResult.setMsg(getErrorMsg(code));
//                    }else{
//                        String resultRP = sinoiovLocationObj.optString("result");
//                        Gson gson = new Gson();
//                        LastLocationRP lastLocationRP = gson.fromJson(resultRP, LastLocationRP.class);
//                        if (StringUtils.isNotBlank(lastLocationRP.getUtc())){ // 转时间
//                            long lt = new Long(lastLocationRP.getUtc());
//                            Date date = new Date(lt);
//                            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                            String resultUtc = format.format(date);
//                            lastLocationRP.setUtc(resultUtc);
//                        }
//                        sinoiovResult.setContent(lastLocationRP);
//                    }
//                    break;
//                }
//            }
//        } catch (Exception e) {
//            log.error("e:" + e.getMessage());
//            sinoiovResult.setCode(-1);
//            sinoiovResult.setMsg("获取车辆最新位置失败");
//        }
//
//        return sinoiovResult;
//    }
//
//    /**
//     * 车辆轨迹查询（车牌号）接口
//     * @param carNo 车牌号
//     * @param qryBtm 查询起始时间（yyyy-MM-dd HH:mm:ss 和 yyyy-MM-dd 格式）
//     *               2014-01-01 09:00:00 或2014-01-01（若为yyyy-MM-dd 格式，则查询指定日期 24 小时内的数据）
//     * @param qryBtm 查询截止时间（yyyy-MM-dd HH:mm:ss 和 yyyy-MM-dd 格式）
//     *               2014-01-01 10:30:25 或2014-01-01（若为yyyy-MM-dd 格式，则查询指定日期 24 小时内的数据）
//     */
//    public SinoiovResult vHisTrack24(String carNo, String qryBtm, String qryEtm) {
//        SinoiovResult sinoiovResult = new SinoiovResult();
//        try {
//            for (int i = 0; i < 3; i++) {
//                // 获取token
//                SinoiovToken sinoiovToken = getToken();
//                if (SinoiovCodeEnum.CODE_1001.getCode() != sinoiovToken.getCode()){
//                    sinoiovResult.setCode(sinoiovToken.getCode());
//                    sinoiovResult.setMsg(getErrorMsg(sinoiovToken.getCode()));
//                    break;
////                    return ResultResponse.fail(sinoiovToken.getMsg());
//                }
//                String token = sinoiovToken.getToken();
//
//                String p = "token=" + token + "&vclN=" + carNo + "&qryBtm=" + qryBtm+ "&qryEtm=" + qryEtm;
//
//                log.debug("参数:" + p);
//                p = TransCode.encode(p);
////            String url = "https://testopen.95155.com/apis/vHisTrack24/ " + p+" ? client_id = 您的客户端ID ";
//                String url = sinoiovConfig.getApiUrl() + "vHisTrack24/" + p + "?client_id=" + sinoiovConfig.getClient_id();
//                DataExchangeService des = new DataExchangeService(5000, 5000);
//                log.debug("请求地址:" + url);
//                String res = des.accessHttps(url, "POST");
//                log.debug("返回:" + res);
//
//                String decodeStr = TransCode.decode(res);
//                JSONObject sinoiovLocationObj = new JSONObject(decodeStr);
//                int code = sinoiovLocationObj.optInt("status");
//                if (code == SinoiovCodeEnum.CODE_1016.getCode()) {
//                    // 令牌失效，清空重试2次
//                    String sinoiovTokenKey = RedisKeys.getSinoiovTokenKey();
//                    redisUtils.delete(redisUtils.addPrefix(sinoiovTokenKey));
//                    if (i == 2){ // 重试两次失败，退出
//                        sinoiovResult.setCode(code);
//                        sinoiovResult.setMsg(getErrorMsg(code));
//                    }
//                } else {
//                    sinoiovResult.setCode(code);
//                    if (SinoiovCodeEnum.CODE_1001.getCode() != code) {
//                        sinoiovResult.setMsg(getErrorMsg(code));
//                    }else{
//                        String resultRP = sinoiovLocationObj.optString("result"); // 参考 LastLocationRP 说明
//                        List<HisTrackPointRP> hisTrackPointRPList = JSONArray.parseArray(resultRP, HisTrackPointRP.class);
//                        sinoiovResult.setContent(hisTrackPointRPList);
//                    }
//                    break;
//                }
//            }
//        } catch (Exception e) {
//            log.error("e:" + e.getMessage());
//            sinoiovResult.setCode(-1);
//            sinoiovResult.setMsg("获取车辆最新位置失败");
//        }
//
//        return sinoiovResult;
//    }
//
//    /**
//     * 获取 智云 错误信息
//     */
//    public String getErrorMsg(int code) {
//        String msg = "智云未知错误";
//        SinoiovCodeEnum[] sinoiovCodeEnums = SinoiovCodeEnum.values();
//        for (SinoiovCodeEnum sinoiovCodeEnum : sinoiovCodeEnums) {
//            if (sinoiovCodeEnum.getCode() == code) {
//                msg = sinoiovCodeEnum.getMsg();
//                break;
//            }
//        }
//        return msg;
//    }
//}
