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
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movie.R
import com.example.movie.ui.theme.MovieTheme

class MainActivity<Bundle> : ComponentActivity() {
    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MovieTheme {
                Example()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Example() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.blanc),
            contentDescription = "Background Image",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )}

    Spacer(modifier = Modifier.height(20.dp))

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 25.dp, horizontal = 20.dp),
        shape = RoundedCornerShape(24.dp),
        value = "",
        onValueChange = {},
        leadingIcon = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = "Search Icon",
                    modifier = Modifier
                        .size(50.dp)
                        .padding(start = 10.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Search movie or Tv Serie",
                    color = Color.DarkGray,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                )
            }
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color(0x9CFFFFFF),
            containerColor = Color.Transparent
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text
        ),
        maxLines = 1
    )
}


@Preview(showBackground = true)
@Composable
fun MoviePreview() {
    MovieTheme {
        Example()
    }
}
@Composable
fun Box(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(88.dp)
                .clip(shape = RoundedCornerShape(corner = CornerSize(16.dp)))

        )
        Text(
            text = stringResource(text),
            modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp),
            style = MaterialTheme.typography.bodyMedium
        )


    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun BoxPreview() {
    MovieTheme {
        Box(
            text = R.string.You,
            drawable = R.drawable.f1,
            modifier = Modifier.padding(8.dp)
        )
    }
}
@Composable
fun BoxRow(modifier: Modifier = Modifier) {
    Column {
        Spacer(modifier = modifier.height(17.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Trending Now",
                modifier = Modifier.padding(horizontal = 16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(modifier=Modifier.weight(1f))
            Text(
                text = "see all",
                size=10.sp,
                modifier = Modifier.padding(horizontal = 2.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
        Spacer(modifier=Modifier.height(7.dp))
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(14.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
            modifier = modifier
        ) {
            items(BoxRow) { item ->

                Box(item.drawable,item.text)

            }

        }
    }


}

private val BoxRow = listOf(
    R.drawable.f3 to  R.string.You,
    R.drawable.f1 to  R.string.f1,
    R.drawable.f2 to  R.string.f2,

    ).map { DrawableStringPair(it.first, it.second) }

private data class DrawableStringPair(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)


@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun BoxRowPreview() {
    MovieTheme {
        BoxRow()
    }
}
@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)

@Composable
fun BottomNavigation() {
    NavigationBar(
        containerColor = Color.White,
        modifier = Modifier
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home",
                    modifier = Modifier
                        .height(40.dp)
                        .width(40.dp)
                )
            },
            selected = false, // You'll need to manage the selected state
            onClick = {}       // Add the action to perform on click
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Favorites",
                    modifier = Modifier
                        .height(40.dp)
                        .width(40.dp)
                )
            },
            selected = false,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.popular), // Replace with your actual drawable
                    contentDescription = "Popular",
                    modifier = Modifier
                        .height(40.dp)
                        .width(40.dp)
                )
            },
            selected = false,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.serie), // Replace with your actual drawable
                    contentDescription = "Series",
                    modifier = Modifier
                        .height(40.dp)
                        .width(40.dp)
                )
            },
            selected = false,
            onClick = {}
        )
    }
}
@Composable
fun PostImage(
    @DrawableRes drawable1: Int,
    modifier: Modifier = Modifier
) {
    Column {
        Spacer(modifier = modifier.height(17.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Special",
                modifier = Modifier.padding(horizontal = 16.dp,vertical=8.dp),
                style = MaterialTheme.typography.headlineSmall
            )
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.insight),
                contentDescription = "Favorites",
                modifier = Modifier
                    .height(40.dp)
                    .width(40.dp)
            )

        }

        Image(
            painter = painterResource(drawable1),
            contentDescription = "",
            modifier = modifier
                .fillMaxWidth()
                .height(300.dp)
                .clip(shape = RoundedCornerShape(corner = CornerSize(30.dp))),

            contentScale = ContentScale.Crop
        )


    }}
@Preview(showBackground = true)
@Composable
fun PostImagePreview() {
    MovieTheme {
        PostImage(
            drawable1 = R.drawable.f6,
        )
    }
}






























