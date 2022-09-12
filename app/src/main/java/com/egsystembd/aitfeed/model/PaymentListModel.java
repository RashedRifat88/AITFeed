package com.egsystembd.aitfeed.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PaymentListModel {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("payment_list")
    @Expose
    private PaymentList paymentList;
    @SerializedName("message")
    @Expose
    private String message;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public PaymentList getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(PaymentList paymentList) {
        this.paymentList = paymentList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


public class Data {

    @SerializedName("amount")
    @Expose
    private String amount;
    @SerializedName("sender_money_receipt_reference")
    @Expose
    private String senderMoneyReceiptReference;
    @SerializedName("payment_type")
    @Expose
    private String paymentType;
    @SerializedName("bank_name")
    @Expose
    private String bankName;
    @SerializedName("sender_bank_branch")
    @Expose
    private String senderBankBranch;
    @SerializedName("payment_date")
    @Expose
    private String paymentDate;
    @SerializedName("payment_confirmation_id")
    @Expose
    private String paymentConfirmationId;
    @SerializedName("payment_depot_id")
    @Expose
    private String paymentDepotId;
    @SerializedName("status")
    @Expose
    private String status;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getSenderMoneyReceiptReference() {
        return senderMoneyReceiptReference;
    }

    public void setSenderMoneyReceiptReference(String senderMoneyReceiptReference) {
        this.senderMoneyReceiptReference = senderMoneyReceiptReference;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getSenderBankBranch() {
        return senderBankBranch;
    }

    public void setSenderBankBranch(String senderBankBranch) {
        this.senderBankBranch = senderBankBranch;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentConfirmationId() {
        return paymentConfirmationId;
    }

    public void setPaymentConfirmationId(String paymentConfirmationId) {
        this.paymentConfirmationId = paymentConfirmationId;
    }

    public String getPaymentDepotId() {
        return paymentDepotId;
    }

    public void setPaymentDepotId(String paymentDepotId) {
        this.paymentDepotId = paymentDepotId;
    }

}


public class PaymentList {

    @SerializedName("current_page")
    @Expose
    private Integer currentPage;
    @SerializedName("data")
    @Expose
    private List<Data> data = null;
    @SerializedName("first_page_url")
    @Expose
    private String firstPageUrl;
    @SerializedName("from")
    @Expose
    private Integer from;
    @SerializedName("last_page")
    @Expose
    private Integer lastPage;
    @SerializedName("last_page_url")
    @Expose
    private String lastPageUrl;
    @SerializedName("next_page_url")
    @Expose
    private Object nextPageUrl;
    @SerializedName("path")
    @Expose
    private String path;
    @SerializedName("per_page")
    @Expose
    private Integer perPage;
    @SerializedName("prev_page_url")
    @Expose
    private Object prevPageUrl;
    @SerializedName("to")
    @Expose
    private Integer to;
    @SerializedName("total")
    @Expose
    private Integer total;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public String getFirstPageUrl() {
        return firstPageUrl;
    }

    public void setFirstPageUrl(String firstPageUrl) {
        this.firstPageUrl = firstPageUrl;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getLastPage() {
        return lastPage;
    }

    public void setLastPage(Integer lastPage) {
        this.lastPage = lastPage;
    }

    public String getLastPageUrl() {
        return lastPageUrl;
    }

    public void setLastPageUrl(String lastPageUrl) {
        this.lastPageUrl = lastPageUrl;
    }

    public Object getNextPageUrl() {
        return nextPageUrl;
    }

    public void setNextPageUrl(Object nextPageUrl) {
        this.nextPageUrl = nextPageUrl;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public Object getPrevPageUrl() {
        return prevPageUrl;
    }

    public void setPrevPageUrl(Object prevPageUrl) {
        this.prevPageUrl = prevPageUrl;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

}


}
