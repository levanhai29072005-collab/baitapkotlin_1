package com.example.lamapp

class SinhVien(
    var hoTen: String,
    var maSV: String,
    var lop: String,
    var chuyenNganh: String
) {
    // Hàm HienThi trả về chuỗi thông tin theo yêu cầu đề bài
    fun HienThi(): String {
        return "THÔNG TIN SINH VIÊN\n\n" +
                "Họ và tên: $hoTen\n" +
                "Mã SV: $maSV\n" +
                "Lớp: $lop\n" +
                "Chuyên ngành: $chuyenNganh"
    }
}