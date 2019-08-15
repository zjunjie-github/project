/**
 *@author zhangjunjie 2019/8/15
 */

function post() {
    var questionId = $("#question_id").val();
    var content = $("#comment_content").val();
    if (!content){
        alert("不能回复空内容~~");
        return;
    }

    $.ajax({
        type: "POST",
        url: "/comment",
        contentType:'application/json',
        data: JSON.stringify({
            "parentId":questionId,
            "content":content,
            "type":1
        }),
        success: function (response) {
            if (response.code == 200){
                window.location.reload();
            }else{
                if (response.code == 2003){
                    var isAccepted = confirm(response.message);
                    if (isAccepted){
                        window.open("https://github.com/login/oauth/authorize?client_id=03e9b0e7ded4935219e5&redirect_uri=http://localhost:8088/callback&scope=user&state=1")
                        window.localStorage.setItem("closable",true);
                    }
                } else{
                alert(response.message);
                }
            }
        },
        dataType: "json"
    });
    console.log(questionId);
    console.log(content);
}