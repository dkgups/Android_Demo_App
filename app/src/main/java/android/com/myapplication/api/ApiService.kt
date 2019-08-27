package android.com.myapplication.api

import android.com.myapplication.model.Facts
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {

    @GET(ApiConstant.FACTS)
     fun loadFacts(): Observable<Facts>
}