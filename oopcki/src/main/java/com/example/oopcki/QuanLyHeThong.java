package com.example.oopcki;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuanLyHeThong {
    private Map<String, SinhVien> sinhViens;
    private Map<String, MonHoc> monHocs;

    public QuanLyHeThong() {
        sinhViens = new HashMap<>();
        monHocs = new HashMap<>();
    }

    public void themSinhVien(SinhVien sv) {
        sinhViens.put(sv.getMaSV(), sv);
    }

    public SinhVien getSinhVien(String maSV) {
        return sinhViens.get(maSV);
    }

    public void themMonHoc(MonHoc monHoc) {
        monHocs.put(monHoc.getMaMonHoc(), monHoc);
    }

    public MonHoc getMonHoc(String maMonHoc) {
        return monHocs.get(maMonHoc);
    }

    public List<MonHoc> getRegisteredSubjects(String maSV) {
        SinhVien sv = getSinhVien(maSV);
        return sv != null ? sv.getMonHocsDaDangKy() : null;
    }

    public boolean isRegistered(String maSV, String maMonHoc) {
        SinhVien sv = getSinhVien(maSV);
        if (sv != null) {
            return sv.getMonHocsDaDangKy().stream().anyMatch(m -> m.getMaMonHoc().equals(maMonHoc));
        }
        return false;
    }

    public void dangKyMonHoc(String maSV, String maMonHoc) {
        SinhVien sv = getSinhVien(maSV);
        MonHoc mh = getMonHoc(maMonHoc);
        if (sv != null && mh != null) {
            sv.dangKyMonHoc(mh);
        }
    }

    public void huyDangKyMonHoc(String maSV, String maMonHoc) {
        SinhVien sv = getSinhVien(maSV);
        MonHoc mh = getMonHoc(maMonHoc);
        if (sv != null && mh != null) {
            sv.huyMonHoc(mh);
        }
    }

    public Map<String, MonHoc> getMonHocs() {
        return monHocs;
    }
}
