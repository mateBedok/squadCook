
const responseHandler = {

    successSaveComment: function (response) {
        $('#displayComment' + response.mainFeedPostId).append(
            '<hr/><div class="media-block pad-all" style="margin-bottom: 12px;padding-left: 50px;">\n' +
            '                                            <div>\n' +
            '                                                <a class="media-left" href="#"><img class="img-circle img-sm" alt="Profile Picture" src="https://scontent-vie1-1.xx.fbcdn.net/v/t1.0-1/p100x100/10400046_1463829200340110_7740717001636395235_n.jpg?_nc_cat=0&oh=8cd981a225ffcfc9568c9308d00006a2&oe=5B6AE5EA"/></a>\n' +
            '                                                <div class="media-body">\n' +
            '                                                    <div class="mar-btm">\n' +
            '                                                        <a href="#" class="btn-link text-semibold media-heading box-inline">'+ response.userFullName +'</a>\n' +
            '                                                        <p class="text-muted text-sm"><i class="fa fa-globe fa-lg"></i> - From Web - 1 min ago</p>\n' +
            '                                                    </div>\n' +
            '                                                    <p>'+ response.commentContent + '</p>\n' +
            '                                                    <div>\n' +
            '                                                        <div class="btn-group">\n' +
            '                                                            <a class="btn btn-sm btn-default btn-hover-success" href="#"><i class="fa fa-thumbs-up"></i></a>\n' +
            '                                                            <a class="btn btn-sm btn-default btn-hover-danger" href="#"><i class="fa fa-thumbs-down"></i></a>\n' +
            '                                                        </div>\n' +
            '                                                    </div>\n' +
            '                                                </div>\n' +
            '                                            </div>\n' +
            '                                        </div>'
        );
    },

    errorSaveComment: function (response) {
        console.log("error saving comment");
    }

};

function postComment(){
    $('.commentBtn').on('click', function (event) {
        event.preventDefault();
        var feedPostId = $(this).attr('id');

        var commentContentId = "#commentContent" + feedPostId;
        let returnData = {
            "commentContent": $(commentContentId).val(),
            "mainFeedPostId": feedPostId,
            "userFullName": $("#userFullName").val()
        };

        $.ajax({
            url: '/saveComment',
            type: 'POST',
            contentType: 'application/json; charset=UTF-8',
            data: JSON.stringify(returnData),
            success: responseHandler.successSaveComment(returnData),
            error: responseHandler.errorSaveComment()
        })
    })
}

$(document).ready(function () {
    postComment();
});

$(document).ajaxSend(function(e, xhr, options) {
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    xhr.setRequestHeader(header, token);
});