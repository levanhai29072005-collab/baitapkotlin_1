package com.example.lamapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Tạo đối tượng SinhVien và truyền thông tin bản thân
        val sv = SinhVien(
            hoTen = "Lê Văn Hải",
            maSV = "12345678",              // Nhập mã sinh viên của bạn
            lop = "126LTTD01",              // Nhập tên lớp
            chuyenNganh = "Công nghệ Thông tin"
        )

        // Gọi hàm HienThi() và đưa lên app
        val tvKetQua = findViewById<TextView>(R.id.tvKetQua)
        tvKetQua.text = sv.HienThi()
    }
}