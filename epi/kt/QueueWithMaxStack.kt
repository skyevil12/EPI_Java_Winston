package epi.kt

import java.util.ArrayDeque

open class QueueWithMaxStack {
    private var inStack = MaxStack()
    private var outStack = MaxStack()

    fun enqueue(x : Int) {
        while(!inStack.empty()) {
            outStack.push(inStack.pop())
        }

        inStack.push(x)

        while(!outStack.empty()) {
            inStack.push(outStack.pop())
        }
    }

    fun dequeue() : Int {
        return inStack.pop()
    }

    fun max() : Int {
        return inStack.max()
    }

    class MaxStack {
        private val stack = ArrayDeque<Array<Int>>()
        fun push(x : Int) {
            if(stack.isEmpty()) {
                stack.push(arrayOf(x, x))
            } else {
                stack.push(arrayOf(x, Math.max(x, stack.peek()[1])))
            }
        }

        fun pop() : Int {
            return stack.pop()[0]
        }

        fun max() : Int {
            return stack.peek()[1]
        }

        fun empty() : Boolean {
            return stack.isEmpty()
        }
    }
}