package com.example.btvn_android
import java.util.Scanner
class Student(
    var id: String,
    var fullName: String,
    var age: Int,
    var major: String,
    var gpa: Double
)
val scanner = Scanner(System.`in`)

// 5 sinh vien mau (nen doi thong tin de khong bi trung voi bai khac)
val list = arrayListOf(
    Student("SV01", "Le Van Hai", 20, "CNTT", 8.6),
    Student("SV02", "Tran Thi Binh", 22, "Kinh Te", 7.5),
    Student("SV03", "Nguyen Van Cuong", 19, "CNTT", 4.2),
    Student("SV04", "Pham Thi Dung", 23, "Dien Tu", 8.2),
    Student("SV05", "Hoang Van Em", 21, "Kinh Te", 6.9)
)
fun inTieuDe() {
    println("------------------------------------------------------------")
    System.out.printf("%-10s %-20s %-8s %-12s %-6s\n", "ID", "Full Name", "Age", "Major", "GPA")
    println("------------------------------------------------------------")
}
fun inSinhVien(s: Student) {
    System.out.printf("%-10s %-20s %-8d %-12s %-6.2f\n", s.id, s.fullName, s.age, s.major, s.gpa)
}
// 1. Add student
fun themSinhVien() {
    print("Nhap ID: ")
    val id = scanner.nextLine().trim()
    print("Nhap Full Name: ")
    val name = scanner.nextLine().trim()

    var age: Int? = null
    while (age == null || age <= 0) {
        print("Nhap Age (> 0): ")
        age = scanner.nextLine().toIntOrNull()
        if (age == null || age <= 0) println("Tuoi khong hop le, vui long nhap lai!")
    }

    print("Nhap Major: ")
    val major = scanner.nextLine().trim()

    var gpa: Double? = null
    while (gpa == null || gpa < 0.0 || gpa > 10.0) {
        print("Nhap GPA (0.0 -> 10.0): ")
        gpa = scanner.nextLine().toDoubleOrNull()
        if (gpa == null || gpa < 0.0 || gpa > 10.0) println("GPA khong hop le, vui long nhap lai!")
    }

    list.add(Student(id, name, age, major, gpa))
    println(">> Them sinh vien thanh cong!")
}

// 2. Display all students (Kèm các tùy chọn sắp xếp hiển thị)
fun hienThiTatCa() {
    if (list.isEmpty()) {
        println(">> Danh sach trong!")
        return
    }
    println("\n--- DISPLAY OPTIONS ---")
    println("1. Danh sach mac dinh")
    println("2. Sap xep GPA giam dan")
    println("3. Sap xep theo tuoi tang dan")
    println("4. Sap xep theo ten (A-Z)")
    print("Chon cach hien thi: ")

    val dsHienThi = ArrayList(list)
    when (scanner.nextLine().toIntOrNull()) {
        2 -> {
            // Bubble sort GPA giam dan
            for (i in 0 until dsHienThi.size - 1) {
                for (j in 0 until dsHienThi.size - 1 - i) {
                    if (dsHienThi[j].gpa < dsHienThi[j + 1].gpa) {
                        val t = dsHienThi[j]
                        dsHienThi[j] = dsHienThi[j + 1]
                        dsHienThi[j + 1] = t
                    }
                }
            }
            println(">> Danh sach sap xep GPA giam dan:")
        }
        3 -> {
            // Bubble sort tuoi tang dan
            for (i in 0 until dsHienThi.size - 1) {
                for (j in 0 until dsHienThi.size - 1 - i) {
                    if (dsHienThi[j].age > dsHienThi[j + 1].age) {
                        val t = dsHienThi[j]
                        dsHienThi[j] = dsHienThi[j + 1]
                        dsHienThi[j + 1] = t
                    }
                }
            }
            println(">> Danh sach sap xep theo tuoi:")
        }
        4 -> {
            // Sap xep theo ten (lay tu cuoi cung trong Full Name)
            for (i in 0 until dsHienThi.size - 1) {
                for (j in 0 until dsHienThi.size - 1 - i) {
                    val ten1 = dsHienThi[j].fullName.trim().substringAfterLast(" ")
                    val ten2 = dsHienThi[j + 1].fullName.trim().substringAfterLast(" ")
                    if (ten1.compareTo(ten2, ignoreCase = true) > 0) {
                        val t = dsHienThi[j]
                        dsHienThi[j] = dsHienThi[j + 1]
                        dsHienThi[j + 1] = t
                    }
                }
            }
            println(">> Danh sach sap xep theo ten (A-Z):")
        }
        else -> println(">> Danh sach sinh vien:")
    }

    inTieuDe()
    for (s in dsHienThi) inSinhVien(s)
}

// 3. Search student
fun timKiem() {
    println("\n--- SEARCH MENU ---")
    println("1. Tim theo GPA tu 7.0 den 8.5")
    println("2. Tim tat ca sinh vien theo mot nganh")
    println("3. Tim sinh vien theo mot phan ten")
    println("4. Tim kiem theo ID sinh vien")
    print("Chon: ")
    val c = scanner.nextLine().toIntOrNull() ?: 0

    when (c) {
        1 -> {
            var count = 0
            inTieuDe()
            for (s in list) {
                if (s.gpa in 7.0..8.5) {
                    inSinhVien(s)
                    count++
                }
            }
            if (count == 0) println("Khong tim thay sinh vien nao co GPA tu 7.0 den 8.5")
        }
        2 -> {
            print("Nhap ten nganh can tim: ")
            val nganh = scanner.nextLine().trim()
            var count = 0
            inTieuDe()
            for (s in list) {
                if (s.major.equals(nganh, ignoreCase = true)) {
                    inSinhVien(s)
                    count++
                }
            }
            if (count == 0) println("Khong tim thay sinh vien thuoc nganh $nganh")
        }
        3 -> {
            print("Nhap mot phan ten: ")
            val ten = scanner.nextLine().trim()
            var count = 0
            inTieuDe()
            for (s in list) {
                if (s.fullName.lowercase().contains(ten.lowercase())) {
                    inSinhVien(s)
                    count++
                }
            }
            if (count == 0) println("Khong co sinh vien nao khop voi chuoi '$ten'")
        }
        4 -> {
            print("Nhap ID sinh vien: ")
            val maTim = scanner.nextLine().trim()
            var timThay = false
            for (s in list) {
                if (s.id.equals(maTim, ignoreCase = true)) {
                    inTieuDe()
                    inSinhVien(s)
                    timThay = true
                    break
                }
            }
            if (!timThay) println(">> Khong tim thay sinh vien co ID: $maTim")
        }
        else -> println("Lua chon khong hop le!")
    }
}

// 4. Calculate average GPA & Thong ke
fun tinhGpaVaDem() {
    if (list.isEmpty()) {
        println(">> Danh sach trong!")
        return
    }

    var demGioi = 0
    var demYeu = 0
    var tongGpa = 0.0

    for (s in list) {
        tongGpa += s.gpa
        if (s.gpa >= 8.0) demGioi++
        if (s.gpa < 5.0) demYeu++
    }

    println("\n--- THONG KE GPA ---")
    System.out.printf("GPA trung binh toan truong: %.2f\n", (tongGpa / list.size))
    println("So sinh vien GPA >= 8.0: $demGioi")
    println("So sinh vien GPA < 5.0: $demYeu")

    print("\nNhap nganh can tinh GPA trung binh: ")
    val nganh = scanner.nextLine().trim()
    var tongNganh = 0.0
    var demNganh = 0

    for (s in list) {
        if (s.major.equals(nganh, ignoreCase = true)) {
            tongNganh += s.gpa
            demNganh++
        }
    }

    if (demNganh > 0) {
        System.out.printf("GPA trung binh nganh %s: %.2f (Co %d sinh vien)\n", nganh, (tongNganh / demNganh), demNganh)
    } else {
        println(">> Khong co sinh vien nao thuoc nganh $nganh")
    }
}

// 5. Find student with highest GPA, Oldest & Top 3
fun timGpaCaoNhatVaLonTuoiNhat() {
    if (list.isEmpty()) {
        println(">> Danh sach trong!")
        return
    }

    var maxGpa = list[0]
    var lonTuoi = list[0]

    for (s in list) {
        if (s.gpa > maxGpa.gpa) maxGpa = s
        if (s.age > lonTuoi.age) lonTuoi = s
    }

    println("\n>> Sinh vien co GPA cao nhat:")
    inTieuDe()
    inSinhVien(maxGpa)

    println("\n>> Sinh vien lon tuoi nhat:")
    inTieuDe()
    inSinhVien(lonTuoi)

    // Hien thi 3 sinh vien GPA cao nhat
    println("\n>> Top 3 sinh vien co GPA cao nhat:")
    val tam = ArrayList(list)
    for (i in 0 until tam.size - 1) {
        for (j in 0 until tam.size - 1 - i) {
            if (tam[j].gpa < tam[j + 1].gpa) {
                val t = tam[j]
                tam[j] = tam[j + 1]
                tam[j + 1] = t
            }
        }
    }
    inTieuDe()
    val top = if (tam.size < 3) tam.size else 3
    for (i in 0 until top) inSinhVien(tam[i])
}

// 6. Remove student
fun xoaSinhVien() {
    print("Nhap ID can xoa: ")
    val id = scanner.nextLine().trim()
    var viTri = -1

    for (i in 0 until list.size) {
        if (list[i].id.equals(id, ignoreCase = true)) {
            viTri = i
            break
        }
    }

    if (viTri != -1) {
        list.removeAt(viTri)
        println(">> Da xoa sinh vien co ID $id thanh cong!")
    } else {
        println(">> Khong tim thay sinh vien co ID: $id")
    }
}

fun main() {
    var chay = true
    while (chay) {
        println("\n========== STUDENT MANAGEMENT ==========")
        println("1. Add student")
        println("2. Display all students")
        println("3. Search student")
        println("4. Calculate average GPA")
        println("5. Find student with highest GPA")
        println("6. Remove student")
        println("0. Exit")
        println("========================================")
        print("Choose: ")

        when (scanner.nextLine().toIntOrNull() ?: -1) {
            1 -> themSinhVien()
            2 -> hienThiTatCa()
            3 -> timKiem()
            4 -> tinhGpaVaDem()
            5 -> timGpaCaoNhatVaLonTuoiNhat()
            6 -> xoaSinhVien()
            0 -> {
                println("Tam biet!")
                chay = false
            }
            else -> println("Lua chon khong hop le! Vui long nhap tu 0 den 6.")
        }
    }
}