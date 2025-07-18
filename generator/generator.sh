#!/bin/bash

JAVA_PATH="/Users/lanruirui/Library/Java/jdk-21.0.2/Contents/Home/bin/java"
JAR_PATH="endless-ddd-simplified-generator-1.0.0-SNAPSHOT.jar"
JAVA_OPTS="-Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8"

echo "Starting the Java application..."
"$JAVA_PATH" $JAVA_OPTS -jar "$JAR_PATH"
echo "Application started."
read -p "Press [Enter] to continue..."
