package com.bignerdranch.android.composeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bignerdranch.android.composeproject.ui.theme.BackGroundColor
import com.bignerdranch.android.composeproject.ui.theme.ComposeProjectTheme

class RegistrationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeProjectTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = BackGroundColor
                ) {
                    Greeting2("Регистрация")
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String) {
    Column(modifier = Modifier.padding(20.dp,20.dp,20.dp,0.dp)) {
        Row {
            CreateHeading(text = name)
            Spacer(modifier = Modifier.width(160.dp))
            CreateIconButton(SettingsActivity())
        }
        Spacer(modifier = Modifier.height(200.dp))
        Row {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()) {
                Column {
                    CreateTextField(text = stringResource(R.string.user_name), false)
                    Spacer(modifier = Modifier.height(16.dp))
                    CreateTextField(text = stringResource(R.string.user_email), false)
                    Spacer(modifier = Modifier.height(16.dp))
                    CreateTextField(text = stringResource(R.string.user_password), true)
                    Spacer(modifier = Modifier.height(16.dp))
                    CreateButton(text = name, ProfileActivity())
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    ComposeProjectTheme {
        Greeting2("регистрация")
    }
}