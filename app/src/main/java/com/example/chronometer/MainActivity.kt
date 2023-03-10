package com.example.chronometer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Chronometer
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val meter = findViewById<Chronometer>(R.id.chronoMeter)
        val button = findViewById<Button>(R.id.button)

        button?.setOnClickListener(object :View.OnClickListener{

            var isWorking = false

            override fun onClick(v: View) {
                if (!isWorking){
                    meter.start()
                    isWorking = true
                }
                else{
                    meter.stop()
                    isWorking = false
                }

                button.setText(if (isWorking) R.string.start else R.string.stop)

                Toast.makeText(this@MainActivity , getString(
                    if (isWorking)
                        R.string.working
                else
                    R.string.stopped ), Toast.LENGTH_SHORT).show()

            }

        })

    }
}