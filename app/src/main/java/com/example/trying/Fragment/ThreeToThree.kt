package com.example.trying.Fragment
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.trying.MainActivity
import com.example.trying.R
import com.example.trying.Utiil.Utills
import com.example.trying.databinding.ThreeXThreeBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ThreeToThree: Fragment(), CoroutineScope by MainScope() {
    private val binding  by lazy { ThreeXThreeBinding.inflate(layoutInflater) }
    var imageClickable= arrayOf(0,0,0,0,0,0,0,0,0)
    var playerChoice=2

    private var turn:Int=1;

    private var matrix = arrayOf(
        arrayOf(-1, -1, -1),
        arrayOf(-1, -1, -1),
        arrayOf(-1, -1, -1)
    )

     val cells by lazy {
         arrayOf(
             arrayOf(binding.b1, binding.b2, binding.b3),
             arrayOf(binding.b4, binding.b5, binding.b6),
             arrayOf(binding.b7, binding.b8, binding.b9)
         )
     }




    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
         super.onCreateView(inflater, container, savedInstanceState)
         return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.restart.setOnClickListener { restart() }
        playerChoice=(context as MainActivity).intent.getIntExtra("PLAYER",2)
        Toast.makeText(context,"playerChoice "+playerChoice, Toast.LENGTH_SHORT).show()

        /*CoroutineScope(Dispatchers.Main).launch {
            delay(50)
            if(playerChoice!=2){
                isPalyerTaskWithAI()
            }
        }*/


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
                perfromAction(binding.b4, 1, 0,3)
            }
        }

        binding.b5.setOnClickListener {
            if (isClickable(4)) {
                perfromAction(binding.b5, 1, 1,4)
            }
        }

        binding.b6.setOnClickListener {
            if (isClickable(5)) {
                perfromAction(binding.b6, 1, 2,5)
            }
        }
        binding.b7.setOnClickListener {
            if (isClickable(6)) {
                perfromAction(binding.b7, 2, 0,6)
            }
        }

        binding.b8.setOnClickListener {
            if (isClickable(7)) {
                perfromAction(binding.b8, 2, 1,7)
            }
        }

        binding.b9.setOnClickListener {
            if (isClickable(8)) {
                perfromAction(binding.b9, 2, 2,8)
            }
        }
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

     class ImageContainer(val  imageView: ImageView,val  index: Int)
     class IndexContainer(val x : Int, val y:Int)

     private fun getImageView(x: Int, y:Int):ImageContainer{
         if(x==0 && y==0) {
             return ImageContainer(binding.b1, 0)
         }else if(x==0 && y==1) {
             return ImageContainer(binding.b2, 1)
         }
         else if(x==0 && y==2) {
             return ImageContainer(binding.b3, 2)
         }
         else if(x==1 && y==0) {
             return ImageContainer(binding.b4, 3)
         }
         else if(x==1 && y==1) {
             return ImageContainer(binding.b5, 4)
         }
         else if(x==1 && y==2) {
             return ImageContainer(binding.b6, 5)
         }
         else if(x==2 && y==0) {
             return ImageContainer(binding.b7, 6)
         }
         else if(x==2 && y==1) {
             return ImageContainer(binding.b8, 7)
         }
         else {
             return ImageContainer(binding.b9, 8)
         }
     }

     private fun minmax(depth:Int, isMaximizing: Boolean):Int{
         if(check()==1) return depth-10
         if(check()==0) return 10 -depth
         if(check()==2) return -2

         if(isMaximizing){
             var bestScore = Int.MIN_VALUE
             for (i in 0 until 3) {
                 for (j in 0 until 3) {
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
             for (i in 0 until 3) {
                 for (j in 0 until 3) {
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

     fun getBestMove():IndexContainer{
         var bestMoveRow = -1
         var bestMoveCol = -1
         var bestScore = Int.MIN_VALUE
         for(i in 0 until 3){
             for(j in 0 until 3){
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
             val indexContainer=IndexContainer(bestMoveRow, bestMoveCol)
             return indexContainer
         }
         val indexContainer=IndexContainer(bestMoveRow, bestMoveCol)
        return  indexContainer
     }

     fun isPalyerTaskWithAI(){
             var indexContainer = getBestMove()
             val x = indexContainer.x
             val y = indexContainer.y
             val imageContainer = getImageView(x, y)
             imageClickable[imageContainer.index] = 1
             matrix[x][y] = 0
             launch(Dispatchers.Main) {
                 imageContainer.imageView.setImageResource(R.drawable.zero2)
                 Utills.SoundBeep(context as MainActivity, R.raw.tozero)
             }
             turn = 1


     }

     private fun isAnyBoxClikable(): Boolean{
         for(element in imageClickable){
             if(element==0){
                 return true
             }
         }
         return false
     }

    private fun perfromAction( imageView: ImageView, x:Int, y:Int, index:Int) {
        //animateWinningCells()
        imageClickable[index]=1
        if(turn==1){
            matrix[x][y]=1
            imageView.setImageResource(R.drawable.cross)
            Utills.SoundBeep(context as MainActivity,R.raw.tox)
            val win=check()
            if(Utills.winner(win,context as MainActivity)){
                imageClickable= arrayOf(1,1,1,1,1,1,1,1,1)
                return
            }
            turn=0

            if(playerChoice==1 && isAnyBoxClikable()){
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

    private fun animateWinningCells() {
        // Assuming you have a variable storing the winning row and columns
        val winningRow = 0 // Replace with your winning row
        val winningColStart = 0 // Replace with your winning column start

        val scaleAnimation = AnimationUtils.loadAnimation(context as MainActivity, R.anim.animation)

        for (col in winningColStart until 3) {
            // val cell = matrix[winningRow][col]
            Log.d("anim1",""+col)

            val scaleAnimation = ObjectAnimator.ofPropertyValuesHolder(
                cells[winningRow][winningColStart],
                PropertyValuesHolder.ofFloat(View.SCALE_X, 1.0f, 1.2f),
                PropertyValuesHolder.ofFloat(View.SCALE_Y, 1.0f, 1.2f)
            )
            scaleAnimation.duration = 500 // Duration in milliseconds

            // Start the animation
            scaleAnimation.start()
        }
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