package com.example.trying

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.trying.databinding.ActivityEntryBinding

class EntryActivity : AppCompatActivity() {
    lateinit var binding: ActivityEntryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityEntryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.layout3x3.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                val intent=Intent(this@EntryActivity,MainActivity::class.java)
                intent.putExtra("TYPE",0)
                startActivity(intent)
            }
        })

        binding.layout4x4.setOnClickListener(object :View.OnClickListener{
            override fun onClick(view: View) {
                val intent=Intent(this@EntryActivity,MainActivity::class.java)
                intent.putExtra("TYPE",1)
                startActivity(intent)
            }
        })

        binding.layout5x5.setOnClickListener(object :View.OnClickListener{
            override fun onClick(view: View) {
                val intent=Intent(this@EntryActivity,MainActivity::class.java)
                intent.putExtra("TYPE",2)
                startActivity(intent)
            }
        })

    }
}