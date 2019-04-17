package com.example.downloader

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import com.xqy.androidx.downloader.Downloader
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       val urls = mutableListOf<String>(
            "http://vip.zuiku8.com/1811/永夜 电视剧《将夜》推广曲 - 谭维维.mp4")
        val filenames = mutableListOf<String>("复仇者联盟")
        val downloadUrl = "http://xunleib.zuida360.com/1809/复仇者联盟4[预告片].mp4"
        Downloader.mInstance.download(downloadUrl,"复仇者联盟4",{
                url,progress->
            progressTextView.text = "$progress%"
            progressView.show()
            progressView.progress = progress
        },{
            url,file->
            progressTextView.text = "下载完成,存储目录：${file.absolutePath}"
        })
//        Downloader.mInstance.multiDownload(urls,filenames,{
//            url,progress->
//                progressTextView.text = "$progress%"
//                progressView.show()
//                progressView.progress = progress
//
//
//
//        },{
//            Log.e("===",it)
//        })
        pauseView.setOnClickListener {
            Downloader.mInstance.pauseDownload(downloadUrl)

        }
        resumeView.setOnClickListener {

            Downloader.mInstance.resumeDownload(downloadUrl)
        }

        Log.e("===","======>>>>>>")
    }
}
