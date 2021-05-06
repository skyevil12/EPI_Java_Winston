package epi.kt

object RealSquareRootV1 {
    //https://www.techiedelight.com/division-two-numbers-using-binary-search-algorithm/
    fun divide(x: Double, y: Double) : Double {
//        var l = 1.0
//        var r =
//        if(x > y) {
//
//        }
        return 0.0
    }

    fun compare(a: Double, b: Double) : Int {
        val EPSILON = 0.00000001
        val diff = (a - b) / b

        return when {
            diff < -EPSILON -> {
                -1
            }
            diff > EPSILON -> {
                1
            }
            else -> {
                0
            }
        }
    }
}

fun main() {
    print("5 / 3 = ${RealSquareRootV1.divide(5.0, 3.0)}")
}