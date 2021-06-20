package com.ephemerayne.data.remote

import com.ephemerayne.data.response.CategoryResponse
import com.ephemerayne.data.response.OptionResponse
import com.ephemerayne.data.response.QuestionResponse
import com.ephemerayne.data.response.TestResponse
import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit

class FakeApi : Api {

    override fun getCategories(): Observable<List<CategoryResponse>> {
        return Observable.fromArray(
            listOf(
                CategoryResponse(1, "Fake Api Category 1"),
                CategoryResponse(2, "Fake Api Category 2"),
            )
        ).delaySubscription(2000, TimeUnit.MILLISECONDS)
    }

    override fun getTests(): Observable<List<TestResponse>> {
        return Observable.fromArray(
            listOf(
                TestResponse(1, 1, "Fake Api Test 1", "desc"),
                TestResponse(1, 2, "Fake Api Test 2", "desc"),
                TestResponse(1, 3, "Fake Api Test 3", "desc"),
                TestResponse(1, 4, "Fake Api Test 4", "desc"),
            )
        ).delaySubscription(2000, TimeUnit.MILLISECONDS)
    }

    override fun getTest(id: Int): Observable<TestResponse> {
        return Observable.just(
            TestResponse(
                1, 10, "Get Test 1 Fake Api", "desc"
            )
        )
    }

    override fun getQuestions(testId: Int): Observable<List<QuestionResponse>> {
        return Observable.fromArray(
            listOf(
                QuestionResponse(1, 1, "Fake Api Question 1"),
                QuestionResponse(1, 2, "Fake Api Question 2"),
                QuestionResponse(1, 3, "Fake Api Question 3"),
            ).filter { it.testId == testId }
        )
    }

    override fun getOptions(questionId: Int): Observable<List<OptionResponse>> {
        return Observable.fromArray(
            listOf(
                OptionResponse(1, 1, 0, "Fake Api Option 1"),
                OptionResponse(1, 2, 1, "Fake Api Option 2"),
                OptionResponse(1, 3, 2, "Fake Api Option 3"),
                OptionResponse(1, 4, 3, "Fake Api Option 4"),

                OptionResponse(2, 5, 0, "Fake Api Option 5"),
                OptionResponse(2, 6, 1, "Fake Api Option 6"),
                OptionResponse(2, 7, 2, "Fake Api Option 7"),
                OptionResponse(2, 8, 3, "Fake Api Option 8"),

                OptionResponse(3, 9, 0, "Fake Api Option 9"),
                OptionResponse(3, 10, 1, "Fake Api Option 10"),
                OptionResponse(3, 11, 2, "Fake Api Option 11"),
                OptionResponse(3, 12, 3, "Fake Api Option 12"),
            ).filter { it.questionId == questionId }
        ).delaySubscription(1000, TimeUnit.MILLISECONDS)
    }
}