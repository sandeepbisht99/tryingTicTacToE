package com.example.trying.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.trying.MainActivity
import com.example.trying.R
import com.example.trying.databinding.FiveXFiveBinding
import com.example.trying.databinding.FourXFourBinding

class FiveToFive:Fragment() {
    lateinit var binding: FiveXFiveBinding
    var imageClickable= arrayOf(0,0,0,0,0,
        0,0,0,0,0,
        0,0,0,0,0,
        0,0,0,0,0,
        0,0,0,0,0)


    var turn:Int=1;

    var matrix = arrayOf(
        arrayOf(-1, -1, -1,-1,-1),
        arrayOf(-1, -1, -1,-1,-1),
        arrayOf(-1, -1, -1,-1,-1),
        arrayOf(-1, -1, -1,-1,-1),
        arrayOf(-1, -1, -1,-1,-1),
    )
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         super.onCreateView(inflater,container, savedInstanceState)
        val view=binding.root
        return view
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=FiveXFiveBinding.inflate(layoutInflater)
        isPlayerTurn()


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
                    perfromAction(binding.b4,0,3)
                    imageClickable[3]=1;
                }
            }
        })

        binding.b5.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                if(isClickable(4)){
                    perfromAction(binding.b5,0,4)
                    imageClickable[4]=1;
                }
            }
        })

        binding.b6.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                if(isClickable(5)){
                    perfromAction(binding.b6,1,0)
                    imageClickable[5]=1;
                }
            }
        })
        binding.b7.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                if(isClickable(6)){
                    perfromAction(binding.b7,1,1)
                    imageClickable[6]=1;
                }
            }
        })

        binding.b8.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                if(isClickable(7)){
                    perfromAction(binding.b8,1,2)
                    imageClickable[7]=1;
                }
            }
        })

        binding.b9.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                if(isClickable(8)){
                    perfromAction(binding.b9,1,3)
                    imageClickable[8]=1;
                }
            }
        })

        binding.b10.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                if(isClickable(9)){
                    perfromAction(binding.b10,1,4)
                    imageClickable[9]=1;
                }
            }
        })

        binding.b11.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                if(isClickable(10)){
                    perfromAction(binding.b11,2,0)
                    imageClickable[10]=1;
                }
            }
        })

        binding.b12.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                if(isClickable(11)){
                    perfromAction(binding.b12,2,1)
                    imageClickable[11]=1;
                }
            }
        })


        binding.b13.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                if(isClickable(12)){
                    perfromAction(binding.b13,2,2)
                    imageClickable[12]=1;
                }
            }
        })

        binding.b14.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                if(isClickable(13)){
                    perfromAction(binding.b14,2,3)
                    imageClickable[13]=1;
                }
            }
        })

        binding.b15.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                if(isClickable(14)){
                    perfromAction(binding.b15,2,4)
                    imageClickable[14]=1;
                }
            }
        })

        binding.b16.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                if(isClickable(15)){
                    perfromAction(binding.b16,3,0)
                    imageClickable[15]=1;
                }
            }
        })


        binding.b17.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                if(isClickable(16)){
                    perfromAction(binding.b17,3,1)
                    imageClickable[16]=1;
                }
            }
        })

        binding.b18.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                if(isClickable(17)){
                    perfromAction(binding.b18,3,2)
                    imageClickable[17]=1;
                }
            }
        })

        binding.b19.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                if(isClickable(18)){
                    perfromAction(binding.b19,3,3)
                    imageClickable[18]=1;
                }
            }
        })

        binding.b20.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                if(isClickable(19)){
                    perfromAction(binding.b20,3,4)
                    imageClickable[19]=1;
                }
            }
        })

        binding.b21.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                if(isClickable(20)){
                    perfromAction(binding.b21,4,0)
                    imageClickable[20]=1;
                }
            }
        })

        binding.b22.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                if(isClickable(21)){
                    perfromAction(binding.b22,4,1)
                    imageClickable[21]=1;
                }
            }
        })

        binding.b23.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                if(isClickable(22)){
                    perfromAction(binding.b23,4,2)
                    imageClickable[22]=1;
                }
            }
        })


        binding.b24.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                if(isClickable(23)){
                    perfromAction(binding.b24,4,3)
                    imageClickable[23]=1;
                }
            }
        })

        binding.b25.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                if(isClickable(24)){
                    perfromAction(binding.b25,4,4)
                    imageClickable[24]=1;
                }
            }
        })

    }
    private fun isPlayerTurn(){
        if(turn==1){
            binding.crossLayout.setBackgroundResource(R.drawable.shape)
            binding.zeroLayout.setBackgroundResource(R.drawable.shape2)
        }else{
            binding.zeroLayout.setBackgroundResource(R.drawable.shape)
            binding.crossLayout.setBackgroundResource(R.drawable.shape2)
        }
    }
    private fun restart(){
         imageClickable= arrayOf(0,0,0,0,0,
            0,0,0,0,0,
            0,0,0,0,0,
            0,0,0,0,0,
            0,0,0,0,0)


         turn=1

         matrix = arrayOf(
            arrayOf(-1, -1, -1,-1,-1),
            arrayOf(-1, -1, -1,-1,-1),
            arrayOf(-1, -1, -1,-1,-1),
            arrayOf(-1, -1, -1,-1,-1),
            arrayOf(-1, -1, -1,-1,-1),
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
        binding.b10.setImageResource(R.color.white)
        binding.b12.setImageResource(R.color.white)
        binding.b11.setImageResource(R.color.white)
        binding.b13.setImageResource(R.color.white)
        binding.b14.setImageResource(R.color.white)
        binding.b15.setImageResource(R.color.white)
        binding.b16.setImageResource(R.color.white)
        binding.b17.setImageResource(R.color.white)
        binding.b18.setImageResource(R.color.white)
        binding.b19.setImageResource(R.color.white)
        binding.b20.setImageResource(R.color.white)
        binding.b21.setImageResource(R.color.white)
        binding.b22.setImageResource(R.color.white)
        binding.b23.setImageResource(R.color.white)
        binding.b24.setImageResource(R.color.white)
        binding.b25.setImageResource(R.color.white)
    }

    private fun perfromAction( imageView: ImageView, x:Int, y:Int) {
        if(turn==1){
            matrix[x][y]=1;
            imageView.setImageResource(R.drawable.cross)
            turn=0
            isPlayerTurn()
        }else if(turn==0){
            matrix[x][y]=0
            imageView.setImageResource(R.drawable.zero2)
            turn=1
            isPlayerTurn()
        }
        val win=check()
        if(winner(win)){
            imageClickable= arrayOf(1,1,1,1,1,
                1,1,1,1,1,
                1,1,1,1,1,
                1,1,1,1,1,
                1,1,1,1,1)
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
            Toast.makeText(context as MainActivity,"x is winner", Toast.LENGTH_SHORT).show()
            return true
        }else if(win==0){
            Toast.makeText(context as MainActivity,"0 is winner", Toast.LENGTH_SHORT).show()
            return true
        }else if(win==2){
            Toast.makeText(context as MainActivity,"Game Drow", Toast.LENGTH_SHORT).show()
            return true
        }
        return false
    }

    private fun check() :Int{
        for (i in 0 until 5) {
            if (matrix[i][0] == matrix[i][1] && matrix[i][1] == matrix[i][2] &&matrix[i][2]==matrix[i][3] &&matrix[i][1] != -1
                || matrix[i][1] == matrix[i][2] && matrix[i][2] == matrix[i][3] && matrix[i][4]==matrix[i][3] && matrix[i][1]!=-1) {
                return matrix[i][1] // Row win
            }
            if (matrix[0][i] == matrix[1][i] && matrix[1][i] == matrix[2][i] && matrix[3][i]==matrix[2][i] && matrix[0][i] != -1
                ||matrix[1][i] == matrix[2][i] && matrix[2][i] == matrix[3][i] && matrix[1][i] != -1) {
                return matrix[1][i] // Column win
            }
        }

        if (matrix[0][0] == matrix[1][1] && matrix[1][1] == matrix[2][2] && matrix[2][2]==matrix[3][3] && matrix[0][0] !=-1 ||
            matrix[1][1] == matrix[2][2] && matrix[2][2] == matrix[3][3] && matrix[3][3]==matrix[4][4] && matrix[1][1] !=-1 ) {
            return matrix[1][1] // Diagonal win (top-left to bottom-right)
        }

        if (matrix[1][0] == matrix[2][1] && matrix[2][1] == matrix[3][2] && matrix[3][2]==matrix[4][3] && matrix[1][0] !=-1){
            return matrix[1][0]
        }

        if (matrix[0][1] == matrix[1][2] && matrix[1][2] == matrix[2][3] && matrix[2][3]==matrix[3][4] && matrix[0][1] !=-1){
            return matrix[0][1]
        }

        if (matrix[0][4] ==matrix[1][3] && matrix[1][3] == matrix[2][2] && matrix[2][2]==matrix[3][1] && matrix[0][4] != -1
            || matrix[1][3] ==matrix[2][2] && matrix[2][2] == matrix[3][1] && matrix[3][1]==matrix[4][0] && matrix[1][3] != -1) {
            return matrix[1][3] // Diagonal win (top-right to bottom-left)
        }

        if(matrix[0][3] ==matrix[1][2] && matrix[1][2] == matrix[2][1] && matrix[2][1] == matrix[3][0] && matrix[0][3] != -1 ){
            return matrix[0][3]
        }

        if(matrix[1][4] ==matrix[2][3] && matrix[2][3] == matrix[3][2] && matrix[3][2] == matrix[4][1] && matrix[1][4] != -1){
            return matrix[1][3]
        }


        // Check for a draw
        for (i in 0 until 5) {
            for (j in 0 until 5) {
                if (matrix[i][j] ==-1) {
                    return -1 // Game still ongoing
                }
            }
        }
        return 2
    }

}