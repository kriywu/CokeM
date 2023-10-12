package com.wurengao.mycloudmusic

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val year = Calendar.getInstance()[Calendar.YEAR]
        findViewById<TextView>(R.id.copyright).text = getString(R.string.copyright, year)
    }
}