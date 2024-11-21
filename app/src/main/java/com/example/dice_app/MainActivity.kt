package com.example.dice_app

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.dice_app.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        var diceImg1 = binding.diceImg1
        var diceImg2 = binding.diceImg2
        var diceImgList = arrayOf(
            R.drawable.dice_1,
            R.drawable.dice_2,
            R.drawable.dice_3,
            R.drawable.dice_4,
            R.drawable.dice_5,
            R.drawable.dice_6,
        )
        binding.diceStartBtn.setOnClickListener {
            Toast.makeText(this, "주사위 Go!", Toast.LENGTH_LONG).show()
            Log.d("MainActivity",  Random.nextInt(1, 6).toString())

            var ran1 = Random.nextInt(0, 5)
            var ran2 = Random.nextInt(0, 5)

            diceImg1.setImageResource(diceImgList[ran1])
            diceImg2.setImageResource(diceImgList[ran2])
        }
    }
}