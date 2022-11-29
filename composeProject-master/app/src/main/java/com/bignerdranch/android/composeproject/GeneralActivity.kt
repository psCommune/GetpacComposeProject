package com.bignerdranch.android.composeproject

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bignerdranch.android.composeproject.*
import com.bignerdranch.android.composeproject.ui.theme.BackGroundColor
import com.bignerdranch.android.composeproject.ui.theme.ui.theme.ComposeProjectTheme

class GeneralActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeProjectTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = BackGroundColor
                ) {
                    Greeting9("Список дел")
                }
            }
        }
    }
}

@Composable
fun Greeting9(name: String) {
    Column(modifier = Modifier.padding(20.dp,20.dp,20.dp,0.dp)) {
        Row {
            CreateHeading(text = name)
            Spacer(modifier = Modifier.width(180.dp))
            CreateMiniAvatar(ProfileActivity())
        }
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()) {
            Column() {
                Spacer(modifier = Modifier.height(32.dp))
                Taskcard(
                    "Вечерний поход в кино",
                    "Идём в кино с колегами!",
                    "10.02.2021",
                    "19:40")
                Spacer(modifier = Modifier.height(16.dp))
                Taskcard(
                    "Забрать заказ с озон",
                    "Пункт выдачи на ул. Ленина, 103",
                    "10.02.2021",
                    "19:40"
                )
                Spacer(modifier = Modifier.height(16.dp))
                Taskcard(
                    Uper = "Запись в автосервис",
                    Lower = "Сдать автомобиль в автосервис на ул. Бисер, д. 14, замена масла",
                    Data = "10.02.2021",
                    Time = "19:40"
                )
            }
        }
        Spacer(modifier = Modifier.height(200.dp))
        CreateButton(text = "Добавить задачу", activ = AddTaskActivity())
        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            CreateBottomPanel(true, false, false,false)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview9() {
    ComposeProjectTheme {
        Greeting9("Список дел")
    }
}