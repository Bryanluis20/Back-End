package abstractfactory

class ProductServiceRestImpl : IProductService {
    private val products = listOf("REST-Teclado","Mouse","Monitor")

    override fun getProducts(): List<String> {
        return this.products
    }
}