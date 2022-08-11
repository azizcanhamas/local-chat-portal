<%-- 
    Document   : chatpanel.jsp
    Created on : Aug 11, 2022, 3:58:35 PM
    Author     : azuwin_user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Local Chat Panel</title>
    <link rel="stylesheet" href="styles/chatpanel.css">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital@1&display=swap" rel="stylesheet"></head>
<body>
    <div class="main">
        <form action="">
        <div id="left">            
                <button formaction="index.html" id="quit">Quit</button>
                <h1>
                    Chat Panel
                </h1>
                <textarea name="textarea" id="textarea" cols="30" rows="10" readonly></textarea>
                <div id="sendmessage">
                    <input type="text">
                    <input type="submit" value="Send">
                </div>             
        </div>
    </form>     
    </div>
</body>

<script>
    document.getElementById("login").disabled=true;
    function check(){
        if(document.getElementById("email").value.length==0)
            document.getElementById("login").disabled=true;
        else
            document.getElementById("login").disabled=false;
    }
    
</script>

</html>