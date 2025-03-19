package com.example.a0319

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a0319.ui.theme.導航實習0319Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            導航實習0319Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MultiplicationTable(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MultiplicationTable(modifier: Modifier = Modifier) {
    val tableItems = (1..9).flatMap { i ->
        (1..9).map { j -> "$i × $j = ${i * j}" }
    }

    LazyColumn(modifier = modifier.padding(16.dp)) {
        items(tableItems) { item ->
            Text(text = item, modifier = Modifier.padding(vertical = 4.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MultiplicationTablePreview() {
    導航實習0319Theme {
        MultiplicationTable()
    }
}