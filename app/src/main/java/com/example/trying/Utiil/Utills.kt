package com.example.trying.Utiil
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.media.AudioManager
import android.media.MediaPlayer
import android.view.View
import android.widget.Toast
import com.example.trying.R


/**
 * Created by sandeep on 9/14/2023.
 */
class Utills: View{
    constructor(context: Context) : super(context) {
        this.invalidate()
        this.draw()
    }

    private fun draw() {
        this.invalidate()
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val paint= Paint()
        paint.style= Paint.Style.STROKE
        paint.isAntiAlias=true
        paint.strokeWidth = 1f;
        canvas?.drawLine(0F, 0F, 20F, 20F, paint);
        canvas?.drawLine(20F, 0F, 0F, 20F, paint);
    }


    companion object{

        lateinit var imageClickable:Array<Int>
        lateinit var matrix: Array<Array<Int>>

        var mediaPlayer =MediaPlayer()




        fun winner(win: Int,context: Context):Boolean {
            if(win==1){
                SoundBeep(context,R.raw.towin)
                Toast.makeText(context,"x is winner", Toast.LENGTH_SHORT).show()
                return true
            }else if(win==0){
                SoundBeep(context,R.raw.towin)
                Toast.makeText(context ,"0 is winner", Toast.LENGTH_SHORT).show()
                return true
            }else if(win==2){
                SoundBeep(context,R.raw.todraw)
                Toast.makeText(context,"Game Drow", Toast.LENGTH_SHORT).show()
                return true
            }
            return false
        }

        fun SoundBeep(context: Context,sound:Int){
            var  mediaPlayer= MediaPlayer()
            mediaPlayer?.setAudioStreamType(AudioManager.STREAM_MUSIC)
            if(mediaPlayer.isPlaying){
                mediaPlayer.pause()
            }
            if(mediaPlayer!=null){
                try {
                    mediaPlayer = MediaPlayer.create(context,sound)
                    mediaPlayer.setLooping(false);
                    mediaPlayer.start()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }

        class IndexContainer(val x : Int, val y:Int)
        fun minmax(depth:Int,isMaximizing: Boolean):Int{

            /*if(imageClickable.size==9) {
                val threeToThree=ThreeToThree()
                if (threeToThree.check() == 1) return depth - 10
                if (threeToThree.check() == 0) return 10 - depth
                if (threeToThree.check() == 2) return -2

            }*/

            if(isMaximizing){
                var bestScore = Int.MIN_VALUE
                for (i in 0 until matrix[0].size) {
                    for (j in 0 until matrix[0].size) {
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
                for (i in 0 until matrix[0].size) {
                    for (j in 0 until matrix[0].size) {
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


        fun getBestMove(imageClickable: Array<Int>, matrix: Array<Array<Int>>): IndexContainer?{
            this.imageClickable=imageClickable
            this.matrix=matrix

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
            return  null
        }

        fun destroy(){
            mediaPlayer.release()
        }

    }
}