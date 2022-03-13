<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="layout/header.jsp" %>

<div class="container">
    <h2>Login</h2>
    <form>
        <div class="form-group">
            <label for="username">UserName:</label>
            <input type="username" class="form-control" id="username"  name="username">
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" class="form-control" id="password"  name="password">
        </div>

        <div class="form-group form-check">
            <label class="form-check-label">
                <input class="form-check-input" type="checkbox" name="remember"> Remember me
            </label>
        </div>
    </form>
    <button id="btn-login" class="btn btn-primary">Login</button>
</div>


<script src="/js/user.js"></script>
<%@ include file="layout/footer.jsp" %>