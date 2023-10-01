package com.example.trying.Utiil
import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import android.util.AttributeSet
import android.widget.Toast
import com.example.trying.R


/**
 * Created by sandeep on 9/14/2023.
 */
class Utills(context: Context, attrs: AttributeSet?) : Animation(context, attrs) {


    companion object{
        lateinit var matrix: Array<Array<Int>>

        var mediaPlayer =MediaPlayer()

        fun winner(win: Int,context: Context):Boolean {
            val animation=Animation(context,null)
            animation.drawline()
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
            try {
                mediaPlayer.release()
                mediaPlayer= MediaPlayer()
                mediaPlayer?.setAudioStreamType(AudioManager.STREAM_MUSIC)

                if(mediaPlayer!=null){
                    try {
                        mediaPlayer = MediaPlayer.create(context,sound)
                        mediaPlayer.setLooping(false);
                        mediaPlayer.start()
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }catch (e : Exception){
                e.printStackTrace()
            }
        }

        fun destroy(){
            mediaPlayer.release()
        }
    }
}