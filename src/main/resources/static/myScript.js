$("document").ready(function (){
    getPersonas();
});

function getPersonas(){
    $.ajax({
        url : "api/Persona/all",
        type : 'GET',
        dataType : 'json',
        success : function(p) {

            $("#resultado").empty();
            for(i=0;i<p.length;i++){
                $("#resultado").append(p[i].id+" "+p[i].name+" "+p[i].email+" "+p[i].age+" ");
                $("#resultado").append(" <button onclick='getPersonaById("+p[i].id+")'>Actualizar</button>");
                $("#resultado").append(" <button onclick='deleteAudience("+p[i].id+")'>Borrar!</button>");
                $("#resultado").append("<br>");
            }

        },
        error : function(xhr, status) {
            alert('ha sucedido un problema');
        },
        complete : function(xhr, status) {
            //  alert('Petición realizada');
        }
    });
}
function getData(){
    let data={
        name: $("#namePersona").val(),
        email: $("#emailPersona").val(),
        age:$("#agePersona").val()
    }
    return data;
}

function cleanData(){
    $("#idPersona").val("");
    $("#namePersona").val("");
    $("#agePersona").val("");
    $("#emailPersona").val("");
}

function savePersona(){

    let myData=getData();
    let dataToSend=JSON.stringify(myData);

    $.ajax({
        url : "api/Persona/save",
        data : dataToSend,
        type : 'POST',
	    dataType : 'json',
        contentType:'application/json',
        success : function(dg) {
            console.log(dg);
            cleanData();
            getPersonas();

        },
        error : function(xhr, status) {
            alert('ha sucedido un problema');
        },
        complete : function(xhr, status) {
            //  alert('Petición realizada');
        }
    });
}

function getPersonaById(idPersona){
    $.ajax({
        url : "api/Persona/"+idPersona,
        type : 'GET',
        dataType : 'json',
        success : function(item) {

            $("#idPersona").val(item.id);
            $("#namePersona").val(item.name);
            $("#emailPersona").val(item.email);
            $("#agePersona").val(item.age);
        },
        error : function(xhr, status) {
            alert('ha sucedido un problema');
        },
        complete : function(xhr, status) {
            //  alert('Petición realizada');
        }
    });
}