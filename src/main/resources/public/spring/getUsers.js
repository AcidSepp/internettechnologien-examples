fetch("/users").then(async response => {
    const body = await response.text()
    console.log(body)
})
