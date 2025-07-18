@echo off
set JAVA_PATH="D:\Program Files\Java\openjdk-21.0.2\bin\java.exe"
set JAR_PATH="endless-ddd-simplified-generator-1.0.0-SNAPSHOT.jar"
set JAVA_OPTS=-Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8

echo Starting the Java application...
%JAVA_PATH% %JAVA_OPTS% -jar %JAR_PATH%
echo Application started.
pause
