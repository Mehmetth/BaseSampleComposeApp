package com.mehmetpetek.basesampleapp.features.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.mehmetpetek.basesampleapp.data.remote.Memes

@Composable
fun CardItem(
    memes: Memes,
    detailClick: (Memes) -> Unit,
    modifier: Modifier = Modifier
) {
    val showShimmer = remember { mutableStateOf(true) }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { detailClick(memes) },
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp,
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.Black,
        ),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = memes.url,
                contentDescription = "",
                contentScale = ContentScale.Crop,
                onSuccess = { showShimmer.value = false },
                modifier = Modifier
                    .size(200.dp)
                    .clip(RoundedCornerShape(15.dp))
                    .background(shimmerBrush(targetValue = 1300f, showShimmer = showShimmer.value))
            )
            Text(
                text = if (showShimmer.value) "" else memes.name,
                style = TextStyle(
                    color = Color.White,
                    fontSize = 17.sp
                ),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(5.dp)
                    .clip(RoundedCornerShape(15.dp))
                    .fillMaxWidth()
                    .background(shimmerBrush(targetValue = 1300f, showShimmer = showShimmer.value))
            )
        }
    }
}