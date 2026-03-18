class Cat {
    constructor(name, color) {
        this.name = name
        this.color = color
    }
}

const boris = new Cat("Boris", "red")
const leo = new Cat("Leo", "grey")
const karli = new Cat("Karli", "white-grey")
const emma = new Cat("Emma", "white-grey")

const cats = [boris, leo, emma, karli]

const lengthOfName = (cat) => cat.name.length

cats.filter((cat) => cat.color === "white-grey")
    .map(lengthOfName)
    .forEach(number => console.log(number))