package com.evgeny_minaenkov.vodovozapp.app_views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.evgeny_minaenkov.vodovozapp.Screen

@Composable
fun NavRow(
    navItems: List<String>,
    section: String,
    navController: NavController,
    onClick: (String) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        contentAlignment = Alignment.Center,
    ) {
        LazyRow(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(navItems) {
                Button(
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                    onClick = {
                        onClick.invoke(it)
                        navController.navigate(Screen.MainScreen.withArgs(it)) {
                            navController.graph.startDestinationRoute?.let {
                                popUpTo(it) {
                                    saveState = true
                                }
                            }
                        }
                    }
                ) {
                    Text(
                        text = it,
                        style = TextStyle(color = if (it == section) Color.Blue else Color.LightGray)
                    )
                }
            }
        }
    }
}
