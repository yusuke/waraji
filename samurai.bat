echo off
SETLOCAL
set JAVA_HOME=C:\bea81sp2\jdk141_05

start %JAVA_HOME%\bin\javaw -jar .\samurai.jar

:finish
ENDLOCAL