fun main() {
    val ten = "Nguyễn Thiện Nhân"
    val maSinhVien = "MSSV123"

    val math = 8.0
    val programming = 7.0
    val database = 9.0

    val tong = math + programming + database
    val trungBinh = tong / 3

    println("Tên sinh viên: $ten")
    println("Mã sinh viên: $maSinhVien")
    println("Điểm Math: $math")
    println("Điểm Programming: $programming")
    println("Điểm Database: $database")
    println("Tổng điểm: $tong")
    println("Điểm trung bình: $trungBinh")

    if (math > programming && math > database) {
        println("Điểm cao nhất: $math")
    } else if (programming > database) {
        println("Điểm cao nhất: $programming")
    } else {
        println("Điểm cao nhất: $database")
    }

    if (trungBinh >= 5.0) {
        println("Sinh viên có đạt không? Có")
    } else {
        println("Sinh viên có đạt không? Không")
    }
}