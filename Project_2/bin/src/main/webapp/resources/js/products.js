const menu = document.querySelector('#mobile-menu');
const menuLinks = document.querySelector('.navbar__menu');

//Display mobile menu
const mobileMenu = () => {
    menu.classList.toggle('is-active');
    menuLinks.classList.toggle('active');
}

menu.addEventListener('click', mobileMenu);

//Cart
let cartIcon = document.querySelector('#cart-icon')
let cart = document.querySelector('.cart')
let closeCart = document.querySelector('#close-cart')

//Open Cart
cartIcon.onclick = () => {
    cart.classList.add("active")
}


//Close cart
closeCart.onclick = () => {
    cart.classList.remove("active")
}