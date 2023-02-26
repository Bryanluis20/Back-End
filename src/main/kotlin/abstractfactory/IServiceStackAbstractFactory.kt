package abstractfactory

interface IServiceStackAbstractFactory {
    /*new*/
    fun getEmployeeService(): IEmployeeService
    /*new*/
    fun getProductsService(): IProductService

}