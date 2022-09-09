//Have some function as soon as the window loads from the server

let user;


(async ()=> {
    console.log("Hello from the profile page");
    let req = await fetch("http://localhost:8080/Project2/api/user/");

    user = await req.text();

    //user2 = await sessionStorage();

    console.log("LoggedIn User: ", user);

    //We can append the welcome message
    document.getElementById("profile-welcome").innerText = 'Welcome back ${user.firstName} ${user.lastName}';

})();

async function logout() {

    sessionStorage.removeItem(loginObj);

}

function updateUserHtml(users){

    let accountDiv = document.getElementById("")

}

//work on the session details, just need to finish formatting profile page, accessing user variables, and logging out bar