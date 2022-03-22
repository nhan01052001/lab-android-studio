package com.example.ontap;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String tvName;
    private String tvGH;
    private double tvGiaThat;
    private double tvGiamGia;

    public Product(int id, String tvName, String tvGH, double tvGiaThat, double tvGiamGia) {
        this.id = id;
        this.tvName = tvName;
        this.tvGH = tvGH;
        this.tvGiaThat = tvGiaThat;
        this.tvGiamGia = tvGiamGia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTvName() {
        return tvName;
    }

    public void setTvName(String tvName) {
        this.tvName = tvName;
    }

    public String getTvGH() {
        return tvGH;
    }

    public void setTvGH(String tvGH) {
        this.tvGH = tvGH;
    }

    public double getTvGiaThat() {
        return tvGiaThat;
    }

    public void setTvGiaThat(double tvGiaThat) {
        this.tvGiaThat = tvGiaThat;
    }

    public double getTvGiamGia() {
        return tvGiamGia;
    }

    public void setTvGiamGia(double tvGiamGia) {
        this.tvGiamGia = tvGiamGia;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", tvName='" + tvName + '\'' +
                ", tvGH='" + tvGH + '\'' +
                ", tvGiaThat=" + tvGiaThat +
                ", tvGiamGia=" + tvGiamGia +
                '}';
    }
}
