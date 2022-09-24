# spring-mvc

此项目用于学习和尝试 SpringMVC 框架的各种功能

## 准备工作

### 安装和配置 Tomcat

1. 从 Tomcat 官网（ https://tomcat.apache.org ）下载 Tomcat
1. 将 zip 文件解压到指定文件夹下（无需通过 homebrew 安装）
1. 将可执行权限赋予 Tomcat 文件夹下 bin 文件夹中 Shell 脚本
1. 之后可以通过 Tomcat 文件夹下 bin 文件夹中 Shell 命令启动或停止服务

赋予权限
```zsh
chmod 755 apache-tomcat-9.0.65/bin/*.sh
```

启动服务
```zsh
zsh apache-tomcat-9.0.65/bin/startup.sh
```

停止服务
```zsh
zsh apache-tomcat-9.0.65/bin/shutdown.sh
```

### 创建 Maven Webapp 项目

这里需要注意，在创建 Maven 项目时使用了新的模板： `maven-archetype-webapp` 。
```sh
mvn archetype:generate -DgroupId=com.xunmao.demo -DartifactId=spring-mvc -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-webapp -DarchetypeVersion=1.4 -DinteractiveMode=false
```

生成项目之后，需要手动创建几个文件夹。
```
.
├── LICENSE
├── README.md
├── cmd                            <-- 启动、停止 Tomcat，以及部署应用的脚本文件在这里。
│   ├── deploy.sh
│   ├── shutdown.sh
│   └── startup.sh
├── pom.xml
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── xunmao
    │   │           └── demo       <-- Java 相关的文件在这里。（需要手动创建）
    │   ├── resources              <-- 各种资源文件在这里。（需要手动创建）
    │   └── webapp
    │       ├── WEB-INF
    │       │   └── web.xml        <-- Web 应用的配置文件在这里。
    │       └── index.jsp          <-- Web 应用的默认首页。
    └── test                       
        └── java
            └── com
                └── xunmao
                    └── demo       <-- 测试相关的文件在这里。（需要手动创建）
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

## 回顾 Java Web

### 创建一个 JSP 和 Servlet

首先，在 WEB-INF 文件夹下创建一个 JSP 页面，这个页面可以通过以下链接访问：
```
localhost:8080/spring-mvc/hello?user=xunmao
```

然后，创建 Servlet 类，用来处理 JSP 页面。

最后，创建配置文件 web.xml（ Servlet 配置文件的默认文件名），将 JSP 页面映射到相应的 Servlet 类。  
（特别注意， web.xml 文件的格式要求严格，最好参考 ROOT 文件夹下的 web.xml 文件）
```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="
    http://xmlns.jcp.org/xml/ns/javaee
    http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
  version="4.0">

  <!-- 
    注意，如果遇到 ${...} 不能被解析，需要检查标签的写法，具体参考：
    https://stackoverflow.com/questions/30080810/el-expressions-not-evaluated-in-jsp
   -->

  <servlet>
    <servlet-name>hello</servlet-name>
    <servlet-class>com.xunmao.demo.servlet.HelloServlet</servlet-class>
  </servlet>

  <servlet-mapping>
    <servlet-name>hello</servlet-name>
    <url-pattern>/hello</url-pattern>
  </servlet-mapping>
</web-app>
```

### 打包并部署

1. 运行 Maven 生命周期中的 package 周期，获得 war 包
1. 将 war 包拷贝至 Tomcat 的指定文件夹

```
{tomcat-installation-directory}/webapps
```

Tomcat 启动时，会将 war 自动展开为同名的文件夹（包含了 jsp 以及 class 文件等）

### 访问应用

访问以下 URL 就可以看到 spring-mvc 项目的首页了。
```
localhost:8080/spring-mvc/
```

当然，也可以通过一些配置将上述 URL 中的 `spring-mvc` 部分省略。可以参考以下博客：  
https://www.cnblogs.com/ysocean/p/6893446.html#_label2

### （参考）设置 Tomcat 管理员账号

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

## 使用 Spring MVC

### 初识 Spring MVC

在使用 Spring MVC 之前，会将一个 servlet 与某个具体的 controller 绑定，再映射到一个具体的 URL 上，例如：
```xml
<servlet>
  <servlet-name>hello</servlet-name>
  <servlet-class>com.xunmao.demo.servlet.HelloServlet</servlet-class>
</servlet>

<servlet-mapping>
  <servlet-name>hello</servlet-name>
  <url-pattern>/hello</url-pattern>
</servlet-mapping>
```

在使用 Spring MVC 之后，web.xml 中只需要一个 servlet 与 Spring MVC 提供的 `DispatcherServlet` 绑定，并映射到一个通用的 URL 上即可：
```xml
<!-- 1. 注册 DispatcherServlet -->
<servlet>
  <servlet-name>app</servlet-name>
  <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
</servlet>

<!-- 
  “/” 匹配所有的请求（但是不包括 .jsp 文件）
  “/*” 匹配所有的请求（但是包括 .jsp 文件）
 -->
<servlet-mapping>
  <servlet-name>app</servlet-name>
  <url-pattern>/app/*</url-pattern>
</servlet-mapping>
```

具体的 controller 将会在 Spring MVC 的配置文件中进行配置，因此，需要给通用的 servlet 提供初始化参数：
```xml
<servlet>
  <servlet-name>app</servlet-name>
  <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
  <!-- 1.1. 关联一个 Spring MVC 的配置文件  -->
  <init-param>
    <param-name>contextConfigLocation</param-name>
    <!-- 
      1) web/xml-based-servlet.xml: 使用 XML 配置
     -->
    <param-value>classpath:web/xml-based-servlet.xml</param-value>
  </init-param>
  ...
</servlet>
```

最终的 web.xml 配置文件如下：
```xml
<web-app>
  <!-- 1. 注册 DispatcherServlet -->
  <servlet>
    <servlet-name>app</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <!-- 1.1. 关联一个 Spring MVC 的配置文件  -->
    <init-param>
      <param-name>contextConfigLocation</param-name>
      <!-- 
        1) web/xml-based-servlet.xml: 使用 XML 配置
       -->
      <param-value>classpath:web/xml-based-servlet.xml</param-value>
    </init-param>
    <!-- 1.2. 启动顺序，数字越小，启动越早 -->
    <load-on-startup>1</load-on-startup>
  </servlet>

  <!-- 
    “/” 匹配所有的请求（但是不包括 .jsp 文件）
    “/*” 匹配所有的请求（但是包括 .jsp 文件）
   -->
  <servlet-mapping>
    <servlet-name>app</servlet-name>
    <url-pattern>/app/*</url-pattern>
  </servlet-mapping>
</web-app>
```

### 使用 XML 配置 Spring MVC

在上一小节中提到：
> 具体的 controller 将会在 Spring MVC 的配置文件中进行配置，因此，需要给通用的 servlet 提供初始化参数

Spring MVC 的配置文件如下（ resources/web/xml-based-servlet.xml ）：
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="
        http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">

  <!-- 1. 添加映射处理器 -->
  <bean class="org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping" />

  <!-- 2. 添加处理器适配器 -->
  <bean class="org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter" />

  <!-- 3. 添加视图解析器 -->
  <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
    <property name="prefix" value="/WEB-INF/" />
    <property name="suffix" value=".jsp" />
  </bean>

  <!-- 4. 添加 Controller -->
  <bean id="/hello" class="com.xunmao.demo.controller.HelloInterfaceController" />
</beans>
```

上述配置文件实际上就是一个标准的 Spring 配置文件，包含了多个 bean。后续在整合 SSM 时，可以使用配置文件的 `import` 语法来整合。

### 使用注解开发

使用注解开发时，需要修改 Spring MVC 的配置文件。这里为了便于对比，新建了一个 Spring MVC 配置文件 ( resources/web/annotated-servlet.xml )：
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xsi:schemaLocation="
        http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd
        http://www.springframework.org/schema/mvc
        https://www.springframework.org/schema/mvc/spring-mvc.xsd">

  <!-- 
    1. 添加包扫描配置
    https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-ann-controller
   -->
  <context:component-scan base-package="com.xunmao.demo.controller" />

  <!-- 2. 添加静态资源处理配置 -->
  <mvc:default-servlet-handler />

  <!-- 3. 添加支持 MVC 注解配置 -->
  <mvc:annotation-driven />

  <!-- 4. 添加时图解析器 -->
  <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
    <property name="prefix" value="/WEB-INF/"></property>
    <property name="suffix" value=".jsp"></property>
  </bean>
</beans>
```

然后，修改 Web 应用的配置文件（web.xml），让 Web 应用启动时加载新的 Spring MVC 配置文件：
```xml
<servlet>
  <servlet-name>app</servlet-name>
  <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
  <init-param>
    <param-name>contextConfigLocation</param-name>
    <!-- 
     1) web/xml-based-servlet.xml: 使用 XML 配置
     2) web/annotated-servlet.xml: 使用注解配置
    -->
    <param-value>classpath:web/annotated-servlet.xml</param-value>
  </init-param>
</servlet>
```

## 整合 Spring MVC 和 Spring

TODO

## 其他

获取参数的方法
> Note that use of @RequestParam is optional (for example, to set its
> attributes). By default, any argument that is a simple value type (as
> determined by BeanUtils#isSimpleProperty) and is not resolved by any other
> argument resolver, is treated as if it were annotated with @RequestParam.

https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-ann-requestheader