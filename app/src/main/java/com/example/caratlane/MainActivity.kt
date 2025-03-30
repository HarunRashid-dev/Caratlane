package com.example.caratlane

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
import androidx.compose.material.icons.Icons
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
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF5F0FF), shape = RoundedCornerShape(12.dp))
            .padding(16.dp)
    ){
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.clock),
                contentDescription = "Clock Icon",
                tint = Color(0xFF6B44C5),
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
            items(3) { index ->
                RecentlyViewItem()
            }
        }

    }
}

@Composable
fun RecentlyViewItem() {
    Column(
        modifier = Modifier
            .width(120.dp)
            .background(Color.White, shape = RoundedCornerShape(8.dp))
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.only),
            contentDescription = "only for me ring",
            modifier = Modifier
                .size(80.dp)
                .background(Color.LightGray, shape = RoundedCornerShape(8.dp))
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "₹9,486",
            fontSize = 12.sp,
            color = Color.Black,
        )

        Text(
            text = "₹10,722",
            fontSize = 12.sp,
            color = Color.Gray,
            style = TextStyle(textDecoration = TextDecoration.LineThrough)
        )

        Text(
            text = "Zayn Gemstone Stud",
            fontSize = 10.sp,
            color = Color.Gray,
            maxLines = 1
        )
    }
}





