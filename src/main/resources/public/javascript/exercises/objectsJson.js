const boris = {
    name: "boris",
    color: "red"
}

const leo = {
    name: "leo",
    color: "grey"
}

const emma = {
    name: "emma",
    color: "white-grey"
}

const karli = {
    name: "karli",
    color: "white-grey"
}

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