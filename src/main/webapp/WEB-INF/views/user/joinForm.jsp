<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="../layout/header.jsp" %>

<div class="container">
    <h2>Join</h2>
    <form>
        <div class="form-group">
            <label for="username">UserName:</label>
            <input type="username" class="form-control" id="username"  name="username">
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" class="form-control" id="password"  name="password">
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" class="form-control" id="email" name="email">
        </div>

    </form>
    <button id = "btn-save" class="btn btn-primary">Join</button>
</div>

<script src="/blog/js/user.js"></script>
<%@ include file="../layout/footer.jsp" %>
