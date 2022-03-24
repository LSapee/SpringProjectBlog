<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="../layout/header.jsp" %>

<div class="container">
    <h2>Login</h2>
    <form action ="/auth/loginProc" method="post">
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
        <button id="btn-login" class="btn btn-primary">Login</button>
        <a href="https://kauth.kakao.com/oauth/authorize?client_id=04f3a1df750e83bb05a1fc8306da6f8b&redirect_uri=http://localhost:8000/auth/kakao/callback&response_type=code"><img height="38px" src = "/img/kakao_login.png" alt="kakao login"></a>
    </form>
</div>

<%@ include file="../layout/footer.jsp" %>