package epi.kt

object IsStringPalindromicPunctuation {
    fun isPalindrome(s: String): Boolean {
        var lS = toLowerCase(s)
        val len = lS.length
        var left = 0
        var right = len - 1

        while(left < right) {
            if(!isAlphaNumeric(lS[left])) {
                left++
                continue
            }

            if(!isAlphaNumeric(lS[right])) {
                right--
                continue
            }

            if(lS[left] != lS[right]) {
                return false
            }

            left++
            right--
        }

        return true
    }

    private fun toLowerCase(s: String): String {
        val sCharArray = s.toCharArray()

        for(i in s.indices) {
            val c = s[i]
            if(c in 'A'..'Z') {
                sCharArray[i] = 'a'.plus(c - 'A')
            }
        }

        return String(sCharArray)
    }

    private fun isAlphaNumeric(ch: Char): Boolean {
        return (ch in '0'..'9') || (ch in 'a'..'z')
    }
}