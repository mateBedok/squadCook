$('#ingredientsContent').keypress(function(event){

    var keycode = (event.keyCode ? event.keyCode : event.which);
    if(keycode == '13'){
        document.getElementById('ingredientsContent').value = document.getElementById('ingredientsContent').value + "\n- ";
        return false;
    }
    event.stopPropagation();
});
