function login(){
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    let user = {
        "username": username,
        "password": password
    }
    $.ajax({
        headers:{
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        method: "post",
        url: "http://localhost:8080/api/auth/login",
        data: JSON.stringify(user),
        success: function (data){
            localStorage.setItem("user", JSON.stringify(data))
            window.location.href = "../computer/computer.html"
        }
    })
}