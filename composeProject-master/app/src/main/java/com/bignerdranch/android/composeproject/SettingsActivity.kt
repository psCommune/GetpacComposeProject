package com.bignerdranch.android.composeproject

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bignerdranch.android.composeproject.ui.theme.BackGroundColor
import com.bignerdranch.android.composeproject.ui.theme.ComposeProjectTheme

class SettingsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeProjectTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = BackGroundColor
                ) {
                    Greeting4("Настройки")
                }
            }
        }
    }
}

@Composable
fun Greeting4(name: String) {
    Column(modifier = Modifier.padding(20.dp,20.dp,20.dp,0.dp)) {
        Row {
            CreateHeading(text = name)
            Spacer(modifier = Modifier.width(180.dp))
            CreateMiniAvatar(ProfileActivity())
        }
        Spacer(modifier = Modifier.height(48.dp))
        Row {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()) {
                Column {
                    Box(modifier = Modifier.fillMaxWidth()) {
                        CreateSettingsButton(activ = ProfileActivity())
                        //CreateTextView(text = stringResource(R.string.setting_1))
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Box(modifier = Modifier.fillMaxWidth()) {
                        CreateDateTimeButton(activ = SettingsActivity())
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Box(modifier = Modifier.fillMaxWidth()) {
                        CreateSoundButton(activ = SettingsActivity())
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Box(modifier = Modifier.fillMaxWidth()) {
                        CreateCheckUpdateButton(activ = SettingsActivity())
                    }
                }
            }
        }
        Column(verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()){
            CreateBottomPanel(false, false, false, true)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    ComposeProjectTheme {
        Greeting4("Android")
    }
}