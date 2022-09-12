package com.egsystembd.aitfeed.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Products {



    public class AvailableSize {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("relation_id")
        @Expose
        private String relationId;
        @SerializedName("meta_name")
        @Expose
        private String metaName;
        @SerializedName("meta_value")
        @Expose
        private String metaValue;
        @SerializedName("unit_price")
        @Expose
        private String unitPrice;
        @SerializedName("refil_price")
        @Expose
        private String refilPrice;
        @SerializedName("count")
        @Expose
        private String count;
        @SerializedName("Stock")
        @Expose
        private Stock stock;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getRelationId() {
            return relationId;
        }

        public void setRelationId(String relationId) {
            this.relationId = relationId;
        }

        public String getMetaName() {
            return metaName;
        }

        public void setMetaName(String metaName) {
            this.metaName = metaName;
        }

        public String getMetaValue() {
            return metaValue;
        }

        public void setMetaValue(String metaValue) {
            this.metaValue = metaValue;
        }

        public String getUnitPrice() {
            return unitPrice;
        }

        public void setUnitPrice(String unitPrice) {
            this.unitPrice = unitPrice;
        }

        public String getRefilPrice() {
            return refilPrice;
        }

        public void setRefilPrice(String refilPrice) {
            this.refilPrice = refilPrice;
        }

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public Stock getStock() {
            return stock;
        }

        public void setStock(Stock stock) {
            this.stock = stock;
        }

//        @Override
//        public String toString() {
//            return new ToStringBuilder(this).append("id", id).append("relationId", relationId).append("metaName", metaName).append("metaValue", metaValue).append("unitPrice", unitPrice).append("refilPrice", refilPrice).append("count", count).append("stock", stock).toString();
//        }

    }



//    @Override
//    public String toString() {
//        return new ToStringBuilder(this).append("products", products).append("numberOfProducts", numberOfProducts).toString();
//    }





    public class Product {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("product_name_id")
        @Expose
        private String productNameId;
        @SerializedName("brand_id")
        @Expose
        private String brandId;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("stock_id")
        @Expose
        private String stockId;
        @SerializedName("area_id")
        @Expose
        private String areaId;
        @SerializedName("dealer_id")
        @Expose
        private String dealerId;
        @SerializedName("image_link")
        @Expose
        private String imageLink;
        @SerializedName("available_sizes")
        @Expose
        private List<AvailableSize> availableSizes = null;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getProductNameId() {
            return productNameId;
        }

        public void setProductNameId(String productNameId) {
            this.productNameId = productNameId;
        }

        public String getBrandId() {
            return brandId;
        }

        public void setBrandId(String brandId) {
            this.brandId = brandId;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getStockId() {
            return stockId;
        }

        public void setStockId(String stockId) {
            this.stockId = stockId;
        }

        public String getAreaId() {
            return areaId;
        }

        public void setAreaId(String areaId) {
            this.areaId = areaId;
        }

        public String getDealerId() {
            return dealerId;
        }

        public void setDealerId(String dealerId) {
            this.dealerId = dealerId;
        }

        public String getImageLink() {
            return imageLink;
        }

        public void setImageLink(String imageLink) {
            this.imageLink = imageLink;
        }

        public List<AvailableSize> getAvailableSizes() {
            return availableSizes;
        }

        public void setAvailableSizes(List<AvailableSize> availableSizes) {
            this.availableSizes = availableSizes;
        }

//        @Override
//        public String toString() {
//            return new ToStringBuilder(this).append("id", id).append("name", name).append("productNameId", productNameId).append("brandId", brandId).append("description", description).append("stockId", stockId).append("areaId", areaId).append("dealerId", dealerId).append("imageLink", imageLink).append("availableSizes", availableSizes).toString();
//        }

    }


    @SerializedName("Products")
    @Expose
    private List<Product> products = null;
    @SerializedName("number_of_products")
    @Expose
    private Integer numberOfProducts;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Integer getNumberOfProducts() {
        return numberOfProducts;
    }

    public void setNumberOfProducts(Integer numberOfProducts) {
        this.numberOfProducts = numberOfProducts;
    }







    public class Stock {

        @SerializedName("stock_count")
        @Expose
        private Integer stockCount;
        @SerializedName("stock_20mm_count")
        @Expose
        private Integer stock20mmCount;
        @SerializedName("stock_22mm_count")
        @Expose
        private Integer stock22mmCount;
        @SerializedName("new_sell_count")
        @Expose
        private Integer newSellCount;
        @SerializedName("new_sell_20mm_count")
        @Expose
        private Integer newSell20mmCount;
        @SerializedName("new_sell_22mm_count")
        @Expose
        private Integer newSell22mmCount;
        @SerializedName("exchange_bottle_count")
        @Expose
        private Integer exchangeBottleCount;
        @SerializedName("exchange_bottle_20mm_count")
        @Expose
        private Integer exchangeBottle20mmCount;
        @SerializedName("exchange_bottle_22mm_count")
        @Expose
        private Integer exchangeBottle22mmCount;

        public Integer getStockCount() {
            return stockCount;
        }

        public void setStockCount(Integer stockCount) {
            this.stockCount = stockCount;
        }

        public Integer getStock20mmCount() {
            return stock20mmCount;
        }

        public void setStock20mmCount(Integer stock20mmCount) {
            this.stock20mmCount = stock20mmCount;
        }

        public Integer getStock22mmCount() {
            return stock22mmCount;
        }

        public void setStock22mmCount(Integer stock22mmCount) {
            this.stock22mmCount = stock22mmCount;
        }

        public Integer getNewSellCount() {
            return newSellCount;
        }

        public void setNewSellCount(Integer newSellCount) {
            this.newSellCount = newSellCount;
        }

        public Integer getNewSell20mmCount() {
            return newSell20mmCount;
        }

        public void setNewSell20mmCount(Integer newSell20mmCount) {
            this.newSell20mmCount = newSell20mmCount;
        }

        public Integer getNewSell22mmCount() {
            return newSell22mmCount;
        }

        public void setNewSell22mmCount(Integer newSell22mmCount) {
            this.newSell22mmCount = newSell22mmCount;
        }

        public Integer getExchangeBottleCount() {
            return exchangeBottleCount;
        }

        public void setExchangeBottleCount(Integer exchangeBottleCount) {
            this.exchangeBottleCount = exchangeBottleCount;
        }

        public Integer getExchangeBottle20mmCount() {
            return exchangeBottle20mmCount;
        }

        public void setExchangeBottle20mmCount(Integer exchangeBottle20mmCount) {
            this.exchangeBottle20mmCount = exchangeBottle20mmCount;
        }

        public Integer getExchangeBottle22mmCount() {
            return exchangeBottle22mmCount;
        }

        public void setExchangeBottle22mmCount(Integer exchangeBottle22mmCount) {
            this.exchangeBottle22mmCount = exchangeBottle22mmCount;
        }

//        @Override
//        public String toString() {
//            return new ToStringBuilder(this).append("stockCount", stockCount).append("stock20mmCount", stock20mmCount).append("stock22mmCount", stock22mmCount).append("newSellCount", newSellCount).append("newSell20mmCount", newSell20mmCount).append("newSell22mmCount", newSell22mmCount).append("exchangeBottleCount", exchangeBottleCount).append("exchangeBottle20mmCount", exchangeBottle20mmCount).append("exchangeBottle22mmCount", exchangeBottle22mmCount).toString();
//        }

    }

}