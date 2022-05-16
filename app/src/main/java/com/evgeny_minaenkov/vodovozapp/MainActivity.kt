package com.evgeny_minaenkov.vodovozapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.evgeny_minaenkov.vodovozapp.view_model.MainViewModel
import com.evgeny_minaenkov.vodovozapp.app_views.NavRow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val mainViewModel: MainViewModel = viewModel()
            val navController = rememberNavController()

            val tovary by mainViewModel.tovary.observeAsState(emptyMap())
            val navItems = mutableListOf<String>()

            tovary.forEach {
                navItems.add(it.key)
            }
            if (tovary.isNotEmpty()) {
                var section by remember { mutableStateOf(navItems.first()) }
                LazyColumn {
                    item {
                        NavRow(
                            navItems = navItems,
                            section = section,
                            navController = navController,
                            onClick = { section = it })
                    }
                    item {
                        Navigation(
                            navHostController = navController,
                            section = section,
                            tovary = tovary,
                            mainViewModel = mainViewModel
                        )
                    }
                }
            }
        }
    }
}
