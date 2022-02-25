<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %> <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<% if (session.getAttribute("username") == null) { String redirectURL =
"http://localhost:8080/PetStore/"; response.sendRedirect(redirectURL); } %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>List Pets Records</title>
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
    <sql:query var="listPets" dataSource="${myDS}">
      SELECT pet.id,pet.name,pet.photo,category.category_name,tag.tag_name,
      pet.status FROM ((pet INNER JOIN category ON pet.categoryid = category.id)
      INNER JOIN tag ON pet.tagid=tag.id);
    </sql:query>
    <div>
      <a href="addpet.jsp">Add Pet Details</a> <br />
      <a href="category.jsp">View Category Details</a> <br />
      <a href="showpet.jsp">Search Pet with Id</a> <br />
      <a href="tag.jsp">View Tag Details</a> <br />
      <a href="logout">LOGOUT</a> <br />
    </div>
    <div align="center">
      <table border="1" cellpadding="5">
        <caption>
          List of Pets
        </caption>
        <tr>
          <th>ID</th>
          <th>Name</th>
          <th>Photo</th>
          <th>Category</th>
          <th>Tag</th>
          <th>Status</th>
          <th>Edit</th>
          <th>Delete</th>
        </tr>
        <c:forEach var="pet" items="${listPets.rows}">
          <tr>
            <td><c:out value="${pet.id}" /></td>
            <td><c:out value="${pet.name}" /></td>
            <td><c:out value="${pet.photo}" /></td>
            <td><c:out value="${pet.category_name}" /></td>
            <td><c:out value="${pet.tag_name}" /></td>
            <td><c:out value="${pet.status}" /></td>
            <td>
              <a
                href="update.jsp?id=${pet.id}&name=${pet.name}&photo=${pet.photo}&status=${pet.status}"
                >Edit</a
              >
            </td>
            <td><a href="delete.jsp?id=${pet.id}">Delete</a></td>
          </tr>
        </c:forEach>
      </table>
    </div>
  </body>
</html>
