package com.example.btvn_android
import java.util.Scanner
import kotlin.math.max
fun main() {
    val scanner = Scanner(System.`in`)
    print("Nhap diem Math: ")
    val math = scanner.nextDouble()
    print("Nhap diem Programming: ")
    val programming = scanner.nextDouble()
    print("Nhap diem Database: ")
    val database = scanner.nextDouble()
    val total = math + programming + database
    val gpa = total / 3
    val maxScore = max(math, max(programming, database))
    val isPassed = gpa >= 5.0
    println("\n--- KET QUA ---")
    println("Tong diem: $total")
    println("Diem trung binh (GPA): $gpa")
    println("Diem cao nhat: $maxScore")
    if (isPassed) {
        println("Ket qua: DAT")
    } else {
        println("Ket qua: KHONG DAT")
    }
}