package epi.kt

object RomanToInteger {
    private var map = hashMapOf('I' to 1, 'V' to 5, 'X' to 10, 'L' to 50, 'C' to 100, 'D' to 500, 'M' to 1000)

    /*
    "LIX"
     */
    fun romanToInteger(s: String): Int {
        var rt = 0
        var prev = Integer.MAX_VALUE

        for(ch in s.toCharArray()) {
            var num = map[ch]
            //Suppose all ch are valid char
            if(num!! > prev) {
                rt -= (2 * prev)
            }
            rt += num
            prev = num
        }

        return rt
    }

    fun isValid(s: String): Boolean {
        return false
    }

    fun integerToRoman(num: Int): String {
        return ""
    }
}