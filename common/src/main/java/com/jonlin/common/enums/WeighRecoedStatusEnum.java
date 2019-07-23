package com.jonlin.common.enums;

/**
 * Copyright (C), 2017-2018, 上海阁为信息科技有限公司
 * FileName: WeighRecoedStatusEnum.java
 * Author:   Lct
 * Date:     2018-07-03 14:02
 * Description: 称重记录枚举
 */
public enum WeighRecoedStatusEnum {

    PUT_IN("1", "入仓"),
    PUT_OUT("2", "出仓");

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

    WeighRecoedStatusEnum(String status, String message) {
        this.status = status;
        this.message = message;
    }


}
