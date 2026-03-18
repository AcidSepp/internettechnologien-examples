document.addEventListener("DOMContentLoaded", async () => {
    const tvt = document.getElementById("tvt")

    const speed = 2
    const scale = 4
    const width = 40 * scale
    const height = 20 * scale

    let maxX = window.innerWidth - width
    const minX = 0
    let maxY = window.innerHeight - height
    const minY = 0

    let positionX = Math.random() * maxX + minX
    let positionY = Math.random() * maxY + minY

    let velocity = randomSpeed(speed)

    tvt.setAttribute("transform", `translate(${positionX},${positionY})`)

    setInterval(function () {
        maxX = window.innerWidth - width
        maxY = window.innerHeight - height

        if (positionX <= minX) {
            positionX = minX
            velocity.x = -velocity.x
        }

        if (positionX >= maxX) {
            positionX = maxX
            velocity.x = -velocity.x
        }

        if (positionY <= minY) {
            positionY = minY
            velocity.y = -velocity.y
        }

        if (positionY >= maxY) {
            positionY = maxY
            velocity.y = -velocity.y
        }

        tvt.setAttribute("transform", `translate(${positionX += velocity.x},${positionY += velocity.y}) scale(${scale})`)
    }, 5);
});

function randomSpeed(speed) {
    let direction = Math.random() * Math.PI
    let velocityX = Math.sin(direction) * speed
    let velocityY = Math.cos(direction) * speed
    return {x: velocityX, y: velocityY}
}