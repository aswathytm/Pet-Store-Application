<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %> <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<% if (session.getAttribute("username") == null) { String redirectURL =
"http://localhost:8080/PetStore/"; response.sendRedirect(redirectURL); } %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Add Data</title>
    <style>
      table {
        border-collapse: collapse;
      }
    </style>
  </head>
  <body>
    <div><a href="list.jsp">Cancel</a> <br /></div>
    <div align="center">
      <table border="1" cellpadding="5">
        <caption>
          Add Pet Details
        </caption>
        <form action="AddPet" method="post">
          <tr>
            <th>name:</th>
            <td><input type="text" name="name" required/><br /></td>
          </tr>
          <tr>
            <th>category:</th>
            <td>
              <sql:setDataSource
                var="myDS"
                driver="com.mysql.jdbc.Driver"
                url="jdbc:mysql://db:3306/petstore?useSSL=false&allowPublicKeyRetrieval=true"
                user="root"
                password="qburst123"
              />

              <sql:query var="listCategory" dataSource="${myDS}">
                SELECT * FROM category;
              </sql:query>

              <select name="category">
                <c:forEach var="category" items="${listCategory.rows}">
                  <option value="${category.id}">
                    ${category.category_name}
                  </option>
                </c:forEach>
              </select>
            </td>
          </tr>

          <tr>
            <th>photo:</th>
            <td><input type="text" name="photo" required/><br /></td>
          </tr>
          <tr>
            <th>status:</th>
            <td><input type="text" name="status" required/><br /></td>
          </tr>
          <tr>
            <th>Tag</th>
            <td>
              <sql:query var="listTag" dataSource="${myDS}">
                SELECT * FROM tag;
              </sql:query>
              <select name="tag">
                <c:forEach var="tag" items="${listTag.rows}">
                  <option value="${tag.id}">${tag.tag_name}</option>
                </c:forEach>
              </select>
            </td>
          </tr>
          <tr>
            <th>submit:</th>
            <td><input type="submit" value="submit" /></td>
          </tr>
        </form>
      </table>
    </div>
  </body>
</html>
