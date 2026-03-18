const string1 = "reliefpfeiler"
const string2 = "keinpfeiler"
const string3 = "anna"

function isPalindrome(a) {
    if (typeof(a) !== "string") {
        return false
    }
    if (a.length === 0 || a.length === 1) {
        return true
    }
    let lastIndex = a.length - 1
    let firstIndex = 0

    while (firstIndex !== lastIndex && lastIndex - firstIndex !== 1) {
        if (a[firstIndex] !== a[lastIndex]) {
            return false
        }
        firstIndex += 1
        lastIndex -= 1
    }
    return true
}

console.log(isPalindrome(string1))
console.log(isPalindrome(string2))
console.log(isPalindrome(string3))