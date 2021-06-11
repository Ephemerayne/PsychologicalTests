package com.ephemerayne.psychologicaltests.navigation

import android.os.Bundle
import com.ephemerayne.presentation.api.OpenResult
import com.ephemerayne.presentation.ui.resultscreen.ResultFragment
import com.ephemerayne.psychologicaltests.R

class OpenResultImpl : OpenResult {

    override fun invoke(sumPoints: Int) {
        NavigationHolder.putAction {
            navigate(
                R.id.result_fragment,
                Bundle().apply {
                    putInt(ResultFragment.RESULT_KEY, sumPoints)
                }
            )
        }
    }
}