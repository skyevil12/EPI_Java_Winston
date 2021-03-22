package epi.kt

object AdvanceByOffsets {
    fun canReachEnd(maxAdvanceSteps: List<Int>): Boolean {
        val len = maxAdvanceSteps.size
        var min = len - 1

        for(i in len - 2 downTo 0) {
            if(i + maxAdvanceSteps[i] >= min) {
                min = i;
            }
        }

        return min == 0
    }
}