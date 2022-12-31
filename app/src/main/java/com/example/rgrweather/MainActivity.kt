package com.example.rgrweather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rgrweather.fragment.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager
            .beginTransaction().replace(R.id.placeholder, MainFragment.newInstance()).commit()
    }

}