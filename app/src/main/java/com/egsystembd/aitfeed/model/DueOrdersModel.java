package com.egsystembd.aitfeed.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DueOrdersModel {

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
        private Object truckRegNo;
        @SerializedName("truck_driver_name")
        @Expose
        private Object truckDriverName;
        @SerializedName("truck_driver_mobile")
        @Expose
        private Object truckDriverMobile;
        @SerializedName("payment_type")
        @Expose
        private Object paymentType;
        @SerializedName("confirmation_id")
        @Expose
        private String confirmationId;
        @SerializedName("spc_id")
        @Expose
        private String spcId;
        @SerializedName("total_product_price")
        @Expose
        private Double totalProductPrice;
        @SerializedName("total_product_discount")
        @Expose
        private Integer totalProductDiscount;
        @SerializedName("total_product_net_price")
        @Expose
        private Double totalProductNetPrice;
        @SerializedName("total_paid")
        @Expose
        private Integer totalPaid;
        @SerializedName("total_due")
        @Expose
        private Double totalDue;

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

        public Object getTruckRegNo() {
            return truckRegNo;
        }

        public void setTruckRegNo(Object truckRegNo) {
            this.truckRegNo = truckRegNo;
        }

        public Object getTruckDriverName() {
            return truckDriverName;
        }

        public void setTruckDriverName(Object truckDriverName) {
            this.truckDriverName = truckDriverName;
        }

        public Object getTruckDriverMobile() {
            return truckDriverMobile;
        }

        public void setTruckDriverMobile(Object truckDriverMobile) {
            this.truckDriverMobile = truckDriverMobile;
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

        public Double getTotalProductPrice() {
            return totalProductPrice;
        }

        public void setTotalProductPrice(Double totalProductPrice) {
            this.totalProductPrice = totalProductPrice;
        }

        public Integer getTotalProductDiscount() {
            return totalProductDiscount;
        }

        public void setTotalProductDiscount(Integer totalProductDiscount) {
            this.totalProductDiscount = totalProductDiscount;
        }

        public Double getTotalProductNetPrice() {
            return totalProductNetPrice;
        }

        public void setTotalProductNetPrice(Double totalProductNetPrice) {
            this.totalProductNetPrice = totalProductNetPrice;
        }

        public Integer getTotalPaid() {
            return totalPaid;
        }

        public void setTotalPaid(Integer totalPaid) {
            this.totalPaid = totalPaid;
        }

        public Double getTotalDue() {
            return totalDue;
        }

        public void setTotalDue(Double totalDue) {
            this.totalDue = totalDue;
        }

    }


}