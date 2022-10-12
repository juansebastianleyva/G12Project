$("document").ready(function (){
    getAudiences();
    getCategories();
});
function getCategories(){
    $.ajax({
        url : "api/Category/all",
        type : 'GET',
        dataType : 'json',
        success : function(p) {
                   $("#categoryAudience").empty();
                    for(i=0;i<p.length;i++){
                        let k="<option value='"+p[i].id+"'>"+p[i].name+"</option>";
                        $("#categoryAudience").append(k);
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
function getAudiences(){
    $.ajax({
        url : "api/Audience/all",
        type : 'GET',
        dataType : 'json',
        success : function(p) {
               $("#resultado").empty();
            for(i=0;i<p.length;i++){
                $("#resultado").append(p[i].name+" "+p[i].description+" "+p[i].owner+" "+p[i].capacity+" ");
                $("#resultado").append(p[i].category.name+" ");
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
function getDataAudience(){
    let data={
        name: $("#nameAudience").val(),
        capacity: $("#capacityAudience").val(),
        description:$("#descriptionAudience").val(),
        owner:$("#ownerAudience").val(),
        category:{ id:$("#categoryAudience option:selected").val()}
    }
    return data;
}

function cleanData(){
        $("#nameAudience").val("");
        $("#capacityAudience").val("");
        $("#descriptionAudience").val("");
        $("#ownerAudience").val("");
}

function saveAudience(){
    let myData=getDataAudience();
    let dataToSend=JSON.stringify(myData);
    $.ajax({
        url : "api/Audience/save",
        data : dataToSend,
        type : 'POST',
	    dataType : 'json',
        contentType:'application/json',
        success : function(dg) {
            console.log(dg);
            cleanData();
            getAudiences();
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