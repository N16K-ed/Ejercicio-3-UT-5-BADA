<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tienda de Ebays</title>
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
            background-image: url("../imajes/fondo.jpg");
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
            outline: 1px solid rgb(175, 175, 175);
            box-shadow: 6px 6px 6px 6px rgba(0, 0, 0, 0.2);
            border-radius: 20px;
            padding: 50px;
            padding-top: 20px;
            padding-bottom: 100px;
            
        }

        .loginForm > form {
            text-align: center;
        }

        .loginForm input {
            height: 3vh;
            border-radius: 5px;
            border: 1px solid black;
            background-color: rgba(211, 211, 211, 0.4);
        }
        
        .loginForm button {
            height: 5vh;
            width: 8vw;
            margin: 5px;
            border-radius: 20px;
            border: 1px solid black;
            background-color: transparent;
            transition: 0.25s ease-in-out;
            /* box-shadow: rgba(0, 0, 0, 0.19) 5px 5px 20px, rgba(0, 0, 0, 0.23) 5px 5px 6px; */
        }

        .loginForm button:hover {
            cursor: pointer;
            box-shadow: rgba(0, 0, 0, 0.19) 5px 5px 20px, rgba(0, 0, 0, 0.23) 5px 5px 6px;
            margin-top: -3px;
            margin-bottom: 15px;
        }

    </style>
</head>
<body>
    <div class="wrapper">
        <div class="loginForm">
            <form action="/inisesion" method="POST">
                <h1>Iniciar Sesión</h1>
                <label for="">Nombre de usuario:</label><br><br>
                <input type="text" name="usuario" id=""><br><br>
                <label for="">Contraseña:</label><br><br>
                <input type="text" name="contrasenya" id=""><br><br>
                <button type="submit">Iniciar Sesión</button>
                <br>
                <p>¿Aún no te has creado una cuenta?</p>
                <button type="button" onclick="window.location.href='registrarse.html';">Registrate ahora</button>
            </form>
        </div>
    </div>
</body>
</html>
