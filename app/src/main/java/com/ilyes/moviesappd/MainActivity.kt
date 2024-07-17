package com.ilyes.moviesappd

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem

import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ilyes.moviesappd.ui.theme.MoviesappdTheme
import com.ilyes.moviesappd.ui.theme.MyText
import com.ilyes.moviesappd.ui.theme.MyText1
import com.ilyes.moviesappd.ui.theme.Purple40

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MoviesappdTheme {

            }
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)




@Composable
fun Top(modifier: Modifier = Modifier) {
    Column {
        Spacer(modifier = modifier.height(10.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.search) ,
                    contentDescription = null,
                    modifier = modifier.size(24.dp),

                    )
            },
            placeholder = {
                Text(
                    text = "Search",
                    style = MaterialTheme.typography.bodySmall,

                    )
            },
            shape = MaterialTheme.shapes.extraLarge,
            colors = TextFieldDefaults.textFieldColors(
                containerColor = colorResource(id = R.color.input_background),
                disabledTextColor = Color.Black ,
                cursorColor = Color.Black ,
                disabledIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            singleLine = true,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            textStyle = MaterialTheme.typography.bodySmall,

            )
    }




}








@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun TopPreview() {
    Surface {
        Top()

    }
}

















@Composable
fun TrendText(modifier: Modifier = Modifier) {
    Column {
        Spacer(modifier = modifier.height(10.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Spacer(modifier = modifier.width(25.dp))
            Text(
                text = "Trending Now",
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                fontSize = 16.sp,
                color = MyText


            )
            Spacer(modifier = modifier.weight(1f))
            Text(
                text = "See All",
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                fontSize = 13.sp,
                color = MyText1



            )
            Spacer(modifier = modifier.width(25.dp))


        }
    }

}
















@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun TrendTextPreview() {
    Surface {
        TrendText()

    }
}




















@Composable
fun Image1(
    modifier: Modifier = Modifier,
    @DrawableRes drawable: Int,

    ) {
    Image(
        painter = painterResource(drawable),
        contentDescription = "",
        modifier = modifier
            .width(140.dp)
            .height(260.dp)
            .clip(RoundedCornerShape(22.dp)),
        contentScale = ContentScale.Crop
    )


}
@Preview(showBackground = true)
@Composable
fun ImagePreview() {
    MoviesappdTheme {
        Column {

            Image1(
                drawable = R.drawable.goth,
            )
        }


    }
}


















@Composable
fun TrendingRow(modifier: Modifier = Modifier) {
    Column {
        Spacer(modifier = modifier.height(17.dp))
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(14.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
            modifier = modifier
        ) {
            items(MyTrendingRow) { item ->
                Image1(drawable = item.drawable)
            }


        }
    }

}










private data class Image(
    @DrawableRes val drawable: Int,
)



private val MyTrendingRow = listOf(
    Image(R.drawable.godfather ),
    Image(R.drawable.thor ),
    Image(R.drawable.creed ),
    Image(R.drawable.knivesout ),
    Image(R.drawable.nobody ),
    Image(R.drawable.nowyouseeme )


)


















@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun TrendingRowPreview() {
    MoviesappdTheme {
        TrendingRow()
    }
}
















@Composable
fun TopRatedText(modifier: Modifier = Modifier) {
    Column {
        Spacer(modifier = modifier.height(10.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Spacer(modifier = modifier.width(25.dp))
            Text(
                text = "Top Rated",
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                fontSize = 16.sp,
                color = MyText


            )
            Spacer(modifier = modifier.weight(1f))



        }
    }

}




















@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun TopRatedTextPreview() {
    Surface {
        TopRatedText()

    }
}



















@Composable
fun Image2(
    modifier: Modifier = Modifier,
    @DrawableRes drawable: Int,

    ) {
    Image(
        painter = painterResource(drawable),
        contentDescription = "",
        modifier = modifier
            .width(360.dp)
            .height(210.dp)
            .clip(RoundedCornerShape(30.dp))
        ,
        contentScale = ContentScale.Crop
    )


}


















@Preview(showBackground = true)
@Composable
fun Image2Preview() {
    MoviesappdTheme {
        Column {

            Image2(
                drawable = R.drawable.goth,
            )
        }

    }
}


















@Composable
fun TopRatedRow(modifier: Modifier = Modifier) {
    Column {
        Spacer(modifier = modifier.height(17.dp))
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(30.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
            modifier = modifier
        ) {
            items(MyTopRatedRow) { item ->
                Image2(drawable = item.drawable)
            }

        }
    }

}












private data class Image2row(
    @DrawableRes val drawable: Int,
)



private val MyTopRatedRow = listOf(
    Image2row(R.drawable.goth ),
    Image2row(R.drawable.thedeparted ),
    Image2row(R.drawable.interstellar ),
    Image2row(R.drawable.logan ),
    Image2row(R.drawable.inception ),
    Image2row(R.drawable.pulpfiction )

)















@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun TopRatedRowPreview() {
    MoviesappdTheme {
        TopRatedRow()
    }
}

















@Composable
fun TvshowsText(modifier: Modifier = Modifier) {
    Column {
        Spacer(modifier = modifier.height(10.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Spacer(modifier = modifier.width(25.dp))
            Text(
                text = "Tv Shows",
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                fontSize = 16.sp,
                color = MyText


            )
            Spacer(modifier = modifier.weight(1f))
            Text(
                text = "See All",
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                fontSize = 13.sp,
                color = MyText1



            )
            Spacer(modifier = modifier.width(25.dp))


        }
    }

}





















@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun TvshowTextPreview() {
    Surface {
        TvshowsText()

    }
}













@Composable
fun Image3(
    modifier: Modifier = Modifier,
    @DrawableRes drawable: Int,

    ) {
    Image(
        painter = painterResource(drawable),
        contentDescription = "",
        modifier = modifier
            .width(140.dp)
            .height(260.dp)
            .clip(RoundedCornerShape(22.dp))
        ,
        contentScale = ContentScale.Crop
    )


}

@Preview(showBackground = true)
@Composable
fun Image3Preview() {
    MoviesappdTheme {
        Column {

            Image3(
                drawable = R.drawable.goth,
            )
        }

    }
}

@Composable
fun TvShowRowRow(modifier: Modifier = Modifier) {
    Column {
        Spacer(modifier = modifier.height(17.dp))
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(14.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
            modifier = modifier
        ) {
            items(MyTvShowRow) { item ->
                Image3(drawable = item.drawable)
            }

        }
    }

}







private data class MyImage3(
    @DrawableRes val drawable: Int,
)



private val MyTvShowRow = listOf(
    MyImage3(R.drawable.goth ),
    MyImage3(R.drawable.ozark ),
    MyImage3(R.drawable.bb ),
    MyImage3(R.drawable.spranos ),
    MyImage3(R.drawable.blacklist ),
    MyImage3(R.drawable.vikings )

)






















@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun TvShowRowRowPreview() {
    MoviesappdTheme {
        TvShowRowRow()
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
                    imageVector = Icons.Default.Home,
                    contentDescription = null,

                )
            },
            label = {
                    Text(text = "Home")
            },

            selected = true,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,

                )
            },
            label = {
                Text(text = "Search")
            },

            selected = false,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = null,

                )
            },
            label = {
                Text(text = "Play")
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
            label = {
                Text(text = "Profile")
            },

            selected = false,
            onClick = {}
        )

    }
}

@Composable
fun FullScreen(modifier: Modifier) {
    MoviesappdTheme {
        Scaffold(
            bottomBar = {
                BottomNavigation()
            },
            topBar = {

            }

        ) { innerPadding ->

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(5.dp),
                contentPadding = PaddingValues(vertical = 4.dp),
                modifier = modifier.padding(innerPadding)
            ) {
                item {
                    Top()
                }
                item {
                    TrendText()
                }
                item {
                    TrendingRow()
                }
                item {
                    TopRatedText()
                }
                item {
                    TopRatedRow()
                }
                item {
                    TvshowsText()
                }
                item {
                    TvShowRowRow()
                }

            }




        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun InstagramBottomNavigationPreview() {
    MoviesappdTheme {
        BottomNavigation()
    }
}




@Preview(showBackground = true,)
@Composable
fun FullScreenPreview() {
    MoviesappdTheme {
        FullScreen(modifier = Modifier)
    }
}





