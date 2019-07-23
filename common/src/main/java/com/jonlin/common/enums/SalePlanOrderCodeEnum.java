package com.jonlin.common.enums;

/**
 * Copyright (C), 2017-2018, 上海阁为信息科技有限公司
 * FileName: SalePlanOrderCodeEnum.java
 * Author:   Lct
 * Date:     2018-07-03 11:57
 * Description: 计划单 状态枚举
 */
public enum SalePlanOrderCodeEnum {
    WAITBILL("0", "待发单"),

    ORDER_TO_SUPPLIER("1", "发单给供应商"),

    ORDER_TO_PERSUPPLIER("2", "发单给个体供应商"),

    WAITLOT("3", "待抓阄"),

    WAITDISPATCH("4", "待派车"),

    WAITSTERILIZE("5", "待消毒"),

    WAIT_PUTIN_STORAGEWEIGN("6", "待入仓过磅"),

    WAIT_PUTOUT_STORAGEWEIGN("7", "待出仓过磅"),

    WAIT_OUTWAREHOUSE("8", "待出库"),

    WAIT_SEND("9", "待发运"),

    WAIT_SIGN_IN("10", "待签收"),

    WAIT_BE_SURE_GATHERING("11", "待确认收款"),

    END("12", "结束"),

    CACELLATION("13", "作废"),

    PART_LOAD("14", "部分装车"),

    TOTAL_LOAD("15", "部分装车");

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

    SalePlanOrderCodeEnum(String status, String message) {
        this.status = status;
        this.message = message;
    }
}
