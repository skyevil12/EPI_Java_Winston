package epi.kt

import java.util.ArrayDeque

open class QueueFromStacksEnqueue {
    var inStack = ArrayDeque<Int>()
    var outStack = ArrayDeque<Int>()
    //Enqueue T O(N) S O(1)
    fun enqueue(x : Int) {
        //Move all cur to another stack, think about the case that cur have 1, 2
        /*
            inS     outS
            1
            2
            ===Move to another
                    2
                    1
            ===push enqueued element
            3
            ===pop outStack and push to inStack
            2
            3       1
            ===finish
            1
            2
            3
         */
        while(!inStack.isEmpty()) {
            outStack.push(inStack.pop())
        }

        inStack.push(x)
        while(!outStack.isEmpty()) {
            inStack.push(outStack.pop())
        }
    }

    fun dequeue() : Int {
        return inStack.pop()
    }
}