-------------------------Samurai 1.0-----------------------
What is "Samurai":
Samurai is a GUI tool to analyze thread dumps.

System reqirements:
OS: Windows or any flavor of Unix that supports Java
JVM: 1.4 or later

Setup:
1)Unzip samurai.zip to a proper directory on your filesystem.

2)Launch samurai.jar using Edit komuso.properties as follows:
Set JAVA_HOME to your Java Home directory such as C:\bea81sp2\jrockit81sp2_141_05
Set WL_HOME to your WebLogic Home directory such as C:\bea81sp2\weblogic81\server

3)Edit komuso.properties as follows:
Set java.naming.provider.url to your weblogic url.
Set java.naming.security.principal to your weblogic admin username
Set java.naming.security.credentials to you weblogic admin password

a typical setting would be as follows,
java.naming.provider.url=t3://127.0.0.1:7001
java.naming.security.principal=system
java.naming.security.credentials=weblogic

Additionally, you can specify the sampling interval in seconds, the number of times and mbean's properties you want to monitor.
See komuso.properties for more detailed information.

Usage:
Just type komuso.sh/bat to run and Samurai will log WebLogic status in CSV format.
Optionally you can specify the filename to output.

- most Unix (including Solaris, Linux, HP-UX, MacOSX or AIX)
$ komuso.sh [filename]
- Windows
> komuso.bat [filename]

Error handling:
-java.lang.IllegalArgumentException: mbean not found [heap free:name:type:property]
This means that the MBean couldn't be found. Check if the name and type are correct.

-java.lang.IllegalArgumentException: property not found [heap free:name:type:property]
This means that the MBean could be found, but the specified property was not found. Check if the property is exist.

-javax.naming.CommunicationException.  Root exception is java.net.ConnectException: t3://localhost:7001: Destination unreachable; nested exception is:
        java.net.ConnectException: Connection refused: connect; No available router to destination
This means that the connection between the Samurai and the WLS has been lost.
Check the network and if the WLS is alive.

Compile:
You can customize komuso for any reason.
Use compile.sh/bat to compile.

Please feel free to comment:
Yusuke Yamamoto
yusukey@bea.com

Special thanks to:
Akira Ueda
Noritaka Kuroiwa
