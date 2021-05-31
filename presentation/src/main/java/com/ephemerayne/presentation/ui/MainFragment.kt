package com.ephemerayne.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ephemerayne.presentation.R
import com.ephemerayne.presentation.databinding.FragmentMainBinding
import com.ephemerayne.presentation.di.PresentationComponent
import com.ephemerayne.presentation.di.PresentationComponentDependencies
import com.ephemerayne.presentation.di.findComponentDependencies
import javax.inject.Inject

class MainFragment : BaseFragment(R.layout.fragment_main) {

    @Inject
    lateinit var viewModel: MainFragmentViewModel

    private lateinit var binding: FragmentMainBinding

    override fun getDependencies(): PresentationComponentDependencies = findComponentDependencies()

    override fun injectDependencies(component: PresentationComponent) = component.inject(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentMainBinding.inflate(inflater)
        .also { binding = it }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        println("debugg: $viewModel")
    }
}