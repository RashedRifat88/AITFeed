package com.egsystembd.aitfeed.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OrderDetailsModel {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("message")
    @Expose
    private String message;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public class AitBankAccountDetails {

        @SerializedName("bank_name")
        @Expose
        private String bankName;
        @SerializedName("bank_account_id")
        @Expose
        private Integer bankAccountId;
        @SerializedName("bank_branch_name")
        @Expose
        private String bankBranchName;
        @SerializedName("bank_account_holder_name")
        @Expose
        private String bankAccountHolderName;
        @SerializedName("bank_account_number")
        @Expose
        private String bankAccountNumber;

        public String getBankName() {
            return bankName;
        }

        public void setBankName(String bankName) {
            this.bankName = bankName;
        }

        public Integer getBankAccountId() {
            return bankAccountId;
        }

        public void setBankAccountId(Integer bankAccountId) {
            this.bankAccountId = bankAccountId;
        }

        public String getBankBranchName() {
            return bankBranchName;
        }

        public void setBankBranchName(String bankBranchName) {
            this.bankBranchName = bankBranchName;
        }

        public String getBankAccountHolderName() {
            return bankAccountHolderName;
        }

        public void setBankAccountHolderName(String bankAccountHolderName) {
            this.bankAccountHolderName = bankAccountHolderName;
        }

        public String getBankAccountNumber() {
            return bankAccountNumber;
        }

        public void setBankAccountNumber(String bankAccountNumber) {
            this.bankAccountNumber = bankAccountNumber;
        }

    }


    public class Data {

        @SerializedName("order")
        @Expose
        private Order order;
        @SerializedName("order_items")
        @Expose
        private List<OrderItem> orderItems = null;
        @SerializedName("ait_bank_account_details")
        @Expose
        private AitBankAccountDetails aitBankAccountDetails;

        public Order getOrder() {
            return order;
        }

        public void setOrder(Order order) {
            this.order = order;
        }

        public List<OrderItem> getOrderItems() {
            return orderItems;
        }

        public void setOrderItems(List<OrderItem> orderItems) {
            this.orderItems = orderItems;
        }

        public AitBankAccountDetails getAitBankAccountDetails() {
            return aitBankAccountDetails;
        }

        public void setAitBankAccountDetails(AitBankAccountDetails aitBankAccountDetails) {
            this.aitBankAccountDetails = aitBankAccountDetails;
        }

    }

    public class Order {

        @SerializedName("order_total")
        @Expose
        private String orderTotal;
        @SerializedName("status")
        @Expose
        private String status;
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

    }


    public class OrderItem {

        @SerializedName("product_name")
        @Expose
        private String productName;
        @SerializedName("product_id")
        @Expose
        private String productId;
        @SerializedName("product_quantity")
        @Expose
        private String productQuantity;
        @SerializedName("product_price")
        @Expose
        private String productPrice;

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        public String getProductQuantity() {
            return productQuantity;
        }

        public void setProductQuantity(String productQuantity) {
            this.productQuantity = productQuantity;
        }

        public String getProductPrice() {
            return productPrice;
        }

        public void setProductPrice(String productPrice) {
            this.productPrice = productPrice;
        }

    }

}