data class User(val name: String, val contribution: Int)


fun main(args: Array<String>) {
    val testList = listOf(listOf("A", "B"), listOf("C", "D"))

    testList.flatMap { it -> it }
        .also { println(it) }
    testList.map { it -> it }
        .also { println(it) }

    val userList =
        mutableListOf<User>().apply {
            add(User("Sejin", 1))
            add(User("Sejin", 2))
            add(User("Sejin", 1))
            add(User("Hyunsu", 1))
            add(User("Hyunsu", 2))
            add(User("root", 1))
        }

    val test = userList.groupBy { it.name } // map 형태로 나옴 (유저 : 유저 리스트(group )
            .map { (name, group) ->
                User(name, group.sumBy { //
                    it.contribution
                })
            }
    println(test)

}

//fun MutableList<User>.aggregate(): MutableList<User>
//    = groupBy { it.name }
