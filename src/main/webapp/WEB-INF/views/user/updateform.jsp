<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="../layout/header.jsp" %>

<div class="container">
    <h2>회원정보 수정</h2>
    <form>
        <input type="hidden" id="id" value="${principal.users.id}"/>
        <div class="form-group">
            <label for="username">UserName:</label>
            <input type="username" value="${principal.users.username}" class="form-control" id="username"
                   name="username" readonly>
        </div>
        <c:if test="${empty principal.users.oauth}">
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" class="form-control" id="password" name="password">
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" value="${principal.users.email}" class="form-control" id="email" name="email" readonly>
            </div>
        </c:if>

    </form>
    <button id="btn-update" class="btn btn-primary">회원정보 수정</button>
</div>

<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp" %>
