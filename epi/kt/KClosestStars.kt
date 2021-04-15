package epi.kt

import epi.KClosestStars
import java.util.*

object KClosestStars {
    fun findClosestKStars(stars: Iterator<KClosestStars.Star>, k: Int): List<KClosestStars.Star> {
        val pq = PriorityQueue<KClosestStars.Star>(Collections.reverseOrder())

        while(stars.hasNext()) {
            pq.offer(stars.next())
            if(pq.size > k) {
                pq.poll()
            }
        }

        return ArrayList(pq)
    }
}