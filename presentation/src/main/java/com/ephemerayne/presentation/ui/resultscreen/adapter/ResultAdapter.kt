package com.ephemerayne.presentation.ui.resultscreen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ephemerayne.domain.entity.PointsInterpretation
import com.ephemerayne.domain.entity.ResultEntity
import com.ephemerayne.presentation.databinding.ResultItemRecyclerViewBinding

class ResultAdapter : RecyclerView.Adapter<ResultViewHolder>() {

    private val results: ArrayList<ResultEntity> = ArrayList()
    private val pointsInterpretation: ArrayList<PointsInterpretation> = ArrayList()

    fun setResults(results: List<ResultEntity>) {
        with(this.results) {
            clear()
            addAll(results).apply {
                sortByDescending { result -> result.dateTime }
            }
            notifyDataSetChanged()
        }
    }

    fun setInterpretation(interpretations: List<PointsInterpretation>) {
        with(this.pointsInterpretation) {
            clear()
            addAll(interpretations)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        val binding = ResultItemRecyclerViewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ResultViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        holder.setItemContent(results[position], pointsInterpretation)

    }

    override fun getItemCount(): Int {
       return results.size and pointsInterpretation.size
    }
}