<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tienda de Ebays</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap');

        html, body {
            overflow: hidden;
        }

        * {
            font-family: "Open Sans", sans-serif;
        }

        .loginForm {
            width: 20%;
            margin: auto;
            margin-top: 10%;
            margin-bottom: 20%;
            height: 30vh;
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
            margin-top: 15%;
            margin-bottom: 20%;
            outline: 1px solid rgb(175, 175, 175);
            box-shadow: 6px 6px 6px 6px rgba(0, 0, 0, 0.2);
            border-radius: 20px;
            padding: 50px;
            padding-top: 20px;
            padding-bottom: 100px;
            text-align: center;            
            
        }
        
        .loginForm h1 {
            margin-top: 10vh;
        }

        .loginForm button {
            height: 5vh;
            width: 8vw;
            margin: 5px;
            border-radius: 20px;
            border: 1px solid black;
            background-color: transparent;
            transition: 0.25s ease-in-out;
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
            <h1>Tu cuenta acaba de ser creada :D</h1>
            <button type="button" onclick="window.location.href='home.html';">Volver al inicio</button>
        </div>
    </div>
</body>
</html>
