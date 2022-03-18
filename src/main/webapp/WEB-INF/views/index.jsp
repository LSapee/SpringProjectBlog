<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="layout/header.jsp"%>

    <div class="container">
<%--        게시글 반복하기--%>
        <c:forEach var="board" items="${boards.content}">
        <div class="card m-10" style="width:300px; height:100%">
            <img class="card-img-top" src="img/a.png" alt="Card image" style="width:100%">
            <div class="card-body">
                <h4 class="card-title">"${board.title}"</h4>
                <p class="card-text">"${board.content}"</p>
                <a href="#" class="btn btn-primary">상세보기</a>
            </div>
        </div>
    </c:forEach>
    <ul class="pagination justify-content-center">
        <c:choose>
            <c:when test="${boards.first}">
                <li class="page-item disabled">
                    <a class="page-link" href="?page=${boards.number-1}">Previous</a>
                </li>
            </c:when>
            <c:otherwise>
                <li class="page-item">
                    <a class="page-link" href="?page=${boards.number-1}">Previous</a>
                </li>
            </c:otherwise>
        </c:choose>
        <c:choose>
            <c:when test="${boards.last}">
                <li class="page-item disabled">
                    <a class="page-link" href="?page=${boards.number+1}">Next</a>
                </li>
            </c:when>
            <c:otherwise>
                <li class="page-item">
                    <a class="page-link" href="?page=${boards.number+1}">Next</a>
                </li>
            </c:otherwise>
        </c:choose>

    </ul>
    </div>

<%@ include file="layout/footer.jsp"%>