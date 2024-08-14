const formUser = document.getElementById("formLogin");
const txtEmail = document.getElementById("email");
const txtPassword = document.getElementById("password");
const txtType = document.getElementById("type");

formUser.addEventListener("submit", (event) => {
    event.preventDefault();

    switch (txtType.value) {
        case "1":
            window.location.href = "veterinario";
            break;
        case "2":
            window.location.href = "administrador";
            break;
        case "3":
            window.location.href = "cliente";
            break;
        default:
            alert("Por favor seleccione un tipo de usuario");
            break;
    }
});