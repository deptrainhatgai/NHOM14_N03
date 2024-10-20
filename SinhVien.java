package com.example.oopcki;

import java.util.ArrayList;
import java.util.List;

public class SinhVien {
    private String maSV;
    private String tenSV;
    private String gioiTinh;
    private String khoaHoc;
    private String queQuan;
    private String ngaySinh;
    private String lop;
    private String sdt;
    private String email;
    private List<String> danhSachMonHocDaDangKy; 

    
    public SinhVien(String maSV, String tenSV, String gioiTinh, String khoaHoc, String queQuan, String ngaySinh, String lop, String sdt, String email) {
        this.maSV = maSV;
        this.tenSV = tenSV;
        this.gioiTinh = gioiTinh;
        this.khoaHoc = khoaHoc;
        this.queQuan = queQuan;
        this.ngaySinh = ngaySinh;
        this.lop = lop;
        this.sdt = sdt;
        this.email = email;
        this.danhSachMonHocDaDangKy = new ArrayList<>();
        this.tongSoTienDaChi = 0; 
    }

    
    public String getMaSV() { return maSV; }
    public String getTenSV() { return tenSV; }
    public String getGioiTinh() { return gioiTinh; }
    public String getKhoaHoc() { return khoaHoc; }
    public String getQueQuan() { return queQuan; }
    public String getNgaySinh() { return ngaySinh; }
    public String getLop() { return lop; }
    public String getSdt() { return sdt; }
    public String getEmail() { return email; }
    public String getTen() { return tenSV; }

    
    public void dangKyMonHoc(String maMH, QuanLyHeThong qlhs) {
        MonHoc monHoc = qlhs.getMonHoc(maMH); 
        if (monHoc != null) {
            double tienDangKy = monHoc.dangKy(); 
            if (tienDangKy != -1) {
                danhSachMonHocDaDangKy.add(maMH);
                System.out.println("Sinh viên " + tenSV + " đã đăng ký môn học: " + maMH + " với số tiền: " + tienDangKy);
            } else {
                System.out.println("Môn học " + maMH + " đã đủ sinh viên đăng ký.");
            }
        } else {
            System.out.println("Không tìm thấy môn học với mã: " + maMH);
        }
    }

    public void themMonHoc(String maMH) {
        this.danhSachMonHocDaDangKy.add(maMH);
    }
    public void xoaMonHoc(String maMH) {
        this.danhSachMonHocDaDangKy.remove(maMH);
    }

    
    public void huyDangKyMonHoc(String maMH) {
        if (danhSachMonHocDaDangKy.contains(maMH)) {
            danhSachMonHocDaDangKy.remove(maMH);
            System.out.println("Sinh viên " + tenSV + " đã hủy đăng ký môn học: " + maMH);
        } else {
            System.out.println("Sinh viên " + tenSV + " chưa đăng ký môn học: " + maMH);
        }
    }

    public boolean daDangKyMonHoc(String maMH) {
        return danhSachMonHocDaDangKy.contains(maMH);
    }

    @Override
    public String toString() {
        return "Mã SV: " + maSV + "\n" +
                "Tên SV: " + tenSV + "\n" +
                "Giới tính: " + gioiTinh + "\n" +
                "Khóa học: " + khoaHoc + "\n" +
                "Quê quán: " + queQuan + "\n" +
                "Ngày sinh: " + ngaySinh + "\n" +
                "Lớp: " + lop + "\n" +
                "SĐT: " + sdt + "\n" +
                "Email: " + email + "\n" +
                "Danh sách môn học đã đăng ký: " + danhSachMonHocDaDangKy.toString();
    }

    public boolean isValidEmail() {
        boolean valid = email.contains("@") && email.contains(".");
        if (!valid) {
            System.out.println("Email không hợp lệ: " + email);
        }
        return valid;
    }

    public boolean isValidSdt() {
        boolean valid = sdt.matches("\\d{10}");
        if (!valid) {
            System.out.println("SĐT không hợp lệ: " + sdt);
        }
        return valid;
    }
    private double tongSoTienDaChi; 

    public double getTongSoTienDaChi() {
        return tongSoTienDaChi;
    }
    public void huyMonHoc(String maMH) {
        danhSachMonHocDaDangKy.remove(maMH); 
    }

    public List<String> getDanhSachMonHocDaDangKy() {
        return danhSachMonHocDaDangKy; 
    }
}
