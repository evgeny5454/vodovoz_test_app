package com.evgeny_minaenkov.vodovozapp.data

import android.util.Log
import com.evgeny_minaenkov.vodovozapp.data.model.Data
import com.evgeny_minaenkov.vodovozapp.data.model.ResponseVodovoz
import com.evgeny_minaenkov.vodovozapp.data.retrofit.VodovozApi

class Repository {

    suspend fun getData(): Map<String , List<Data>> {
        val response = VodovozApi.api.getData().body()
        val map = mutableMapOf<String , List<Data>>()

        response?.TOVARY?.forEach {
            map.put(it.NAME, it.data)
        }

        Log.d("VODOVOZ_DATA" , map.toString())
        return map
        //
    }
}