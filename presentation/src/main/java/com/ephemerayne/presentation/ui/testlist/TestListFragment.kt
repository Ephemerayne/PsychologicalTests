package com.ephemerayne.presentation.ui.testlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.ephemerayne.presentation.R
import com.ephemerayne.presentation.api.OpenTest
import com.ephemerayne.presentation.databinding.FragmentTestListBinding
import com.ephemerayne.presentation.di.PresentationComponent
import com.ephemerayne.presentation.di.PresentationComponentDependencies
import com.ephemerayne.presentation.di.findComponentDependencies
import com.ephemerayne.presentation.ui.BaseFragment
import javax.inject.Inject

class TestListFragment : BaseFragment(R.layout.fragment_test_list), OnTestListener {

    @Inject
    lateinit var viewModel: TestListViewModel

    @Inject
    lateinit var openTest: OpenTest

    private lateinit var binding: FragmentTestListBinding
    private val adapter: TestListAdapter = TestListAdapter(this)

    companion object {
        const val CATEGORY_KEY = "CATEGORY KEY"
    }

    override fun getDependencies(): PresentationComponentDependencies = findComponentDependencies()

    override fun injectDependencies(component: PresentationComponent) = component.inject(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentTestListBinding.inflate(inflater).also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(binding.testListRecyclerView) {
            layoutManager = LinearLayoutManager(context)
            adapter = this@TestListFragment.adapter
        }
        viewModel.getTests().observe(viewLifecycleOwner, {
            adapter.setTests(it)
        })
    }

    override fun onTestClick(id: Int) {
        openTest(id)
    }
}