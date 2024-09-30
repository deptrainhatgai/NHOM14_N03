package com.example.oopcki;

import java.util.ArrayList;
import java.util.List;

public class SinhVien {
    private String maSV;
    private String tenSV;
    private String gioiTinh;
    private String khoa;
    private String queQuan;
    private String ngaySinh;
    private String lop;
    private List<MonHoc> monHocsDaDangKy;

    public SinhVien(String maSV, String tenSV, String gioiTinh, String khoa, String queQuan, String ngaySinh, String lop) {
        this.maSV = maSV;
        this.tenSV = tenSV;
        this.gioiTinh = gioiTinh;
        this.khoa = khoa;
        this.queQuan = queQuan;
        this.ngaySinh = ngaySinh;
        this.lop = lop;
        this.monHocsDaDangKy = new ArrayList<>();
    }

    public String getMaSV() {
        return maSV;
    }

    public String getTenSV() {
        return tenSV;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public String getKhoa() {
        return khoa;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public String getLop() {
        return lop;
    }

    public List<MonHoc> getMonHocsDaDangKy() {
        return monHocsDaDangKy;
    }

    public void dangKyMonHoc(MonHoc monHoc) {
        monHocsDaDangKy.add(monHoc);
    }

    public void huyMonHoc(MonHoc monHoc) {
        monHocsDaDangKy.remove(monHoc);
    }

    @Override
    public String toString() {
        return "Sinh viên: " + tenSV + " (Mã: " + maSV + ")";
    }
}
