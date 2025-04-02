package com.example.caratlane

import android.icu.util.Currency
import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.animateScrollBy
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.nio.file.WatchEvent
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CheckboxDefaults.colors
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Constraints
import kotlin.contracts.contract


class MainActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen(){

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
    {
        item { HeaderSection() }

        item { Spacer(modifier = Modifier.height(1.dp))}

        item { SearchBar() }

        item { Spacer(modifier = Modifier.height(5.dp))}

        item { CategoryList() }

        item { Spacer(modifier = Modifier.height(9.dp))}

        item { AutoSlidingImageSlider() }

        item { Spacer(modifier = Modifier.height(3.dp))}

        item { gold() }

        item { Spacer(modifier = Modifier.height(3.dp))}

        item { StillThinkingSection() }

        item { Spacer(modifier = Modifier.height(3.dp))}

        item { GoldSavingBanner() }

    }
}

@Composable
fun HeaderSection(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Row(verticalAlignment = Alignment.CenterVertically){
            Image(
                painter = painterResource(id= R.drawable.logo),
                contentDescription = "App Logo",
                modifier = Modifier.size(50.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))

            Column {
                Text(
                    text = "Delivery & Stores",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF6B44C5)
                )

                Row(verticalAlignment = Alignment.CenterVertically){
                    Text(
                        text = "Enter Pincode",
                        fontSize = 12.sp,
                        color = Color.Black
                    )
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Dropdown"
                    )
                }
            }
        }

        Row(verticalAlignment = Alignment.CenterVertically){
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "Favorite",
                tint = Color(0xFF6B3FA0),
                modifier = Modifier.size(24.dp)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Icon(
                imageVector = Icons.Filled.ShoppingCart,
                contentDescription = "Cart",
                tint = Color(0xFF6B3FA0),
                modifier = Modifier.size(24.dp)
            )
        }
        }
}

@Composable
fun SearchBar(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .background(Color(0xFFF5F5F5), shape = RoundedCornerShape(16.dp))
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = "Search Icon",
            tint = Color.Gray,
            modifier = Modifier.size(20.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = "Search 'Collection'",
            color = Color.Gray,
            fontSize = 14.sp,
            style = TextStyle()
        )
    }
}

@Composable
fun CategoryList(){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ){
        CategoryItem(imageRes = R.drawable.rings, title= "Rings")
        CategoryItem(imageRes = R.drawable.earrings, title = "Earrings")
        CategoryItem(imageRes = R.drawable.necklaces, title = "Necklaces")
        CategoryItem(imageRes = R.drawable.bracelets, title = "Bracelets & Bangles")
    }

    Spacer(modifier = Modifier.height(8.dp))

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ){
        CategoryItem(imageRes = R.drawable.latest, title = "Latest")
        CategoryItem(imageRes = R.drawable.everyday, title = "Everyday 22KT")
        CategoryItem(imageRes = R.drawable.silver, title = "Silver by Shaya")
        CategoryItem(imageRes = R.drawable.kt, title = "9KT")
    }

}

@Composable
fun CategoryItem(imageRes: Int, title: String){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(4.dp)
            .width(70.dp)
    ){
        Image(
            painter = painterResource(id= imageRes),
            contentDescription = title,
            modifier = Modifier
                .size(80.dp)
                .background(Color.LightGray, shape = RoundedCornerShape(8.dp))
        )
        Text(
            text = title,
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

@Composable
fun AutoSlidingImageSlider(){
    val image = listOf(
        R.drawable.luna,
        R.drawable.shaya,
        R.drawable.sol
        )

    val pagerState = rememberPagerState(pageCount = { image.size })
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        while (true){
            delay(9000)
            coroutineScope.launch {
                val nextPage = (pagerState.currentPage + 1) % image.size
                pagerState.animateScrollToPage(nextPage)
            }
        }
    }

    Column (
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        ) { page ->
            Image(
                painter = painterResource(id = image[page]),
                contentDescription = "Jewelry Banner $page",
                modifier = Modifier.fillMaxWidth()
            )
        }
    }

}

@Composable
fun gold(){
        Image(
            painter = painterResource(id = R.drawable.freegold),
            contentDescription = "Free Gold",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
    }

@Composable
fun StillThinkingSection(){

    val recentlyViewedItems = listOf(
        RecentlyViewedItem(R.drawable.recently, "9,486", "10,722", "Luna Gemstone Stud"),
        RecentlyViewedItem(R.drawable.shayaa, "8,999", "10,000", "Shaya Diamond Ring"),
        RecentlyViewedItem(R.drawable.sola, "10,500", "12,000", "Sol Gold Earrings")
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF5F0FF), shape = RoundedCornerShape(12.dp))
            .padding(16.dp)
    ){
        Row(verticalAlignment = Alignment.CenterVertically){
            Icon(
                imageVector = Icons.Filled.AccessTime,
                contentDescription = "Default clock icon",
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Still Thinking about these?",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }

        Text(
            text = "Look back at your recent browser designs",
            fontSize = 12.sp,
            color = Color.Gray,
            modifier = Modifier.padding(top = 4.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxWidth()
        ){
            items(recentlyViewedItems) { item ->
                RecentlyViewedItem(item = item)
            }
        }

    }

}

data class RecentlyViewedItem(
    val imageRes: Int,
    val currentPrice: String,
    val oldPrice: String,
    val title: String
)

@Composable
fun RecentlyViewedItem(item: RecentlyViewedItem) {
    Column(
        modifier = Modifier
            .width(120.dp)
            .background(Color.White, shape = RoundedCornerShape(8.dp))
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = item.imageRes),
            contentDescription = item.title,
            modifier = Modifier
                .size(80.dp)
                .background(Color.LightGray, shape = RoundedCornerShape(8.dp))
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = item.currentPrice,
            fontSize = 12.sp,
            color = Color.Black,
        )

        Text(
            text = item.oldPrice,
            fontSize = 12.sp,
            color = Color.Gray,
            style = TextStyle(textDecoration = TextDecoration.LineThrough)
        )

        Text(
            text = item.title,
            fontSize = 10.sp,
            color = Color.Gray,
            maxLines = 1
        )

    }
}

@Composable
fun GoldSavingBanner(){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = 4.dp
    ){
        Column(
            modifier = Modifier
                .background(Color(0xFF0A74DA))
                .padding(16.dp)
        ){
            Image(
                painter = painterResource(id = R.drawable.goldsaving),
                contentDescription = "Gold Saving Scheme",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                contractScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Gold Saving Scheme (PoP!)",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 18.sp
            )

            Text(
                text = "Complete 9 installments and enjoy the 10th one Free!",
                color = Color.White,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = { },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
            ) {
                Text("ENROLL NOW", color = Color.Blue)
            }

        }

    }
}




