package abstractfactory

class ProductServiceWSImpl: IProductService {
    private val products = listOf("SOA-Refresco","Jugo","Fruta")

    override fun getProducts(): List<String> {
        return  this.products

    }
}