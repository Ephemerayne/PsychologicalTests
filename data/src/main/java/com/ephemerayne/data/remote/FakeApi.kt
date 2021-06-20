package com.ephemerayne.data.remote

import com.ephemerayne.data.response.CategoryResponse
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
}