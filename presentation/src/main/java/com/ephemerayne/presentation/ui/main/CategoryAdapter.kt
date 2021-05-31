package com.ephemerayne.presentation.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ephemerayne.domain.entity.CategoryEntity
import com.ephemerayne.presentation.databinding.CategoryItemBinding

class CategoryAdapter(
    private val onCategoryListener: OnCategoryListener
) : RecyclerView.Adapter<CategoryViewHolder>() {

    private val categories: ArrayList<CategoryEntity> = ArrayList()

    fun setCategories(categories: List<CategoryEntity>) {
        with(this.categories) {
            clear()
            addAll(categories)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding =
            CategoryItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return CategoryViewHolder(binding, onCategoryListener)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.setItemContent(categories[position])
    }

    override fun getItemCount() = categories.size
}