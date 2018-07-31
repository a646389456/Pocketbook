package com.example.lenovo.pocketbook;

import org.litepal.crud.DataSupport;

public class Stuff extends DataSupport {
    private String Leixing;
    private String Pinpai;
    private Integer Jiage;
    private Integer Shuliang;

    public void setLeixing(String leixing) {
        this.Leixing = leixing;
    }

    public String getLeixing() {
        return Leixing;
    }

    public void setPinpai(String pinpai) {
        this.Pinpai = pinpai;
    }

    public String getPinpai() {
        return Pinpai;
    }

    public void setJiage(Integer jiage) {
        this.Jiage = jiage;
    }

    public Integer getJiage() {
        return Jiage;
    }

    public void setShuliang(Integer shuliang) {
        this.Shuliang = shuliang;
    }

    public Integer getShuliang() {
        return Shuliang;
    }

}
