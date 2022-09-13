#!/bin/zsh

thisProject="/Users/qing/programming/java/spring-mvc"
tomcatWebapps="/Users/qing/programming/java/tools/apache-tomcat-9.0.65/webapps/"

# 通过 Maven 进行打包
mvn package -f "$thisProject/pom.xml"

# 将 war 包拷贝到 {tomcat-installation-directory}/webapps 路径下
cp "$thisProject/target/spring-mvc.war" $tomcatWebapps
