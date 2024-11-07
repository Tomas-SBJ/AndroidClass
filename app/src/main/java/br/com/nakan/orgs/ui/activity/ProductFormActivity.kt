package br.com.nakan.orgs.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import br.com.nakan.orgs.R
import br.com.nakan.orgs.dao.ProductDao
import br.com.nakan.orgs.databinding.ActivityProductFormBinding
import br.com.nakan.orgs.model.Product
import java.math.BigDecimal

class ProductFormActivity : AppCompatActivity(R.layout.activity_product_form) {
    private val productDao = ProductDao()

    private val binding by lazy {
        ActivityProductFormBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("ProductFormActivity", "onCreate: ")
        configSaveButton()

        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        Log.i("ProductFormActivity", "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.i("ProductFormActivity", "onResume: ")
    }

    override fun onStop() {
        super.onStop()
        Log.i("ProductFormActivity", "onStop: ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("ProductFormActivity", "onRestart: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("ProductFormActivity", "onDestroy: ")
    }

    private fun configSaveButton() {
        val saveButton = binding.activityProductFormSaveButton
        saveButton.setOnClickListener {
            productDao.create(createProduct())
            finish()
        }
    }

    private fun createProduct(): Product {
        val nameField = binding.activityProductFormName
        val name = nameField.text.toString()

        val descriptionField = binding.activityProductFormDescription
        val description = descriptionField.text.toString()

        val valueField = binding.activityProductFormValue
        val value = valueField.text.toString().ifBlank {
            "0"
        }.let {
            BigDecimal(it)
        }

        return Product(
            name = name,
            description = description,
            value = value
        )
    }
}