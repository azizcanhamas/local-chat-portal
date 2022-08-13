<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login | Free Local Chat Portal</title>
    <link rel="stylesheet" href="styles/index.css">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital@1&display=swap" rel="stylesheet"></head>
<body>
    <div class="main">
        <div id="left">
            <img src="img/logo.png" alt="">
            <h2>
                Welcome to Free Local Chat Portal!
            </h2>
        </div>
        <div id="right">
            <form action="loginController"method="post">
                <table>
                    <tr>
                        <td>E-mail</td>
                        <td><input type="text" name="email" id="email" onkeyup="check()"></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="password" id="password" onkeyup="check()"></td>
                    </tr>
                    <tr>
                        <td><button formaction="register.jsp">Register</button></td>
                        <td><input type="submit" value="Login" id="login"></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</body>

<script>
    document.getElementById("login").disabled=true;
    function check(){
        if(document.getElementById("email").value.length==0)
            document.getElementById("login").disabled=true;
        else if(document.getElementById("password").value.length==0)
            document.getElementById("login").disabled=true;
        else
            document.getElementById("login").disabled=false;
    }
    
</script>

</html>