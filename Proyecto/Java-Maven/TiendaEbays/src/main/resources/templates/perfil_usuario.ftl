<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Perfil</title>
    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap');

        * {
            font-family: "Open Sans", sans-serif;
        }

        html, body {
            margin: 0px;
            padding: 20px;
        }

        .topnav {
            overflow: hidden;
            background-color: #414141;
            border-radius: 20px;
            margin-top: -20px;
            margin-bottom: 2vh;
        }

        .topnav a{
            display: inline-block;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
            font-size: 17px;
        }

        .topnav a:hover:not(:first-child) {
            background-color: #717171;
            text-decoration: underline;
        }

        .categorias {
            overflow: hidden;
            display: flex;
            justify-content: center;
            align-self: center;
            background-color: #4d4d4d;
        }

        .categorias a {
            display: inline-block;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        .categorias a{
            font-size: 14px;
        }

        .categorias a:hover{
            text-decoration: underline;
            background-color: #616161;
            color: white;
        }

        .topnav form {
            display: inline-block;
            padding: 14px 16px;
            margin-left: 25%;
        }

        .topnav input {
            width: 30vw;
            border-radius: 5px;
            height: 4vh;
        }

        .topnav button {
            margin-left: 10px;
            height: 5.5vh;
            width: 3vw;
            border-radius: 5px;
            background-color: transparent;
            outline: 1px solid white;
            border: none;
        }

        .perfil img {
            border-radius: 50%;
            width: 20vh;
        }

        .perfil {
            text-align: center;
            background-color: lightgray;
            padding: 20px;
            border-radius: 20px;
            border: 1px solid rgb(86, 86, 86);
            box-shadow: rgba(0, 0, 0, 0.3) 0px 19px 38px, rgba(0, 0, 0, 0.22) 0px 15px 12px;
        }

        .perfil > div {
            outline: 1px solid red;
        }

        .logo {
            text-align: center;
        }

        .objetosVenta {
            text-align: center;
            margin-top: 6vh;
            background-color: lightgray;
            outline: 1p solid pink;
            padding: 20px;
            padding-bottom: 8vh;
            border-radius: 20px;
            border: 1px solid rgb(86, 86, 86);
            box-shadow: rgba(0, 0, 0, 0.3) 0px 19px 38px, rgba(0, 0, 0, 0.22) 0px 15px 12px;
        }

        .objetosVenta > h1 {
            margin-bottom: 40px;
        }

        .articulos {
            display: grid;
            grid-template-columns: repeat(4, 1fr);
            grid-row-gap: 4vh;
        }

        .articulos  div {
            padding: 20px;
            padding-top: 30px;
            padding-bottom: 40px;
            text-align: center;
            outline: 1px solid rgb(154, 154, 154);
            border-radius: 10px;
            align-items: center;
            width: 60%;
            margin: auto;
            background-color: rgba(221, 221, 221, 0.5);
            box-shadow: rgba(50, 50, 93, 0.25) 0px 50px 100px -20px, rgba(0, 0, 0, 0.3) 0px 30px 60px -30px, rgba(10, 37, 64, 0.35) 0px -2px 6px 0px inset;
        }

        .articulos  div  img {
            border-radius: 10px;
        }

        .articulos  div  p{
            text-align: center;
            margin: auto;
        }

    </style>
</head>
<body>
    <div class="wrapper">
        <div class="topnav">
            <a class="active" href="index.html">Evai</a>
            <form action="">
                <input type="text" placeholder="Buscar..." name="" id="">
                <button><i class="fa fa-search" style="color: white;"></i></button>
            </form>
            <a href="login.html">Login</a>
            <a href="registrarse.html">Registrarse</a>
        </div>
        <div class="perfil">
            <img src="../imajes/usuario.jpg" alt="">
            <h1>Nombre usuario</h1>
            <h2>Apellido1 Apellido2</h2>
        </div>
        <div class="objetosVenta">
            <h1>Articulos que [nombreUsuario] vende</h1>
            <div class="articulos">
                <div class="objecto">
                    <a href=""><img src="../imajes/objetoimagen.png" height="150px" alt=""></a>
                    <h3>Titulo objeto</h3>
                    <p>Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...</p>
                </div>
                <div class="objecto">
                    <a href=""><img src="../imajes/objetoimagen.png" height="150px" alt=""></a>
                    <h3>Titulo objeto</h3>
                    <p>Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...</p>
                </div>
                <div class="objecto">
                    <a href=""><img src="../imajes/objetoimagen.png" height="150px" alt=""></a>
                    <h3>Titulo objeto</h3>
                    <p>Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...</p>
                </div>
                <div class="objecto">
                    <a href=""><img src="../imajes/objetoimagen.png" height="150px" alt=""></a>
                    <h3>Titulo objeto</h3>
                    <p>Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...</p>
                </div>
                <div class="objecto">
                    <a href=""><img src="../imajes/objetoimagen.png" height="150px" alt=""></a>
                    <h3>Titulo objeto</h3>
                    <p>Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...</p>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
