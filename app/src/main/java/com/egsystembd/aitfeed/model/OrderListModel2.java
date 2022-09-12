package com.egsystembd.aitfeed.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class OrderListModel2 {

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
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;

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
        private String updatedBy;
        @SerializedName("ait_bank")
        @Expose
        private AitBank aitBank;

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

        public String getUpdatedBy() {
            return updatedBy;
        }

        public void setUpdatedBy(String updatedBy) {
            this.updatedBy = updatedBy;
        }

        public AitBank getAitBank() {
            return aitBank;
        }

        public void setAitBank(AitBank aitBank) {
            this.aitBank = aitBank;
        }

    }


}

