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

## 创建 Maven 项目

```sh
mvn archetype:generate -DgroupId=com.xunmao.demo -DartifactId=spring-mvc -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
```