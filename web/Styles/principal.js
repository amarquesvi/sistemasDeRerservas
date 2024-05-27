/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


 document.addEventListener('DOMContentLoaded', () => {
    console.log("Script de JavaScript carregado com sucesso.");
    const menuIcon = document.getElementById('menu-icon');
    const searchIcon = document.getElementById('search-icon');
    const searchBox = document.querySelector('.search-box');
    const menuLinks = document.querySelectorAll('.menu-link');
    const dropdownMenu = document.getElementById("dropdown-menu");
    
    // Adicionar evento de clique para o ícone de menu
    menuIcon.addEventListener('click', () => {
        console.log("Ícone de menu clicado!"); // Adicione esta linha

        // Toggle display do dropdown menu
        if (dropdownMenu.style.display === "none" || dropdownMenu.style.display === "") {
            dropdownMenu.style.display = "block";
        } else {
            dropdownMenu.style.display = "none";
        }
    });
    
    // Fechar o dropdown menu se o usuário clicar fora dele
    window.addEventListener("click", function(event) {
        if (!menuIcon.contains(event.target) && !dropdownMenu.contains(event.target)) {
            dropdownMenu.style.display = "none";
        }
    });

    // Adicionar evento de clique para o ícone de pesquisa
    searchIcon.addEventListener('click', () => {
        searchBox.classList.toggle('active'); // Adicionar/Remover a classe 'active' para a caixa de pesquisa
    });
    
    // Adicionar evento de clique para cada link do menu
    menuLinks.forEach(link => {
        link.addEventListener('click', () => {
            const menu = document.querySelector('.menu');
            menu.classList.remove('show'); // Ocultar o menu ao clicar em um link
            dropdownMenu.style.display = "none"; // Ocultar o dropdown ao clicar em um link do menu
        });
    });
});
