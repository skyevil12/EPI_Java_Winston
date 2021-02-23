package epi.kt

import java.lang.RuntimeException
import java.util.*

open class QueueFromStacks {
    var inStack = ArrayDeque<Int>()
    var outStack = ArrayDeque<Int>()
    //T O(1) S O(N)
    fun enqueue(x : Int) {
        inStack.push(x)
    }
    //T O(N) S O(N)
    fun dequeue() : Int {
        if(outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop())
            }
        }

        if(outStack.isEmpty()) {
            throw RuntimeException("Empty queue!")
        } else {
            return outStack.pop()
        }
    }
}