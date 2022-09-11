# spring-mvc

此项目用于学习和尝试 SpringMVC 框架的各种功能

## 安装和配置 Tomcat

- 首先，从 Tomcat 官网地址（ https://tomcat.apache.org ）下载 Tomcat 的 ZIP 文件到指定文件夹下
- 然后，赋予 Tomcat 文件夹下 bin 文件夹中 Shell 文件可执行权限
- 最后，通过 Tomcat 文件夹下 bin 文件夹中 Shell 命令启动或停止服务

### 赋予权限

```zsh
chmod 755 apache-tomcat-9.0.65/bin/*.sh
```

### 启动服务

```zsh
zsh apache-tomcat-9.0.65/bin/startup.sh
```

### 停止服务

```zsh
zsh apache-tomcat-9.0.65/bin/shutdown.sh
```

## 准备工作

### 创建 Maven Webapp 项目

这里需要注意，在创建 Maven 项目时使用了新的模板： maven-archetype-webapp 。

```sh
mvn archetype:generate -DgroupId=com.xunmao.demo -DartifactId=spring-mvc -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-webapp -DarchetypeVersion=1.4 -DinteractiveMode=false
```

### 导入依赖

```xml
<!-- Spring MVC -->
<!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
<dependency>
  <groupId>org.springframework</groupId>
  <artifactId>spring-webmvc</artifactId>
  <version>5.3.22</version>
</dependency>
<!-- Servlet -->
<!-- https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api -->
<dependency>
  <groupId>javax.servlet</groupId>
  <artifactId>javax.servlet-api</artifactId>
  <version>4.0.1</version>
  <scope>provided</scope>
</dependency>
<!-- JSP -->
<!-- https://mvnrepository.com/artifact/javax.servlet.jsp/javax.servlet.jsp-api -->
<dependency>
  <groupId>javax.servlet.jsp</groupId>
  <artifactId>javax.servlet.jsp-api</artifactId>
  <version>2.3.3</version>
  <scope>provided</scope>
</dependency>
```

## 将应用部署到 Tomcat

### 通过 Maven 打包应用

运行 Maven 生命周期中的 package 周期，获得 war 包。

### 部署到 Tomcat

将 war 包拷贝至 Tomcat 的指定文件夹：

```
{tomcat-installation-directory}/webapps
```

Tomcat 启动时，会将 war 自动展开为同名的文件夹（包含了 jsp ， class 文件）

### 访问应用

访问以下 URL 就可以看到 spring-mvc 项目的首页了。

```
localhost:8080/spring-mvc/
```

当然，也可以通过一些配置将上述 URL 中的 `spring-mvc` 部分省略。可以参考以下博客：  
https://www.cnblogs.com/ysocean/p/6893446.html#_label2

### 设置 Tomcat 管理员账号

在以下配置文件中，可以添加管理员账号：

```
{tomcat-installation-directory}/conf/tomcat-users.xml
```

具体来说就是在 `tomcat-users` 中添加 `user` 标签。

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!--
  Licensed to the Apache Software Foundation (ASF) under one or ...
-->
<tomcat-users xmlns="http://tomcat.apache.org/xml"
              xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
              xsi:schemaLocation="http://tomcat.apache.org/xml tomcat-users.xsd"
              version="1.0">
<!--
  By default, no user is included in the "manager-gui" role required ...
-->
    <user username="admin" password="admin" roles="manager-gui"/>
</tomcat-users>
```

### 添加新的 JSP 和 Servlet

新的 JSP 通过以下链接访问：

```
localhost:8080/spring-mvc/hello?user=xunmao
```

首先，编写 hello.jsp 文件，存放在 WEB-INF 文件夹下。  
然后，将 JSP 加入 web.xml 文件，以便映射到相应的 Servlet 类。

```xml
<!DOCTYPE web-app PUBLIC "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN" "http://java.sun.com/dtd/web-app_2_3.dtd">

<web-app>
  <display-name>Archetype Created Web Application</display-name>

  <servlet>
    <servlet-name>HelloServlet</servlet-name>
    <servlet-class>com.xunmao.demo.servlet.HelloServlet</servlet-class>
  </servlet>

  <servlet-mapping>
    <servlet-name>HelloServlet</servlet-name>
    <url-pattern>/hello</url-pattern>
  </servlet-mapping>
</web-app>
```