package epi.kt

import java.lang.StringBuilder

object SpreadsheetEncoding {
    fun ssDecodeColID(col : String) : Int {
        var rt = 0

        for(i in col.indices) {
            rt = rt * 26 + (col[i] - 'A') + 1
        }

        return rt
    }

    fun ssEncodeColID(id : Int) : String {
        var rt = StringBuilder()
        //Could not change input para
        var vId = id

        while(vId > 0) {
            vId --;
            rt.append('A'.plus(vId % 26))
            vId /= 26
        }

        return rt.reverse().toString()
    }
}