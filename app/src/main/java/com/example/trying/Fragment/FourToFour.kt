package com.example.trying.Fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.trying.MainActivity
import com.example.trying.R
import com.example.trying.Utiil.Utills
import com.example.trying.databinding.FourXFourBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class FourToFour:Fragment() , CoroutineScope by MainScope() {
    lateinit var binding: FourXFourBinding
    private var wall=2
    var imageClickable= arrayOf(0,0,0,0,
        0,0,0,0,
        0,0,0,0,
        0,0,0,0)
    private var playerChoice=2


    private var turn:Int=1;

    private var matrix = arrayOf(
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
        val view=binding.root
        return  view
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=FourXFourBinding.inflate(layoutInflater)

        playerChoice=(context as MainActivity).intent.getIntExtra("PLAYER",2)
        Toast.makeText(context,"playerChoice "+playerChoice,Toast.LENGTH_SHORT).show()
        if(playerChoice!=2){
            isPalyerTaskWithAI()
        }
        binding.restart.setOnClickListener { restart() }

        binding.b1.setOnClickListener {
            if (isClickable(0)) {
                perfromAction(binding.b1, 0, 0,0)
            }
        }

        binding.b2.setOnClickListener {
            if (isClickable(1)) {
                perfromAction(binding.b2, 0, 1,1)
            }
        }

        binding.b3.setOnClickListener {
            if (isClickable(2)) {
                perfromAction(binding.b3, 0, 2,2)
            }
        }


        binding.b4.setOnClickListener {
            if (isClickable(3)) {
                perfromAction(binding.b4, 0, 3,3)
            }
        }

        binding.b5.setOnClickListener {
            if (isClickable(4)) {
                perfromAction(binding.b5, 1, 0,4)
            }
        }

        binding.b6.setOnClickListener {
            if (isClickable(5)) {
                perfromAction(binding.b6, 1, 1,5)
            }
        }
        binding.b7.setOnClickListener {
            if (isClickable(6)) {
                perfromAction(binding.b7, 1, 2,6)
            }
        }

        binding.b8.setOnClickListener {
            if (isClickable(7)) {
                perfromAction(binding.b8, 1, 3,7)
            }
        }

        binding.b9.setOnClickListener {
            if (isClickable(8)) {
                perfromAction(binding.b9, 2, 0,8)
            }
        }

        binding.b10.setOnClickListener {
            if (isClickable(9)) {
                perfromAction(binding.b10, 2, 1,9)
            }
        }

        binding.b11.setOnClickListener {
            if (isClickable(10)) {
                perfromAction(binding.b11, 2, 2,10)
            }
        }

        binding.b12.setOnClickListener {
            if (isClickable(11)) {
                perfromAction(binding.b12, 2, 3,11)
            }
        }


        binding.b13.setOnClickListener {
            if (isClickable(12)) {
                perfromAction(binding.b13, 3, 0,12)
            }
        }

        binding.b14.setOnClickListener {
            if (isClickable(13)) {
                perfromAction(binding.b14, 3, 1,13)
            }
        }

        binding.b15.setOnClickListener {
            if (isClickable(14)) {
                perfromAction(binding.b15, 3, 2,14)
            }
        }

        binding.b16.setOnClickListener {
            if (isClickable(15)) {
                perfromAction(binding.b16, 3, 3,15)
            }
        }
    }
    private fun restart(){
        wall=2
        imageClickable= arrayOf(0,0,0,0,
            0,0,0,0,
            0,0,0,0,
            0,0,0,0)


         turn=1

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

    private fun getImageView(x: Int, y:Int): ImageContainer {
        if(x==0 && y==0) {
            return ImageContainer(binding.b1, 0)
        }else if(x==0 && y==1) {
            return ImageContainer(binding.b2, 1)
        }
        else if(x==0 && y==2) {
            return ImageContainer(binding.b3, 2)
        }
        else if(x==0 && y==3) {
            return ImageContainer(binding.b4, 3)
        }
        else if(x==1 && y==0) {
            return ImageContainer(binding.b5, 4)
        }
        else if(x==1 && y==1) {
            return ImageContainer(binding.b6, 5)
        }
        else if(x==1 && y==2) {
            return ImageContainer(binding.b7, 6)
        }
        else if(x==1 && y==3) {
            return ImageContainer(binding.b8, 7)
        }
        else if(x==2 && y==0) {
            return ImageContainer(binding.b9, 8)
        }
        else if(x==2 && y==1) {
            return ImageContainer(binding.b10, 9)
        }
        else if(x==2 && y==2) {
            return ImageContainer(binding.b11, 10)
        }
        else if(x==2 && y==3) {
            return ImageContainer(binding.b12, 11)
        }
        else if(x==3 && y==0) {
            return ImageContainer(binding.b13, 12)
        }
        else if(x==3 && y==1) {
            return ImageContainer(binding.b14, 13)
        }
        else if(x==3 && y==2) {
            return ImageContainer(binding.b15, 14)
        }
        else {
            return ImageContainer(binding.b16, 15)
        }
    }

    private fun minmax(depth:Int, isMaximizing: Boolean):Int{
        if(depth==5) return -2
        if(check()==1) return depth-6
        if(check()==0) return 6 -depth
        if(check()==2) return -2

        if(isMaximizing){
            var bestScore = Int.MIN_VALUE
            for (i in 0 until wall) {
                for (j in 0 until wall) {
                    if (matrix[i][j] == -1) {
                        matrix[i][j] = 0
                        val score = minmax(depth+1,false)
                        matrix[i][j] = -1
                        bestScore = maxOf(bestScore, score)
                    }
                }
            }
            return bestScore
        }else{
            var bestScore = Int.MAX_VALUE
            for (i in 0 until wall) {
                for (j in 0 until wall) {
                    if (matrix[i][j] ==-1) {
                        matrix[i][j] = 1
                        val score = minmax( depth+1,true)
                        matrix[i][j] = -1
                        bestScore = minOf(bestScore, score)
                    }
                }
            }
            return bestScore
        }
    }

     class ImageContainer(val  imageView: ImageView,val  index: Int)
     class IndexContainer(val x : Int, val y:Int)

    fun getBestMove(): IndexContainer{
        var bestMoveRow = -1
        var bestMoveCol = -1
        var bestScore = Int.MIN_VALUE
        for(i in 0 until wall){
            for(j in 0 until wall){
                if (matrix[i][j]==-1){
                    matrix[i][j]=0
                    val score=minmax(0,false)
                    matrix[i][j]=-1
                    if (score > bestScore) {
                        bestScore = score
                        bestMoveRow = i
                        bestMoveCol = j
                    }
                }

            }
        }
        if(bestMoveCol!=-1 && bestMoveRow!=-1){
            return IndexContainer(bestMoveRow, bestMoveCol)
        }
        return  IndexContainer(bestMoveRow, bestMoveCol)
    }


    private fun isPalyerTaskWithAI(){
        if(wall<4){
            wall++
        }
        val indexContainer=getBestMove()
        val x=indexContainer.x
        val y=indexContainer.y
        val imageContainer=getImageView(x,y)
        imageClickable[imageContainer.index]=1
        matrix[x][y]=0
        launch(Dispatchers.Main){
            imageContainer.imageView.setImageResource(R.drawable.zero2)
            Utills.SoundBeep(context as MainActivity,R.raw.tozero)
            val win=check()
            if(Utills.winner(win,context as MainActivity)){
                imageClickable= arrayOf(1,1,1,1,
                    1,1,1,1,
                    1,1,1,1,
                    1,1,1,1)
                return@launch
            }
            turn=1
        }

    }

    private fun isAnyBoxClikable(): Boolean{
        for(element in imageClickable){
            if(element ==0){
                return true
            }
        }
        return false
    }

    private fun perfromAction(imageView: ImageView, x:Int, y:Int,index: Int) {
        Log.d("@sandeep"," "+wall)
        imageClickable[index]=1
        if(turn==1){
            matrix[x][y]=1
            imageView.setImageResource(R.drawable.cross)
            Utills.SoundBeep(context as MainActivity,R.raw.tox)
            turn=0
            val win=check()
            if(Utills.winner(win,context as MainActivity)){
                imageClickable= arrayOf(1,1,1,1,
                    1,1,1,1,
                    1,1,1,1,
                    1,1,1,1)
                return
            }
            if(playerChoice==1 && isAnyBoxClikable()){
                launch(Dispatchers.IO) {
                    isPalyerTaskWithAI()
                }
                turn=1
            }
        }else if(turn==0){
            matrix[x][y]=0
            imageView.setImageResource(R.drawable.zero2)
            Utills.SoundBeep(context as MainActivity,R.raw.tozero)
            turn=1
        }
        val win=check()
        if(Utills.winner(win,context as MainActivity)){
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