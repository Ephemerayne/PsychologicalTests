package com.ephemerayne.data.remote

import com.ephemerayne.data.response.CategoryResponse
import com.ephemerayne.data.response.TestResponse
import io.reactivex.rxjava3.core.Observable

interface Api {

    fun getCategories(): Observable<List<CategoryResponse>>

    fun getTests(): Observable<List<TestResponse>>

    fun getTest(id: Int): Observable<TestResponse>
}