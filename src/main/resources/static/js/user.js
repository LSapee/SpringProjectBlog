let index = {
    init:function(){
        $("#btn-save").on("click",()=>{//function사용하지 않는 이유 this를 바인딩하기 위해서!
            this.save();
        });
        $("#btn-update").on("click",()=>{//function사용하지 않는 이유 this를 바인딩하기 위해서!
            this.update();
        });
    },

    save:function (){
        // alert("user의 save 함수 호출");
        let data = {
            username : $("#username").val(),
            password : $("#password").val(),
            email : $("#email").val()
        };  //json형식으로 js 데이터 정리

        //ajax 호출시 default가 비동기 호출
        $.ajax({
            type:"POST", //전송방식
            url:"/auth/joinProc",
            data:JSON.stringify(data),// JSON으로 데이터 변경 body데이터
            contentType:"application/json; charset=utf-8", //body데이터가 어떤 타입인지 (MIME)
            dataType:"json"//요청을 서버로해서 응답이 왔을 때
            }).done(function (resp){

                alert("회원가입이 완료되었습니다.");
                console.log(resp);
                location.href="/";
            }).fail(function (error) {
                alert(JSON.stringify(error));
            });//ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert요청

    },
    update:function (){
        // alert("user의 save 함수 호출");
        let data = {
            id : $("#id").val(),
            username:$("#username").val(),
            password : $("#password").val(),
            email : $("#email").val()
        };  //json형식으로 js 데이터 정리

        $.ajax({
            type:"PUT", //전송방식
            url:"/user",
            data:JSON.stringify(data),// JSON으로 데이터 변경 body데이터
            contentType:"application/json; charset=utf-8", //body데이터가 어떤 타입인지 (MIME)
            dataType:"json"//요청을 서버로해서 응답이 왔을 때
        }).done(function (resp){
            alert("회원정보 수정이 완료되었습니다.");
            console.log(resp);
            location.href="/";
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });//ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert요청

    }
}

index.init();

/*
       $("#btn-login").on("click",()=>{//function사용하지 않는 이유 this를 바인딩하기 위해서!
            this.login();
        });
  ,login:function (){
      // alert("user의 save 함수 호출");
      let data = {
          username : $("#username").val(),
          password : $("#password").val(),
      };  //json형식으로 js 데이터 정리

      //ajax 호출시 default가 비동기 호출
      $.ajax({
          type:"POST", //전송방식
          url:"/api/user/login",
          data:JSON.stringify(data),// JSON으로 데이터 변경 body데이터
          contentType:"application/json; charset=utf-8", //body데이터가 어떤 타입인지 (MIME)
          dataType:"json"//요청을 서버로해서 응답이 왔을 때
      }).done(function (resp){
          alert("로그인이 완료되었습니다.");
          console.log(resp);
          location.href="/";
      }).fail(function (error) {
          console.log(JSON.stringify(error));
      });//ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert요청

  }

 */