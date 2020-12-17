package epi.kt

import java.lang.StringBuilder

object ValidIpAddresses {
    fun getValidIpAddress(s: String) : List<String> {
        var rtList = ArrayList<String>()

        core(s, 3, 0, StringBuilder(), rtList)

        return rtList
    }

    fun core(s: String, k: Int, st: Int, sb: StringBuilder, rtList: MutableList<String>) : Unit {
        if(k == 0) {
            val str = s.substring(st)
            if(isValid(str)) {
                val oriLen = sb.length
                if(sb.isNotEmpty()) {
                    sb.append(".")
                }
                sb.append(str)
                rtList.add(sb.toString())
                sb.setLength(oriLen)
            }
            return
        }

        for(i in st + 1 .. st + 3) {
            if(i >= s.length) {
                break
            }
            val str = s.substring(st, i)
            if(isValid(str)) {
                val oriLen = sb.length
                if(sb.isNotEmpty()) {
                    sb.append(".")
                }
                sb.append(str)
                core(s, k - 1, i, sb, rtList)
                sb.setLength(oriLen)
            }
        }
    }

    fun isValid(str: String) : Boolean {
        if(str.length > 3 || (str[0] == '0' && str.length > 1)) {
            return false
        }

        var rt = Integer.parseInt(str)
        return rt in 0..255
    }
}