package com.example.btvn_android
fun sayHello(name: String) = println("Xin chao $name")
fun add(a: Int, b: Int): Int = a + b
fun calculateAverage(a: Double, b: Double): Double = (a + b) / 2
fun main() {
    print("Nhap ten: ")
    val name = readlnOrNull()?.takeIf { it.isNotBlank() } ?: "Bạn"
    sayHello(name)
    print("Nhap so nguyen a: ")
    val a = readlnOrNull()?.toIntOrNull() ?: 0
    print("Nhap so nguyen b: ")
    val b = readlnOrNull()?.toIntOrNull() ?: 0
    println("Tong = ${add(a, b)}")
    print("Nhập so thuc x: ")
    val x = readlnOrNull()?.toDoubleOrNull() ?: 0.0
    print("Nhập so thuc y: ")
    val y = readlnOrNull()?.toDoubleOrNull() ?: 0.0
    println("Trung Binh Cong = ${calculateAverage(x, y)}")
}