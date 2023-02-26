package abstractfactory

class EmployeeServiceRestImpl: IEmployeeService {
    private val employees = listOf("Bryan","Melissa","Cardozo")

    override fun getEmployee(): List<String> {
        return this.employees
    }
}