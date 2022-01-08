package com.example.intentinkotlin

import android.app.Activity
import android.content.Intent
import android.media.tv.TvView
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts

class DetaiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detai)
        initView()
    }
    fun initView(){
        var tv_detail = findViewById<TextView>(R.id.tv_detail)
        var user = intent.getSerializableExtra("name")
        tv_detail.text = user.toString()
        var btn_detail = findViewById<Button>(R.id.btn_detail)
        btn_detail.setOnClickListener {
            backToFinish()
        }
    }
    fun backToFinish(){
        var user2 = User(333,"Aziza")
        var intent = Intent()
        intent.putExtra("result",user2)
        setResult(Activity.RESULT_OK,intent)
        finish()
    }
}