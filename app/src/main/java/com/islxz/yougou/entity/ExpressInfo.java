package com.islxz.yougou.entity;

import java.util.List;

/**
 * Created by Qingsu on 2017/6/22.
 */

public class ExpressInfo {

    private String status;
    private String orderId;
    private String expressName;
    private List<String> expressInfo;
    private List<String> dateInfo;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getExpressName() {
        return expressName;
    }

    public void setExpressName(String expressName) {
        this.expressName = expressName;
    }

    public List<String> getExpressInfo() {
        return expressInfo;
    }

    public void setExpressInfo(List<String> expressInfo) {
        this.expressInfo = expressInfo;
    }

    public List<String> getDateInfo() {
        return dateInfo;
    }

    public void setDateInfo(List<String> dateInfo) {
        this.dateInfo = dateInfo;
    }
}
