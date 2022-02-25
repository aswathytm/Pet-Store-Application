<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %> <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<% if (session.getAttribute("username") == null) { String redirectURL =
"http://localhost:8080/PetStore/"; response.sendRedirect(redirectURL); } %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>category</title>
    <style>
      table {
        border-collapse: collapse;
      }
    </style>
  </head>
  <body>
    <sql:setDataSource
      var="myDS"
      driver="com.mysql.jdbc.Driver"
      url="jdbc:mysql://db:3306/petstore?useSSL=false&allowPublicKeyRetrieval=true"
      user="root"
      password="qburst123"
    />
    <sql:query var="listcat" dataSource="${myDS}">
      SELECT * FROM category;
    </sql:query>
    <div>
      <a href="add_category.jsp?id=${category.id}">Add Category</a><br />

      <a href="list.jsp?id=${category.id}">Show Pet Details</a><br />
    </div>
    <div align="center">
      <table border="1" cellpadding="5">
        <caption>
          Category list
        </caption>

        <tr>
          <th>ID</th>
          <th>Name</th>
          <th>Edit</th>
          <th>Delete</th>
        </tr>
        <c:forEach var="category" items="${listcat.rows}">
          <tr>
            <td><c:out value="${category.id}" /></td>
            <td><c:out value="${category.category_name}" /></td>
            <td>
              <a
                href="update_category.jsp?id=${category.id}&name=${category.category_name}"
                >Edit</a
              >
            </td>
            <td><a href="delete_category.jsp?id=${category.id}">Delete</a></td>
          </tr>
        </c:forEach>
      </table>
    </div>
  </body>
</html>
