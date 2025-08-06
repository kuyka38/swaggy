package com.kunji.swaggy.ui.screens.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.kunji.swaggy.R
import com.kunji.swaggy.ui.theme.newgreen

@Composable
fun DashboardScreen2(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // Top Card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp),
            shape = RoundedCornerShape(bottomStart = 56.dp),
            colors = CardDefaults.cardColors(newgreen)
        ) {
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "",
                        tint = Color.White
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Crypto Currency",
                    color = Color.White.copy(alpha = 0.8f),
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                )

                Text(
                    text = "Landing page",
                    color = Color.White.copy(alpha = 0.8f),
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier.padding(top = 16.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.girl),
                        contentDescription = "girl",
                        modifier = Modifier
                            .width(60.dp)
                            .height(60.dp),
                        contentScale = ContentScale.Crop
                    )

                    Text(
                        text = "Samantha",
                        color = Color.White.copy(alpha = 0.8f),
                        style = MaterialTheme.typography.bodySmall,
                        fontSize = 16.sp
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "A soft mist drifted through the forest, weaving between mossy roots and quiet ferns. Sunlight broke through the leaves in scattered beams, casting golden patterns on the ground.",
                    color = Color.White.copy(alpha = 0.8f),
                    fontSize = 15.sp,
                    modifier = Modifier.width(250.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // File Grid (no loops, separate cards)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                FileCard("Layout Docs", "PDF • 10MB", R.drawable.adobe, Color(0xFFFFE0E0))
                FileCard("Presentation", "MOV • 10MB", R.drawable.videos, Color(0xFFDCEBFF))
                FileCard("All Assets", "ZIP • 10MB", R.drawable.assets, Color(0xFFFFE9CC))
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                FileCard("Layout Docs", "WAV • 10MB", R.drawable.layout, Color(0xFFE5D9FF))
                FileCard("Layout Docs", "XLS • 10MB", R.drawable.xcel, Color(0xFFD9F7E0))
                FileCard("Layout Docs", "DOCX • 10MB", R.drawable.windows, Color(0xFFDCEEFF))
            }
        }
    }
}

@Composable
fun FileCard(title: String, subtitle: String, imageResId: Int, backgroundColor: Color) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(90.dp)
    ) {
        Box(
            modifier = Modifier
                .size(60.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(backgroundColor),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = null,
                modifier = Modifier.size(30.dp)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = title,
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = subtitle,
            fontSize = 12.sp,
            color = Color.Gray
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DashboardScreen2Preview() {
    DashboardScreen2(navController = rememberNavController())
}
