// snippet: class
class Cat {
    constructor(name) {
        this.name = name
    }
    speak() {
        console.log(`${this.name} says: meow`)
    }
}

const emma = new Cat("emma")
const boris = new Cat("boris")
// snippet: /class

emma.speak()
boris.speak()