cloudinary.setCloudName('dvtsdp6jc');

const reesponseHandler = {

    successUploadFile: function (response) {
        $('#post-img-container').html("<img class='post-img' src='" + response.url + "' style='width: 140px;\n" +
            "    height: auto; margin-top: 20px; margin-left: 20px; border-radius: 20px'/>")
    },

    errorUploadFile: function (response) {
        console.log("error saving comment");
    }

};

widget = cloudinary.createUploadWidget({
        upload_preset: 'x0ztkxfn',
        theme: 'minimal',
        stylesheet: "#cloudinary-overlay.modal {\n" +
        "    background-color: rgba(107, 107, 107, 0.89);\n" +
        "}"
    },
    function(error, result) {
    console.log(result[0].url);
    let data = {
        "url": result[0].url,
    };

    $.ajax({
        url: '/uploadFile',
        type: 'POST',
        contentType: 'application/json; charset=UTF-8',
        data: JSON.stringify(data),
        success: reesponseHandler.successUploadFile(data)
    })});

$('#uploadButton').on('click', function (event) {
    event.preventDefault();
    widget.open();
});
