package com.egsystembd.aitfeed.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Ledger {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("dealer_ledger_list")
    @Expose
    private List<DealerLedgerList> dealerLedgerList = null;
    @SerializedName("message")
    @Expose
    private String message;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<DealerLedgerList> getDealerLedgerList() {
        return dealerLedgerList;
    }

    public void setDealerLedgerList(List<DealerLedgerList> dealerLedgerList) {
        this.dealerLedgerList = dealerLedgerList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public class DealerLedgerList {

        @SerializedName("date")
        @Expose
        private String date;
        @SerializedName("transaction_id")
        @Expose
        private String transactionId;
        @SerializedName("transaction_type")
        @Expose
        private String transactionType;
        @SerializedName("sale_amount")
        @Expose
        private String saleAmount;
        @SerializedName("paid_amount")
        @Expose
        private String paidAmount;
        @SerializedName("balance")
        @Expose
        private String balance;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getTransactionId() {
            return transactionId;
        }

        public void setTransactionId(String transactionId) {
            this.transactionId = transactionId;
        }

        public String getTransactionType() {
            return transactionType;
        }

        public void setTransactionType(String transactionType) {
            this.transactionType = transactionType;
        }

        public String getSaleAmount() {
            return saleAmount;
        }

        public void setSaleAmount(String saleAmount) {
            this.saleAmount = saleAmount;
        }

        public String getPaidAmount() {
            return paidAmount;
        }

        public void setPaidAmount(String paidAmount) {
            this.paidAmount = paidAmount;
        }

        public String getBalance() {
            return balance;
        }

        public void setBalance(String balance) {
            this.balance = balance;
        }

    }

}



