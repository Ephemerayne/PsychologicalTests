package com.ephemerayne.data.remote

import com.ephemerayne.data.response.CategoryResponse
import io.reactivex.rxjava3.core.Observable

interface Api {

    fun getCategories(): Observable<List<CategoryResponse>>
}