package com.example.practicepdfreader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //activity_main 은 xml파일임.
        setContentView(R.layout.activity_main) // Resource의 layout에 있는 activity_main을 불러와라

        val tv : TextView = findViewById(R.id.tv_hello)
        val btn : Button = findViewById(R.id.button1)
        var second : Int = 0
        var isRunning = false
        var timerTask : Timer? = null

        btn.setOnClickListener{
            isRunning = !isRunning
            if(isRunning){
                timerTask = kotlin.concurrent.timer(period=1000){
                    second++
                    runOnUiThread{
                        tv.text = second.toString()
                    }
                }
            }
            else{
                timerTask?.cancel()
            }
        }
        //tv.text = "안녕"
    }
}