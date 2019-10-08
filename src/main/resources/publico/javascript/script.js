$(document).ready(function () {
    $('.estudiante').on('click', function(){
        var matricula = $(this).children(".matricula").text();
        window.location.replace("/showEstudiante/" + matricula);
    });
});