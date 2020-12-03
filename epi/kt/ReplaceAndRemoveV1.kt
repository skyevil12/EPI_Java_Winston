package epi.kt

object ReplaceAndRemoveV1 {
    //T O(N) S O(1), constant map usage and in place modification
    fun replaceAndRemove(size: Int, s: CharArray): Int {
        var map: HashMap<Char, String> = HashMap()
        map['.'] = "DOT"
        map[','] = "COMMA"
        map['?'] = "QUESTION MARK"
        map['!'] = "EXCLAMATION MARK"

        var rt = size
        for(ch in s) {
            if(map.containsKey(ch)) {
                rt += (map.get(ch)!!.length - 1)
            }
        }

        var j = rt - 1
        for(i in size - 1 downTo 0) {
            var ch = s[i]
            if(map.containsKey(ch)) {
                for(k in map[ch]!!.length - 1 downTo 0) {
                    s[j--] = map[ch]!![k]
                }
            } else {
                s[j--] = ch
            }
        }

        return rt
    }
}

fun main() {
    val inputStr = "Hello world, Win.Hung! Are you okay?"
    val input = CharArray(100)
    for(i in inputStr.indices) {
        input[i] = inputStr[i]
    }

    var rt = ReplaceAndRemoveV1.replaceAndRemove(inputStr.length, input)

    print(String(input.copyOfRange(0, rt)))
}