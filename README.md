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
<br><br>

And all layout file into layout folder in android studio 

<img src="https://github.com/AfiHisam/Connect_Android_Mysql/blob/master/layout.PNG">

<hr>

## Lets setup the server and database 

1) Install the xampp on host computer as server 
2) Go to phpmyadmin and create new user privilege name "android" and password "pass123"

<img src="https://github.com/AfiHisam/Connect_Android_Mysql/blob/master/1.PNG">

After add user account successfully, it should look like this
<img src="https://github.com/AfiHisam/Connect_Android_Mysql/blob/master/2.PNG">

Create new database and name it as "connect" and table as "student". Insert some data into it
<img src="https://github.com/AfiHisam/Connect_Android_Mysql/blob/master/4.PNG">





