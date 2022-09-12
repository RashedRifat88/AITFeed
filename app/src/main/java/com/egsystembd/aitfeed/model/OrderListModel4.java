package com.egsystembd.aitfeed.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class OrderListModel4 {

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
    @SerializedName("truck_reg_no")
    @Expose
    private String truckRegNo;
    @SerializedName("truck_driver_name")
    @Expose
    private String truckDriverName;
    @SerializedName("truck_driver_mobile")
    @Expose
    private String truckDriverMobile;
    @SerializedName("sales_point")
    @Expose
    private SalesPoint salesPoint;
    @SerializedName("payment_type")
    @Expose
    private Object paymentType;
    @SerializedName("confirmation_id")
    @Expose
    private String confirmationId;
    @SerializedName("spc_id")
    @Expose
    private String spcId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("ait_order_id")
    @Expose
    private String aitOrderId;
    @SerializedName("ait_order_depot_id")
    @Expose
    private String aitOrderDepotId;
    @SerializedName("payment")
    @Expose
    private List<Payment> payment = null;
    @SerializedName("total_product_volume")
    @Expose
    private String totalProductVolume;
    @SerializedName("total_product_price")
    @Expose
    private String totalProductPrice;
    @SerializedName("total_product_discount")
    @Expose
    private String totalProductDiscount;
    @SerializedName("total_product_net_price")
    @Expose
    private String totalProductNetPrice;
    @SerializedName("total_paid")
    @Expose
    private String totalPaid;
    @SerializedName("total_due")
    @Expose
    private String totalDue;
    @SerializedName("order_items")
    @Expose
    private List<OrderItem> orderItems = null;

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

    public SalesPoint getSalesPoint() {
        return salesPoint;
    }

    public void setSalesPoint(SalesPoint salesPoint) {
        this.salesPoint = salesPoint;
    }

    public Object getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Object paymentType) {
        this.paymentType = paymentType;
    }

    public String getConfirmationId() {
        return confirmationId;
    }

    public void setConfirmationId(String confirmationId) {
        this.confirmationId = confirmationId;
    }

    public String getSpcId() {
        return spcId;
    }

    public void setSpcId(String spcId) {
        this.spcId = spcId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getAitOrderId() {
        return aitOrderId;
    }

    public void setAitOrderId(String aitOrderId) {
        this.aitOrderId = aitOrderId;
    }

    public String getAitOrderDepotId() {
        return aitOrderDepotId;
    }

    public void setAitOrderDepotId(String aitOrderDepotId) {
        this.aitOrderDepotId = aitOrderDepotId;
    }

    public List<Payment> getPayment() {
        return payment;
    }

    public void setPayment(List<Payment> payment) {
        this.payment = payment;
    }

    public String getTotalProductVolume() {
        return totalProductVolume;
    }

    public void setTotalProductVolume(String totalProductVolume) {
        this.totalProductVolume = totalProductVolume;
    }

    public String getTotalProductPrice() {
        return totalProductPrice;
    }

    public void setTotalProductPrice(String totalProductPrice) {
        this.totalProductPrice = totalProductPrice;
    }

    public String getTotalProductDiscount() {
        return totalProductDiscount;
    }

    public void setTotalProductDiscount(String totalProductDiscount) {
        this.totalProductDiscount = totalProductDiscount;
    }

    public String getTotalProductNetPrice() {
        return totalProductNetPrice;
    }

    public void setTotalProductNetPrice(String totalProductNetPrice) {
        this.totalProductNetPrice = totalProductNetPrice;
    }

    public String getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(String totalPaid) {
        this.totalPaid = totalPaid;
    }

    public String getTotalDue() {
        return totalDue;
    }

    public void setTotalDue(String totalDue) {
        this.totalDue = totalDue;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
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
    @SerializedName("product_discount")
    @Expose
    private String productDiscount;
    @SerializedName("product_net_price")
    @Expose
    private String productNetPrice;
    @SerializedName("product_pack_size")
    @Expose
    private String productPackSize;
    @SerializedName("product_volume")
    @Expose
    private String productVolume;
    @SerializedName("product")
    @Expose
    private Product product;

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

    public String getProductDiscount() {
        return productDiscount;
    }

    public void setProductDiscount(String productDiscount) {
        this.productDiscount = productDiscount;
    }

    public String getProductNetPrice() {
        return productNetPrice;
    }

    public void setProductNetPrice(String productNetPrice) {
        this.productNetPrice = productNetPrice;
    }

    public String getProductPackSize() {
        return productPackSize;
    }

    public void setProductPackSize(String productPackSize) {
        this.productPackSize = productPackSize;
    }

    public String getProductVolume() {
        return productVolume;
    }

    public void setProductVolume(String productVolume) {
        this.productVolume = productVolume;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}






public class Payment implements Serializable{

    @SerializedName("amount")
    @Expose
    private String amount;
    @SerializedName("receiver_bank_account_id")
    @Expose
    private String receiverBankAccountId;
    @SerializedName("sender_money_receipt_reference")
    @Expose
    private Object senderMoneyReceiptReference;
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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getReceiverBankAccountId() {
        return receiverBankAccountId;
    }

    public void setReceiverBankAccountId(String receiverBankAccountId) {
        this.receiverBankAccountId = receiverBankAccountId;
    }

    public Object getSenderMoneyReceiptReference() {
        return senderMoneyReceiptReference;
    }

    public void setSenderMoneyReceiptReference(Object senderMoneyReceiptReference) {
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


public class Product implements Serializable{

    @SerializedName("product_name")
    @Expose
    private String productName;
    @SerializedName("agent_commission")
    @Expose
    private String agentCommission;
    @SerializedName("product_pack_size")
    @Expose
    private String productPackSize;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getAgentCommission() {
        return agentCommission;
    }

    public void setAgentCommission(String agentCommission) {
        this.agentCommission = agentCommission;
    }

    public String getProductPackSize() {
        return productPackSize;
    }

    public void setProductPackSize(String productPackSize) {
        this.productPackSize = productPackSize;
    }

}


public class SalesPoint implements Serializable{

    @SerializedName("sales_point_name")
    @Expose
    private String salesPointName;
    @SerializedName("sales_point_code")
    @Expose
    private String salesPointCode;

    public String getSalesPointName() {
        return salesPointName;
    }

    public void setSalesPointName(String salesPointName) {
        this.salesPointName = salesPointName;
    }

    public String getSalesPointCode() {
        return salesPointCode;
    }

    public void setSalesPointCode(String salesPointCode) {
        this.salesPointCode = salesPointCode;
    }

}
}