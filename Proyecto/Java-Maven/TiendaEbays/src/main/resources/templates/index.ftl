<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Evay</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
    @import url('https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap');
    @font-face {
        font-family: "open-sans";
        src: url("../fuentes/OpenSans_Condensed-Regular.ttf");
    }

    * {
        font-family: "Open Sans", sans-serif;
    }

    .venta {
        margin-top: 40px;
    }

    .venta h1 {
        text-align: center;
        margin-bottom: 4vh;
        font-size: 28px;
    }

    .objetos {
        padding-left: 40px;
        padding-right: 40px;
        margin: 20px;
        display: grid;
        grid-template-columns: repeat(5, 1fr);
        grid-template-rows: 1fr;
        grid-column-gap: 25px;
        grid-row-gap: 15px;
        margin-bottom: 7vh;
    }

    .objeto {
        text-align: center;
        outline: 1px solid gray;
        padding: 5px;
        padding-top: 20px;
        padding-bottom: 20px;
        border-radius: 15px;
        width: 80%;
        box-shadow: 6px 6px 6px 6px rgba(0, 0, 0, 0.2);
    }

    .objeto img {
        border-radius: 10px;
    }

    .objeto h3{
        text-align: center;
        margin-top: 0px;
        margin-bottom: 3px;
    }

    .objeto p{
        margin: auto;
        width: 150px;
        font-size: 14px;
    }

    footer {
        background-color: #4d4d4d;
        padding-top: 3px;
    }

    footer h3 {
        text-align: center;
        color: white;
        margin-bottom: 0;
        margin: 20px;
    }

    footer li {
        list-style-type: none;
    }

    .footerGrid {
        display: grid;
        grid-template-columns: repeat(2, 1fr);
        grid-template-rows: 1fr;
        grid-column-gap: 0px;
        grid-row-gap: 0px;
        background-color: #414141;
        padding-top: 20px;
    }

    .footerGrid > * {
        padding: 0;
        margin: 0;
    }

    .footerGrid form {
        text-align: center;
        padding: 20px;
    }

    .footerGrid input {
        margin: 10px;
        height: 4vh;
        width: 18vw;
        border-radius: 5px;
    }

    .footerGrid ul {
        margin-left: 60px;
    }

    .footerGrid a {
        text-decoration: none;
        color: white;
    }

    .slideshow-container {
        max-width: 1000px;
        position: relative;
        margin: auto;
        margin-top: 30px;
    }

    .mySlides {
        display: none;
    }

    .prev, .next {
        cursor: pointer;
        position: absolute;
        top: 50%;
        width: auto;
        margin-top: -22px;
        padding: 16px;
        color: white;
        font-weight: bold;
        font-size: 18px;
        transition: 0.6s ease;
        border-radius: 0 3px 3px 0;
        user-select: none;
    }

    .next {
        right: 0;
        border-radius: 3px 0 0 3px;
    }

    .prev:hover, .next:hover {
        background-color: rgba(0,0,0,0.8);
    }

    .text {
        color: #f2f2f2;
        font-size: 15px;
        padding: 8px 12px;
        position: absolute;
        bottom: 8px;
        width: 100%;
        text-align: center;
    }

    .numbertext {
        color: #f2f2f2;
        font-size: 12px;
        padding: 8px 12px;
        position: absolute;
        top: 0;
    }

    .dot {
        cursor: pointer;
        height: 15px;
        width: 15px;
        margin: 0 2px;
        background-color: #bbb;
        border-radius: 50%;
        display: inline-block;
        transition: background-color 0.6s ease;
    }


    .fade {
        animation-name: fade;
        animation-duration: 1.5s;
    }

    @keyframes fade {
        from {opacity: .4}
        to {opacity: 1}
    }
body, html{
    margin: 0;
    padding: 0;
}

.topnav {
    overflow: hidden;
    background-color: #414141;
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
            <a href="/login">Login</a>
            <a href="/registrarse">Registrarse</a>
        </div>
        <div class="categorias">
            <a href="">Electronica</a>
            <a href="">Jardin</a>
            <a href="">Moda</a>
            <a href="">Motor</a>
            <a href="">Deportes</a>
            <a href="">Juguetes y ocio</a>
            <a href="">Equipamiento industrial</a>
            <a href="">Ofertas</a>
        </div>

        <div class="slideshow-container">

            <div class="mySlides fade">
                <div class="numbertext">1 / 3</div>
                <img src="https://i.ibb.co/43kYGnP/banner.png" style="width:100%">
                <div class="text">Caption Text</div>
            </div>
          
            <div class="mySlides fade">
                <div class="numbertext">2 / 3</div>
                <img src="https://i.ibb.co/43kYGnP/banner.png" style="width:100%">
                <div class="text">Caption Two</div>
            </div>
          
            <div class="mySlides fade">
                <div class="numbertext">3 / 3</div>
                <img src="https://i.ibb.co/43kYGnP/banner.png" style="width:100%">
                <div class="text">Caption Three</div>
            </div>
          
            <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
            <a class="next" onclick="plusSlides(1)">&#10095;</a>
          </div>
          <br>
          
          <div style="text-align:center">
            <span class="dot" onclick="currentSlide(1)"></span>
            <span class="dot" onclick="currentSlide(2)"></span>
            <span class="dot" onclick="currentSlide(3)"></span>
          </div>
        
        <div class="venta">
            <h1>Lo mas vendido</h1>
            <div class="objetos">
                <div class="objeto">
                    <img src="../imajes/objetoimagen.png" height="150px" alt="">
                    <h3>Titulo objeto</h3>
                    <p>Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...</p>
                </div>
                <div class="objeto">
                    <img src="../imajes/objetoimagen.png" height="150px" alt="">
                    <h3>Titulo objeto</h3>
                    <p>Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...</p>
                </div>
                <div class="objeto">
                    <img src="../imajes/objetoimagen.png" height="150px" alt="">
                    <h3>Titulo objeto</h3>
                    <p>Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...</p>
                </div>
                <div class="objeto">
                    <img src="../imajes/objetoimagen.png" height="150px" alt="">
                    <h3>Titulo objeto</h3>
                    <p>Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...</p>
                </div>
                <div class="objeto">
                    <img src="../imajes/objetoimagen.png" height="150px" alt="">
                    <h3>Titulo objeto</h3>
                    <p>Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...</p>
                </div>
            </div>
            <h1>Tendencias</h1>
            <div class="objetos">
                <div class="objeto">
                    <img src="../imajes/objetoimagen.png" height="150px" alt="">
                    <h3>Titulo objeto</h3>
                    <p>Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...</p>
                </div>
                <div class="objeto">
                    <img src="../imajes/objetoimagen.png" height="150px" alt="">
                    <h3>Titulo objeto</h3>
                    <p>Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...</p>
                </div>
                <div class="objeto">
                    <img src="../imajes/objetoimagen.png" height="150px" alt="">
                    <h3>Titulo objeto</h3>
                    <p>Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...</p>
                </div>
                <div class="objeto">
                    <img src="../imajes/objetoimagen.png" height="150px" alt="">
                    <h3>Titulo objeto</h3>
                    <p>Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...</p>
                </div>
                <div class="objeto">
                    <img src="../imajes/objetoimagen.png" height="150px" alt="">
                    <h3>Titulo objeto</h3>
                    <p>Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...</p>
                </div>
            </div>
            <h1>Novedades</h1>
            <div class="objetos">
                <div class="objeto">
                    <img src="../imajes/objetoimagen.png" height="150px" alt="">
                    <h3>Titulo objeto</h3>
                    <p>Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...</p>
                </div>
                <div class="objeto">
                    <img src="../imajes/objetoimagen.png" height="150px" alt="">
                    <h3>Titulo objeto</h3>
                    <p>Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...</p>
                </div>
                <div class="objeto">
                    <img src="../imajes/objetoimagen.png" height="150px" alt="">
                    <h3>Titulo objeto</h3>
                    <p>Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...</p>
                </div>
                <div class="objeto">
                    <img src="../imajes/objetoimagen.png" height="150px" alt="">
                    <h3>Titulo objeto</h3>
                    <p>Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...</p>
                </div>
                <div class="objeto">
                    <img src="../imajes/objetoimagen.png" height="150px" alt="">
                    <h3>Titulo objeto</h3>
                    <p>Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...</p>
                </div>
            </div>
        </div>
        <footer>
            <h3>Parece que has llegado al final :)<br>Dale a la barra de búsqueda para buscar algo más específico</h3>
            <div class="footerGrid">
                <div>
                    <ul>
                        <li><a href="">Sobre nosotros</a></li>
                        <li><a href="registrarse.html">Registrarse</a></li>
                        <li><a href="login.html">Iniciar sesion</a></li>
                    </ul>
                </div>
                <div>
                    <form action="">
                        <label for="" style="color: white;">Suscribete a nuestro newsletter</label>
                        <br>
                        <input type="text" name="" id="">
                    </form>
                </div>
            </div>
        </footer>
    </div>
    <script>
let slideIndex = 1;
showSlides(slideIndex);

// Next/previous controls
function plusSlides(n) {
  showSlides(slideIndex += n);
}

// Thumbnail image controls
function currentSlide(n) {
  showSlides(slideIndex = n);
}

function showSlides(n) {
  let i;
  let slides = document.getElementsByClassName("mySlides");
  let dots = document.getElementsByClassName("dot");
  if (n > slides.length) {slideIndex = 1}
  if (n < 1) {slideIndex = slides.length}
  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";
  }
  for (i = 0; i < dots.length; i++) {
    dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";
  dots[slideIndex-1].className += " active";
}
    </script>
</body>
</html>
