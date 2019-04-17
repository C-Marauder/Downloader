# Downloader
A Android Library for Download File Base On OkHttp
### Kotlin+Okhttp封装的文件下载开发模块，基于AndroidX版本
## 1.依赖

`implementation 'com.xqy.androidx.downloader:downloader:1.0.0'`

## 2.使用

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
