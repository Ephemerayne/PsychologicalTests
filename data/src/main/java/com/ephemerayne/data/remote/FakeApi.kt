package com.ephemerayne.data.remote

import com.ephemerayne.data.response.CategoryResponse
import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit

class FakeApi: Api {

    override fun getCategories(): Observable<List<CategoryResponse>> {
        return Observable.fromArray(
            listOf(
                CategoryResponse(1, "Fake Api Category 1"),
                CategoryResponse(2, "Fake Api Category 2"),
            )
        ).delaySubscription(2000, TimeUnit.MILLISECONDS)
    }
}