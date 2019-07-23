package com.jonlin.common.enums;

/**
 * Copyright (C), 2017-2018, 上海阁为信息科技有限公司
 * FileName: DriverStatusEnum.java
 * Author:   Lct
 * Date:     2018-07-19 8:55
 * Description: 运输状态，0:未排队;1:在途;2:排队;3:待发运',
 */
public enum DriverTranStatusEnum {
    NOT_LINE_UP("0", "未排队"),

    IN_TRANSIT("1", "在途"),

    LINE_UP("2", "排队"),

    READEY_FOR_DELIERY("3", "待发运");

    public String status;

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

    public String message;

    DriverTranStatusEnum(String status, String message) {
        this.status = status;
        this.message = message;
    }
}
