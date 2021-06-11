package com.ephemerayne.presentation.ui.resultscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ephemerayne.presentation.R
import com.ephemerayne.presentation.databinding.FragmentResultBinding
import com.ephemerayne.presentation.di.PresentationComponent
import com.ephemerayne.presentation.di.PresentationComponentDependencies
import com.ephemerayne.presentation.di.findComponentDependencies
import com.ephemerayne.presentation.ui.BaseFragment
import javax.inject.Inject

class ResultFragment : BaseFragment(R.layout.fragment_result) {

    companion object {
        const val RESULT_KEY = "RESULT KEY"
    }

    @Inject
    lateinit var viewModel: ResultViewModel

    private lateinit var binding: FragmentResultBinding

    override fun getDependencies(): PresentationComponentDependencies = findComponentDependencies()

    override fun injectDependencies(component: PresentationComponent) = component.inject(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentResultBinding.inflate(inflater).also { binding = it }.root


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val sumPoints = arguments?.getInt(RESULT_KEY)
        val resPlural: String? = sumPoints?.let { resources.getQuantityString(R.plurals.points, it) }
        binding.resultPoints.text = getString(R.string.result_points, sumPoints, resPlural)
    }
}

