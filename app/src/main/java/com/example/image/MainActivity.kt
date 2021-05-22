package com.example.image

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.net.URI

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    fun cap(v: View){
        var i=Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(i,11)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode==11 && resultCode==Activity.RESULT_OK){
            val im=data?.extras?.get("data") as Bitmap
            imgv.setImageBitmap(im)
        }
        else if(requestCode==1 && resultCode==Activity.RESULT_OK){
            imgv.setImageURI(data?.data)
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
    fun choose(v:View){
        var a=Intent(Intent.ACTION_GET_CONTENT)
        a.type= "image/*"
        startActivityForResult(a, 1)
    }


}