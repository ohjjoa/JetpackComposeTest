package com.example.jetpackcomposetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposetest.ui.theme.JetpackComposeTestTheme

// Box = FrameLayout 으로 이해 하자
class ThirdActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 자식들 contentAlignment = Alignment.TopEnd 상단의 우측 정렬 해라
        setContent {
            Box(
                modifier = Modifier
                    .background(color = Color.Cyan)
                    .fillMaxWidth()
                    .height(200.dp),
//                contentAlignment = Alignment.TopEnd
            ) {
               // 자식들
               Text("hello")
               Box(
                   modifier = Modifier.fillMaxSize()
                       .padding(16.dp),
                   contentAlignment = Alignment.BottomEnd
               ) {
                   Text("1121212~~~~~~~~~~")
               }
            }
        }
    }
}
