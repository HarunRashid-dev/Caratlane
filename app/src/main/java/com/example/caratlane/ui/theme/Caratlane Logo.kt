package com.example.caratlane.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.caratlane.R

@Preview(showBackground = true)
@Composable
fun Caratlane() {
    Image(painter = painterResource(id = R.drawable.logo),
        contentDescription = "Logo")
}