package epi.kt

import java.lang.StringBuilder
import java.util.ArrayDeque

object DirectoryPathNormalization {
    fun shortestEquivalentPath(path: String): String {
       /*
        Separate path by using '/' and pop when met '..'
        */
        var pathStrs = path.split("/")
        var deque = ArrayDeque<String>()
        for(i in pathStrs.indices) {
            var cur = pathStrs[i]
            when (cur) {
                ".." -> {
                    deque.pollFirst()
                }
                "." -> {
                }
                else -> {
                    deque.offerFirst(cur)
                }
            }
        }

        var rt = StringBuilder()
        while(deque.isEmpty()) {
            rt.append(deque.pollLast());
        }

        return rt.toString()
    }
}