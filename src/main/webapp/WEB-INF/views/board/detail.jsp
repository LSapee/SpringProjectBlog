<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="../layout/header.jsp"%>
    <div class="container">
        <button class="btn btn-secondary" onclick="history.back()">
            돌아가기
        </button>
        <c:if test="${board.users.id == principal.users.id}">
            <a href="/board/${board.id}/updateForm" class="btn btn-warning">수정</a>
            <button id="btn-delete" class="btn btn-danger">삭제</button>
        </c:if>
        <br/>
        <div>
            글 번호 :<span id="id"><i>${board.id} </i></span>
            작성자 : <span><i>${board.users.username}</i></span>
        </div>
            <div>
                <h3>${board.title}</h3>
            </div>
            <hr>
        <div>
            <div>
                ${board.content}
            </div>

        </div>
        <hr/>

        <div >
            <div class="card">
                <div claas="card-body"><textarea class="form-control" rows= "1"></textarea></div>
                <div class="card-footer"><button class ="btn btn-primary">등록</button></div>
            </div>
        </div>

    </div>

<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp"%>