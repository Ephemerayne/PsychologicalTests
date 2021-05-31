package com.ephemerayne.presentation.ui.testlist

import androidx.recyclerview.widget.RecyclerView
import com.ephemerayne.domain.entity.TestEntity
import com.ephemerayne.presentation.databinding.TestListItemBinding

class TestListViewHolder(
    private val binding: TestListItemBinding,
    private val onTestListListener: OnTestListener
): RecyclerView.ViewHolder(binding.root) {

    fun setItemContent(testEntity: TestEntity) {
        with(binding.testName) {
            text = testEntity.title

                setOnClickListener {
                    onTestListListener.onTestClick(testEntity.id)
                }
        }
    }
}