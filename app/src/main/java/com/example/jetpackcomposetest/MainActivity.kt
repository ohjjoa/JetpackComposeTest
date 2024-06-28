package com.example.jetpackcomposetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposetest.ui.theme.JetpackComposeTestTheme

// Column, Row, Text = Column, Row 는 LinearLayout 으로 이해 하자
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTestTheme {
               Surface(color = MaterialTheme.colorScheme.background) {
                   // 수직 배열
//                   Column {
//                       Text("hollo")
//                       Text("word")
//                   }
                   // 수평 배열
                   // Spacer 간격조절
//                   Row {
//                       Text("hollo")
//                       Spacer(Modifier.width(16.dp))
//                       Text("word")
//                   }
                   // modify 크기 및 각 속성들 조절 가능
                   // fillMaxSize 화면 전체 체우기
                   // horizontalAlignment 속성의 정렬
                   Column(
                       modifier = Modifier
                           .fillMaxSize()
                           .background(color = Color.Blue)
                           .padding(16.dp),
                       horizontalAlignment = Alignment.CenterHorizontally,
                   ) {
                       Text("hollo")
                       Text("world")
                   }
               }
            }
        }
    }
}
