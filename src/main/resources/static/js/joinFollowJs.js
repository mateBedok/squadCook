
function requestSquadJoin(){
    $('.joinButton').on('click', function (event) {
        event.preventDefault();
        console.log("clicked")
        var squadId = $(this).attr('id');

        let returnData = {
            "squadId": squadId
        };

        $.ajax({
            url: '/requestSquadJoin',
            type: 'POST',
            contentType: 'application/json; charset=UTF-8',
            data: JSON.stringify(returnData)
            /*success: responseHandler.successSaveRequestJoin(returnData),
            error: responseHandler.errorSaveRequestJoin()*/
        })
    })
}

$(document).ready(function () {
    requestSquadJoin();
});

$(document).ajaxSend(function(e, xhr, options) {
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    xhr.setRequestHeader(header, token);
});