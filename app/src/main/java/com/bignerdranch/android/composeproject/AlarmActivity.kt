package com.bignerdranch.android.composeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bignerdranch.android.composeproject.ui.theme.BackGroundColor
import com.bignerdranch.android.composeproject.ui.theme.ComposeProjectTheme

class AlarmActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeProjectTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = BackGroundColor
                ) {
                    Greeting10("Будильник")
                }
            }
        }
    }
}

@Composable
fun Greeting10(name: String) {
    Column(modifier = Modifier.padding(20.dp, 20.dp, 20.dp, 0.dp)) {
        Row {
            CreateHeading(text = name)
            Spacer(modifier = Modifier.width(180.dp))
            CreateMiniAvatar(ProfileActivity())
        }
        Spacer(modifier = Modifier.height(48.dp))
        Column() {
            CreateGroupSwitch(false, "07:30")
            CreateGroupSwitch(true, "08:00")
        }
        //Spacer(modifier = Modifier.height(230.dp))
        //CreateButton(text = "Добавить будильник", activ = CreateAlarm())
        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            CreateButton(text = "Добавить будильник", activ = CreateAlarm())
            Spacer(modifier = Modifier.height(32.dp))
            CreateBottomPanel(false, true, false, false)
        }
    }
}