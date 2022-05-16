package com.evgeny_minaenkov.vodovozapp.data.retrofit

import com.evgeny_minaenkov.vodovozapp.data.model.ResponseVodovoz
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("newmobile/glavnaya/super_top.php")
    suspend fun getData(
        @Query("action") actoin: String = "topglav",
    ): Response<ResponseVodovoz>
}