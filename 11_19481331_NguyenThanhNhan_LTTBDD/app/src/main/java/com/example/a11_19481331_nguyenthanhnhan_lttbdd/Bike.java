package com.example.a11_19481331_nguyenthanhnhan_lttbdd;

import java.io.Serializable;

public class Bike implements Serializable {
    private int idImg;
    private String tvName;
    private double tvGia;
    private int tvPhanTram;

    public Bike(int idImg, String tvName, double tvGia, int tvPhanTram) {
        this.idImg = idImg;
        this.tvName = tvName;
        this.tvGia = tvGia;
        this.tvPhanTram = tvPhanTram;
    }

    public int getIdImg() {
        return idImg;
    }

    public void setIdImg(int idImg) {
        this.idImg = idImg;
    }

    public String getTvName() {
        return tvName;
    }

    public void setTvName(String tvName) {
        this.tvName = tvName;
    }

    public double getTvGia() {
        return tvGia;
    }

    public void setTvGia(double tvGia) {
        this.tvGia = tvGia;
    }

    public int getTvPhanTram() {
        return tvPhanTram;
    }

    public void setTvPhanTram(int tvPhanTram) {
        this.tvPhanTram = tvPhanTram;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "idImg=" + idImg +
                ", tvName='" + tvName + '\'' +
                ", tvGia=" + tvGia +
                ", tvPhanTram=" + tvPhanTram +
                '}';
    }
}
