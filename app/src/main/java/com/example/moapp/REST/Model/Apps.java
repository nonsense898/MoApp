package com.example.moapp.REST.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Apps {

    @SerializedName("applicationToken")
    @Expose
    private String applicationToken;
    @SerializedName("isPayment")
    @Expose
    private Boolean isPayment;
    @SerializedName("applicationStatus")
    @Expose
    private Boolean applicationStatus;
    @SerializedName("applicationName")
    @Expose
    private String applicationName;
    @SerializedName("endOfPayment")
    @Expose
    private Object endOfPayment;
    @SerializedName("applicationIcoUrl")
    @Expose
    private String applicationIcoUrl;
    @SerializedName("applicationUrl")
    @Expose
    private String applicationUrl;
    @SerializedName("applicationId")
    @Expose
    private String applicationId;
    @SerializedName("CountOrders")
    @Expose
    private Integer countOrders;
    @SerializedName("CountNewOrders")
    @Expose
    private Integer countNewOrders;
    @SerializedName("CountInProgressOders")
    @Expose
    private Integer countInProgressOders;
    @SerializedName("CountCompletedOrders")
    @Expose
    private Integer countCompletedOrders;

    public String getApplicationToken() {
        return applicationToken;
    }

    public void setApplicationToken(String applicationToken) {
        this.applicationToken = applicationToken;
    }

    public Boolean getIsPayment() {
        return isPayment;
    }

    public void setIsPayment(Boolean isPayment) {
        this.isPayment = isPayment;
    }

    public Boolean getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(Boolean applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public Object getEndOfPayment() {
        return endOfPayment;
    }

    public void setEndOfPayment(Object endOfPayment) {
        this.endOfPayment = endOfPayment;
    }

    public String getApplicationIcoUrl() {
        return applicationIcoUrl;
    }

    public void setApplicationIcoUrl(String applicationIcoUrl) {
        this.applicationIcoUrl = applicationIcoUrl;
    }

    public String getApplicationUrl() {
        return applicationUrl;
    }

    public void setApplicationUrl(String applicationUrl) {
        this.applicationUrl = applicationUrl;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public Integer getCountOrders() {
        return countOrders;
    }

    public void setCountOrders(Integer countOrders) {
        this.countOrders = countOrders;
    }

    public Integer getCountNewOrders() {
        return countNewOrders;
    }

    public void setCountNewOrders(Integer countNewOrders) {
        this.countNewOrders = countNewOrders;
    }

    public Integer getCountInProgressOders() {
        return countInProgressOders;
    }

    public void setCountInProgressOders(Integer countInProgressOders) {
        this.countInProgressOders = countInProgressOders;
    }

    public Integer getCountCompletedOrders() {
        return countCompletedOrders;
    }

    public void setCountCompletedOrders(Integer countCompletedOrders) {
        this.countCompletedOrders = countCompletedOrders;
    }
}

