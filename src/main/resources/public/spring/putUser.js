const body = {
    name: "peter", email: "peter@lustig.de"
}

const request = {
    method: 'PUT',
    headers: {
        'Content-Type': 'application/json'
    },
    body: JSON.stringify(body)
}

fetch("/users").then(async response => {
    const users = await response.json()
    const putUserResponse = await fetch("/users/" + users[0].id, request)
    const putUserBody = await putUserResponse.text()
    console.log(putUserBody)
})

