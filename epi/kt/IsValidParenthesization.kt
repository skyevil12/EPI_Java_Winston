package epi.kt

import java.util.ArrayDeque

object IsValidParenthesization {
    fun isWellFormed(s: String): Boolean {
        var map = HashMap<Char, Char>()
        map[')'] = '('//round brackets
        map[']'] = '['//square brackets
        map['}'] = '{'//curly brackets
        var stack = ArrayDeque<Char>()
        for(i in s.indices) {
            var cur = s[i]
            if(!map.containsKey(cur)) {
                stack.push(cur)
            } else {
                if(stack.isEmpty() || stack.pop() != map[cur]) {
                    return false
                }
            }
        }

        return stack.isEmpty()
    }
}