const myFunction = function (numberOne, numberTwo) {
    return numberOne * numberTwo
}

const logConsole = function (aFunction) {
    console.log(aFunction(1, 2))
}

logConsole(myFunction)