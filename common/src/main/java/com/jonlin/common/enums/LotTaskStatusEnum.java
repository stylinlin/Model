package com.jonlin.common.enums;

/**
 * Copyright (C), 2017-2018, 上海阁为信息科技有限公司
 * FileName: LotTaskStatusEnum.java
 * Author:   Lct
 * Date:     2018-07-19 9:18
 * Description: 抓阄任务 Enum 状态 1:待抓;2:已抓:3:取消',
 */
public enum LotTaskStatusEnum {

    WAITING_LOT("1", "待抓"),
    ALREADY_LOT("2", "已抓"),
    CANCEL_LOT("3", "取消");

    LotTaskStatusEnum(String status, String message) {
        this.status = status;
        this.message = message;
    }

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

    public String status;
    public String message;
}
