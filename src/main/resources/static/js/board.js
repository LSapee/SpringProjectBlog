let index;
index = {
    init: function () {
        $("#btn-save").on("click", () => {
            this.save();
        });
        $("#btn-delete").on("click", () => {
            this.deleteById();
            alert(id);
        });
    },
    save: function () {
        // alert("user의 save 함수 호출");
        let data = {
            title: $("#title").val(),
            content: $("#content").val(),
        };  //json형식으로 js 데이터 정리

        //ajax 호출시 default가 비동기 호출
        $.ajax({
            type: "POST", //전송방식
            url: "/api/board",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8", //body데이터가 어떤 타입인지 (MIME)
            dataType: "json"//요청을 서버로해서 응답이 왔을 때
        }).done(function (resp) {

            alert("글쓰기가 완료되었습니다.");
            console.log(resp);
            location.href = "/";
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });//ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert요청

    },
    deleteById: function () {

        const id = $("#id").val();

        $.ajax({
            type: "DELETE", //전송방식
            url: "/api/board/" + id,
            dataType: "json"
        }).done(function (resp) {
            alert("삭제가 완료되었습니다.");
            console.log(resp);
            location.href = "/";
        }).fail(function (error) {
            console.log(JSON.stringify(error));
        });//ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert요청

    }
};

index.init();