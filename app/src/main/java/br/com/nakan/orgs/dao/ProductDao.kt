package br.com.nakan.orgs.dao

import br.com.nakan.orgs.model.Product

class ProductDao {
    fun create(product: Product) {
        products.add(product)
    }

    fun getList(): List<Product> {
        return products.toList();
    }

    companion object {
        private val products = mutableListOf<Product>()
    }
}