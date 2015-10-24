
function getTestREst() {

    var jsontext = '{ "userName" : "amin" , "passWord": "amin"}';
    var user = JSON.parse(jsontext);

    jQuery.ajax({
        type: "POST",
        url: "http://localhost:8090/ksu-capstone-project-app/rest/userservice/userauth",
        data: user,
        dataType :"json",
        contentType:"application/json",
        accept:"application/json",
        //crossDomain: true,

        success : function(data, status, jqXHR) {
            $('#reply').html(data);
            alert(data.toString());
        },

        error : function(jqXHR, status) {
        }
    });
}





function getTestGet() {

    var username= $("#username").val();
    var password=$("#password").val();
    var url= 'http://localhost:8090/ksu-capstone-project-app/rest/userservice/userServ?userName='+
            username+'&passWord='+password;
    jQuery.ajax({
        type: "GET",
        url: url,

        success : function(data, status, jqXHR) {
            // $('#reply').html(data);
            $('#loginpop').hide();
            $("#username").val(' ');
            $("#password").val(' ');
        },

        error : function(jqXHR, status) {
            alert('login failed please try again');
        }
    });
}


