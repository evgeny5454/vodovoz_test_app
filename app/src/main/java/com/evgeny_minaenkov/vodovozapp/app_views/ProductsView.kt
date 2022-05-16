package com.evgeny_minaenkov.vodovozapp.app_views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.evgeny_minaenkov.vodovozapp.data.model.Data
import com.evgeny_minaenkov.vodovozapp.view_model.MainViewModel

@Composable
fun ProductsView(tovary: Map<String, List<Data>>, selector: String, mainViewModel: MainViewModel) {
    val products = mutableListOf<Data>()
    tovary.forEach {
        if (selector == it.key)
            it.value.forEach { product ->
                products.add(product)
            }
    }
    LazyRow(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 4.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(products) { product ->
            Product(product, mainViewModel = mainViewModel)
        }
    }
}