fun main() {
    println(" BAI 1: In tu 1 den 10")
    for (i in 1..10) {
        print("$i ")
    }
    println("\n")
    println(" BAI 2: Tinh tong 1 den 100" )
    var tong = 0
    for (i in 1..100) {
        tong = tong + i
    }
    println("Tong = $tong\n")
    println("BAI 3: In cac so chan tu 1 den 20 ")
    var so = 1
    while (so <= 20) {
        if (so % 2 == 0) {
            print("$so ")
        }
        so++
    }
    println()
}