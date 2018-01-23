package com.example.diana.myapplicationengtester.api.pojo;
import com.google.gson.annotations.SerializedName;
public class ResponseData {
    @SerializedName("extract")
    private String description;
    public String getDescription() {
        return description;
    }
    //public void setTranslatedText(String translatedText) {
       // this.translatedText = translatedText;
    //}
}