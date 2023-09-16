package com.example.secondtry

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.io.Serializable

//import java.io.Serializable

class MyCustomObject: Serializable {
    constructor() {}
    var name = ""
    var id = 0
    var place = ""
    constructor(mName: String, mId: Int, mPlace: String){
        name = mName
        id = mId
        place = mPlace
    }
}

interface DataBack {
    fun mydata(name: String)
}

class MainActivity : AppCompatActivity(), DataBack, Serializable {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn = findViewById<Button>(R.id.button)
        val myThis = this
        btn.setOnClickListener {
            val intent = Intent(this, ScrollingActivity::class.java).apply {
                val passingObject = MyCustomObject()
                passingObject.name = "Geek"
                passingObject.id = 1
                passingObject.place = "India"
                putExtra("object", passingObject)
                putExtra("delegate", myThis)
            }
            startActivity(intent)

        }
    }

    override fun onResume() {
        super.onResume()
    }

    override fun mydata(name: String) {
        println("Hi...")
        println(name)
//        val textView = findViewById<TextView>(R.id.textView222)
//        textView.text = name
    }
}