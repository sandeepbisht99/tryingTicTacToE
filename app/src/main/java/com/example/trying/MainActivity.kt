package com.example.trying

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.trying.Fragment.FiveToFive
import com.example.trying.Fragment.FourToFour
import com.example.trying.Fragment.ThreeToThree
import com.example.trying.Utiil.Utills
import com.example.trying.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val type=intent.getIntExtra("TYPE",0)

        val supportFragmentManager=supportFragmentManager

        val transaction= supportFragmentManager.beginTransaction()

        val frame=when(type){
            0-> ThreeToThree()
            1->FourToFour()
            2->FiveToFive()
            else-> ThreeToThree()
        }

        transaction.replace(R.id.framelayout,frame)
        transaction.commit()

    }



    override fun onBackPressed() {
        super.onBackPressed()
        Utills.destroy()
    }

    override fun onDestroy() {
        super.onDestroy()
        Utills.destroy()
    }
}