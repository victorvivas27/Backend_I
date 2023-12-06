document.addEventListener("DOMContentLoaded", function () {
    const signUpButton = document.getElementById("signUp");
    const signInButton = document.getElementById("signIn");
    const container = document.querySelector(".container");
    const welcomeContainer = document.querySelector(".welcome-container");

    signUpButton.addEventListener("click", () => {
        container.classList.add("right-panel-active");
    });

    signInButton.addEventListener("click", () => {
        container.classList.remove("right-panel-active");
        showWelcome();
    });

    function showWelcome() {
        document.querySelectorAll(".form-container").forEach((form) => {
            form.style.display = "none";
        });
        welcomeContainer.style.display = "flex";
    }
});