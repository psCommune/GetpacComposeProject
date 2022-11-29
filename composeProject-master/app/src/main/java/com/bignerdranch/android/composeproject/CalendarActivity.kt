package com.bignerdranch.android.composeproject

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.CalendarView
import android.widget.DatePicker
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.bignerdranch.android.composeproject.ui.theme.BackGroundColor
import com.bignerdranch.android.composeproject.ui.theme.ComposeProjectTheme
import java.util.*

class CalendarActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeProjectTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = BackGroundColor
                ) {
                    Greeting5("Календарь")
                }
            }
        }
    }
}

@Composable
fun Greeting5(name: String) {
    Column(modifier = Modifier.padding(20.dp,20.dp,20.dp,0.dp)) {
        Row {
            CreateHeading(text = name)
            Spacer(modifier = Modifier.width(180.dp))
            CreateMiniAvatar(ProfileActivity())
        }
        Row{
            CreateSecondCalendar()
        }
        Column(verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()){
            CreateBottomPanel(false, false, true, false)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview5() {
    ComposeProjectTheme {
        Greeting5("Календарь")
    }
}