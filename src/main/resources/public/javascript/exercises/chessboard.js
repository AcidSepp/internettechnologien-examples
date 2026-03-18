const width = 8
const height = 8

let result = ""

for (let row = 0; row < height; row++) {
    for (let col = 0; col < width; col++) {
        if (row % 2 === 0) {
            if (col % 2 === 0) {
                result += "X"
            } else {
                result += "_"
            }
        } else {
            if (col % 2 === 0) {
                result += "_"
            } else {
                result += "X"
            }
        }
    }
    result += "\n"
}

console.log(result)