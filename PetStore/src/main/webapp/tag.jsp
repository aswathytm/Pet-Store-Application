<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %> <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<% if (session.getAttribute("username") == null) { String redirectURL =
"http://localhost:8080/PetStore/"; response.sendRedirect(redirectURL); } %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Tag</title>
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
    <sql:query var="listtag" dataSource="${myDS}">
      SELECT * FROM tag;
    </sql:query>
    <div><a href="list.jsp?id=${tag.id}">Show Pet Details</a><br /></div>
    <div align="center">
      <table border="1" cellpadding="5">
        <caption>
          Tag list
        </caption>

        <tr>
          <th>ID</th>
          <th>Name</th>
        </tr>
        <c:forEach var="tag" items="${listtag.rows}">
          <tr>
            <td><c:out value="${tag.id}" /></td>
            <td><c:out value="${tag.tag_name}" /></td>
          </tr>
        </c:forEach>
      </table>
    </div>
  </body>
</html>
