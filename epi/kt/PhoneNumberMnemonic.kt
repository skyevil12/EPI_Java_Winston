package epi.kt

import java.lang.StringBuilder

object PhoneNumberMnemonic {
    var map = arrayOf(arrayOf('0'), arrayOf('1'), arrayOf('A', 'B', 'C')
            , arrayOf('D', 'E', 'F'), arrayOf('G', 'H', 'I'), arrayOf('J', 'K', 'L')
            , arrayOf('M', 'N', 'O'), arrayOf('P', 'Q', 'R', 'S'), arrayOf('T', 'U', 'V')
            , arrayOf('W', 'X', 'Y', 'Z'))

    fun phoneMnemonic(phoneNumber: String): List<String> {
        /*var chars = phoneNumber.toCharArray()
        var rtList = ArrayList<String>()

        core(chars, 0, rtList)
        return rtList*/

        //Iterative, T O(4^N * 4^N) S O(4^N)
        var rtList = ArrayList<String>()
        rtList.add("")
        for(ch in phoneNumber.toCharArray()) {
            var tmp = ArrayList<String>()
            for(ch in map[ch - '0']) {
                for(cur in rtList) {
                    tmp.add(StringBuilder(cur).append(ch).toString())
                }
            }
            rtList = ArrayList(tmp);
        }

        return rtList
    }

    fun core(chars: CharArray, cur: Int, rtList: MutableList<String>): Unit {
        if(cur == chars.size) {
            rtList.add(String(chars))
            return
        }

        var ori = chars[cur]
        var idx = ori - '0'
        for(ch in map[idx]) {
            chars[cur] = ch
            core(chars, cur + 1, rtList)
        }
        chars[cur] = ori
    }
}