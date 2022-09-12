package com.egsystembd.aitfeed.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class OrderListModel3 {

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


    public class AitBank {

        @SerializedName("bank_account_id")
        @Expose
        private Integer bankAccountId;
        @SerializedName("bank_name_id")
        @Expose
        private String bankNameId;
        @SerializedName("bank_branch_name")
        @Expose
        private String bankBranchName;
        @SerializedName("bank_account_holder_name")
        @Expose
        private String bankAccountHolderName;
        @SerializedName("bank_account_number")
        @Expose
        private String bankAccountNumber;
        @SerializedName("bank_account_type")
        @Expose
        private String bankAccountType;
        @SerializedName("bank")
        @Expose
        private Bank bank;

        public Integer getBankAccountId() {
            return bankAccountId;
        }

        public void setBankAccountId(Integer bankAccountId) {
            this.bankAccountId = bankAccountId;
        }

        public String getBankNameId() {
            return bankNameId;
        }

        public void setBankNameId(String bankNameId) {
            this.bankNameId = bankNameId;
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

        public String getBankAccountType() {
            return bankAccountType;
        }

        public void setBankAccountType(String bankAccountType) {
            this.bankAccountType = bankAccountType;
        }

        public Bank getBank() {
            return bank;
        }

        public void setBank(Bank bank) {
            this.bank = bank;
        }

    }


    public class Bank {

        @SerializedName("bank_name_id")
        @Expose
        private String bankNameId;
        @SerializedName("bank_name")
        @Expose
        private String bankName;
        @SerializedName("status")
        @Expose
        private String status;

        public String getBankNameId() {
            return bankNameId;
        }

        public void setBankNameId(String bankNameId) {
            this.bankNameId = bankNameId;
        }

        public String getBankName() {
            return bankName;
        }

        public void setBankName(String bankName) {
            this.bankName = bankName;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

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

        @SerializedName("order_items")
        @Expose
        private List<OrderItem> orderItems = null;
        @SerializedName("ait_bank")
        @Expose
        private AitBank aitBank;
        @SerializedName("sales_point")
        @Expose
        private SalesPoint salesPoint;
        @SerializedName("confirmation_id")
        @Expose
        private String confirmation_id;

        @SerializedName("payment_type")
        @Expose
        private String payment_type;

        @SerializedName("total_product_volume")
        @Expose
        private String product_volume;


        public String getPayment_type() {
            return payment_type;
        }

        public void setPayment_type(String payment_type) {
            this.payment_type = payment_type;
        }

        public String getProduct_volume() {
            return product_volume;
        }

        public void setProduct_volume(String product_volume) {
            this.product_volume = product_volume;
        }

        public String getConfirmation_id() {
            return confirmation_id;
        }

        public void setConfirmation_id(String confirmation_id) {
            this.confirmation_id = confirmation_id;
        }

        public SalesPoint getSalesPoint() {
            return salesPoint;
        }

        public void setSalesPoint(SalesPoint salesPoint) {
            this.salesPoint = salesPoint;
        }

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

        public List<OrderItem> getOrderItems() {
            return orderItems;
        }

        public void setOrderItems(List<OrderItem> orderItems) {
            this.orderItems = orderItems;
        }

        public AitBank getAitBank() {
            return aitBank;
        }

        public void setAitBank(AitBank aitBank) {
            this.aitBank = aitBank;
        }


    }


    public class SalesPoint implements Serializable {

        @SerializedName("sales_point_name")
        @Expose
        private String salesPointName;

        public String getSalesPointName() {
            return salesPointName;
        }

        public void setSalesPointName(String salesPointName) {
            this.salesPointName = salesPointName;
        }

    }


    public class OrderItem implements Serializable {

        @SerializedName("order_item_id")
        @Expose
        private String orderItemId;
        @SerializedName("order_id")
        @Expose
        private String orderId;
        @SerializedName("product_id")
        @Expose
        private String productId;
        @SerializedName("product_quantity")
        @Expose
        private String productQuantity;
        @SerializedName("product_price")
        @Expose
        private String productPrice;
        @SerializedName("product")
        @Expose
        private Product product;


        public Product getProduct() {
            return product;
        }

        public void setProduct(Product product) {
            this.product = product;
        }


        public String getOrderItemId() {
            return orderItemId;
        }

        public void setOrderItemId(String orderItemId) {
            this.orderItemId = orderItemId;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
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

    public class Product implements Serializable {

        @SerializedName("product_name")
        @Expose
        private String productName;

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }


    }


}