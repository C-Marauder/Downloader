package com.example.downloader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import com.xqy.androidx.downloader.Downloader
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       val urls = mutableListOf<String>(
           "https://i.asnpic.win/forum/201806/28/001210eaonj2p4nhppfdhf.jpg",
               "http://zydm1.bofang.cc:2016/1503/我的洗发水-小屁孩版，又被洗脑了/我的洗发水-小屁孩版，又被洗脑了_hd.mp4",
            "http://vip.zuiku8.com/1811/永夜 电视剧《将夜》推广曲 - 谭维维.mp4",
            "http://xunlei.zuidaxunlei.com/1902/灵剑尊第1季-12.mp4")
        val filenames = mutableListOf<String>("美女","我的洗发水","将夜","灵剑尊")

        Downloader.mInstance.multiDownload(urls,filenames,{
            url,progress-> Log.e("==","$url-----进度：$progress")
        },{
            Log.e("===",it)
        })
        pauseView.setOnClickListener {
            //Downloader.mInstance.pauseDownload()

        }
        resumeView.setOnClickListener {

            //Downloader.mInstance.resumeDownload(mp3)
        }

        Log.e("===","======>>>>>>")
    }
}
