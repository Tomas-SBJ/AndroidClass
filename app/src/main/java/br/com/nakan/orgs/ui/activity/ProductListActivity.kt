package br.com.nakan.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import br.com.nakan.orgs.R
import br.com.nakan.orgs.dao.ProductDao
import br.com.nakan.orgs.databinding.ActivityProductListBinding
import br.com.nakan.orgs.ui.recyclerview.adapter.ProductListAdapter

class ProductListActivity : AppCompatActivity(R.layout.activity_product_list) {
    private val productDao = ProductDao()
    private val adapter = ProductListAdapter(this, productDao.getList())

    private val binding by lazy {
        ActivityProductListBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("MainActivity", "onCreate: ")

        configRecycleView()
        configFab()

        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        Log.i("ProductListActivity", "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.i("ProductListActivity", "onResume: ")

        adapter.update(productDao.getList())
    }

    override fun onPause() {
        super.onPause()
        Log.i("ProductListActivity", "onResume: ")
    }

    override fun onStop() {
        super.onStop()
        Log.i("ProductListActivity", "onStop: ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("ProductListActivity", "onRestart: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("ProductListActivity", "onDestroy: ")
    }

    private fun configRecycleView() {
        val recyclerView = binding.activityProductListRecyclerView
        recyclerView.adapter = adapter
    }

    private fun configFab() {
        val fab = binding.activityProductListFab
        fab.setOnClickListener {
            val intent = Intent(this, ProductFormActivity::class.java)
            startActivity(intent)
        }
    }
}