
function like(){
    $('.like').on('click', function (event) {
        let likeIdClass = '.' + $(this).attr('id');
        let likeId = '#' + $(this).attr('id');
        let likeClass = $(likeId).attr('class');
        if (likeClass === "far fa-heart like") {
            $(likeId).attr('class', 'fas fa-heart like');
            $(likeIdClass).text(parseInt($(likeIdClass).text()) + 1);
            console.log($(likeIdClass).text());

        } else {
            $(likeId).attr('class', 'far fa-heart like');
            $(likeIdClass).text(parseInt($(likeIdClass).text()) - 1);
        }
    })
}

$(document).ready(function () {
    like();
});