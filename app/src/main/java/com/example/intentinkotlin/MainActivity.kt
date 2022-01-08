package com.example.intentinkotlin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    lateinit var tv_home : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }
    fun initView(){
        var open_detail_activity = findViewById<Button>(R.id.b_open_detail)
        open_detail_activity.setOnClickListener {
            var user = User(333,"Ilhombek")
            openDetailActivity(user)
        }
    }
    var detail = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()){result->
        if (result.resultCode == Activity.RESULT_OK){
            var user = result.data
            var user1  = user!!.getSerializableExtra("result")
            tv_home.text = user1.toString()
        }
    }
    fun openDetailActivity(user: User){
        tv_home = findViewById(R.id.tv_home)
        var intent = Intent(this,DetaiActivity::class.java);
        intent.putExtra("name",user)
        detail.launch(intent)
    }
}