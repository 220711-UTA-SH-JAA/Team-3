//Have some function as soon as the window loads from the server

let user = localStorage.key(0);

console.log(user);

let loginObj = {
    username : user,
    password : localStorage.getItem(user)
}

    console.log("Hello from the profile page");
    console.log(loginObj.username);
    console.log(loginObj.password);
    let req = fetch('http://localhost:8080/Project2/api/user/login/',{
        method: 'Post',
        headers: {'Content-type': 'application/json'},
       body: JSON.stringify(loginObj)
    }) 

   acc = req.text;

    //user2 = await sessionStorage();

    console.log("LoggedIn User: ", user);

    //We can append the welcome message
    document.getElementById("profile-welcome").innerText = 'Welcome back ' + user;
    document.getElementById("user-drop").innerText = user;

console.log(acc);
/*fetch('http://localhost:8080/Project2/api/user/login/',{
    method: 'Post',
    headers: {'Content-type': 'application/json'},
   body: JSON.stringify(loginObj)
}) 
.then(response => {
if (response.ok) {
    //document.getElementById("profile-welcome").innerText = response.text();
//window.location.href = "./logged-in.html";
console.log("successfully logged in!11!1")
} 
else {
return Promise.reject()
}
})
.then(data => console.log(data))
.catch(error => console.log('error is', error));*/


async function logout() {

    localStorage.clear();
    window.location.href = "./login.html";
}
let lg = document.getElementById("logout");
lg.addEventListener("click", logout)

function updateUserHtml(users){

    let accountDiv = document.getElementById("")

}
//work on the session details, just need to finish formatting profile page, accessing user variables, and logging out bar