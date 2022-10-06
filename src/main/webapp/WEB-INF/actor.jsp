<%@ page contentType="text/html; charset=utf-8" language="java" %>
  <!DOCTYPE html>
  <html lang="en">

  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Actor</title>
    <!-- 导入本地保存的 Bootstrap 依赖 -->
    <link rel="stylesheet" href="../bootstrap-5.2.1-dist/css/bootstrap.min.css">
    <!-- 导入 jQuery 依赖 -->
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <!-- 导入自定义 JS 代码 -->
    <!-- 
      通过 Ajax 请求，将 GET 方法转换为 POST 方法：
      https://blog.csdn.net/peng_hong_fu/article/details/70729130
     -->
    <script src="../js/toPostMethod.js"></script>
  </head>

  <body>
    <div class="container mt-4">
      <h6 class="display-6 fw-bold mb-4">演员列表</h6>

      <div>
        <a href="" class="btn btn-primary btn-sm">新增</a>
        <a href="${pageContext.request.contextPath}/v1/actors" onclick="toPostMethod(this); return false;"
          class="btn btn-outline-secondary btn-sm">重置</a>
      </div>

      <table class="table table-hover table-striped">
        <thead>
          <tr>
            <th>ID</th>
            <th>名字</th>
            <th>姓氏</th>
            <th>更新时间</th>
            <th>操作</th>
          </tr>
        </thead>
        <tbody>
          <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
            <c:forEach var="actor" items="${requestScope.get('actors')}">
              <tr>
                <td>${actor.getActorId()}</td>
                <td>${actor.getFirstName()}</td>
                <td>${actor.getLastName()}</td>
                <td>${actor.getLastUpdate()}</td>
                <td>
                  <a href="" class="btn btn-primary btn-sm">修改</a>
                  <a href="${pageContext.request.contextPath}/v1/delete/actor/${actor.getActorId()}"
                    onclick="toPostMethod(this); return false;"
                    class="btn btn-outline-secondary btn-sm">删除</a>
                </td>
              </tr>
            </c:forEach>
            <!-- <tr>
          <td>1</td>
          <td>PENELOPE</td>
          <td>GUINESS</td>
          <td>Wed Feb 15 04:34:33 CST 2006</td>
          <td>
            <a href="" class="btn btn-primary btn-sm">修改</a>
            <a href="" class="btn btn-outline-secondary btn-sm">删除</a>
          </td>
        </tr>
        <tr>
          <td>2</td>
          <td>PENELOPE</td>
          <td>GUINESS</td>
          <td>Wed Feb 15 04:34:33 CST 2006</td>
          <td>
            <a href="" class="btn btn-primary btn-sm">修改</a>
            <a href="" class="btn btn-outline-secondary btn-sm">删除</a>
          </td>
        </tr>
        <tr>
          <td>3</td>
          <td>PENELOPE</td>
          <td>GUINESS</td>
          <td>Wed Feb 15 04:34:33 CST 2006</td>
          <td>
            <a href="" class="btn btn-primary btn-sm">修改</a>
            <a href="" class="btn btn-outline-secondary btn-sm">删除</a>
          </td>
        </tr> -->
        </tbody>
      </table>
    </div>
  </body>

  </html>