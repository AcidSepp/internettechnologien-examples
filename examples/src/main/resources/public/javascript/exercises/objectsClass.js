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

leo.birth = 2019
emma.birth = 2020
karli.birth = 2020
boris.birth = undefined

const cats = [boris, leo, emma, karli]

for (let cat of cats) {
    for (let catKey in cat) {
        console.log(catKey + " " + cat[catKey])
    }
}