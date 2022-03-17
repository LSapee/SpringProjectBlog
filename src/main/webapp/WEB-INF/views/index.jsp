<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="layout/header.jsp"%>

    <div class="container">
        <c:forEach var="board" items="${boards}">
        <div class="card m-10" style="width:300px">
            <img class="card-img-top" src="img/a.png" alt="Card image" style="width:100%">
            <div class="card-body">
                <h4 class="card-title">"${board.title}"</h4>
                <p class="card-text">"${board.content}"</p>
                <a href="#" class="btn btn-primary">상세보기</a>
            </div>
        </div>
    </c:forEach>
    </div>

<%@ include file="layout/footer.jsp"%>