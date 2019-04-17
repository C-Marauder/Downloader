package com.xqy.androidx.downloader

import okhttp3.Request
import okio.BufferedSource
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStream

internal class Task(var url:String,
           var hasDownloadSize:Long=0,
           var inputStream:InputStream?=null,
           var fileOutputStream: FileOutputStream?=null,
           var status:DownloadStatus=DownloadStatus.START,
           var errorMsg:String?=null,
           val request: Request,
           val file:File,
           var contentSize:Long=0)



internal enum class DownloadStatus{
    START,DOWNLOADING,ERROR,PAUSED,RESUME
}


 typealias OnDownload = (String,Int)->Unit
typealias OnComplete =(String)->Unit
