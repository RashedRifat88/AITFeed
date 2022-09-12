package com.egsystembd.aitfeed.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SalesPoints {

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

        @SerializedName("sales_point_id")
        @Expose
        private String salesPointId;
        @SerializedName("sales_point_name")
        @Expose
        private String salesPointName;

        public String getSalesPointId() {
            return salesPointId;
        }

        public void setSalesPointId(String salesPointId) {
            this.salesPointId = salesPointId;
        }

        public String getSalesPointName() {
            return salesPointName;
        }

        public void setSalesPointName(String salesPointName) {
            this.salesPointName = salesPointName;
        }

    }


}


