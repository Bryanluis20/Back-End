package abstractfactory

class EmployeeServiceRestImpl: IEmployeeService {
    private val employees = listOf("REST-Bryan","REST-Melissa","REST-Cardozo")

    override fun getEmployee(): List<String> {
        return this.employees
    }
}