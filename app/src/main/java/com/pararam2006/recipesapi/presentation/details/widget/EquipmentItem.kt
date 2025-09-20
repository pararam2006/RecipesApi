package com.pararam2006.recipesapi.presentation.details.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.pararam2006.recipesapi.domain.dto.EquipmentDto

@Composable
fun EquipmentItem(
    equipment: EquipmentDto
) {
    val url = equipment.image
    Column(
        modifier = Modifier
            .height(80.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = rememberAsyncImagePainter(url),
            contentDescription = equipment.name,
            modifier = Modifier.size(50.dp),
            contentScale = ContentScale.FillBounds,
        )
        Text(equipment.name)
    }
}