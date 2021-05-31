package com.ephemerayne.psychologicaltests.navigation

import android.os.Bundle
import com.ephemerayne.presentation.api.OpenCategory
import com.ephemerayne.presentation.ui.testlist.TestListFragment
import com.ephemerayne.psychologicaltests.R

class OpenCategoryImpl : OpenCategory {
    override fun invoke(id: Int) {
        NavigationHolder.putAction {
            navigate(R.id.test_list_fragment,
                Bundle().apply {
                    putInt(TestListFragment.CATEGORY_KEY, id)
                })
        }
    }
}