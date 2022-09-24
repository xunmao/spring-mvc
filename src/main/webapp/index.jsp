<%@ page contentType="text/html; charset=utf-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Spring MVC Demo</title>
  <!-- Bootstrap CDN -->
  <!-- 
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
   -->
  <!-- Bootstrap Local -->
  <link rel="stylesheet" href="bootstrap-5.2.1-dist/css/bootstrap.min.css">
  <!-- CSS -->
  <link rel="stylesheet" href="style.css">
</head>

<body>
  <div class="heading">
    <img class="mx-auto mb-4" src="assets/tomcat-logo.svg" alt="tomcat logo" width="72" height="57">
    <img class="mx-auto mb-4" src="assets/JSP-logo.svg" alt="JSP logo" width="72" height="57">
    <img class="mx-auto mb-4" src="assets/spring-logo.svg" alt="spring logo" width="72" height="57">
    <img class="mx-auto mb-4" src="assets/bootstrap-logo.svg" alt="bootstrap logo" width="72" height="57">
    <!-- https://getbootstrap.com/docs/5.2/content/typography/ -->
    <h5 class="display-5 fw-bold">SPRING MVC DEMO</h5>
  </div>

  <div class="content">
    <p class="lead">
      这是一个学习和尝试 Spring MVC 框架的各种功能的 Demo 网站。网站的页面采用 Bootstrap 来进行美化。
    </p>
    <div>
      <!-- https://getbootstrap.com/docs/5.2/components/buttons/ -->
      <a href="${pageContext.request.contextPath}/hello?user=xunmao" class="btn btn-primary btn-lg px-4 gap-3">欢迎页面</a>
      <a href="${pageContext.request.contextPath}/v1/actor/1" class="btn btn-outline-secondary btn-lg px-4">1号演员</a>
    </div>
  </div>
</body>

</html>