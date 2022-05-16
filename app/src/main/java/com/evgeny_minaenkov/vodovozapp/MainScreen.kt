package com.evgeny_minaenkov.vodovozapp

import androidx.compose.runtime.Composable
import com.evgeny_minaenkov.vodovozapp.data.model.Data
import com.evgeny_minaenkov.vodovozapp.app_views.ProductsView
import com.evgeny_minaenkov.vodovozapp.view_model.MainViewModel

@Composable
fun MainScreen(
    section: String?,
    tovary: Map<String, List<Data>>,
    mainViewModel: MainViewModel
) {
    ProductsView(tovary = tovary, selector = section ?: "", mainViewModel = mainViewModel)
}




