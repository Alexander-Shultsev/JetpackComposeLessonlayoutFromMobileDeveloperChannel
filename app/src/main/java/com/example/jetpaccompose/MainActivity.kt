package com.example.jetpaccompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetpaccompose.ViewModel.MainViewModel
import com.example.jetpaccompose.view.components.*
import com.example.jetpaccompose.view.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {

                }
            }
        }
    }
}

val brawnGrayColor = Color(0xFF959595)
val whiteTwo = Color(0xFFf1f1f1)

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeTheme {
        ProductScreen()
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProductScreen(mainViewModel: MainViewModel = viewModel()) {
    val article by mainViewModel.article.observeAsState("")
    val title by mainViewModel.title.observeAsState("")
    val inWishList by mainViewModel.inWishList.observeAsState(false)
    val inCompareList by mainViewModel.inCompareList.observeAsState(false)

    LazyColumn(content = {
        stickyHeader {
            Toolbar()
        }
        item { StartImage(mainViewModel) }
        item { Text(article, modifier = Modifier
            .padding(start = 16.dp, top = 24.dp),
            style = TextStyle(color = brawnGrayColor),
            fontSize = 12.sp
        )}
        item { Text(title, modifier = Modifier
            .padding(start = 16.dp, top = 16.dp, end = 64.dp),
            style = TextStyle(color = Color.Black),
            fontSize = 14.sp,
            fontWeight = FontWeight(500)
        )}
        item { RatingRowView() }
        item { PriceView(mainViewModel) }
        item { CountView(mainViewModel) }
        item { HeaderView("Способы получения") }
        item { DeliveryPickupView(mainViewModel) }
        item {
            RouteButton(
                onClick = {},
                model = RouteButtonModel(
                    routeId = "AllCharactersScreen",
                    title = "Наличие в магазинах"
                )
            )
        }
        item {
            ActionButton(
                model = ActionButtonModel(
                    title = "Добавить в список",
                    selectedTitle = "Добавлено к список",
                    isSelected = inWishList
                ),
                onClick = { _, _ ->
                    mainViewModel.inWishListChange()
                }
            )
        }
        item { HeaderView("Характеристики") }
        item { CharacterList(mainViewModel) }
        item {
            RouteButton(
                onClick = {},
                model = RouteButtonModel(
                    routeId = "AllCharactersScreen",
                    title = "Все характеристики"
                )
            )
        }
        item {
            ActionButton(
                model = ActionButtonModel(
                    title = "Добавить к сравнению",
                    selectedTitle = "Добавлено к сравнению",
                    isSelected = inCompareList
                ),
                onClick = { _, _ ->
                    mainViewModel.inCompareListChange()
                }
            )
        }
    },
    modifier = Modifier.fillMaxSize())
}

@Composable
fun CharacterList(mainViewModel: MainViewModel) {
    val characterList by mainViewModel.characterList.observeAsState(emptyList())

    Column()
    {
        characterList.map {
            CharacterListItem(model = it)
        }
    }
}

@Composable
fun DeliveryPickupView(mainViewModel: MainViewModel) {
    val pickupStoresCount by mainViewModel.pickupStoresCount.observeAsState(1)

    Row(modifier = Modifier.padding(start = 16.dp, end = 40.dp, top = 22.dp, bottom = 22.dp)){
        Box(modifier = Modifier
            .size(24.dp)
            .background(Color.Gray))
        Column(modifier = Modifier.padding(start = 24.dp)) {
            Subtitle5("Доставка: Завтра, 25 июня")
            Subtitle6("На складе: 112 шт.")

            if (pickupStoresCount > 0) {
                Spacer(modifier = Modifier.height(20.dp))
                Subtitle5("Самовывоз: Сегодня")
                Subtitle6("Доступно в 10 магазинах")
            }
        }
    }
}

@Composable
fun HeaderView(title: String) {
    Box(modifier = Modifier
        .background(whiteTwo)
        .fillMaxWidth()
        .height(68.dp)
        .padding(start = 16.dp, top = 30.dp))
    {
        Text(title, style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Medium))
    }
}

@Composable
fun CountView(mainViewModel: MainViewModel) {
    val countProduct by mainViewModel.countProduct.observeAsState(0)
    
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(78.dp)
            .padding(horizontal = 16.dp))
    {
        Box(
            modifier = Modifier
                .size(20.dp)
                .background(brawnGrayColor))
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 24.dp))
        {
            Subtitle5("Рассчитать количество")
            Subtitle6("В наличии: $countProduct")
        }
        Box(
            modifier = Modifier
                .size(12.dp)
                .background(brawnGrayColor))
    }
}

@Composable
fun Toolbar() {
    Row(
        modifier = Modifier
            .height(44.dp)
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.background),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("Н")
        Spacer(modifier = Modifier.weight(1f))
        Text("М")
    }
}

@Composable
fun StartImage(mainViewModel: MainViewModel) {
    val image by mainViewModel.pictureLink.observeAsState()

    ImageView(
        imageUrl = image,
        modifier = Modifier
            .height(260.dp)
            .background(Color.White))

}

@Composable
fun RatingRowView() {
    Row {
       Box(modifier = Modifier
           .fillMaxWidth()
           .height(52.dp)
           .background(color = Color.Gray)
       )
    }
}

@Composable
fun PriceView(mainViewModel: MainViewModel) {
    val countProductsInCart by mainViewModel.countProductsInCard.observeAsState(0)

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .height(80.dp)
            .fillMaxWidth()) {
            Text("123 1233", modifier = Modifier
                .padding(start = 16.dp),
                style = TextStyle(color = Color.Black, fontSize = 20.sp, fontWeight = FontWeight.Medium))
            Text("руб/шт", modifier = Modifier
                .padding(start = 4.dp)
                .weight(1f),
                style = TextStyle(color = brawnGrayColor, fontSize = 12.sp, fontWeight = FontWeight.Medium))

            if (countProductsInCart == 0) {
                Button(onClick = {
                    mainViewModel.addProductInCart()
                },
                modifier = Modifier
                    .width(160.dp)
                    .height(48.dp)
                    .padding(end = 16.dp),
                shape = RoundedCornerShape(4.dp)
                ) {
                    Text("В корзину", style = TextStyle (
                        color = Color.White,
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp))
                }
            } else {
                Text(text = "В корзину [$countProductsInCart]", modifier = Modifier
                    .width(160.dp)
                    .height(48.dp))
            }
    }
}