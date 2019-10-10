document.querySelector("#matricula").addEventListener("keypress", function (evt) {
    if (evt.which != 8 && evt.which != 0 && evt.which != 13  && evt.which < 48 || evt.which > 57) {
        evt.preventDefault();
    }
});

document.querySelector("#telefono").addEventListener("keypress", function (evt) {
    if (evt.which != 8 && evt.which != 0 && evt.which != 13  && evt.which < 48 || evt.which > 57) {
        evt.preventDefault();
    }
});

document.querySelector("#nombre").addEventListener("keypress", function (evt) {
    if (evt.which != 8 && evt.which != 0 && evt.which != 13 && evt.which != 32 && (evt.which < 65 || evt.which > 90) && (evt.which < 97 || evt.which > 122)) {
        evt.preventDefault();
    }
});

document.querySelector("#apellido").addEventListener("keypress", function (evt) {
    if (evt.which != 8 && evt.which != 0 && evt.which != 13 && evt.which != 32  && (evt.which < 65 || evt.which > 90) && (evt.which < 97 || evt.which > 122)) {
        evt.preventDefault();
    }
});