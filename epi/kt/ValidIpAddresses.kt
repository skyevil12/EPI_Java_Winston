/*Guideline
All eng 
Edge cases and example
Alg and complexity
*/
package epi.kt

import java.lang.StringBuilder

object ValidIpAddresses {

    /*
     	T O(3 ^ k) S O(3^k*N)
	s	19216811
	k	3	2	1	0
	st	0	1	2	3
	i	1	2	3	4
	sb	1	1, 9	1, 9, 2	1, 9, 2, 16811
	
*/

    fun getValidIpAddress(s: String): List<String> {
        var rtList = ArrayList<String>()
        core(s, 3, 0, StringBuilder(), rtList)
        return rtList;
    }

    fun core(s: String, k: Int, st: Int, sb: StringBuilder, rtList: MutableList<String>) {
        if (k == 0) {
            //Time to add to list
            val section = s.substring(st)
            if (isValid(section)) {
                val oriLen = sb.length
                if (sb.isNotEmpty()) {
                    sb.append('.')
                }
                sb.append(section)
                rtList.add(sb.toString())
                sb.setLength(oriLen)
            }
            return
        }

        for (i in st + 1..st + 3) {
            if (i >= s.length) {
                break
            }
            val section = s.substring(st, i)
            if (!isValid(section)) {
                break
            }

            val oriLen = sb.length
            if (sb.isNotEmpty()) {
                sb.append('.')
            }
            sb.append(section)
            core(s, k - 1, i, sb, rtList)
            sb.setLength(oriLen)
        }
    }

    fun isValid(section: String): Boolean {
        if (section.length > 3 || (section[0] == '0' && section.length > 1)) {
            return false
        }

        val rt = Integer.valueOf(section)
        return rt in 0..255
    }
}














