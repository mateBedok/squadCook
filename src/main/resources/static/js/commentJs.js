
const responseHandler = {

    successSaveComment: function (response) {
        $('#displayComment' + response.mainFeedPostId).append(
            '<hr/><div class="media-block pad-all" style="margin-bottom: 12px;padding-left: 50px;">\n' +
            '                                            <div>\n' +
            '                                                <a class="media-left" href="#"><img class="img-circle img-sm" alt="Profile Picture" src="'+ response.profileImage +'"/></a>\n' +
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
        $('.comment-textarea').val('');
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
            "profileImage": $('#profileImage').val(),
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