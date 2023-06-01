package nullobject

class EmployeeDAOService {
    private val employees: ArrayList<Employee> = ArrayList()
    init {
        val employee = Employee(1L, "Bryan Luis Pineda",
            Address("Cuahutemoc 231 La diana cazadora, CDMX"))
        employees.add(employee)
    }

    fun findEmployeeById(id: Long): Employee {
        return employees.firstOrNull { it.getId() == id } ?: Employee.NULL_EMPLOYEE
    }
}