// snippet: json
const emma = {
    species: "cat",
    name: "emma",
    speak() {
        console.log(`${this.name} says: meow`)
    }
}

// snippet: /json

// snippet: prototyping
const boris = Object.create(emma)
boris.name = "boris"
// snippet: /prototyping

emma.speak()
boris.speak()