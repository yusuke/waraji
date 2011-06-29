#!/bin/sh
BUILD_CLASS_PATH=
BUILD_HOME=.
if [ -n ${JAVA_HOME} ] ; then
 JAVA_HOME=/Library/Java/Home
fi
echo ${JAVA_HOME}
for i in $BUILD_HOME/lib/*.jar ; do
    BUILD_CLASS_PATH=${BUILD_CLASS_PATH}:$i
done

$JAVA_HOME/bin/java -classpath ${BUILD_CLASS_PATH} org.apache.tools.ant.Main "$@" 
