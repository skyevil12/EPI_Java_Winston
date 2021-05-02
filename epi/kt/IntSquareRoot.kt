package epi.kt

object IntSquareRoot {
    fun squareRoot(k : Int) : Int {
        var l = (0).toLong()
        var r = k.toLong()

        while(l < r) {
            val m : Long = l + (r - l) / 2
            val mVal : Long = m * m

            if(mVal >= k) {
                r = m
            } else {
                l = m + 1
            }
        }

        return if(l * l == k.toLong()) {
            l.toInt()
        } else {
            (l - 1).toInt()
        }
    }
}