const menu = document.querySelector('#mobile-menu');
const menuLinks = document.querySelector('.navbar__menu');

//Display mobile menu
const mobileMenu = () => {
    menu.classList.toggle('is-active');
    menuLinks.classList.toggle('active');
}

menu.addEventListener('click', mobileMenu);

/*function Login()
{
    var a = new Array();
    up1 = new Object();
    up2 = new Object();

    up1 = {
        name:'hectoast@gmail.com',
        password:btoa('pwd')
    };

    up2={
        name: 'taz@gmail.com',
        password:btoa('password')
    };

    a.push(up1);
    a.push(up2);
}*/

let firstNameElement = document.getElementById("firstName");
let lastNameElement = document.getElementById("lastName");
let usernameElement = document.getElementById("username");
let passwordElement = document.getElementById("password");
let emailElement = document.getElementById("email");
let formElement = document.getElementById("form");
form.addEventListener('submit', login);
//let submitBtn = document.getElementById("")
//submitBtn.addEventListener("click", login);


async function login(ethan){

    ethan.preventDefault();

    console.log("We handled the click event of the submit button");
    //getting values from the form field
    let firstName = firstNameElement.value;
    let lastName = lastNameElement.value;
    let username = usernameElement.value;
    let password = passwordElement.value;
    let email = emailElement.value;

    let loginObj = {
        firstName,
        lastName,
        username,
        password,
        email
    }

    console.log("Ready to register: ", loginObj);
try{
    //if the request is successful all is well, if it fails/returns !200 it will be in the catch
    let req = await fetch("http://localhost:8080/Project2/api/user/", {
        method: 'Post',
        headers: {'Content-type': 'application/json'},
        body: JSON.stringify(loginObj)
    });

    let res = await req.json();

    console.log("push user to the next page");
    console.log(res);
    window.location.href = "./logged-in.html";
    } catch(e){
        console.log("The user did not register successfully");
        console.log(e);
    }
}