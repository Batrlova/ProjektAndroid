package com.example.diana.myapplicationengtester.api.pojo;
import com.google.gson.annotations.SerializedName;

public class ResponseTranslator {
    @SerializedName("extract")
    private String description;
    public String getResponseData() {
        return description;
    }
   /* public void setResponseData(ResponseData description) {
        this.description = description;
    }*/
}