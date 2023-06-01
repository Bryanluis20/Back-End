package strategy

class OnMemoryDataBase {
    companion object {
        private val users=hashMapOf("Bryan" to User("Bryan","123456","Admin"),
            "Monse" to User("Monse","123456","Docente"),
            "Fernanda" to User("Fernanda","123456","Estudiante"),
        )
        fun findUserByName(name: String?): User? {
            return users[name]
        }
    }
}