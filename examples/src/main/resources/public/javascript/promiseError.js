async function myAsyncFunction() {
    return new Promise((resolve, reject) => {
        console.log("Foo")
        setTimeout(() => {
            reject(new Error("broken!"))
        }, 1000);
    });
}

myAsyncFunction()
    .then(() => console.log("Baz"))
    .catch(error => console.log(error))