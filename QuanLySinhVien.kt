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

// 5 sinh vien mau duoc tao san luon tai day
val list = arrayListOf(
    Student("SV01", "le Van Hai", 20, "CNTT", 8.6),
    Student("SV02", "Tran Thi Binh", 22, "Kinh Te", 7.5),
    Student("SV03", "Le Van Cuong", 19, "CNTT", 3.8),
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
    val id = scanner.nextLine()
    print("Nhap Full Name: ")
    val name = scanner.nextLine()
    print("Nhap Age: ")
    val age = scanner.nextLine().toInt()
    print("Nhap Major: ")
    val major = scanner.nextLine()
    print("Nhap GPA: ")
    val gpa = scanner.nextLine().toDouble()

    list.add(Student(id, name, age, major, gpa))
    println(" Them sinh vien thanh cong!")
}

// 2. Display all students
fun hienThiTatCa() {
    if (list.isEmpty()) {
        println("Danh sach trong!")
        return
    }
    inTieuDe()
    for (s in list) {
        inSinhVien(s)
    }
}

// 3. Search student
fun timKiem() {
    println("1. Tim theo GPA tu 7.0 den 8.5")
    println("2. Tim tat ca sinh vien theo mot nganh")
    println("3. Tim sinh vien theo mot phan ten")
    println("4. Tim kiem theo ID SINH VIEN")
    print("Chon: ")
    val c = scanner.nextLine().toInt()

    if (c == 1) {
        inTieuDe()
        for (s in list) {
            if (s.gpa >= 7.0 && s.gpa <= 8.5) {
                inSinhVien(s)
            }
        }
    } else if (c == 2) {
        print("Nhap ten nganh: ")
        val nganh = scanner.nextLine()
        inTieuDe()
        for (s in list) {
            if (s.major.equals(nganh, ignoreCase = true)) {
                inSinhVien(s)
            }
        }
    } else if (c == 3) {
        print("Nhap mot phan ten: ")
        val ten = scanner.nextLine()
        inTieuDe()
        for (s in list) {
            if (s.fullName.lowercase().contains(ten.lowercase())) {
                inSinhVien(s)
            }
        }
    } else if (c == 4) {
        print("Nhap ID sinh vien: ")
        val maTim = scanner.nextLine()
        var timThay = false

        for (s in list) {
            if (s.id.equals(maTim, ignoreCase = true)) {
                inTieuDe()
                inSinhVien(s)
                timThay = true
                break
            }
        }

        if (!timThay) {
            println(">> Khong tim thay sinh vien co ID: $maTim")
        }
    }
}

// 4. Calculate average GPA & Dem GPA
fun tinhGpaVaDem() {
    var demGioi = 0
    var demYeu = 0
    var tongGpa = 0.0

    for (s in list) {
        tongGpa += s.gpa
        if (s.gpa >= 8.0) demGioi++
        if (s.gpa < 5.0) demYeu++
    }

    println("GPA trung binh toan truong: " + (tongGpa / list.size))
    println("So sinh vien GPA >= 8.0: $demGioi")
    println("So sinh vien GPA < 5.0: $demYeu")

    print("Nhap nganh can tinh GPA trung binh: ")
    val nganh = scanner.nextLine()
    var tongNganh = 0.0
    var demNganh = 0

    for (s in list) {
        if (s.major.equals(nganh, ignoreCase = true)) {
            tongNganh += s.gpa
            demNganh++
        }
    }

    if (demNganh > 0) {
        println("GPA trung binh nganh $nganh: " + (tongNganh / demNganh))
    } else {
        println("Khong co sinh vien nao thuoc nganh $nganh")
    }
}

// 5. Find student with highest GPA & Oldest
fun timGpaCaoNhatVaLonTuoiNhat() {
    if (list.isEmpty()) return

    var maxGpa = list[0]
    var lonTuoi = list[0]

    for (s in list) {
        if (s.gpa > maxGpa.gpa) maxGpa = s
        if (s.age > lonTuoi.age) lonTuoi = s
    }

    println(">> Sinh vien co GPA cao nhat:")
    inTieuDe()
    inSinhVien(maxGpa)

    println(">> Sinh vien lon tuoi nhat:")
    inTieuDe()
    inSinhVien(lonTuoi)
}

// 6. Remove student
fun xoaSinhVien() {
    print("Nhap ID can xoa: ")
    val id = scanner.nextLine()
    var viTri = -1

    for (i in 0 until list.size) {
        if (list[i].id.equals(id, ignoreCase = true)) {
            viTri = i
            break
        }
    }

    if (viTri != -1) {
        list.removeAt(viTri)
        println(">> Da xoa thanh cong!")
    } else {
        println(">> Khong tim thay ID nay!")
    }
}

// 7. Sap xep & Top 3
fun sapXepMenu() {
    println("1. Sap xep GPA giam dan & Top 3")
    println("2. Sap xep theo tuoi tang dan")
    println("3. Sap xep theo First Name (A-Z)")
    println("4. Sap xep theo ket qua (PASS truoc, ROT sau)")
    print("Chon: ")
    val c = scanner.nextLine().toInt()

    val tam = ArrayList(list)

    if (c == 1) {
        // Bubble sort GPA giam dan
        for (i in 0 until tam.size - 1) {
            for (j in 0 until tam.size - 1 - i) {
                if (tam[j].gpa < tam[j + 1].gpa) {
                    val t = tam[j]
                    tam[j] = tam[j + 1]
                    tam[j + 1] = t
                }
            }
        }
        println(">> Danh sach sau sap xep GPA giam dan:")
        inTieuDe()
        for (s in tam) inSinhVien(s)

        println(">> Top 3 sinh vien GPA cao nhat:")
        inTieuDe()
        val top = if (tam.size < 3) tam.size else 3
        for (i in 0 until top) inSinhVien(tam[i])

    } else if (c == 2) {
        // Bubble sort tuoi tang dan
        for (i in 0 until tam.size - 1) {
            for (j in 0 until tam.size - 1 - i) {
                if (tam[j].age > tam[j + 1].age) {
                    val t = tam[j]
                    tam[j] = tam[j + 1]
                    tam[j + 1] = t
                }
            }
        }
        inTieuDe()
        for (s in tam) inSinhVien(s)

    } else if (c == 3) {
        // Bubble sort: Lay tu cuoi cung trong Ho va Ten (First Name kieu Viet) de so sanh
        for (i in 0 until tam.size - 1) {
            for (j in 0 until tam.size - 1 - i) {
                val ten1 = tam[j].fullName.trim().substringAfterLast(" ")
                val ten2 = tam[j + 1].fullName.trim().substringAfterLast(" ")

                if (ten1.compareTo(ten2, ignoreCase = true) > 0) {
                    val t = tam[j]
                    tam[j] = tam[j + 1]
                    tam[j + 1] = t
                }
            }
        }
        println(">> Danh sach sau sap xep theo First Name (A-Z):")
        inTieuDe()
        for (s in tam) inSinhVien(s)

    } else if (c == 4) {
        // Bubble sort: PASS (gpa >= 4.0) dung truoc, ROT (gpa < 4.0) dung sau
        for (i in 0 until tam.size - 1) {
            for (j in 0 until tam.size - 1 - i) {
                if (tam[j].gpa < 4.0 && tam[j + 1].gpa >= 4.0) {
                    val t = tam[j]
                    tam[j] = tam[j + 1]
                    tam[j + 1] = t
                }
            }
        }
        println(">> Danh sach sau sap xep (PASS truoc, ROT sau):")
        println("----------------------------------------------------------------------")
        System.out.printf("%-10s %-20s %-8s %-12s %-6s %-8s\n", "ID", "Full Name", "Age", "Major", "GPA", "Status")
        println("----------------------------------------------------------------------")
        for (s in tam) {
            val status = if (s.gpa >= 4.0) "PASS" else "ROT"
            System.out.printf("%-10s %-20s %-8d %-12s %-6.2f %-8s\n", s.id, s.fullName, s.age, s.major, s.gpa, status)
        }
        println("----------------------------------------------------------------------")
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
        println("7. Sap xep & Top 3")
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
            7 -> sapXepMenu()
            0 -> {
                println("Tam biet!")
                chay = false
            }
            else -> println("Lua chon khong hop le!")
        }
    }
}