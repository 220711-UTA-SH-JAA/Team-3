const menu = document.querySelector('#mobile-menu');
const menuLinks = document.querySelector('.navbar__menu');

//Display mobile menu
const mobileMenu = () => {
    menu.classList.toggle('is-active');
    menuLinks.classList.toggle('active');
}



//Cart
let cartIcon = document.querySelector('#cart-icon')
let cart = document.querySelector('.cart')
let closeCart = document.querySelector('#close-cart')

//Open Cart


// let req = fetch('http://localhost:8080/Project2/api/user/allproducts')
//   .then((response) => response.json())
//   .then((data) => console.log(data));


async function getItems() {
  let url = 'http://localhost:8080/Project2/api/user/allproducts';
  try {
      let res = await fetch(url);
      return await res.json();
  } catch (error) {
      console.log(error);
  }
}

async function renderItems() {
  let items = await getItems();
  let html = '';
  items.forEach(item => {
      let htmlSegment = `<div class="product-box">
                          <img src="${item.imgSrc}" >
                          <h2 class="product-title">${item.itemName}</h2>
                          <span class="price">$${item.itemPrice}</span>
                          <i class='bx bx-shopping-bag add-cart'></i>
                      </div>`;

      html += htmlSegment;
  });

  let container = document.querySelector('.shop-content');
  container.innerHTML = html;
}

renderItems();