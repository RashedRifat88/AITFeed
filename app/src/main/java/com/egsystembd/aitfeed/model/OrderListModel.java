package com.egsystembd.aitfeed.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class OrderListModel {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("data")
    @Expose
    private List<Data> data = null;
    @SerializedName("message")
    @Expose
    private String message;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public class Data {

        @SerializedName("order_id")
        @Expose
        private Integer orderId;
        @SerializedName("order_total")
        @Expose
        private String orderTotal;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("receiver_bank_account_id")
        @Expose
        private String receiverBankAccountId;
        @SerializedName("sender_bank_branch")
        @Expose
        private String senderBankBranch;
        @SerializedName("sender_money_receipt_reference")
        @Expose
        private String senderMoneyReceiptReference;
        @SerializedName("truck_reg_no")
        @Expose
        private String truckRegNo;
        @SerializedName("truck_driver_name")
        @Expose
        private String truckDriverName;
        @SerializedName("truck_driver_mobile")
        @Expose
        private String truckDriverMobile;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("created_by")
        @Expose
        private String createdBy;
        @SerializedName("updated_by")
        @Expose
        private Object updatedBy;

        public Integer getOrderId() {
            return orderId;
        }

        public void setOrderId(Integer orderId) {
            this.orderId = orderId;
        }

        public String getOrderTotal() {
            return orderTotal;
        }

        public void setOrderTotal(String orderTotal) {
            this.orderTotal = orderTotal;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getReceiverBankAccountId() {
            return receiverBankAccountId;
        }

        public void setReceiverBankAccountId(String receiverBankAccountId) {
            this.receiverBankAccountId = receiverBankAccountId;
        }

        public String getSenderBankBranch() {
            return senderBankBranch;
        }

        public void setSenderBankBranch(String senderBankBranch) {
            this.senderBankBranch = senderBankBranch;
        }

        public String getSenderMoneyReceiptReference() {
            return senderMoneyReceiptReference;
        }

        public void setSenderMoneyReceiptReference(String senderMoneyReceiptReference) {
            this.senderMoneyReceiptReference = senderMoneyReceiptReference;
        }

        public String getTruckRegNo() {
            return truckRegNo;
        }

        public void setTruckRegNo(String truckRegNo) {
            this.truckRegNo = truckRegNo;
        }

        public String getTruckDriverName() {
            return truckDriverName;
        }

        public void setTruckDriverName(String truckDriverName) {
            this.truckDriverName = truckDriverName;
        }

        public String getTruckDriverMobile() {
            return truckDriverMobile;
        }

        public void setTruckDriverMobile(String truckDriverMobile) {
            this.truckDriverMobile = truckDriverMobile;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getCreatedBy() {
            return createdBy;
        }

        public void setCreatedBy(String createdBy) {
            this.createdBy = createdBy;
        }

        public Object getUpdatedBy() {
            return updatedBy;
        }

        public void setUpdatedBy(Object updatedBy) {
            this.updatedBy = updatedBy;
        }

    }
}





