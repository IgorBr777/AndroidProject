package com.example.androidproject.utils.coroutines

import android.util.Log
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*

class CoroutinesExample {

    fun testCoroutines(){

        CoroutineScope(Dispatchers.IO).launch {

            val job= launch {
                for ( i in 1..5){
                    Log.w("called","$i")
                    delay(400)

                }
            }
            Log.w("start","started")
            job.join()
            Log.w("finish","finished")

        }


    }


    fun testCoroutinesCancel(){

        CoroutineScope(CoroutineName("TMS Lesson28")+ Dispatchers.IO).launch {
            val job = launch {
                for (i in 1..5) {
                    Log.w("called", "$i")
                    delay(400)

                }
            }
            Log.w("start", "started")
            job.cancel()
            Log.w("finish", "${coroutineContext[CoroutineName.Key]}")


        }

    }



}