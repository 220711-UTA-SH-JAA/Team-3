//Have some function as soon as the window loads from the server

let user;


(async ()=> {
    console.log("Hello from the profile page");
    let req = await fetch("http://localhost:8080/Project2/api/user/")

    user = await req.json();

    console.log("LoggedIn User: ", user);

    //We can append the welcome message
    document.getElementById("profile-welcome").innerText = 'Welcome back ${user.firstName} ${user.lastName}';

})();