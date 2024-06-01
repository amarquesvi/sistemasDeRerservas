<%-- 
   Document   : paginaPrincipal
   Created on : 24 de abr. de 2024, 20:32:05
   Author     : vihma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;700&display=swap" rel="stylesheet">
        <title>Home Page</title>
        <link rel="stylesheet" href="Styles/principal.css"/>

    </head>
    <body>
        <!-- Navbar -->
        <header>

            <!-- Menu-ícone -->
            <i class='bx bx-menu' id="menu-icon"></i>

            <!-- Links --> 
            <div class="container">
                <div class="menu">
                    <nav>
                        <a href="#cafeterias" class="menu-link">Cafeterias</a>
                        <a href="#hotels" class="menu-link">Hotéis</a>
                        <a href="#events" class="menu-link">Eventos</a>
                        <a href="#gastrobares" class="menu-link">Gastrobares</a>

                    </nav>
                </div>

                <!--ícones -->   
                <div class="header-icon">
                    <i class='bx bx-search-alt-2' id="search-icon" ></i>
                </div>

            </div>  

            <!--caixa de pesquisa-->   
            <div class="search-box">
                <input type="search" name="search" id="search-input" placeholder="Pesquise aqui...">
            </div>


            <div class="dropdown-menu" id="dropdown-menu">
                <a href="<%= request.getContextPath() %>/minhasreservas.do" class="dropdown-link">Minhas Reservas</a>
                <a href="<%= request.getContextPath() %>/meuperfil.do"" class="dropdown-link">Meu Perfil</a>
            </div>

        </header>

        <!-- Cafeterias -->
        <section id="cafeterias" class="section">
            <div class="content">
                <h2>CAFETERIAS</h2>
                <div class="products-container">
                    <!-- Subopções de reservas para Cafeterias -->
                    <div class="box">
                        <div class="box-content">
                            <img src="https://images.unsplash.com/photo-1581683705068-ca8f49fc7f45?q=80&w=1374&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" alt="Café com chocolate">
                            <div class="description">
                                <h3>La Bossue</h3>
                                <span>A Cafeteria La Bussue é um café delicado e acolhedor no centro da cidade. Oferece uma variedade de bebidas quentes, lanches e sobremesas deliciosas. A equipe é simpática e atenciosa, proporcionando uma atmosfera relaxante para os clientes desfrutarem.</span>
                                <br>
                                <a href="paginaReservar.jsp?local=La%20Bossue" class="reservation-link reservation-button">Reservar</a>
                            </div>
                        </div>
                    </div>
                    <div class="box">
                        <div class="box-content">
                            <img src="https://images.unsplash.com/photo-1602594323720-79b579e4d20e?q=80&w=1470&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D
                                 " alt="Descrição da imagem">
                            <h3>Patissier</h3>
                            <span>A Cafeteria Patissier é um destino irresistível para os amantes de doces, oferecendo uma variedade de sobremesas finas e deliciosas, criadas com maestria por patissiers talentosos.</span>
                            <br>
                            <a href="paginaReservar.jsp?local=Patissier" class="reservation-link reservation-button">Reservar</a>
                        </div>
                    </div>
                    <div class="box">
                        <div class="box-content">
                            <img src="https://images.unsplash.com/photo-1570038281437-550322a86cb8?q=80&w=1374&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D
                                 " alt="Descrição da imagem">
                            <h3>Casa francesa</h3>
                            <span>A Casa Francesa é um elegante café que oferece uma autêntica experiência francesa, com uma variedade de delícias culinárias inspiradas na gastronomia francesa clássica.</span>
                            <br>
                            <a href="paginaReservar.jsp?local=Casa%20francesa" class="reservation-link reservation-button">Reservar</a>
                        </div>
                    </div>
                    <div class="box">
                        <div class="box-content">
                            <img src="https://images.unsplash.com/photo-1591261730799-ee4e6c2d16d7?q=80&w=1470&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D
                                 " alt="Descrição da imagem">
                            <h3>Café Bilhares</h3>
                            <span>O Café Bilhares é um espaço único que combina o prazer de jogar bilhar com a experiência de desfrutar de bebidas e petiscos deliciosos em um ambiente descontraído e acolhedor.</span>
                            <br>
                            <a href="paginaReservar.jsp?local=Café%20Bilhares" class="reservation-link reservation-button">Reservar</a>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!-- Hoteis -->
        <section id="hotels" class="section">
            <div class="content">
                <h2>HOTÉIS</h2>
                <div class="products-container">
                    <!-- Subopções de reservas para Hotéis -->
                    <div class="box">
                        <div class="box-content">
                            <img src="https://images.unsplash.com/photo-1554647286-f365d7defc2d?q=80&w=1374&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D " alt="Descrição da imagem">
                            <h3>Hotel Lux</h3>
                            <span>O Hotel Lux oferece uma experiência de hospedagem luxuosa e sofisticada, com acomodações elegantes, serviços de classe mundial e uma localização privilegiada para uma estadia memorável.</span>
                            <br>
                            <a href="paginaReservar.jsp?local=Hotel%20Lux" class="reservation-link reservation-button">Reservar</a>
                        </div>
                    </div>
                    <div class="box">
                        <div class="box-content">
                            <img src="https://images.unsplash.com/photo-1600011689032-8b628b8a8747?q=80&w=1374&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" alt="Descrição da imagem">
                            <h3>Hotel Marítimo</h3>
                            <span>O Hotel Marítimo oferece uma estadia relaxante à beira-mar, com vistas deslumbrantes, acomodações confortáveis e uma variedade de comodidades para uma experiência de hospedagem memorável.</span>
                            <br>
                            <a href="paginaReservar.jsp?local=Hotel%20Marítimo" class="reservation-link reservation-button">Reservar</a>
                        </div>
                    </div>
                    <div class="box">
                        <div class="box-content">
                            <img src="https://images.unsplash.com/photo-1573052905904-34ad8c27f0cc?q=80&w=1470&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D
                                 " alt="Descrição da imagem">
                            <h3>Horizonte Sereno</h3>
                            <span>otel conceitual que promete uma experiência de hospedagem relaxante e revigorante. Ele transmite uma sensação de calma e paz, convidando os hóspedes a desfrutarem de uma estadia tranquila e rejuvenescedora.</span>
                            <br>
                            <a href="paginaReservar.jsp?local=Horizonte%20Sereno" class="reservation-link reservation-button">Reservar</a>
                        </div>
                    </div>
                    <div class="box">
                        <div class="box-content">
                            <img src="https://images.unsplash.com/photo-1566073771259-6a8506099945?q=80&w=1470&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D
                                 " alt="Descrição da imagem">
                            <h3>Praia Resort</h3>
                            <span>uma estadia relaxante e tranquila à beira-mar, onde os hóspedes podem desfrutar da serenidade da praia enquanto são mimados com serviços de resort.</span>
                            <br>
                            <a href="paginaReservar.jsp?local=Praia%20Resort" class="reservation-link reservation-button">Reservar</a>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Eventos -->
        <section id="events" class="section">
            <div class="content">
                <h2>EVENTOS</h2>
                <div class="products-container">
                    <!-- Subopções de reservas para Eventos -->
                    <div class="box">
                        <div class="box-content">
                            <img src="https://images.unsplash.com/photo-1616262862743-6091f7c0d1fe?q=80&w=1470&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" alt=" MAAT MUSEU DE ARTE">
                            <h3>Maat Museu de Arte</h3>
                            <span>Museu de Arte, Arquitetura e Tecnologia) em Lisboa é um centro cultural moderno e inovador que combina exposições de arte contemporânea, arquitetura e tecnologia em um ambiente deslumbrante à beira-rio, oferecendo uma experiência única para os visitantes explorarem a interseção entre diferentes formas de expressão artística e cultural.</span>
                            <br>
                            <a href="paginaReservar.jsp?local=Maat%20Museu%20de%20Arte" class="reservation-link reservation-button">Reservar</a>
                        </div>
                    </div>
                    <div class="box">
                        <div class="box-content">
                            <img src="https://images.unsplash.com/photo-1607998803461-4e9aef3be418?q=80&w=1374&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" alt="TEATRO">
                            <h3>Palco Estrelado</h3>
                            <span>O Palco Estrelado é um teatro emblemático que cativa o público com uma variedade de performances teatrais, musicais e artísticas, proporcionando experiências emocionantes e memoráveis para os espectadores.</span>
                            <br>
                            <a href="paginaReservar.jsp?local=Palco%20Estrelado" class="reservation-link reservation-button">Reservar</a>
                        </div>
                    </div>
                    <div class="box">
                        <div class="box-content">
                            <img src="https://images.unsplash.com/photo-1659061364735-78027adca38d?q=80&w=1476&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" alt="MANÉ GARRINHA">
                            <h3>Mané Garrincha</h3>
                            <span>O Estádio Nacional Mané Garrincha é um local icônico que recebe uma variedade de eventos, desde emocionantes partidas de futebol e grandes shows musicais até eventos corporativos de grande porte, oferecendo experiências inesquecíveis para os participantes.</span>
                            <br>
                            <a href="paginaReservar.jsp?local=Mané%20Garrincha" class="reservation-link reservation-button">Reservar</a>
                        </div>
                    </div>
                    <div class="box">
                        <div class="box-content">
                            <img src="https://images.unsplash.com/photo-1576085898274-069be5a26c58?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NTB8fGV2ZW50b3xlbnwwfHwwfHx8MA%3D%3D" alt="WORKSHOP DE DESIGN">
                            <h3>Workshop</h3>
                            <span>Oferecemos workshops interativos e práticos projetados para impulsionar o crescimento pessoal e profissional, fornecendo uma oportunidade única para aprender habilidades essenciais, colaborar com outros participantes e aplicar conhecimentos em situações do mundo real. Junte-se a nós para uma experiência enriquecedora e transformadora!</span>
                            <br>
                            <a href="paginaReservar.jsp?local=Workshop" class="reservation-link reservation-button">Reservar</a>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!-- Gastrobares -->
        <section id="gastrobares" class="section">
            <div class="content">
                <h2>GASTROBARES</h2>
                <div class="products-container">
                    <!-- Subopções de reservas para Gastrobares -->
                    <div class="box">
                        <div class="box-content">
                            <img src="https://images.unsplash.com/photo-1558028023-1989e72878ed?q=80&w=1372&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" alt="Descrição da imagem">
                            <h3>Gastrobar Fusion</h3>
                            <span>Experimente uma fusão irresistível de sabores no nosso Gastrobar Fusion, onde pratos e coquetéis inovadores se encontram para uma experiência gastronômica única e memorável.</span>
                            <br>
                            <a href="paginaReservar.jsp?local=Gastrobar%20Fusion" class="reservation-link reservation-button">Reservar</a>
                        </div>
                    </div>
                    <div class="box">
                        <div class="box-content">
                            <img src="https://images.unsplash.com/photo-1666307588778-6f0b349bd517?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NjB8fHJlc3RhdXJhbnRlJTIwYmFyfGVufDB8fDB8fHww" alt="Descrição da imagem">
                            <h3>Gastrobar Vintage</h3>
                            <span>Explore o charme e o sabor de décadas passadas no nosso Gastrobar Vintage, onde coquetéis clássicos e pratos tradicionais se unem em uma atmosfera nostálgica e acolhedora.</span>
                            <br>
                            <a href="paginaReservar.jsp?local=Gastrobar%20Vintage" class="reservation-link reservation-button">Reservar</a>
                        </div>
                    </div>
                    <div class="box">
                        <div class="box-content">
                            <img src="https://images.unsplash.com/photo-1481833761820-0509d3217039?q=80&w=1470&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" alt="Descrição da imagem">
                            <h3> Relax Gastrobar</h3>
                            <span>Desfrute de uma experiência gastronômica tranquila e relaxante no nosso Relax Gastrobar, onde pratos leves e refrescantes se combinam com coquetéis artesanais em um ambiente sereno</span>
                            <br>
                            <a href="paginaReservar.jsp?local=Relax%20Gastrobar" class="reservation-link reservation-button">Reservar</a>
                        </div>
                    </div>
                    <div class="box">
                        <div class="box-content">
                            <img src="https://images.unsplash.com/photo-1514933651103-005eec06c04b?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OXx8cmVzdGF1cmFudGUlMjBiYXJ8ZW58MHx8MHx8fDA%3D" alt="Descrição da imagem">
                            <h3>Urbano Gatrobar</h3>
                            <span>Saboreie uma fusão vibrante de gastronomia urbana no nosso Urbano Gastrobar, onde pratos contemporâneos e coquetéis modernos se encontram em um ambiente dinâmico e cosmopolita.</span>
                            <br>
                            <a href="paginaReservar.jsp?local=Urbano%20Gatrobar" class="reservation-link reservation-button">Reservar</a>
                        </div>
                    </div>
                </div>
            </div>
        </section>


        <script src="Styles/principal.js"></script>


    </body>
</html>
