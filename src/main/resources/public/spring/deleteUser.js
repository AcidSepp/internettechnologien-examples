const body = {
    name: "peter", email: "peter@lustig.de"
}

const request = {
    method: 'DELETE',
    headers: {
        'Content-Type': 'application/json'
    },
    body: JSON.stringify(body)
}

fetch("/users").then(async response => {
    const users = await response.json()
    const deleteResponse = await fetch("/users/" + users[0].id, request)
    const deletedUserBody = await deleteResponse.text()
    console.log(deletedUserBody)
})

