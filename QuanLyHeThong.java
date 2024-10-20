package com.example.oopcki;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class QuanLyHeThong {
    private Map<String, MonHoc> monHocs;
    private Map<String, SinhVien> sinhViens;

    public QuanLyHeThong() {
        monHocs = new HashMap<>();
        sinhViens = new HashMap<>();

       
        themMonHoc(new MonHoc("MH001", "Lập trình Java", "Nguyễn Văn Duy", "Lop N01", 3, 30, 1000.0)); // Giá tiền là 1000.0
        themMonHoc(new MonHoc("MH002", "Cấu trúc dữ liệu", "Đỗ Vân Nam", "Lop N02", 4, 25, 1500.0)); // Giá tiền là 1500.0
        themMonHoc(new MonHoc("MH004", " OOP", "Nguyễn Lệ Thu", "Lop N02", 3, 40, 1200.0)); // Giá tiền là 1200.0
        themMonHoc(new MonHoc("MH005", " Ngôn ngữ c", "Đinh Trường Giang", "Lop N03", 3, 40, 1200.0)); // Giá tiền là 1200.0
        themMonHoc(new MonHoc("MH006", " Xây dựng web", "Nguyễn Huy Hoàng", "Lop N07", 3, 40, 1200.0)); // Giá tiền là 1200.0
        themMonHoc(new MonHoc("MH007", " Thiết kế đồ họa", "Đinh Việt Hoàng", "Lop N09", 3, 40, 1200.0)); // Giá tiền là 1200.0
        themMonHoc(new MonHoc("MH008", " Thiết kế phần mềm ", "Hoàng Văn Nam", "Lop N01", 3, 40, 1200.0)); // Giá tiền là 1200.0
        themMonHoc(new MonHoc("MH009", " Lập trình Python", "Trần Thành Long", "Lop N02", 2, 40, 1200.0)); // Giá tiền là 1200.0
        

        themSinhVien(new SinhVien("SV001", "Nguyễn Văn Anh", "Nam", "2024-2027", "Hà Nội", "01/01/2000", "CNTT", "0123456789", "nguyenvana@example.com"));
        themSinhVien(new SinhVien("SV002", "Lê Văn linh", "Nữ", "2024-2027", "Ninh Bình", "15/06/2002", "CNTT", "0987654321", "lethib@example.com"));
        themSinhVien(new SinhVien("SV003", "Nguyễn văn Bình", "Nam", "2024-2027", "Nam Định", "16/07/2002", "Kinh tế", "0987654326", "letxuanb@example.com"));
        themSinhVien(new SinhVien("SV004", "Lê Thị Cúc", "Nữ", "2024-2027", "Cà Mau", "15/08/2002", "KĨ THUẬT ", "0987654326", "letxuanb@example.com"));
        themSinhVien(new SinhVien("SV005", " Trần Đức Bình", "nam", "2024-2027", "Tuyên Quang", "21/05/2002", "Kinh tế", "0987654326", "letxuanb@example.com"));
        themSinhVien(new SinhVien("SV006", " Nguyễn văn Công", "nam", "2024-2027", "Lai Châu", "27/02/2002", "KĨ THUẬT ", "0987654326", "letxuanb@example.com"));
        themSinhVien(new SinhVien("SV007", "Nguyễn Thị Thuỳ Linh", "Nữ", "2024-2027", "Hà Nội", "12/03/2002", "CNTT", "0987654326", "letxuanb@example.com"));
        themSinhVien(new SinhVien("SV008", " Nguyễn Minh Sang", "nam", "2024-2027", "Hà Nội", "18/04/2002", "Kinh tế", "0987654326", "letxuanb@example.com"));
    }

   
    public void themMonHoc(MonHoc monHoc) {
        if (monHoc != null && !monHocs.containsKey(monHoc.getMaMH())) {
            monHocs.put(monHoc.getMaMH(), monHoc);
            System.out.println("Thêm môn học thành công: " + monHoc.getTenMH());
        }
    }

    
    public Collection<SinhVien> getDanhSachSinhVien() {
        return sinhViens.values();
    }

   
    public void themSinhVien(SinhVien sinhVien) {
        if (sinhVien != null && !sinhViens.containsKey(sinhVien.getMaSV())) {
            sinhViens.put(sinhVien.getMaSV(), sinhVien);
            System.out.println("Thêm sinh viên thành công: " + sinhVien.getTen());
        }
    }

    public MonHoc getMonHoc(String maMH) {
        return monHocs.get(maMH);
    }

    public void dangKyMonHoc(String maSV, String maMH) {
        SinhVien sv = sinhViens.get(maSV);
        if (sv != null) {
            MonHoc monHoc = getMonHoc(maMH); 
            if (monHoc != null) {
                sv.dangKyMonHoc(maMH, this);
                System.out.println("Đăng ký môn học thành công cho sinh viên: " + sv.getTen());
            } else {
                System.out.println("Không tìm thấy môn học với mã: " + maMH);
            }
        } else {
            System.out.println("Không tìm thấy sinh viên với mã: " + maSV);
        }
    }


    public void huyDangKyMonHoc(String maSV, String maMH) {
       
        MonHoc monHoc = getMonHoc(maMH);
        if (monHoc != null) {
            monHoc.giamSoLuongSV(); 
        }
    }
    
   
    public void xoaSinhVien(String maSV) {
        if (sinhViens.containsKey(maSV)) {
            sinhViens.remove(maSV);
            System.out.println("Xóa sinh viên thành công: " + maSV);
        }
    }

    
    public Collection<MonHoc> getDanhSachMonHoc() {
        return monHocs.values();
    }
}
