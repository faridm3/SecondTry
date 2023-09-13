package com.example.secondtry

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.secondtry.databinding.ActivityScrollingBinding

@Suppress("DEPRECATION")
class ScrollingActivity : AppCompatActivity() {

private lateinit var binding: ActivityScrollingBinding
    private var delegate: DataBack? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling)

        val myIntent = intent
        val derivedObject = myIntent.getSerializableExtra("object") as MyCustomObject
        val myTextView = findViewById<TextView>(R.id.textView2)
        myTextView.append(derivedObject.name + "\n")
        myTextView.append(derivedObject.id.toString() + "\n")
        myTextView.append(derivedObject.place + "\n")

        val delegateObject = myIntent.getSerializableExtra("delegate") as MainActivity
        delegate = delegateObject
        sending("Data back")

        val btn = findViewById<Button>(R.id.button)
        btn.setOnClickListener {
//            val passingObject = MyCustomObject()
//            passingObject.name = "Geek2"
//            passingObject.id = 2
//            passingObject.place = "India2"
            finish()
        }
    }
    private fun sending(info: String) {
        delegate?.mydata(info)
    }
}