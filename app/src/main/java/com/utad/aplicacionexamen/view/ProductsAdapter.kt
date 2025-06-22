package com.utad.aplicacionexamen.View

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.utad.aplicacionexamen.Model.Product

class ProductsAdapter {
}class ProductsAdapter(private val onClick: (Product) -> Unit) :
    RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {

    private var items = listOf<Product>()

    fun submitList(list: List<Product>) {
        items = list
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(product: Product) {
            binding.title.text = product.title
            binding.price.text = "$${product.price}"
            Glide.with(binding.root.context).load(product.image).into(binding.image)
            binding.root.setOnClickListener { onClick(product) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }
}