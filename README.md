# Downloader
A Android Library for Download File Base On OkHttp
### Kotlin+Okhttp封装的文件下载开发模块，基于AndroidX版本
## 1.依赖

`implementation 'com.xqy.androidx.downloader:downloader:1.0.0'`

## 2.使用

* **单个任务下载**
```
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
        
        //暂停
        pauseView.setOnClickListener {
            Downloader.mInstance.pauseDownload(downloadUrl)

        }
        //重新下载
        resumeView.setOnClickListener {

            Downloader.mInstance.resumeDownload(downloadUrl)
        }
```
 <img src="https://github.com/xqy666666/Downloader/blob/master/download.gif" width="300" height="600" />
 
 * **多任务下载**
 
 ```
 val urls = mutableListOf<String>(
            "http://vip.zuiku8.com/1811/永夜 电视剧《将夜》推广曲 - 谭维维.mp4",
            "http://xunleib.zuida360.com/1809/复仇者联盟4[预告片].mp4")
        val filenames = mutableListOf<String>("将夜","复仇者联盟4")
        Downloader.mInstance.multiDownload(urls,filenames,{
                url,progress->
            //根据url判断是哪个下载任务，并进行操作
        },{
            url,file->
        })
 ```
