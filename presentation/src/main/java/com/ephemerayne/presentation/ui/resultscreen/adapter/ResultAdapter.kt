package com.ephemerayne.presentation.ui.resultscreen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ephemerayne.domain.entity.PointsInterpretationEntity
import com.ephemerayne.domain.entity.ResultEntity
import com.ephemerayne.presentation.databinding.ResultItemRecyclerViewBinding

class ResultAdapter : RecyclerView.Adapter<ResultViewHolder>() {

    private val results: ArrayList<ResultEntity> = ArrayList()
    private val pointsInterpretationEntity: ArrayList<PointsInterpretationEntity> = ArrayList()

    fun setResults(results: List<ResultEntity>) {
        with(this.results) {
            clear()
            addAll(results).apply {
                sortByDescending { result -> result.dateTime }
            }
            notifyDataSetChanged()
        }
    }

    fun setInterpretation(interpretationEntities: List<PointsInterpretationEntity>) {
        with(this.pointsInterpretationEntity) {
            clear()
            addAll(interpretationEntities)
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
        holder.setItemContent(results[position], pointsInterpretationEntity)

    }

    override fun getItemCount(): Int {
       return results.size and pointsInterpretationEntity.size
    }
}