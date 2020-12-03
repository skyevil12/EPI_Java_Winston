package epi.kt

object ReverseWords {
    fun reverseWords(input: CharArray) {
        val len = input.size
        reverseString(input, 0, len - 1)

        var st = 0
        var ed = -1
        while(true) {
            ed = find(input, st, ' ')
            if(ed == -1) {
                break
            }

            reverseString(input, st, ed - 1)
            st = ed + 1
        }
    }

    private fun reverseString(chars: CharArray, st: Int, ed: Int) {
        var lSt = st
        var lEd = ed
        while(lSt < lEd) {
            var tmp = chars[lSt]
            chars[lSt] = chars[lEd]
            chars[lEd] = tmp
            lSt++
            lEd--
        }
    }

    private fun find(chars: CharArray, st: Int, target: Char): Int {
        val len = chars.size
        if(st >= len) {
            return -1
        }

        for(i in st until len) {
            if(chars[i] == target) {
                return i
            }
        }

        return len
    }
}