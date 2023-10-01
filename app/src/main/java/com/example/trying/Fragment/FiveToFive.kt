package com.example.trying.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.trying.MainActivity
import com.example.trying.R
import com.example.trying.Utiil.Utills
import com.example.trying.databinding.FiveXFiveBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

 class FiveToFive:Fragment() , CoroutineScope by MainScope() {

    private var wall:Int=3
    private var clickTwice:Int=0
    private lateinit var binding: FiveXFiveBinding
    private var imageClickable= arrayOf(0,0,0,0,0,
        0,0,0,0,0,
        0,0,0,0,0,
        0,0,0,0,0,
        0,0,0,0,0)

    private var playerChoice=2

    private var turn:Int=1

    private var matrix = arrayOf(
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
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=FiveXFiveBinding.inflate(layoutInflater)

        playerChoice=(context as MainActivity).intent.getIntExtra("PLAYER",2)

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

        binding.b5.setOnClickListener{
            if (isClickable(4)) {
                perfromAction(binding.b5, 0, 4, 4)
            }
        }

        binding.b6.setOnClickListener {
            if (isClickable(5)) {
                perfromAction(binding.b6, 1, 0, 5)
            }
        }
        binding.b7.setOnClickListener {
            if (isClickable(6)) {
                perfromAction(binding.b7, 1, 1, 6)
            }
        }

        binding.b8.setOnClickListener {
            if (isClickable(7)) {
                perfromAction(binding.b8, 1, 2, 7)
            }
        }

        binding.b9.setOnClickListener {
            if (isClickable(8)) {
                perfromAction(binding.b9, 1, 3, 8)
            }
        }

        binding.b10.setOnClickListener {
            if (isClickable(9)) {
                perfromAction(binding.b10, 1, 4, 9)
            }
        }

        binding.b11.setOnClickListener {
            if (isClickable(10)) {
                perfromAction(binding.b11, 2, 0, 10)
            }
        }

        binding.b12.setOnClickListener {
            if (isClickable(11)) {
                perfromAction(binding.b12, 2, 1, 11)
            }
        }


        binding.b13.setOnClickListener {
            if (isClickable(12)) {
                perfromAction(binding.b13, 2, 2, 12)
            }
        }

        binding.b14.setOnClickListener {
            if (isClickable(13)) {
                perfromAction(binding.b14, 2, 3, 13)
            }
        }

        binding.b15.setOnClickListener {
            if (isClickable(14)) {
                perfromAction(binding.b15, 2, 4, 14)
            }
        }

        binding.b16.setOnClickListener {
            if (isClickable(15)) {
                perfromAction(binding.b16, 3, 0, 15)
            }
        }


        binding.b17.setOnClickListener {
            if (isClickable(16)) {
                perfromAction(binding.b17, 3, 1, 16)
            }
        }

        binding.b18.setOnClickListener {
            if (isClickable(17)) {
                perfromAction(binding.b18, 3, 2, 17)
            }
        }

        binding.b19.setOnClickListener {
            if (isClickable(18)) {
                perfromAction(binding.b19, 3, 3, 18)
            }
        }

        binding.b20.setOnClickListener {
            if (isClickable(19)) {
                perfromAction(binding.b20, 3, 4, 19)
            }
        }

        binding.b21.setOnClickListener {
            if (isClickable(20)) {
                perfromAction(binding.b21, 4, 0, 20)
            }
        }

        binding.b22.setOnClickListener {
            if (isClickable(21)) {
                perfromAction(binding.b22, 4, 1, 21)
            }
        }

        binding.b23.setOnClickListener {
            if (isClickable(22)) {
                perfromAction(binding.b23, 4, 2,22)
            }
        }


        binding.b24.setOnClickListener {
            if (isClickable(23)) {
                perfromAction(binding.b24, 4, 3, 23)
            }
        }

        binding.b25.setOnClickListener {
            if (isClickable(24)) {
                perfromAction(binding.b25, 4, 4, 24)
            }
        }

    }
    private fun restart(){
        wall=3
        clickTwice=0

         imageClickable= arrayOf(0,0,0,0,0,
            0,0,0,0,0,
            0,0,0,0,0,
            0,0,0,0,0,
            0,0,0,0,0)

         turn=1

         matrix = arrayOf(
            arrayOf(-1, -1, -1, -1, -1),
            arrayOf(-1, -1, -1, -1, -1),
            arrayOf(-1, -1, -1, -1, -1),
            arrayOf(-1, -1, -1, -1, -1),
            arrayOf(-1, -1, -1, -1, -1),
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
    private fun isAnyBoxClikable(): Boolean{
        for(element in imageClickable){
            if(element ==0){
                return true
            }
        }
        return false
    }

    inner class ImageContainer(val  imageView: ImageView,val  index: Int)
    inner class IndexContainer(val x : Int, val y:Int)


    fun minmax(depth:Int, alpha : Int, beta:Int, isMaximizing: Boolean):Int{
        if(depth==5) return -2
        if(check()==1) return depth-7
        if(check()==0) return 7 -depth
        if(check()==2) return -2
        var bestScore=Integer.MIN_VALUE
        if(isMaximizing){
            for (i in 0 until wall) {
                for (j in 0 until wall) {
                    if (matrix[i][j] == -1) {
                        matrix[i][j] = 0
                        val score = minmax(depth+1, alpha, beta,false)
                        matrix[i][j] = -1
                        bestScore = maxOf(bestScore, score)
                        var b= maxOf(beta,score)
                        if (b <= alpha) {
                            return break
                        }
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
                        val score = minmax( depth+1,alpha,beta,true)
                        matrix[i][j] = -1
                        bestScore = minOf(bestScore, score)
                        var a = minOf(alpha,score)
                        if (beta <= a) {
                            return break
                        }
                    }

                }
            }
            return bestScore
        }
    }

    fun getBestMove(): IndexContainer {
        var bestMoveRow = -1
        var bestMoveCol = -1
        var bestScore = Int.MIN_VALUE
        for(i in 0 until wall){
            for(j in 0 until wall){
                if (matrix[i][j]==-1){
                    matrix[i][j]=0
                    val score=minmax(0, Int.MIN_VALUE, Int.MAX_VALUE,false)
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
        else if(x==0 && y==4) {
            return ImageContainer(binding.b5, 4)
        }
        else if(x==1 && y==0) {
            return ImageContainer(binding.b6, 5)
        }
        else if(x==1 && y==1) {
            return ImageContainer(binding.b7, 5)
        }
        else if(x==1 && y==2) {
            return ImageContainer(binding.b8, 6)
        }
        else if(x==1 && y==3) {
            return ImageContainer(binding.b9, 8)
        }
        else if(x==1 && y==4) {
            return ImageContainer(binding.b10, 9)
        }
        else if(x==2 && y==0) {
            return ImageContainer(binding.b11, 10)
        }
        else if(x==2 && y==1) {
            return ImageContainer(binding.b12, 11)
        }
        else if(x==2 && y==2) {
            return ImageContainer(binding.b13, 12)
        }
        else if(x==2 && y==3) {
            return ImageContainer(binding.b14, 13)
        }
        else if(x==2 && y==4) {
            return ImageContainer(binding.b15, 14)
        }

        else if(x==3 && y==0) {
            return ImageContainer(binding.b16, 15)
        }
        else if(x==3 && y==1) {
            return ImageContainer(binding.b17, 16)
        }
        else if(x==3 && y==2) {
            return ImageContainer(binding.b18, 17)
        }
        else if(x==3 && y==3) {
            return ImageContainer(binding.b19, 18)
        }
        else if(x==3 && y==4) {
            return ImageContainer(binding.b20, 19)
        }
        else if(x==4 && y==0) {
            return ImageContainer(binding.b21, 20)
        }
        else if(x==4 && y==1) {
            return ImageContainer(binding.b22, 21)
        }
        else if(x==4 && y==2) {
            return ImageContainer(binding.b23, 22)
        }
        else if(x==4 && y==3) {
            return ImageContainer(binding.b24, 23)
        }
        else {
            return ImageContainer(binding.b25, 24)
        }
    }

    private fun isPalyerTaskWithAI(){
        val indexContainer=getBestMove()
        val x=indexContainer.x
        val y=indexContainer.y
        val imageContainer=getImageView(x,y)
        imageClickable[imageContainer.index]=1

        matrix[x][y]=0
        launch(Dispatchers.Main) {
            imageContainer.imageView.setImageResource(R.drawable.zero2)
            Utills.SoundBeep(context as MainActivity,R.raw.tozero)
            val win=check()
            if(Utills.winner(win,context as MainActivity)){
                isClickableInitialaxation()
                return@launch
            }
        }
        turn=1
    }


    private fun perfromAction( imageView: ImageView, x:Int, y:Int, index:Int) {
        clickTwice++
        if(clickTwice >2 && wall<5){
            wall++
        }

        imageClickable[index]=1
        if(turn==1){
            matrix[x][y]=1
            imageView.setImageResource(R.drawable.cross)
            Utills.SoundBeep(context as MainActivity,R.raw.tox)
            turn=0
            val win=check()
            if(Utills.winner(win,context as MainActivity)){
                isClickableInitialaxation()
                return
            }
            if( playerChoice==1 && isAnyBoxClikable()){
                launch(Dispatchers.IO) {
                    delay(200)
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
            isClickableInitialaxation()
            return
        }
    }
    private fun isClickable(imageNumber:Int):Boolean{
        if(imageClickable[imageNumber]==0){
            return true
        }
        return false
    }

    fun isClickableInitialaxation(){
        imageClickable= arrayOf(1,1,1,1,1,
            1,1,1,1,1,
            1,1,1,1,1,
            1,1,1,1,1,
            1,1,1,1,1)
    }


    private fun check() :Int{
        for (i in 0 until 5) {
            if (matrix[i][0] == matrix[i][1] && matrix[i][1] == matrix[i][2] &&matrix[i][2]==matrix[i][3] &&matrix[i][1] != -1
                || matrix[i][1] == matrix[i][2] && matrix[i][2] == matrix[i][3] && matrix[i][4]==matrix[i][3] && matrix[i][1]!=-1) {
                return matrix[i][1] // Row win
            }
            if (matrix[0][i] == matrix[1][i] && matrix[1][i] == matrix[2][i] && matrix[3][i]==matrix[2][i] && matrix[0][i] != -1
                ||matrix[1][i] == matrix[2][i] && matrix[2][i] == matrix[3][i] && matrix[3][i]==matrix[4][i]  && matrix[1][i] != -1) {
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
            return matrix[2][3]
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