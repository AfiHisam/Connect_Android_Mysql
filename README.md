# Connect_Android_Mysql

This application basically give a clear understanding on how make connections between android app and web based application. 

This method is very effective for those who want to build an application that requires the admin to update the information inside the app in real time.

<img src="https://github.com/AfiHisam/Connect_Android_Mysql/blob/master/Teori.png">

## lets start

After clone/download this git, copy and paste mysql-connector-java-5.1.23-bin.jar to libs forder in android studio. 

<img src="https://github.com/AfiHisam/Connect_Android_Mysql/blob/master/pic1.PNG" width="40%">
<p>
After that, add 3 line of code on build.gradle (Module.app)

<pre>
compile 'com.squareup.picasso:picasso:2.5.2'
compile 'com.github.amigold.fundapter:library:1.0'
compile files('libs/mysql-connector-java-5.1.23-bin.jar')
</pre>

Not forget to add this line of code in AndroidManifest.xml in order to make connection 

<pre>
< uses-permission android:name="android.permission.INTERNET" />
</pre>
<hr>

Copy and paste Connection.java and CustomAdapter.java into java folder 
<img src="https://github.com/AfiHisam/Connect_Android_Mysql/blob/master/class.PNG">
