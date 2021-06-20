package com.ephemerayne.presentation.ui.resultscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.ephemerayne.domain.entity.PointsInterpretationEntity
import com.ephemerayne.presentation.R
import com.ephemerayne.presentation.databinding.FragmentResultBinding
import com.ephemerayne.presentation.di.PresentationComponent
import com.ephemerayne.presentation.di.PresentationComponentDependencies
import com.ephemerayne.presentation.di.findComponentDependencies
import com.ephemerayne.presentation.ui.BaseFragment
import com.ephemerayne.presentation.ui.resultscreen.adapter.ResultAdapter
import com.ephemerayne.presentation.ui.test.TestFragment
import javax.inject.Inject

class ResultFragment : BaseFragment(R.layout.fragment_result) {

    companion object {
        const val RESULT_KEY = "RESULT KEY"
    }

    @Inject
    lateinit var viewModel: ResultViewModel

    private lateinit var binding: FragmentResultBinding

    private val adapter: ResultAdapter = ResultAdapter()

    override fun getDependencies(): PresentationComponentDependencies = findComponentDependencies()

    override fun injectDependencies(component: PresentationComponent) = component.inject(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentResultBinding.inflate(inflater).also { binding = it }.root


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val testId = arguments?.getInt(TestFragment.TEST_KEY)
        val sumPoints = arguments?.getInt(RESULT_KEY)
        val resPlural: String? =
            sumPoints?.let { resources.getQuantityString(R.plurals.points, it) }
        binding.resultPoints.text = getString(R.string.result_points, sumPoints, resPlural)

        with(binding.recyclerViewResults) {
            layoutManager = LinearLayoutManager(context)
            adapter = this@ResultFragment.adapter
        }
        if (testId != null) {
            viewModel.getResult(testId).observe(viewLifecycleOwner, {
                adapter.setResults(it)
            })
            viewModel.getInterpretation(testId).observe(viewLifecycleOwner, {
                adapter.setInterpretation(it)
                if (sumPoints != null) {
                    setResult(sumPoints, it)
                }
            })
        }
    }
    private fun setResult(sumPoints: Int, pointsInterpretationEntity: List<PointsInterpretationEntity>) {
        val testResultInterpretation = getResultDescription(sumPoints, pointsInterpretationEntity)
        binding.resultType.text = testResultInterpretation.result
        binding.resultDescription.text = testResultInterpretation.description
    }
}

