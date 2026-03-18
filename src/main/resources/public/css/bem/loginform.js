document.addEventListener("DOMContentLoaded", async () => {
    const userNameField = document.getElementById("inputUsername")
    const userNameElement = document.getElementById("usernameElement")
    userNameField.onkeyup = () => {
        if (/\s/.test(userNameField.value) || userNameField.value.length <= 3) {
            userNameElement.classList.remove("myForm__username--valid")
            userNameElement.classList.add("myForm__username--invalid")
        } else {
            userNameElement.classList.remove("myForm__username--invalid")
            userNameElement.classList.add("myForm__username--valid")
        }
    }
});