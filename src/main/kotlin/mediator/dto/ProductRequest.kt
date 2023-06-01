package mediator.dto

class ProductRequest {
    private var products: MutableList<Product> = ArrayList()

    fun getProducts(): List<Product> {
        return products
    }

    fun setProducts(products: List<Product>) {
        this.products = products.toMutableList()
    }
}