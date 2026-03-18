const numbers = [1, 2, 3, 4, 5, 6, 7, 8]

// Fisher–Yates shuffle https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle
for (let i = 0; i < numbers.length; i++) {
    const j = Math.floor(Math.random() * (numbers.length - 1));
    swap(i, j, numbers)
}

console.log(numbers)

function swap(i, j, numbers) {
    const hold = numbers[i]
    numbers[i] = numbers[j]
    numbers[j] = hold
}