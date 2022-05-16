package com.evgeny_minaenkov.vodovozapp.app_views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.evgeny_minaenkov.vodovozapp.R
import com.evgeny_minaenkov.vodovozapp.data.model.Data
import com.evgeny_minaenkov.vodovozapp.view_model.MainViewModel

private val darkGreen = Color(0xFF3F8142)

@Composable
fun Product(product: Data, mainViewModel: MainViewModel) {

    val favorites by mainViewModel.favorites.observeAsState(emptyList())
    val cart by mainViewModel.cart.observeAsState(emptyList())

    Card(
        shape = RoundedCornerShape(4.dp),
        border = BorderStroke(0.3.dp, color = Color.LightGray),
        elevation = 0.dp,
        modifier = Modifier
            .width(190.dp)
    ) {
        Column {
            val prise = product.EXTENDED_PRICE.first().PRICE.toInt()
            Row(modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 10.dp)) {
                Spacer(modifier = Modifier.weight(1f))
                Box(modifier = Modifier.clickable {
                    mainViewModel.addToFavorites(product = product)
                }
                ) {
                    Image(
                        painter = if (!favorites.contains(product))
                            painterResource(id = R.drawable.ic_baseline_favorite_border_24)
                        else painterResource(
                            id = R.drawable.ic_baseline_favorite_24
                        ),
                        contentDescription = R.drawable.ic_baseline_favorite_border_24.toString()
                    )
                }
            }

            ImageView(
                imageUri = "http://szorin.vodovoz.ru${product.DETAIL_PICTURE}",
                modifier = Modifier
                    .size(150.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.weight(1f))
            Row(modifier = Modifier.padding(start = 10.dp, end = 10.dp, bottom = 10.dp)) {
                Text(
                    text = "$prise",
                    style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                    modifier = Modifier.align(Alignment.Bottom)
                )
                Text(
                    text = "₽",
                    style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Normal),
                    modifier = Modifier
                        .padding(start = 4.dp)
                        .align(Alignment.Bottom)
                )
                Spacer(modifier = Modifier.weight(1f))
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(color = darkGreen, shape = RoundedCornerShape(100)),
                ) {

                    Image(
                        modifier = Modifier
                            .size(24.dp)
                            .align(Alignment.Center)
                            .clickable {
                                mainViewModel.addToCart(product)
                            },
                        painter = if (!cart.contains(product))
                            painterResource(id = R.drawable.ic_add_shopping_cart)
                        else painterResource(
                            id = R.drawable.ic_baseline_check_24
                        ),
                        contentDescription = R.drawable.ic_add_shopping_cart.toString()
                    )
                }
            }
        }
    }
}
