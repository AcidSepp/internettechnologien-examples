async function myAsyncFunction() {
    return new Promise(resolve => {
        setTimeout(() => {
            resolve("My Result!")
        }, 1000);
    });
}

async function myAwaitFunction() {
    console.log("Before")
    let result = await myAsyncFunction()
    console.log(result)
    console.log("After")
}
myAwaitFunction()