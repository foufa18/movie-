package com.example.work1
import android.health.connect.datatypes.HeightRecord
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.work1.ui.theme.Pink40
import com.example.work1.ui.theme.Pink80
import com.example.work1.ui.theme.Purple40
import com.example.work1.ui.theme.Purple80
import com.example.work1.ui.theme.PurpleGrey40
import com.example.work1.ui.theme.Work1Theme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
           Work1Theme {

            }
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)




@Composable
fun Top(modifier: Modifier = Modifier) {
    Column {
        Spacer(modifier = modifier.height(15.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = null,
                    modifier = modifier.size(24.dp),

                    )
            },
            placeholder = {
                Text(
                    text = "Where you want to go",
                    style = MaterialTheme.typography.bodyMedium,
                    color=Color.Gray,

                    )
            },
            shape = MaterialTheme.shapes.extraLarge,
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Purple40,
                disabledTextColor = Color.LightGray,
                cursorColor = Color.LightGray,
                disabledIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Black,
                unfocusedIndicatorColor = Color.LightGray
            ),
            singleLine = true,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            textStyle = MaterialTheme.typography.bodySmall,

            )
    }
}
@Preview(showBackground = true, backgroundColor = 0xFF000000, heightDp = 70)
@Composable
fun TopPreview() {
    Surface {
        Top()

    }
}

@Composable
fun TrendText(modifier: Modifier = Modifier
    .fillMaxWidth()
    .padding(horizontal = 12.dp),) {
    Column {
        Spacer(modifier = modifier.height(10.dp))

            Spacer(modifier = modifier.width(25.dp))
            Text(
                modifier = modifier.padding(start = 15.dp,top=5.dp),
                text = "Hello Alex,",
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                fontSize = 22.sp,
                color = Color.LightGray


            )
            Spacer(modifier = modifier.height(10.dp))
            Text(
                modifier = modifier.padding(start = 15.dp,bottom=10.dp),
                text = "Find your perfect places",
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                fontSize = 25.sp,
                color =Color.Gray



            )
            Spacer(modifier = modifier.width(25.dp))

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
fun Trend2Text(modifier: Modifier = Modifier) {
    Column {
        Spacer(modifier = modifier.height(10.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Spacer(modifier = modifier.width(25.dp))
            Text(
                text = "Hotels",
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                fontSize = 23.sp,
                color = Color.DarkGray


            )
            Spacer(modifier = modifier.weight(1f))
            Text(
                text = "View All",
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                fontSize = 16.sp,
                color = Color.Blue



            )
            Spacer(modifier = modifier.width(25.dp))


        }
    }

}



@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun TrendText2Preview() {
    Surface {
        Trend2Text()

    }
}
@Composable
fun CategoryBoxes() {
    Row(modifier = Modifier.height(50.dp),

        horizontalArrangement = Arrangement.SpaceEvenly // Distribute boxes evenly
    ) {
        CategoryBox("All")
        CategoryBox("Popular")
        CategoryBox("Top")
        CategoryBox("Sale")
        CategoryBox("100$")
        CategoryBox("100$-300$")
        // Add more CategoryBox composables as needed
    }
}

@Composable
fun CategoryBox(text: String) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .background(color = Pink40, shape = RoundedCornerShape(8.dp))
            .padding(horizontal = 16.dp, vertical = 7.dp,)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            color=Color.Blue
        )

    }
}
@Preview(showBackground = true,heightDp = 50)
@Composable
fun CategoryBoxesPreview( ) {


    CategoryBoxes()

}

    @Composable
    fun Image1(@DrawableRes drawable: Int,
               @StringRes text: Int,) {
        Box {
            Image(
                painter = painterResource(id = drawable), // Replace with your image
                contentDescription = "Image description",
                modifier = Modifier
                    .padding(8.dp)
                    .width(190.dp)
                    .height(250.dp)
                    .background(
                        color = PurpleGrey40,
                        shape = RoundedCornerShape(20.dp),

                        )
                    .padding(horizontal = 2.dp, vertical = 2.dp)
                    .clip(RoundedCornerShape(22.dp)),
                contentScale = ContentScale.Crop
            )
                Icon(
                    painter = painterResource(id = R.drawable.fav
                    ),
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(18.dp),
                    tint=Purple40

                )
            Text(
                text =  stringResource(text),
                color = Color.White, // Adjust color as needed
                modifier = Modifier
                    .align(Alignment.BottomEnd) // Position the text
                    .padding(16.dp) ,// Add padding around the text
                    style=MaterialTheme.typography.titleMedium,
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = " London",
                color = Color.White, // Adjust color as needed
                modifier = Modifier
                    .align(Alignment.BottomCenter) // Position the text
                    .padding(16.dp) // Add padding around the text
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun Image1Preview() {
        Work1Theme {
            Column {

                Image1(text = R.string.Y,
                    drawable = R.drawable.f6,)
            }


        }}
@Composable
fun ImageLazyRow(imageDataList: List<Pair<Int, Int>>) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 8.dp)
    ) {
        items(imageDataList) { (drawable, text) ->
            Image1(drawable = drawable, text = text)
        }
    }
}

// Sample data (same as before)
val imageDataList = listOf(
    R.drawable.f6 to R.string.Y,
    R.drawable.f7 to R.string.f,
    // Add more image and text pairs as needed
)

@Preview(showBackground = true)
@Composable
fun ImageLazyRowPreview() {
    Work1Theme {
        ImageLazyRow(imageDataList)
    }
}

// Your existing Image1 composable
@Composable
fun TrendyText(modifier: Modifier = Modifier) {
    Column {
        Spacer(modifier = modifier.height(10.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Spacer(modifier = modifier.width(25.dp))
            Text(
                text = "Events",
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                fontSize = 23.sp,
                color = Color.DarkGray


            )
            Spacer(modifier = modifier.weight(1f))
            Text(
                text = "View All",
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                fontSize = 16.sp,
                color = Color.Blue


            )
            Spacer(modifier = modifier.width(25.dp))


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
fun Image2(@DrawableRes drawable: Int,
           @StringRes text: Int,) {
    Box {
        Image(
            painter = painterResource(id = drawable), // Replace with your image
            contentDescription = "Image description",
            modifier = Modifier
                .padding(8.dp)
                .width(300.dp)
                .height(170.dp)
                .background(color = PurpleGrey40, shape = RoundedCornerShape(20.dp))
                .padding(horizontal = 2.dp, vertical = 2.dp)
                .clip(RoundedCornerShape(22.dp)),
            contentScale = ContentScale.Crop
        )
        Text(
            text =  stringResource(text),
            color = Color.White, // Adjust color as needed
            modifier = Modifier
                .align(Alignment.BottomStart) // Position the text
                .padding(16.dp) ,// Add padding around the text
            style=MaterialTheme.typography.titleMedium,
        )
        Spacer(modifier = Modifier.height(2.dp))

    }
}

@Preview(showBackground = true)
@Composable
fun Image2Preview() {
    Work1Theme {
        Column {

            Image2(text = R.string.a,
                drawable = R.drawable.f1,)
        }


    }}
@Composable
fun ImageLazyRow2(imageDataList: List<Pair<Int, Int>>) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 8.dp)
    ) {
        items(imageDataList) { (drawable, text) ->
            Image2(drawable = drawable, text = text)
        }
    }
}

// Sample data (same as before)
val imageDataList2 = listOf(
    R.drawable.f1 to R.string.a,
    R.drawable.f2 to R.string.b,
    // Add more image and text pairs as needed
)

@Preview(showBackground = true)
@Composable
fun ImageLazyRow2Preview() {
    Work1Theme {
        ImageLazyRow2(imageDataList2)
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
                    tint=Pink80,



                    )

            },
            selected = false,
            onClick = {}

        )
        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.chat
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
                    imageVector = Icons.Default.Notifications,
                    contentDescription = null,

                    )
            },

            selected = false,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.serach
                    ),
                    contentDescription = null,
                    tint=Purple80,

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
@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE, heightDp = 59)
@Composable
fun BottomNavigationPreview() {
    Work1Theme {
        BottomNavigation()
    }
}
@Composable
fun FullScreenPreview(content: @Composable Modifier.() -> Unit) {
    Work1Theme {
        Scaffold(modifier = Modifier.fillMaxSize()) {
            content(Modifier.padding(it)) // Add padding for content
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppContent() {
    Scaffold(
        bottomBar = { BottomNavigation() }
    ) { innerPadding ->
        Column() {
            Top()
            TrendText()
            Trend2Text()
            CategoryBoxes()
            ImageLazyRow(imageDataList)
            TrendyText()
            ImageLazyRow2(imageDataList2)
        }
    }
}
