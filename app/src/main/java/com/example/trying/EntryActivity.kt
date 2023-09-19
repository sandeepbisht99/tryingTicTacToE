package com.example.trying

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.trying.databinding.ActivityEntryBinding

class EntryActivity : AppCompatActivity() {
    lateinit var binding: ActivityEntryBinding

     var playerchoice: Int=2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityEntryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.TwoPlayer.setBackgroundResource(R.drawable.back)
        binding.TwoPlayer.setOnClickListener {
            binding.TwoPlayer.setBackgroundResource(R.drawable.back)
            binding.SinglePlayer.setBackgroundResource(R.drawable.buttonbackground)
            playerchoice=2
        }

        binding.SinglePlayer.setOnClickListener {
            binding.SinglePlayer.setBackgroundResource(R.drawable.back)
            binding.TwoPlayer.setBackgroundResource(R.drawable.buttonbackground)
            playerchoice=1
        }



        binding.layout3x3.setOnClickListener { startActivty(0) }

        binding.layout4x4.setOnClickListener { startActivty(1) }

        binding.layout5x5.setOnClickListener { startActivty(2) }

    }

    private fun startActivty(value: Int){
        val intent=Intent(this@EntryActivity,MainActivity::class.java)
        intent.putExtra("TYPE",value)
        intent.putExtra("PLAYER",playerchoice)
        startActivity(intent)
    }
}