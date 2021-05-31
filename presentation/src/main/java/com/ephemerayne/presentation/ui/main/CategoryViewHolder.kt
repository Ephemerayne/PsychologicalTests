package com.ephemerayne.presentation.ui.main

import androidx.recyclerview.widget.RecyclerView
import com.ephemerayne.domain.entity.CategoryEntity
import com.ephemerayne.presentation.databinding.CategoryItemBinding

class CategoryViewHolder(
    private val binding: CategoryItemBinding,
    private val onCategoryListener: OnCategoryListener
) : RecyclerView.ViewHolder(binding.root) {

    fun setItemContent(categoryEntity: CategoryEntity) {
        with(binding.categoryName) {
            text = categoryEntity.name

            setOnClickListener {
                onCategoryListener.onCategoryClick(categoryEntity.id)
            }
        }
    }
}