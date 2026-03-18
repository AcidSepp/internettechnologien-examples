const body = {
    name: "hans"
}

const request = {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json'
    },
    body: JSON.stringify(body)
}

fetch("/users", request).then(async (response) => {
    if (!response.ok) {
        const errorBody = await response.text();
        console.log(errorBody)
    }
})
