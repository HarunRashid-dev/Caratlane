package com.example.caratlane.ui.theme

import android.R.attr.contentDescription
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.caratlane.R

@Preview(showBackground = true)
@Composable
fun Caratlane() {
    Image(painter = painterResource(id = R.drawable.logo),
        contentDescription = "Logo",
        modifier = Modifier
        .size(60.dp)
        .padding(8.dp)
            .align(Alignment.TopStart)
    )
}