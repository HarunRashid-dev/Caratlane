package com.example.caratlane

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ){
        HeaderSection()

        Spacer(modifier = Modifier.height(1.dp))

        SearchBar()

        Spacer(modifier = Modifier.height(5.dp))

        CategoryList()

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







