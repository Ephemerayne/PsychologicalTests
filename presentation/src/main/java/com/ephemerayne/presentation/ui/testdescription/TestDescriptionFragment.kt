package com.ephemerayne.presentation.ui.testdescription

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ephemerayne.presentation.R
import com.ephemerayne.presentation.api.OpenTest
import com.ephemerayne.presentation.databinding.FragmentTestDescriptionBinding
import com.ephemerayne.presentation.di.PresentationComponent
import com.ephemerayne.presentation.di.PresentationComponentDependencies
import com.ephemerayne.presentation.di.findComponentDependencies
import com.ephemerayne.presentation.ui.BaseFragment
import javax.inject.Inject

class TestDescriptionFragment : BaseFragment(R.layout.fragment_test_description) {

    companion object {
        const val TEST_KEY = "TEST_KEY"
    }

    @Inject
    lateinit var viewModel: TestDescriptionViewModel

    @Inject
    lateinit var openTest: OpenTest

    private lateinit var binding: FragmentTestDescriptionBinding

    override fun getDependencies(): PresentationComponentDependencies = findComponentDependencies()

    override fun injectDependencies(component: PresentationComponent) = component.inject(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentTestDescriptionBinding.inflate(inflater).also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val testId = arguments?.getInt(TEST_KEY)
        if (testId != null) {
            viewModel.getTest(testId).observe(viewLifecycleOwner, {
                with(binding) {
                    testTitle.text = it.title
                    testDescription.text = it.description
                }
            })
        }

        binding.beginTestButton.setOnClickListener {
            if (testId != null) {
                openTest(testId)
            }
        }
    }
}

