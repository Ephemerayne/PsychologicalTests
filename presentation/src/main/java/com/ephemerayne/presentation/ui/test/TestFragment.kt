package com.ephemerayne.presentation.ui.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import com.ephemerayne.domain.entity.QuestionEntity
import com.ephemerayne.presentation.R
import com.ephemerayne.presentation.databinding.FragmentTestBinding
import com.ephemerayne.presentation.di.PresentationComponent
import com.ephemerayne.presentation.di.PresentationComponentDependencies
import com.ephemerayne.presentation.di.findComponentDependencies
import com.ephemerayne.presentation.ui.BaseFragment
import javax.inject.Inject

class TestFragment : BaseFragment(R.layout.fragment_test) {

    companion object {
        const val TEST_KEY = "TEST_KEY"
    }

    @Inject
    lateinit var viewModel: TestViewModel

    private lateinit var binding: FragmentTestBinding

    override fun getDependencies(): PresentationComponentDependencies = findComponentDependencies()

    override fun injectDependencies(component: PresentationComponent) = component.inject(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentTestBinding.inflate(inflater).also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val testId = arguments?.getInt(TEST_KEY)

        testId?.let { id ->
            viewModel.getQuestions(id).observe(viewLifecycleOwner, {
                viewModel.questions = it
                showOptions(it.firstOrNull())
            })
        }

        binding.nextButton.setOnClickListener {
            showOptions(viewModel.getNextQuestion())
        }
    }

    private fun showOptions(question: QuestionEntity?) {
        if (question == null) return
        viewModel.getOptions(question.id).observe(viewLifecycleOwner, { options ->
            val optionsGroup = binding.optionsGroup
            optionsGroup.removeAllViews()
            optionsGroup.clearCheck()
            for (option in options) {
                val optionButton = RadioButton(context)
                optionButton.text = option.option
                optionsGroup.addView(optionButton)
            }
        })
    }
}