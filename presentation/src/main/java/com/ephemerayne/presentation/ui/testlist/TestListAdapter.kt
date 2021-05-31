package com.ephemerayne.presentation.ui.testlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ephemerayne.domain.entity.TestEntity
import com.ephemerayne.presentation.databinding.TestListItemBinding

class TestListAdapter(
    private val onTestListener: OnTestListener
) : RecyclerView.Adapter<TestListViewHolder>() {

    private val tests: ArrayList<TestEntity> = ArrayList()

    fun setTests(tests: List<TestEntity>) {
        with(this.tests) {
            clear()
            addAll(tests)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestListViewHolder {
        val binding = TestListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TestListViewHolder(binding, onTestListener)
    }

    override fun onBindViewHolder(holder: TestListViewHolder, position: Int) {
        holder.setItemContent(tests[position])
    }

    override fun getItemCount() = tests.size
}