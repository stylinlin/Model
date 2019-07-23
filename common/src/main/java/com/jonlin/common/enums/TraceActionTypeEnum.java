package com.jonlin.common.enums;

/**
 * Copyright (C), 2017-2018, 上海阁为信息科技有限公司
 * FileName: TraceActionTypeEnum.java
 * Author:   Lct
 * Date:     2018-07-05 11:24
 * Description: 业务追踪状态 Enum
 */
public enum TraceActionTypeEnum {


    TRACE_TO_SUPPLIER("1", "发单给供应商"),

    TRACE_TO_PERSUPPLIER("2", "发单给个体供应商"),

    TRACE_BILL("3", "发单"),

    TRACE_LOT("4", "抓阄"),

    TRACE_DISPATCH("5", "派车"),

    TRACE_STERILIZE("6", "消毒"),

    TRACE_PUTIN_STORAGEWEIGN("7", "入仓称重"),

    TRACE_PUTOUT_STORAGEWEIGN("8", "出仓称重"),

    TRACE_OUTWAREHOUSE("9", "出库"),

    TRACE_SEND("10", "发运"),

    TRACE_SIGN_IN("11", "签收"),

    TRACE_BE_SURE_GATHERING("12", "确认收货"),

    TRACE_SURE_GATHERING("13", "确认收钱"),

    CACELLATION("14", "作废");

    public String status;

    public String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    TraceActionTypeEnum(String status, String message) {
        this.status = status;
        this.message = message;
    }

}
