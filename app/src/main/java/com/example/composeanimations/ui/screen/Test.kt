package com.example.composeanimations.ui.screen

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Test() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .verticalScroll(
                state = rememberScrollState(),
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var isIncreased by remember {
            mutableStateOf(true)
        }
        val size by animateDpAsState(targetValue =  if (isIncreased) 200.dp else 100.dp, label = "")

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { isIncreased = !isIncreased }
        ) {
            Text(
                text = "Animate size",
            )
        }
        AnimatedContainer(
            text = "Size",
            size = size
        )

        var isRect by remember {
            mutableStateOf(true)
        }
        val radius by animateIntAsState(targetValue =  if (isRect) 4 else 50, label = "")

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { isRect = !isRect }
        ) {
            Text(
                text = "Animate shape",
            )
        }
        AnimatedContainer(
            text = "Shape",
            radiusPercent = radius
        )

        var isSelected by remember {
            mutableStateOf(false)
        }
        val borderWidth by animateDpAsState(targetValue =  if (isSelected) 4.dp else 0.dp, label = "")

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { isSelected = !isSelected}
        ) {
            Text(
                text = "Animate border",
            )
        }
        AnimatedContainer(
            text = "Border",
            borderWidth = borderWidth
        )

        var isColored by remember {
            mutableStateOf(false)
        }
        val color by animateColorAsState(targetValue =  if (isColored) Color.Magenta else Color.Blue, label = "")

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { isColored = !isColored}
        ) {
            Text(
                text = "Animate color",
            )
        }
        AnimatedContainer(
            text = "Color",
            color = color
        )

        var isVisible by remember {
            mutableStateOf(true)
        }
        val visibility by animateFloatAsState(targetValue =  if (isVisible) 1f else 0f, label = "")
        
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { isVisible = !isVisible}
        ) {
            Text(
                text = "Animate visibility",
            )
        }
        AnimatedContainer(
            text = "Visibility",
            visibility = visibility
        )
    }
}

@Composable
private fun AnimatedContainer(
    text: String,
    size: Dp = 200.dp,
    radiusPercent: Int = 4,
    borderWidth: Dp = 0.dp,
    color: Color = Color.Blue,
    visibility: Float = 1f
) {
    Box(
        modifier = Modifier
            .alpha(visibility)
            .clip(RoundedCornerShape(radiusPercent))
            .border(width = borderWidth, color = Color.Black)
            .background(color)
            .size(size),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = Color.White
        )
    }
}