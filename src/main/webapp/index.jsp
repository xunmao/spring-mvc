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
  <!-- 导入本地保存的 Bootstrap 依赖 -->
  <link rel="stylesheet" href="bootstrap-5.2.1-dist/css/bootstrap.min.css">
  <!-- 导入自定义 CSS -->
  <link rel="stylesheet" href="css/signin.css">
</head>

<body>
  <div class="container mt-4 text-center">
    <!-- https://getbootstrap.com/docs/5.2/utilities/spacing/ -->
    <!-- https://getbootstrap.com/docs/5.2/utilities/text/#text-alignment -->
    <div>
      <img class="mx-auto mb-4" src="assets/tomcat-logo.svg" alt="tomcat logo" width="72" height="57">
      <img class="mx-auto mb-4" src="assets/JSP-logo.svg" alt="JSP logo" width="72" height="57">
      <img class="mx-auto mb-4" src="assets/spring-logo.svg" alt="spring logo" width="72" height="57">
      <img class="mx-auto mb-4" src="assets/bootstrap-logo.svg" alt="bootstrap logo" width="72" height="57">
      <!-- https://getbootstrap.com/docs/5.2/content/typography/ -->
      <h5 class="display-5 fw-bold mb-4">SPRING MVC DEMO</h5>
    </div>

    <div>
      <p class="lead">
        这是一个学习和尝试 Spring MVC 框架的各种功能的 Demo 网站。网站的页面采用 Bootstrap 来进行美化。
      </p>
      <div>
        <!-- https://getbootstrap.com/docs/5.2/components/buttons/ -->
        <a href="${pageContext.request.contextPath}/v1/actors" class="btn btn-outline-secondary btn-lg px-4">演员列表
          (v1)</a>
        <!-- <a href="${pageContext.request.contextPath}/v1/actor/1" class="btn btn-outline-secondary btn-lg px-4">1号演员 (v1)</a> -->
        <a href="${pageContext.request.contextPath}/v2/actors" class="btn btn-outline-secondary btn-lg px-4">演员列表
          (v2)</a>
        <a href="${pageContext.request.contextPath}/v2/actor/1" class="btn btn-outline-secondary btn-lg px-4">1号演员
          (v2)</a>
      </div>
    </div>
  </div>

  <div class="form-signin">
    <form action="${pageContext.request.contextPath}/hello" method="get">
      <div class="form-floating">
        <input type="text" class="form-control" id="floatingUsername" name="username" placeholder="Username" />
        <label for="floatingUsername">Username</label>
      </div>
      <div class="form-floating">
        <input type="password" class="form-control" id="floatingPassword" name="password" placeholder="Password" />
        <label for="floatingPassword">Password</label>
      </div>
      <button type="submit" class="btn btn-primary btn-lg w-100">Sign in</button>
    </form>
  </div>
</body>

</html>