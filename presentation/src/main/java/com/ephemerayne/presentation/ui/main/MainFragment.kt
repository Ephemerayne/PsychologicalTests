package com.ephemerayne.presentation.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.ephemerayne.presentation.R
import com.ephemerayne.presentation.api.OpenCategory
import com.ephemerayne.presentation.databinding.FragmentMainBinding
import com.ephemerayne.presentation.di.PresentationComponent
import com.ephemerayne.presentation.di.PresentationComponentDependencies
import com.ephemerayne.presentation.di.findComponentDependencies
import com.ephemerayne.presentation.ui.BaseFragment
import javax.inject.Inject

class MainFragment : BaseFragment(R.layout.fragment_main), OnCategoryListener {

    @Inject
    lateinit var viewModel: MainFragmentViewModel

    @Inject
    lateinit var openCategory: OpenCategory

    private lateinit var binding: FragmentMainBinding

    private val adapter: CategoryAdapter = CategoryAdapter(this)

    override fun getDependencies(): PresentationComponentDependencies = findComponentDependencies()

    override fun injectDependencies(component: PresentationComponent) = component.inject(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentMainBinding.inflate(inflater)
        .also { binding = it }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(binding.categoryRecyclerView) {
            layoutManager = LinearLayoutManager(context)
            adapter = this@MainFragment.adapter
        }
        viewModel.getCategories().observe(viewLifecycleOwner, {
            adapter.setCategories(it)
        })
    }

    override fun onCategoryClick(id: Int) = openCategory(id)
}