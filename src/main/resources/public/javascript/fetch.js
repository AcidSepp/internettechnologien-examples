let fetchPromise = fetch("fetch.json")
fetchPromise.then(async (response) => {
    let text = await response.text()
    console.log(text)
})