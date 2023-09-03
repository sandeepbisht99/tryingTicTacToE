package com.example.trying

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.viewbinding.ViewBinding
import com.example.trying.databinding.ActivityMainBinding
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var imageClickable= arrayOf(0,0,0,0,0,0,0,0,0)

    lateinit var listImageview: List<ImageView>

    var turn:Int=1;

    var matrix = arrayOf(
        arrayOf(-1, -1, -1),
        arrayOf(-1, -1, -1),
        arrayOf(-1, -1, -1)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listImageview= listOf(
            binding.b1,
            binding.b2,
            binding.b3,
            binding.b4,
            binding.b5,
            binding.b6,
            binding.b7,
            binding.b8,
            binding.b9
        )

        binding.restart.setOnClickListener(object :View.OnClickListener{
            override fun onClick(view: View) {
                restart()
            }

        })

        binding.b1.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                if(isClickable(0)){
                    perfromAction(binding.b1,0,0)
                    imageClickable[0]=1;
                }
            }
        })

        binding.b2.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                if(isClickable(1)){
                    perfromAction(binding.b2,0,1)
                    imageClickable[1]=1;
                }
            }
        })

        binding.b3.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                if(isClickable(2)){
                    perfromAction(binding.b3,0,2)
                    imageClickable[2]=1;
                }
            }
        })


        binding.b4.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                if(isClickable(3)){
                    perfromAction(binding.b4,1,0)
                    imageClickable[3]=1;
                }
            }
        })

        binding.b5.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                if(isClickable(4)){
                    perfromAction(binding.b5,1,1)
                    imageClickable[4]=1;
                }
            }
        })

        binding.b6.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                if(isClickable(5)){
                    perfromAction(binding.b6,1,2)
                    imageClickable[5]=1;
                }
            }
        })
        binding.b7.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                if(isClickable(6)){
                    perfromAction(binding.b7,2,0)
                    imageClickable[6]=1;
                }
            }
        })

        binding.b8.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                if(isClickable(7)){
                    perfromAction(binding.b8,2,1)
                    imageClickable[7]=1;
                }
            }
        })

        binding.b9.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                if(isClickable(8)){
                    perfromAction(binding.b9,2,2)
                    imageClickable[8]=1;
                }
            }
        })
    }

    private fun restart(){
         imageClickable= arrayOf(0,0,0,0,0,0,0,0,0)

        turn =1

        matrix = arrayOf(
            arrayOf(-1, -1, -1),
            arrayOf(-1, -1, -1),
            arrayOf(-1, -1, -1)
        )

        binding.b1.setImageResource(R.color.white)
        binding.b2.setImageResource(R.color.white)
        binding.b3.setImageResource(R.color.white)
        binding.b4.setImageResource(R.color.white)
        binding.b5.setImageResource(R.color.white)
        binding.b6.setImageResource(R.color.white)
        binding.b7.setImageResource(R.color.white)
        binding.b8.setImageResource(R.color.white)
        binding.b9.setImageResource(R.color.white)
    }

    private fun perfromAction( imageView: ImageView, x:Int, y:Int) {
        if(turn==1){
            matrix[x][y]=1;
            imageView.setImageResource(R.drawable.cross)
            turn=0
        }else if(turn==0){
            matrix[x][y]=0
            imageView.setImageResource(R.drawable.zero2)
            turn=1
        }
        val win=check()
        if(winner(win)){
            imageClickable= arrayOf(1,1,1,1,1,1,1,1,1)
            return
        }
    }
    private fun isClickable(imageNumber:Int):Boolean{
        if(imageClickable[imageNumber]==0){
            return true
        }
        return false
    }

    private fun winner(win: Int):Boolean {
        if(win==1){
            Toast.makeText(this,"x is winner",Toast.LENGTH_SHORT).show()
            return true
        }else if(win==0){
            Toast.makeText(this,"0 is winner",Toast.LENGTH_SHORT).show()
            return true
        }else if(win==2){
            Toast.makeText(this,"Game Drow",Toast.LENGTH_SHORT).show()
            return true
        }
        return false
    }

    private fun check() :Int{
        for (i in 0 until 3) {
            if (matrix[i][0] == matrix[i][1] && matrix[i][1] == matrix[i][2] && matrix[i][0] != -1) {
                return matrix[i][0] // Row win
            }
            if (matrix[0][i] == matrix[1][i] && matrix[1][i] == matrix[2][i] && matrix[0][i] != -1) {
                return matrix[0][i] // Column win
            }
        }

        if (matrix[0][0] == matrix[1][1] && matrix[1][1] == matrix[2][2] && matrix[0][0] !=-1) {
            return matrix[0][0] // Diagonal win (top-left to bottom-right)
        }

        if (matrix[0][2] ==matrix[1][1] && matrix[1][1] == matrix[2][0] && matrix[0][2] != -1) {
            return matrix[0][2] // Diagonal win (top-right to bottom-left)
        }

        // Check for a draw
        for (i in 0 until 3) {
            for (j in 0 until 3) {
                if (matrix[i][j] ==-1) {
                    return -1 // Game still ongoing
                }
            }
        }
        return 2
    }
}