package io.delivery.model;

import java.io.Serializable;

public class InventoryResponse implements Serializable {
    private String orderId;
    private int returnCode;
    private String comment;

    public String getProductId() {
        return orderId;
    }
    public void setProductId(String productId) {
        this.orderId = productId;
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
        return "InventoryResponse [productId=" + orderId + ", returnCode=" + returnCode + ", comment=" + comment
                + "]";
    }

}
