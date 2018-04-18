var collapsedSize = '51px';
$('.item').each(function() {
    var h = this.scrollHeight;
    console.log(h);
    var div = $(this);
    if (h > 60) {
        div.css('height', collapsedSize);
        div.after('<a id="more" class="item" >Read more</a><br/>');
        var link = div.next();
        link.click(function(e) {
            e.stopPropagation();

            if (link.text() != 'Collapse') {
                link.text('Collapse');
                div.animate({
                    'height': h
                });

            } else {
                div.animate({
                    'height': collapsedSize
                });
                link.text('Read more');
            }

        });
    }

});
