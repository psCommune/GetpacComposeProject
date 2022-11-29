package com.bignerdranch.android.composeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bignerdranch.android.composeproject.ui.theme.BackGroundColor
import com.bignerdranch.android.composeproject.ui.theme.ComposeProjectTheme

class ProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeProjectTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = BackGroundColor
                ) {
                    Greeting3("Профиль пользователя")
                }
            }
        }
    }
}

@Composable
fun Greeting3(name: String) {
    Column(modifier = Modifier.padding(20.dp,20.dp,20.dp,0.dp)) {
        Row {
            CreateHeading(text = name)
            Spacer(modifier = Modifier.width(40.dp))
            CreateIconButton(SettingsActivity())
        }
        Column() {
            Spacer(
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
            )
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()) {
                CreateBigAvatar()
            }
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()) {
                Spacer(modifier = Modifier.height(100.dp))
                CreateTextView(text = stringResource(R.string.No_log))
            }
            Spacer(modifier = Modifier.height(16.dp))
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()) {
                CreateButton(text = stringResource(R.string.button_login), activ = LogInActivity())
            }
            Spacer(modifier = Modifier.height(16.dp))
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()) {
                CreateButton(text = stringResource(R.string.button_reg), activ = RegistrationActivity())
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    ComposeProjectTheme {
        Greeting3("Профиль пользователя")
    }
}