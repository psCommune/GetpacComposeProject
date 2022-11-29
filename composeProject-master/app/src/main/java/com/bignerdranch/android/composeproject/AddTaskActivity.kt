package com.bignerdranch.android.composeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bignerdranch.android.composeproject.ui.theme.BackGroundColor
import com.bignerdranch.android.composeproject.ui.theme.ComposeProjectTheme

class AddTaskActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeProjectTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = BackGroundColor
                ) {
                    Greeting7("Добавить задачу")
                }
            }
        }
    }
}

@Composable
fun Greeting7(name: String) {
    Column(modifier = Modifier.padding(20.dp,20.dp,20.dp,0.dp)) {
        Row {
            CreateHeading(text = name)
            Spacer(modifier = Modifier.width(96.dp))
            CreateIconButton(GeneralActivity())
        }
        Spacer(modifier = Modifier.height(48.dp))
        Column(){
            Row() {
                CreateTextField(text = "Заголовок задачи", pass = false)
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row() {
                Column {
                    CreateDateTime(text = "16:30", true)
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    CreateDateTime(text = "14.01.2021", false)
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row() {
                CreateBigTextField(text = "Описание задачи")
            }
        }
        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            CreateButton(text = "Записать задачу", activ = GeneralActivity())
            Spacer(modifier = Modifier.height(64.dp))
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview7() {
    ComposeProjectTheme {
        Greeting7("Добавить задачу")
    }
}