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
import com.example.trying.databinding.FourXFourBinding

class FourToFour:Fragment() {
    lateinit var binding: FourXFourBinding
    var imageClickable= arrayOf(0,0,0,0,
        0,0,0,0,
        0,0,0,0,
        0,0,0,0)

    var turn:Int=1

    var matrix = arrayOf(
        arrayOf(-1, -1, -1,-1),
        arrayOf(-1, -1, -1,-1),
        arrayOf(-1, -1, -1,-1),
        arrayOf(-1, -1, -1,-1)
    )
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return binding.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=FourXFourBinding.inflate(layoutInflater)
        isPlayerTurn()

        binding.restart.setOnClickListener { restart() }

        binding.b1.setOnClickListener {
            if (isClickable(0)) {
                perfromAction(binding.b1, 0, 0)
                imageClickable[0] = 1
            }
        }

        binding.b2.setOnClickListener {
            if (isClickable(1)) {
                perfromAction(binding.b2, 0, 1)
                imageClickable[1] = 1
            }
        }

        binding.b3.setOnClickListener {
            if (isClickable(2)) {
                perfromAction(binding.b3, 0, 2)
                imageClickable[2] = 1
            }
        }


        binding.b4.setOnClickListener {
            if (isClickable(3)) {
                perfromAction(binding.b4, 0, 3)
                imageClickable[3] = 1
            }
        }

        binding.b5.setOnClickListener {
            if (isClickable(4)) {
                perfromAction(binding.b5, 1, 0)
                imageClickable[4] = 1
            }
        }

        binding.b6.setOnClickListener {
            if (isClickable(5)) {
                perfromAction(binding.b6, 1, 1)
                imageClickable[5] = 1
            }
        }

        binding.b7.setOnClickListener {
            if (isClickable(6)) {
                perfromAction(binding.b7, 1, 2)
                imageClickable[6] = 1
            }
        }

        binding.b8.setOnClickListener {
            if (isClickable(7)) {
                perfromAction(binding.b8, 1, 3)
                imageClickable[7] = 1
            }
        }

        binding.b9.setOnClickListener {
            if (isClickable(8)) {
                perfromAction(binding.b9, 2, 0)
                imageClickable[8] = 1
            }
        }

        binding.b10.setOnClickListener {
            if (isClickable(9)) {
                perfromAction(binding.b10, 2, 1)
                imageClickable[9] = 1
            }
        }

        binding.b11.setOnClickListener {
            if (isClickable(10)) {
                perfromAction(binding.b11, 2, 2)
                imageClickable[10] = 1
            }
        }

        binding.b12.setOnClickListener {
            if (isClickable(11)) {
                perfromAction(binding.b12, 2, 3)
                imageClickable[11] = 1
            }
        }


        binding.b13.setOnClickListener {
            if (isClickable(12)) {
                perfromAction(binding.b13, 3, 0)
                imageClickable[12] = 1
            }
        }

        binding.b14.setOnClickListener {
            if (isClickable(13)) {
                perfromAction(binding.b14, 3, 1)
                imageClickable[13] = 1
            }
        }

        binding.b15.setOnClickListener {
            if (isClickable(14)) {
                perfromAction(binding.b15, 3, 2)
                imageClickable[14] = 1
            }
        }

        binding.b16.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                if(isClickable(15)){
                    perfromAction(binding.b16,3,3)
                    imageClickable[15]=1
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
        imageClickable= arrayOf(0,0,0,0,
            0,0,0,0,
            0,0,0,0,
            0,0,0,0)

         turn=1
         isPlayerTurn()

         matrix = arrayOf(
            arrayOf(-1, -1, -1,-1),
            arrayOf(-1, -1, -1,-1),
            arrayOf(-1, -1, -1,-1),
            arrayOf(-1, -1, -1,-1)
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
        binding.b11.setImageResource(R.color.white)
        binding.b12.setImageResource(R.color.white)
        binding.b13.setImageResource(R.color.white)
        binding.b14.setImageResource(R.color.white)
        binding.b15.setImageResource(R.color.white)
        binding.b16.setImageResource(R.color.white)
    }

    private fun perfromAction( imageView: ImageView, x:Int, y:Int) {
        if(turn==1){
            matrix[x][y]=1
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
            imageClickable= arrayOf(1,1,1,1,
                1,1,1,1,
                1,1,1,1,
                1,1,1,1)
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
        for (i in 0 until 4) {
            if (matrix[i][0] == matrix[i][1] && matrix[i][1] == matrix[i][2] && matrix[i][1] != -1
                || matrix[i][1] == matrix[i][2] && matrix[i][2] == matrix[i][3] && matrix[i][1]!=-1) {
                return matrix[i][1] // Row win
            }
            if (matrix[0][i] == matrix[1][i] && matrix[1][i] == matrix[2][i] && matrix[0][i] != -1
                ||matrix[1][i] == matrix[2][i] && matrix[2][i] == matrix[3][i] && matrix[1][i] != -1) {
                return matrix[1][i] // Column win
            }
        }

        if (matrix[0][0] == matrix[1][1] && matrix[1][1] == matrix[2][2] && matrix[0][0] !=-1 ||
            matrix[1][1] == matrix[2][2] && matrix[2][2] == matrix[3][3] && matrix[1][1] !=-1 ) {
            return matrix[1][1] // Diagonal win (top-left to bottom-right)
        }

        if (matrix[1][0] == matrix[2][1] && matrix[2][1] == matrix[3][2] && matrix[1][0] !=-1){
            return matrix[1][0]
        }

        if (matrix[0][1] == matrix[1][2] && matrix[1][2] == matrix[2][3] && matrix[0][1] !=-1){
            return matrix[0][1]
        }

        if (matrix[0][3] ==matrix[1][2] && matrix[1][2] == matrix[2][1] && matrix[0][3] != -1
            || matrix[1][2] ==matrix[2][1] && matrix[2][1] == matrix[3][0] && matrix[1][2] != -1) {
            return matrix[1][2] // Diagonal win (top-right to bottom-left)
        }

        if(matrix[0][2] ==matrix[1][1] && matrix[1][1] == matrix[2][0] && matrix[0][2] != -1 ){
            return matrix[0][2]
        }

        if(matrix[1][3] ==matrix[2][2] && matrix[2][2] == matrix[3][1] && matrix[1][3] != -1){
           return matrix[1][3]
        }

        // Check for a draw
        for (i in 0 until 4) {
            for (j in 0 until 4) {
                if (matrix[i][j] ==-1) {
                    return -1 // Game still ongoing
                }
            }
        }
        return 2
    }

}