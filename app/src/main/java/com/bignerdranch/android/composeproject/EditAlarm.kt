package com.bignerdranch.android.composeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bignerdranch.android.composeproject.ui.theme.BackGroundColor
import com.bignerdranch.android.composeproject.ui.theme.ComposeProjectTheme

class EditAlarm : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeProjectTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = BackGroundColor
                ) {
                    Greeting6("Изменить будильник")
                }
            }
        }
    }
}

@Composable
fun Greeting6(name: String) {
Column(modifier = Modifier.padding(20.dp,20.dp,20.dp,0.dp)) {
    Row {
        Column {
            CreateHeading(text = name)
        }
        Spacer(modifier = Modifier.width(64.dp))
        Column {
            CreateIconButton(AlarmActivity())
        }
    }
    Spacer(modifier = Modifier.height(32.dp))
    Column {
        Row {
            Column {
                CreateDateTime(text = "16:30", true)
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                CreateDateTime(text = "14.01.2021",false)
            }
        }
        Spacer(modifier = Modifier.height(24.dp))
        Row{
            Box(modifier = Modifier.fillMaxWidth()){
                Column {
                    CreateTextView(text = "Повторять каждый")
                    Spacer(modifier = Modifier.height(24.dp))
                    CreateCheckBox(text = "Понедельник")
                    Spacer(modifier = Modifier.height(16.dp))
                    CreateCheckBox(text = "Вторник")
                    Spacer(modifier = Modifier.height(16.dp))
                    CreateCheckBox(text = "Среда")
                    Spacer(modifier = Modifier.height(16.dp))
                    CreateCheckBox(text = "Четверг")
                    Spacer(modifier = Modifier.height(16.dp))
                    CreateCheckBox(text = "Пятница")
                    Spacer(modifier = Modifier.height(16.dp))
                    CreateCheckBox(text = "Суббота")
                    Spacer(modifier = Modifier.height(16.dp))
                    CreateCheckBox(text = "Воскресенье")
                }
            }
        }
        Column(verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()){
            CreateButton(text = "Создать будильник", activ = AddTaskActivity())
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview6() {
    ComposeProjectTheme {
        Greeting6("Изменить будильник")
    }
}