package com.example.kotlincatchtheball

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList
import java.util.Random as Random2
import kotlin.random.Random as Random1

class MainActivity : AppCompatActivity() {

    var score = 0
    var imageArray = ArrayList<ImageView>()
    var handler = Handler()
    var runnable = Runnable {  }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       imageArray.add(imageView)
       imageArray.add(imageView2)
       imageArray.add(imageView3)
       imageArray.add(imageView4)
       imageArray.add(imageView5)
       imageArray.add(imageView6)
       imageArray.add(imageView7)
       imageArray.add(imageView8)
       imageArray.add(imageView9)

        hideImages()



        object : CountDownTimer(15000,1000){
            override fun onTick(millisUntilFinished: Long) {
                timertw.text = "Time : " + millisUntilFinished/1000
            }

            override fun onFinish() {
                timertw.text = "Time : 0"

                val alert = AlertDialog.Builder(this@MainActivity)
                alert.setTitle("game over")
                alert.setMessage("restart the game ?")
                alert.setPositiveButton("yes"){dialog,which ->
                    val intent = intent
                    finish()
                    startActivity(intent)

                }
                alert.setNegativeButton("no"){dialog, which ->
                    Toast.makeText(this@MainActivity,"Game Over ",Toast.LENGTH_LONG).show()
                    finish()
                }

                alert.show()




            }

        }.start()
    }

    fun hideImages(){
        runnable = object : Runnable{
            override fun run() {
                for (image in imageArray){
                    image.visibility = View.INVISIBLE
                }
                val random = kotlin.random.Random.nextInt(9)
                imageArray[random].visibility = View.VISIBLE

                handler.postDelayed(runnable,500)
            }

        }
        handler.post(runnable)

    }

    fun increaseScore(view :View) {
        score  = score + 1
        Scoretw.text = "Score: $score"

    }
}