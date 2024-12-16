package com.example.oopcki;

public class MonHoc {
    private String maMonHoc;
    private String tenMonHoc;
    private int soTinChi;

    public MonHoc(String maMonHoc, String tenMonHoc, int soTinChi) {
        this.maMonHoc = maMonHoc;
        this.tenMonHoc = tenMonHoc;
        this.soTinChi = soTinChi;
    }

    public String getMaMonHoc() {
        return maMonHoc;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public int getSoTinChi() {
        return soTinChi;
    }

    @Override
    public String toString() {
        return "Môn học: " + tenMonHoc + " (Mã: " + maMonHoc + ", Tín chỉ: " + soTinChi + ")";
    }
}
