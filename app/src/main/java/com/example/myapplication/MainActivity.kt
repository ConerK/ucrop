package com.example.myapplication

import android.content.Context
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.graphics.BitmapFactory
import android.os.*
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.view.Window
import android.view.WindowManager
import android.widget.FrameLayout
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*
import org.greenrobot.eventbus.EventBus
import java.util.LinkedHashMap

class MainActivity : AppCompatActivity() ,View.OnClickListener{
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_te->{
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
                Toast.makeText(this,"qqq",Toast.LENGTH_LONG).show()
            }
            R.id.btn_test->{
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)
                Toast.makeText(this,"www",Toast.LENGTH_LONG).show()
            }
            R.id.btnt ->{
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
                Toast.makeText(this,"eeee",Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_test.setOnClickListener(this)
//        OkHttpClient；
//        Glide;
//        EventBus;
//        HandlerThread;
//        FrameLayout
//        ThreadLocal
//        Message
//        Handler
//        Looper
//        LinkedHashMap

    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if(newConfig.orientation == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT){
            //切换到竖屏
            //修改布局文件
            setContentView(R.layout.activity_main)
            //findViewById ....
            //TODO something
            btn_test.setOnClickListener(this)
            btn_te.setOnClickListener(this)
            Log.d("test"," -- onConfigurationChanged  可以在竖屏方向 to do something");
        }else{
            //切换到横屏
            //修改布局文件
            setContentView(R.layout.activity_main2)
            //findViewById ....
            //TODO something
            btn.setOnClickListener(this)
            btnt.setOnClickListener(this)
            Log.d("test"," -- onConfigurationChanged  可以在横屏方向 to do something");
        }
    }
}
