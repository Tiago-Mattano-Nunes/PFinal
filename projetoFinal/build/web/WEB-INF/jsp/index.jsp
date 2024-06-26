<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mercadinho pra você</title>
        <link rel="icon" href="./assets/Preview__1_-removebg-preview.png">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
              crossorigin="anonymous">
        <link rel="stylesheet" href="./styles/index.css" />
        <script src="https://kit.fontawesome.com/446d1f4167.js" crossorigin="anonymous"></script>
    </head>

    <body>

    <header>
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
            <div class="container-fluid">
                <img src="./assets/Preview__1_-removebg-preview.png" alt="">

                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                        data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                        aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">


                        <li class="nav-item">
                            <i class="fa-solid fa-house"></i>
                            <a class="navbar-brand" href="./Index">Home</a>
                        </li>

                        <li class="nav-item">
                            <i class="fa-solid fa-glasses"></i>
                            <a class="navbar-brand" aria-current="page" href="./Sobrenos">Sobre Nós</a>
                        </li>
                        <li class="nav-item">
                            <i class="fa-solid fa-right-to-bracket"></i>
                            <a class="navbar-brand" href="./Cadastro">Login</a>
                        </li>
                        <li class="nav-item dropdown">
                            <i class="fa-solid fa-hand-point-up"></i>
                            <a class="navbar-brand dropdown-toggle" href="#" role="button"
                               data-bs-toggle="dropdown" aria-expanded="false">
                                Departamentos
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="./Categoria?id=1">Frios</a></li>
                                <li><a class="dropdown-item" href="./Categoria?id=2">Carnes</a></li>
                                <li><a class="dropdown-item" href="./Categoria?id=3">Bebidas</a></li>
                                <li>
                                    <hr class="dropdown-divider">
                                </li>

                            </ul>

                        </li>

                    </ul>
                    <div class="classi">
                        <a href="./Carrinho?id=${usuario.idUsuario}"> <i class="fa-solid fa-cart-shopping"></i> </a>
                        <br>
                        <a href="./PerfilUsu"> <i class="fa-solid fa-user"></i> </a>
                    </div>


                    <form class="d-flex" role="search" action="achar" enctype="multipart/form-data"
                          method="post">
                        <input class="form-control me-2" type="search" placeholder="Pesquisar"
                               aria-label="Pesquisar" name="nome">
                        <button class="btn btn-outline-success" type="submit"><i
                                class="fa-solid fa-magnifying-glass"></i></button>
                    </form>

                </div>
            </div>
        </nav>
        <br>
        <br>
        <div class="voltar">


            <a href="./Index"><i class="fa-solid fa-chevron-left">Voltar</i></a>

        </div>



    </header>

    <main>
        <br><br>

        <div id="carouselExampleIndicators" class="carousel slide">
            <div class="carousel-indicators">
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0"
                        class="active" aria-current="true" aria-label="Slide 1"></button>
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1"
                        aria-label="Slide 2"></button>
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2"
                        aria-label="Slide 3"></button>
            </div>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="./assets/f3.png" class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item">
                    <img src="./assets/f1.png" class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item">
                    <img src="./assets/coisa.png" class="d-block w-100" alt="...">
                </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators"
                    data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators"
                    data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>

        <br><br>
        <p>Produtos:</p>
        <br>

        <div class="containerr">
            <div class="containerr">
                <c:forEach items="${produtos}" var="produto">
                    <div id="${produto.idProdutos}" class="produto">
                        <h2>${produto.nome}</h2>
                        <img src="data:image/png;base64,${produto.imagemBase64}" alt="${produto.nome}">
                        <p>R$ ${produto.preco}</p>
                        <a href="./PUnico?id=${produto.idProdutos}"><input type="submit" value="comprar"></a>
                    </div>
                </c:forEach>
            </div>
        </div>
    </main>

    <br><br>

    <footer>
        <p> Todos Os Direitos Reservados de: Tiago Mattano Nunes dos Santos ©️</p>
    </footer>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
    crossorigin="anonymous"></script>
</body>

</html>