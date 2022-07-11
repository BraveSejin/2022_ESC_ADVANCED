package example

data class Fish(var name: String)

fun myWith(name: String, block: String.() -> Unit) {
    name.block()
}

fun fishEx() {
    val fish = Fish("splashy")
    with(fish.name) {
        println(this.capitalize())
    }

    myWith(fish.name) {
        var block = this
        println(block.capitalize())
        println(capitalize())
    }
}

fun main() {
    fishEx()

}