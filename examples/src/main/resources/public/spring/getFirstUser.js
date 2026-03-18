fetch("/users").then(async response => {
    const users = await response.json()
    const firstUserResponse = await fetch("/users/" + users[0].id)
    const firstUserBody = await firstUserResponse.text()
    console.log(firstUserBody)
})
