async function myAsyncFunction() {
    return new Promise(resolve => {
        console.log("Foo")
        setTimeout(() => {
            console.log("Bar")
            resolve()
        }, 1000);
    });
}

myAsyncFunction().then(() => console.log("Baz"))