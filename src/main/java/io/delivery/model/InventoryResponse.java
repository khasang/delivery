package io.delivery.model;

import java.io.Serializable;

public class InventoryResponse implements Serializable {
    private String orderId;
    private int returnCode;
    private String comment;

    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public int getReturnCode() {
        return returnCode;
    }
    public void setReturnCode(int returnCode) {
        this.returnCode = returnCode;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    @Override
    public String toString() {
        return "InventoryResponse [orderId=" + orderId + ", returnCode=" + returnCode + ", comment=" + comment
                + "]";
    }

