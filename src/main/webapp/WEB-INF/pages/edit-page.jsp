<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Edit User</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: #b3159b">
        <div>
            <a href="http://localhost:8080/" class="navbar-brand">  </a>
        </div>
    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <form action="/admin/update" method="post">
                <caption>
                    <h2>
                        Edit User
                    </h2>
                </caption>
                <input type="hidden" name="id" value="<c:out value='${user.id}' />" />
                <fieldset class="form-group">
                    <label>User Login</label> <input type="text"
                                                     value="<c:out value='${user.username}' />" class="form-control"
                                                     name="username" required="required">
                </fieldset>

                <fieldset class="form-group">
                    <label>User Password</label> <input type="text"
                                                        value="<c:out value='${user.password}' />" class="form-control"
                                                        name="password" required="required">
                </fieldset>
                <tr>
                    <td><input type="checkbox" name="user" value="1">USER<Br>
                        <input type="checkbox" name="admin" value="2">ADMIN<Br>
                    </td>
                </tr>

                <button type="submit" class="btn btn-success">Save </button>
            </form>
        </div>
    </div>
</div>
</body>
</html>