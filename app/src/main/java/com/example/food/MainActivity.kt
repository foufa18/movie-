
package com.example.food

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons.Default
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.food.ui.theme.FoodTheme
import com.example.food.ui.theme.Pink40

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FoodTheme {


                }
            }
        }
    }
@Composable
fun Top(modifier: Modifier = Modifier) {
    Column {
        Spacer(modifier = modifier
            .height(10.dp)
            .fillMaxSize()
            .padding(start = 10.dp))
        Row(
                    modifier = modifier.padding(start=300.dp,end=10.dp)


        ) {

            Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,

                    )
            Spacer(modifier=modifier.padding(5.dp))

            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = null,

                )
        }

}}
@Preview(showBackground = true)
@Composable
fun TopPreview() {
    FoodTheme {
        Top()
    }
}
@Composable
fun TrendText(modifier: Modifier = Modifier) {
    Column {
        Spacer(modifier = modifier.height(10.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically


        ) {
            Spacer(modifier = modifier.width(25.dp))
            Text(
                text = "Explore our\n Delicious offers",
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 23.sp,
                color = Color.Black,


            )

        }
    }

}


@Preview(showBackground = true)
@Composable
fun Text1Preview() {
    FoodTheme {
        TrendText()

    }
}
@Composable
fun Image(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier= Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    )

        {
            Image(
                painter = painterResource(drawable),
                contentDescription = "",
                modifier = modifier
                    .width(130.dp)
                    .height(100.dp)
                    .clip(RoundedCornerShape(22.dp)),
                contentScale = ContentScale.Crop
            )
            Row()
            {}
            Text(
                text = stringResource(text), // Display the text
                modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 2.dp),
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "chinese,South indian", // Display the text
                modifier = Modifier.paddingFromBaseline(top = 18.dp, bottom = 8.dp),
                style = MaterialTheme.typography.titleSmall,
                color = Color.Gray
            )
        }
    }


@Preview(showBackground = true)
@Composable
fun ImagePreview() {
    FoodTheme {
        Column {

            Image(
                text = R.string.Y,
                drawable = R.drawable.f5,
                modifier = Modifier.padding(8.dp)
            )
        }


    }
}
@Composable
fun foodRow(modifier: Modifier = Modifier) {
    Column {
        Spacer(modifier = modifier.height(17.dp))
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(14.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
            modifier = modifier
        ) {
            items(MyTrendingRow) { item ->
                Image(item.drawable,item.text)
            }


        }

    }

}

private val MyTrendingRow= listOf(
    R.drawable.f5 to R.string.Y,
    R.drawable.f6 to R.string.f,
    R.drawable.f7 to R.string.i,

    ).map { DrawableStringPair(it.first, it.second) }

private data class DrawableStringPair(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)


@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun foodRowPreview() {
    FoodTheme {
        foodRow()
    }
}

@Composable
fun TrendyText(modifier: Modifier = Modifier) {
    Column {
        Spacer(modifier = modifier
            .height(10.dp)
            .fillMaxSize())
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Spacer(modifier = modifier.width(20.dp))
            Text(
                text = "Near Me (15)",
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                fontSize = 16.sp,
                color =Color.Gray


            )
            Spacer(modifier = modifier.width(180.dp))
            Image(
                painter = painterResource(id = R.drawable.f),
                contentDescription = "",
                colorFilter = ColorFilter.tint(Color.LightGray),
                modifier = modifier

                    .width(26.dp)
                    .height(26.dp),
                contentScale = ContentScale.Crop



            )

            Spacer(modifier = modifier.width(5.dp))
            Text(
                text = "Filter",
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                fontSize = 13.sp,
                color = Color.Gray,



                )



        }
    }

}
@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun TrendyTextPreview() {
    Surface {
        TrendyText()

    }
}
@Composable
fun Image2(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier= Modifier,
)
{

    Column(
        modifier = modifier,
    ) {
        Row( modifier = modifier
            .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End){
        Image(
            painter = painterResource(drawable),
            contentDescription = "",
            modifier = modifier
                .width(130.dp)
                .height(110.dp)
                .clip(RoundedCornerShape(22.dp))
            ,
            contentScale = ContentScale.Crop
        )
            Column(
                modifier = Modifier.padding(start = 10.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)

            ) {
                Row(modifier = modifier
                    .padding(120.dp, top = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End){
                    Row(){}

                    Image(
                        painter = painterResource(id = R.drawable.degree),
                        contentDescription = "",
                        modifier = modifier
                            .width(26.dp)
                            .height(26.dp),
                        colorFilter=ColorFilter.tint(Color.Green)

                        ,
                        contentScale = ContentScale.Crop


                    )
                    Text( text="open")

                }
            Text(
                text = stringResource(text),
                modifier = Modifier.padding(bottom = 8.dp),
                style = MaterialTheme.typography.titleLarge
            )

            Text(
                text = "chinese, South indian",
                style = MaterialTheme.typography.titleSmall,
                color = Color.Gray
            )
                Text(
                    text = "100-102,Hight st Manchester,UK",
                    style = MaterialTheme.typography.titleSmall,
                    color = Color.LightGray
                )
        }
            }}}


@Preview(showBackground = true)
@Composable
fun Image2Preview() {
    FoodTheme {
        Column {

            Image2(
                text = R.string.G,
                drawable = R.drawable.f1,
            )
        }


    }
}
@Composable
fun foodyColumn(modifier: Modifier = Modifier) {
    Column {
        Spacer(modifier = modifier
            .height(10.dp)
            .fillMaxSize())
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(0.dp),
            modifier = modifier
        ) {
            items(MyTrendingColumn) { item ->
                Image2(item.drawable,item.text)
            }


        }

    }

}

private val MyTrendingColumn= listOf(
    R.drawable.f1 to R.string.G,
    R.drawable.f2 to R.string.f,
    R.drawable.f3 to R.string.i,

    ).map { DrawableStringPair(it.first, it.second) }

private data class DrawableString1Pair(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)


@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun foodyColumnPreview() {
    FoodTheme {
        foodyColumn()
    }
}
@Composable
fun BottomNavigation(modifier: Modifier = Modifier) {





    NavigationBar(
        containerColor = Color.White,
        modifier = modifier
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Default.Home,
                    contentDescription = null,
                    tint=Pink40,



                )

            },

            selected = true,
            onClick = {}

        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = null,

                    )
            },

            selected = false,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.shop
                    ),
                    contentDescription = null,

                    )
            },


            selected = false,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,

                    )
            },


            selected = false,
            onClick = {}
        )

    }
}
@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun BottomNavigationPreview() {
    FoodTheme {
        BottomNavigation()
    }
}
@Composable
fun FullScreenPreview(content: @Composable Modifier.() -> Unit) {
    FoodTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) {
            content(Modifier.padding(it)) // Add padding for content
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AllPreviewsInFullScreen() {
    FullScreenPreview {
        Column {
            Top()
            TrendText()
            foodRow()
            TrendyText()
            foodyColumn()
            BottomNavigation()
        }
    }
}
