const body = {
    name: "hans", email: "hans@dampf.de"
}

const request = {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json'
    },
    body: JSON.stringify(body)
}

fetch("/users", request).then(async response => {
    const body = await response.text()
    console.log(body)
})
