package com.egsystembd.aitfeed.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


public class OrderListModel5 {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("order_list")
    @Expose
    private OrderList orderList;
    @SerializedName("message")
    @Expose
    private String message;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public OrderList getOrderList() {
        return orderList;
    }

    public void setOrderList(OrderList orderList) {
        this.orderList = orderList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }




public class Data implements Serializable{

    @SerializedName("order_id")
    @Expose
    private String orderId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("ait_order_id")
    @Expose
    private String aitOrderId;
    @SerializedName("ait_order_depot_id")
    @Expose
    private String aitOrderDepotId;
    @SerializedName("total_product_volume")
    @Expose
    private String totalProductVolume;
    @SerializedName("truck_reg_no")
    @Expose
    private Object truckRegNo;
    @SerializedName("truck_driver_name")
    @Expose
    private Object truckDriverName;
    @SerializedName("truck_driver_mobile")
    @Expose
    private Object truckDriverMobile;
    @SerializedName("sales_point_name")
    @Expose
    private String salesPointName;
    @SerializedName("total_product_price")
    @Expose
    private String totalProductPrice;
    @SerializedName("total_product_net_price")
    @Expose
    private String totalProductNetPrice;
    @SerializedName("total_product_discount")
    @Expose
    private String totalProductDiscount;
    @SerializedName("order_total")
    @Expose
    private String orderTotal;
    @SerializedName("total_paid")
    @Expose
    private String totalPaid;
    @SerializedName("total_due")
    @Expose
    private String totalDue;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("order_items")
    @Expose
    private List<OrderItem> orderItems = null;


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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

    public String getTotalProductVolume() {
        return totalProductVolume;
    }

    public void setTotalProductVolume(String totalProductVolume) {
        this.totalProductVolume = totalProductVolume;
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

    public String getSalesPointName() {
        return salesPointName;
    }

    public void setSalesPointName(String salesPointName) {
        this.salesPointName = salesPointName;
    }

    public String getTotalProductPrice() {
        return totalProductPrice;
    }

    public void setTotalProductPrice(String totalProductPrice) {
        this.totalProductPrice = totalProductPrice;
    }

    public String getTotalProductNetPrice() {
        return totalProductNetPrice;
    }

    public void setTotalProductNetPrice(String totalProductNetPrice) {
        this.totalProductNetPrice = totalProductNetPrice;
    }

    public String getTotalProductDiscount() {
        return totalProductDiscount;
    }

    public void setTotalProductDiscount(String totalProductDiscount) {
        this.totalProductDiscount = totalProductDiscount;
    }

    public String getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(String orderTotal) {
        this.orderTotal = orderTotal;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
    @SerializedName("product_name")
    @Expose
    private String productName;
    @SerializedName("product_id")
    @Expose
    private String productId;
    @SerializedName("product_price")
    @Expose
    private String productPrice;
    @SerializedName("product_discount")
    @Expose
    private String productDiscount;
    @SerializedName("product_pack_size")
    @Expose
    private String productPackSize;
    @SerializedName("product_net_price")
    @Expose
    private String productNetPrice;
    @SerializedName("product_quantity")
    @Expose
    private String productQuantity;
    @SerializedName("product_volume")
    @Expose
    private String productVolume;

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

    public String getProductPackSize() {
        return productPackSize;
    }

    public void setProductPackSize(String productPackSize) {
        this.productPackSize = productPackSize;
    }

    public String getProductNetPrice() {
        return productNetPrice;
    }

    public void setProductNetPrice(String productNetPrice) {
        this.productNetPrice = productNetPrice;
    }

    public String getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(String productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductVolume() {
        return productVolume;
    }

    public void setProductVolume(String productVolume) {
        this.productVolume = productVolume;
    }

}


public class OrderList implements Serializable{

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