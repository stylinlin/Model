package com.jonlin.common.enums;

/**
 * <br/>
 * 智云api code
 * @author zl
 * @version [V1.0 2017/6/27 16:42]
 */
public enum SinoiovCodeEnum {
    CODE_1001(1001, "接口执行成功"),
    CODE_1002(1002, "参数不正确（参数为空、查询时间范围不正确、参数数量不正确）"),
    CODE_1003(1003, "车辆调用数量已达上限"),
    CODE_1004(1004, "接口调用次数已达上限"),
    CODE_1005(1005, "该 API 账号未授权指定所属行政区划数据范围"),
    CODE_1006(1006, "无结果"),
    CODE_1010(1010, "用户名或密码不正确"),
    CODE_1011(1011, "IP 不在白名单列表"),
    CODE_1012(1012, "账号已禁用"),
    CODE_1013(1013, "账号已过有效期"),
    CODE_1014(1014, "无接口权限"),
    CODE_1015(1015, "用户认证系统已升级，请使用令牌访问"),
    CODE_1016(1016, "令牌失效"),
    CODE_1017(1017, "账号欠费"),
    CODE_1018(1018, "授权的接口已禁用"),
    CODE_1019(1019, "授权的接口已过期"),
    CODE_1020(1020, "该车调用次数已达上限"),
    CODE_1021(1021, "client_id 不正确"),
    CODE_9001(9001, "系统异常"),
    ;
    private int code;
    private String msg;

    SinoiovCodeEnum(int code, String msg){
        this.code = code;
        this.msg = msg;
    }
    public int getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }

}
