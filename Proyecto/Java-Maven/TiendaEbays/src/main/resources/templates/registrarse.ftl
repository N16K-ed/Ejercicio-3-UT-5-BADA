<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Iniciar Sesión</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap');

        * {
            font-family: "Open Sans", sans-serif;
        }

        .loginForm {
            width: 20%;
            margin: auto;
            margin-top: 10%;
            margin-bottom: 20%;
            height: 40vh;
            outline: 1px solid gray;
        }

        .loginForm > form {
            text-align: center;
        }


        body {
            background-image: url("src/main/resources/images/fondo.jpg");
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
        }

        .loginForm {
            backdrop-filter: blur(5px);
            width: 20%;
            margin: auto;
            margin-top: 10%;
            margin-bottom: 20%;
            height: 40vh;
            outline: 1px solid rgb(175, 175, 175);
            box-shadow: 6px 6px 6px 6px rgba(0, 0, 0, 0.2);
            border-radius: 20px;
            padding: 50px;
        }

        .loginForm > form {
            text-align: center;
        }

    </style>
</head>
<body>
    <div class="wrapper">
        <div class="loginForm">
            <form action="/regis" method="POST">
                <h1>Registrarse</h1>
                <label for="">Nombre de usuario:</label><br><br>
                <input type="text" name="usuario" id=""><br><br>
                <label for="">Email:</label><br><br>
                <input type="text" name="email" id=""><br><br>
                <label for="">Contraseña:</label><br><br>
                <input type="text" name="contrasenya" id=""><br><br>
                <label for="">Confirmar contraseña:</label><br><br>
                <input type="text" name="confirmarcontrasenya" id=""><br><br>
                <button type="submit">Registrarse</button>
                <br>

                <button><a href="/">Volver a la página principal</a></button>
            </form>
        </div>
    </div>
</body>
</html>
