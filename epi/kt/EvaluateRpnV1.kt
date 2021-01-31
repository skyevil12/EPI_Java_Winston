package epi.kt

import java.util.*

object EvaluateRpnV1 {
    fun eval(expression: String) : Int {
        var stack = ArrayDeque<Int>();
        var strs = expression.split(",")

        for(i in strs.size - 1 downTo 0) {
            val str = strs[i];
            if("+-*/".contains(str)) {
                val first = stack.pop()
                val second = stack.pop()
                when (str) {
                    "+" -> {
                        stack.push(first + second)
                    }
                    "-" -> {
                        stack.push(first - second)
                    }
                    "*" -> {
                        stack.push(first * second)
                    }
                    "/" -> {
                        stack.push(first / second)
                    }
                }
            } else {
                stack.push(Integer.valueOf(str));
            }
        }

        return stack.pop()
    }
}

fun main() {
    print("val is ${EvaluateRpnV1.eval("+,4,/,13,5")}")
}