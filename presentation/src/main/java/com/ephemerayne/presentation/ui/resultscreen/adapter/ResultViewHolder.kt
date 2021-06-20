package com.ephemerayne.presentation.ui.resultscreen.adapter

import androidx.recyclerview.widget.RecyclerView
import com.ephemerayne.domain.entity.PointsInterpretationEntity
import com.ephemerayne.domain.entity.ResultEntity
import com.ephemerayne.presentation.R
import com.ephemerayne.presentation.databinding.ResultItemRecyclerViewBinding
import com.ephemerayne.presentation.ui.resultscreen.getResultDescription
import com.ephemerayne.presentation.utils.dateFormatter
import com.ephemerayne.presentation.utils.timeFormatter

class ResultViewHolder(
    private val binding: ResultItemRecyclerViewBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun setItemContent(
        resultEntity: ResultEntity,
        pointsInterpretationEntity: List<PointsInterpretationEntity>
    ) {
        with(binding) {
            dateResultColumn.text = binding.root.context.getString(
                R.string.date_time_formatter,
                dateFormatter.format(resultEntity.dateTime.toLocalDate()),
                timeFormatter.format(resultEntity.dateTime.toLocalTime())
            )
            pointsResultColumn.text = resultEntity.points.toString()

            for (interpretation in pointsInterpretationEntity) {
                val testResultInterpretation =
                    getResultDescription(resultEntity.points, pointsInterpretationEntity)
                binding.resultColumn.text = testResultInterpretation.result
            }
        }
    }
}