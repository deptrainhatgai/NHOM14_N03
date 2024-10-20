package com.example.oopcki;
public class MonHoc {
    private String maMH;
    private String tenMH;
    private String tenGiangVien;
    private String tenLop;
    private int soTinChi;
    private int maxSoSinhVien; 
    private int soSVDangKy; 
    private double soTien; 
    private int soLuongSV = 0; 


    public MonHoc(String maMH, String tenMH, String tenGiangVien, String tenLop, int soTinChi, int maxSoSinhVien, double soTien) {
        this.maMH = maMH;
        this.tenMH = tenMH;
        this.tenGiangVien = tenGiangVien;
        this.tenLop = tenLop;
        this.soTinChi = soTinChi;
        this.maxSoSinhVien = maxSoSinhVien;
        this.soTien = soTien; 
    }


    public String getMaMH() {
        return maMH;
    }

    public String getTenMH() {
        return tenMH;
    }

    public String getTenGiangVien() {
        return tenGiangVien;
    }

    public String getTenLop() {
        return tenLop;
    }

    public int getSoTinChi() {
        return soTinChi;
    }

    public int getMaxSoSinhVien() {
        return maxSoSinhVien;
    }

    public int getSoSVDangKy() {
        return soSVDangKy;
    }
    public double getSoTien() {
        return soTien;
    }

    public void setSoTien(double soTien) {
        this.soTien = soTien;
    }
    public void setSoLuongSV(int soLuong) {
        this.soLuongSV = soLuong; 
    }
    public int getSoLuongSV() {
        return soLuongSV; 
    }
    public void tangSoLuongSV() {
        if (soLuongSV < maxSoSinhVien) {
            soLuongSV++;
        }
    }
    public void giamSoLuongSV() {
        if (soLuongSV > 0) {
            soLuongSV--;
        }
    }
    public double dangKy() {
        if (soSVDangKy < maxSoSinhVien) {
            soSVDangKy++;
            return soTien; 
        }
        return -1; 
    }



//
//    
//    public boolean dangKy() {
//        if (soSVDangKy < maxSoSinhVien) {
//            soSVDangKy++;
//            return true; // Đăng ký thành công
//        }
//        return false; // Đủ số lượng sinh viên
//    }

    
    public void huyDangKy() {
        if (soSVDangKy > 0) {
            soSVDangKy--;
        }
    }
}
