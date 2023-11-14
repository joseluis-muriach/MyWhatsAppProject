package com.example.mywhatsappproject

import androidx.compose.animation.graphics.ExperimentalAnimationGraphicsApi
import androidx.compose.animation.graphics.res.animatedVectorResource
import androidx.compose.animation.graphics.res.rememberAnimatedVectorPainter
import androidx.compose.animation.graphics.vector.AnimatedImageVector
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale

@OptIn(ExperimentalAnimationGraphicsApi::class)
@Composable
fun floatingButtom(){
    FloatingActionButton(onClick = {},
        containerColor = Color(0xFF027A58)
    ) {
        val image =
            AnimatedImageVector.animatedVectorResource(R.drawable.add_rotation
            )
        var atEnd by remember { mutableStateOf(false) }
        Image(
            painter = rememberAnimatedVectorPainter(image, atEnd),
            contentDescription = "VectorDrawable",
            modifier = Modifier.clickable {
                atEnd = !atEnd
            },
            contentScale = ContentScale.Crop,
        )
    }
}