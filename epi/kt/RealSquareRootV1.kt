package epi.kt

object RealSquareRootV1 {
    //https://www.techiedelight.com/division-two-numbers-using-binary-search-algorithm/
    fun divide(x: Double, y: Double) : Double {
        var l = 0.0
        var r = Double.MAX_VALUE

        while(true) {
            val m = l + (r - l) * 0.5
            when {
                compare(y * m, x) == 0 -> {
                    return m
                }
                compare(y * m, x) == 1 -> {
                    r = m
                }
                compare(y * m, x) == -1 -> {
                    l = m
                }
            }
        }
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