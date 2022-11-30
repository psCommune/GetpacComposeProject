package com.bignerdranch.android.composeproject

import android.content.Intent
import android.os.Bundle
import android.widget.CalendarView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.Shapes
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.bignerdranch.android.composeproject.ui.theme.*

class AllComposablesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeProjectTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                }
            }
        }
    }
}

@Composable
fun CreateHeading(text: String)
{
    Text(text = text, fontSize = 24.sp, color = Color.White, fontWeight = FontWeight.Bold)
}

@Composable
fun CreateTextView(text: String)
{
    Text(text = text, fontSize = 16.sp, color = Color.White)
}

@Composable
fun CreateTextField(text: String, pass: Boolean) {
    var password by rememberSaveable { mutableStateOf("") }
    if (pass == true) {
        Box(
            modifier = Modifier
                .background(BackGroundColor)
                .size(340.dp, 54.dp)
                .clip(RoundedCornerShape(15.dp))
        ) {
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                placeholder = { Text(text) },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier
                    .background(Color.White)
                    .size(340.dp, 54.dp)
                    .clip(RoundedCornerShape(15.dp))
            )
        }
    } else {
        Box(
            modifier = Modifier
                .background(BackGroundColor)
                .size(340.dp, 54.dp)
                .clip(RoundedCornerShape(15.dp))
        ) {
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                placeholder = { Text(text) },
                modifier = Modifier
                    .background(Color.White)
                    .size(340.dp, 54.dp)
                    .clip(RoundedCornerShape(15.dp))
            )
        }
    }
}

@Composable
fun CreateButton(text: String, activ: ComponentActivity)
{
    val context = LocalContext.current
    Button(onClick = {
        context.startActivity(Intent(context, activ::class.java))},
        Modifier
            .size(340.dp, 54.dp)
            .clip(RoundedCornerShape(15)),
        colors = ButtonDefaults.buttonColors(GreenButtonColor)) {
        Text(text = text, fontSize = 24.sp, color = Color.White)
    }
}
@Composable
fun CreateIconButton(activ: ComponentActivity)
{
    val context = LocalContext.current
    IconButton(onClick = {context.startActivity(Intent(context, activ::class.java))}) {
        Image(painter = painterResource(R.drawable.back_button), contentDescription = "",
            Modifier
                .size(40.dp, 40.dp))
    }
}

@Composable
fun CreateBigAvatar()
{
    Image(painter = painterResource(R.drawable.big_avatar), contentDescription = "",
        Modifier
            .size(200.dp, 200.dp)
            .clip(CircleShape)
    )
}

@Composable
fun CreateDateTime(text: String, images: Boolean)
{
    var password by rememberSaveable { mutableStateOf("") }
    Box(modifier = Modifier
        .background(BackGroundColor)
        .clip(RoundedCornerShape(15.dp))){
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            placeholder = { Text(text) },
            modifier = Modifier
                .background(Color.White)
                .size(160.dp, 54.dp)
                .clip(RoundedCornerShape(15.dp)),
            leadingIcon = {
                if (images == true)
                {
                    Icon(painter = painterResource(R.drawable.mini_clock), contentDescription = "clock", modifier = Modifier.size(16.dp))
                }
                else if (images == false)
                {
                    Icon(painter = painterResource(R.drawable.mini_calendar), contentDescription = "clock", modifier = Modifier.size(16.dp))
                }
            }
        )
    }
}

@Composable
fun CreateCheckBox(text: String)
{
    val checkedState = remember { mutableStateOf(false) }
    Row{
        Box(
            Modifier
                .background(Color.White)
                .size(18.dp)){
            Checkbox(
                checked = checkedState.value,
                onCheckedChange = { checkedState.value = it },
                colors = CheckboxDefaults.colors(
                    uncheckedColor = Color.Yellow
                )
            )
        }
        Text(text, fontSize = 16.sp, color = Color.White, modifier = Modifier.padding(8.dp,0.dp,0.dp,0.dp))
    }
}

@Composable
fun CreateMiniAvatar(activ: ComponentActivity)
{
    val context = LocalContext.current
    IconButton(onClick = {context.startActivity(Intent(context, activ::class.java))}) {
        Image(painter = painterResource(R.drawable.mini_avatar), contentDescription = "",
            Modifier
                .size(48.dp, 48.dp)
        )
    }
}

@Composable
fun CreateSecondCalendar()
{
    AndroidView({ CalendarView(it) },
        modifier = Modifier.wrapContentWidth(),
        update = { views ->
            views.setOnDateChangeListener { calendarView, i, i2, i3 ->
            }
        }
    )
}

@Composable
fun CreateSettingsButton(activ: ComponentActivity)
{
    val context = LocalContext.current
    TextButton(onClick = { context.startActivity(Intent(context, activ::class.java)) }) {
        Text(
            text = "Профиль пользователя      >",
            fontSize = 22.sp,
            color = Color.White,
        )
    }
}
@Composable
fun CreateDateTimeButton()
{
    val context = LocalContext.current
    TextButton(onClick = { }) {
        Text(
            text = "Дата и время                       >",
            fontSize = 22.sp,
            color = Color.White,
        )
    }
}
@Composable
fun CreateSoundButton()
{
    val context = LocalContext.current
    TextButton(onClick = { }) {
        Text(
            text = "Настройки звука                 >",
            fontSize = 22.sp,
            color = Color.White,
        )
    }
}
@Composable
fun CreateCheckUpdateButton()
{
    val context = LocalContext.current
    TextButton(onClick = { }) {
        Text(
            text = "Проверить обновления      >",
            fontSize = 22.sp,
            color = Color.White,
        )
    }
}

@Composable
fun CreatetextButton(text: String)
{
    val context = LocalContext.current
    TextButton(onClick = { context.startActivity(Intent(context, EditAlarm::class.java)) }) {
        Text(
            text = text,
            fontSize = 48.sp,
            color = Color.White,
        )
    }
}

@Composable
fun BottomList(activ: ComponentActivity, images: Boolean)
{
    val context = LocalContext.current
    IconButton(onClick = {context.startActivity(Intent(context, activ::class.java))}) {
        if (images)
        {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(painter = painterResource(R.drawable.list_element_activ), contentDescription = "",
                    Modifier
                        .size(32.dp))
                Text(text = "List", color = BackGroundColor, fontSize = 12.sp)
            }

        }
        else if(!images)
        {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(R.drawable.list_element), contentDescription = "",
                    Modifier
                        .size(32.dp))
                Text(text = "List", color = Color.Red, fontSize = 12.sp)
            }
        }
    }
}
@Composable
fun BottomAlarm(activ: ComponentActivity, images: Boolean)
{
    val context = LocalContext.current
    IconButton(onClick = {context.startActivity(Intent(context, activ::class.java))}) {
        if (images == true)
        {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(R.drawable.clock_element_activ),
                    contentDescription = "",
                    Modifier
                        .size(32.dp))
                Text(text = "Alarm", color = BackGroundColor, fontSize = 12.sp)
            }
        }
        else if(images == false)
        {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(R.drawable.clock_element), contentDescription = "",
                    Modifier
                        .size(32.dp))
                Text(text = "Alarm", color = Color.Red, fontSize = 12.sp)
            }
        }
    }
}
@Composable
fun BottomCalendar(activ: ComponentActivity, images: Boolean)
{
    val context = LocalContext.current
    IconButton(onClick = {context.startActivity(Intent(context, activ::class.java))}) {
        if (images == true)
        {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(R.drawable.calendar_element_activ),
                    contentDescription = "",
                    Modifier
                        .size(32.dp))
                Text(text = "Calendar", color = BackGroundColor, fontSize = 12.sp)
            }
        }
        else if(images == false)
        {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(R.drawable.calendar_element), contentDescription = "",
                    Modifier
                        .size(32.dp))
                Text(text = "Calendar", color = Color.Red, fontSize = 12.sp)
            }
        }
    }
}
@Composable
fun BottomSettings(activ: ComponentActivity, images: Boolean)
{
    val context = LocalContext.current
    IconButton(onClick = {context.startActivity(Intent(context, activ::class.java))}) {
        if (images == true)
        {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(R.drawable.settings_element_activ),
                    contentDescription = "",
                    Modifier
                        .size(32.dp))
                Text(text = "Settings", color = BackGroundColor, fontSize = 12.sp)
            }
        }
        else if(images == false)
        {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(R.drawable.settings_element), contentDescription = "",
                    Modifier
                        .size(32.dp))
                Text(text = "Settings", color = Color.Red, fontSize = 12.sp)
            }
        }
    }
}

@Composable
fun CreateBottomPanel(images1: Boolean,images2: Boolean,images3: Boolean,images4: Boolean) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .height(72.dp)
            .width(288.dp)
            .clip(RoundedCornerShape(25.dp, 25.dp, 0.dp, 0.dp))
            .background(GreenButtonColor)
    )
    {
        Row()
        {
            BottomList(activ = GeneralActivity(),images1)
            Spacer(modifier = Modifier.width(16.dp))
            BottomAlarm(activ = AlarmActivity(), images2)
            Spacer(modifier = Modifier.width(16.dp))
            BottomCalendar(activ = CalendarActivity(), images3)
            Spacer(modifier = Modifier.width(16.dp))
            BottomSettings(activ = SettingsActivity(), images4)
        }
    }
}

@Composable
fun Taskcard(Uper:String, Lower:String, Data:String, Time:String){
    val context = LocalContext.current
    Card(shape = Shapes.large,
        modifier = Modifier
            .size(330.dp, 90.dp)
            .clickable { context.startActivity(Intent(context, EditTaskActivity::class.java)) },
        elevation = 10.dp,
        backgroundColor = Yellow2){
        Column(horizontalAlignment = Alignment.Start, modifier = Modifier.padding(16.dp, 12.dp, 0.dp, 0.dp)) {
            Text(Uper, fontSize = 16.sp, color = Color.White, fontWeight = FontWeight.Bold)
            Text(modifier = Modifier.width(248.dp), text =  Lower, maxLines = 2, fontSize = 11.sp, color = Gray2)
        }
        Column(horizontalAlignment =  Alignment.End, modifier = Modifier.padding(0.dp, 17.dp, 8.dp, 0.dp)) {
            Column(horizontalAlignment = Alignment.Start) {
                Text(Data, fontSize = 11.sp, color = Gray2)
                Text(Time, fontSize = 11.sp, color = Gray2)
            }
        }
    }
}

@Composable
fun CustomSwitch(
    switchPadding: Dp,
    buttonWidth: Dp,
    buttonHeight: Dp,
    value: Boolean
){
    val switchSize by remember{
        mutableStateOf(buttonHeight-switchPadding*2)
    }
    val interactionSource = remember {
        MutableInteractionSource()
    }
    var switchClicker by remember { mutableStateOf(value) }
    var padding by remember { mutableStateOf(0.dp) }
    padding = if(switchClicker) buttonWidth-switchSize-switchPadding*2 else 0.dp
    val animateSize by animateDpAsState(
        targetValue =
        if(switchClicker) padding else 0.dp,
        tween(durationMillis = 200,
            delayMillis = 0,
            easing = LinearOutSlowInEasing
        )
    )
    Box(modifier = Modifier
        .width(buttonWidth)
        .height(buttonHeight)
        .clip(CircleShape)
        .background(if (switchClicker) OnSwitch else OffSwitch)
        .clickable(
            interactionSource = interactionSource,
            indication = null
        ) {
            switchClicker = !switchClicker
        })
    {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(switchPadding))
        {
            Box(modifier = Modifier
                .fillMaxHeight()
                .width(animateSize)
                .background(Color.Transparent))
            Box(modifier = Modifier
                .size(switchSize)
                .clip(CircleShape)
                .background(Color.White)
            )
        }
    }
}

@Composable
fun CreateGroupSwitch(OffOrOn: Boolean, text: String)
{
    Box() {
        Box(contentAlignment = Alignment.TopStart) {
            CreatetextButton(text = text)
        }
        Box(
            Modifier
                .padding(16.dp)
                .fillMaxWidth(), contentAlignment = Alignment.TopEnd
        ) {
            CustomSwitch(
                switchPadding = 12.dp,
                buttonWidth = 96.dp,
                buttonHeight = 48.dp,
                value = OffOrOn
            )
        }
    }
}

@Composable
fun CreateBigTextField(text: String)
{
    var password by rememberSaveable { mutableStateOf("") }
    Box(
        modifier = Modifier
            .background(BackGroundColor)
            .size(340.dp, 96.dp)
            .clip(RoundedCornerShape(15.dp))
    ) {
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            placeholder = { Text(text) },
            modifier = Modifier
                .background(Color.White)
                .size(340.dp, 96.dp)
                .clip(RoundedCornerShape(15.dp))
        )
    }
}

@Composable
fun CreateButtonDelete(text: String, activ: ComponentActivity)
{
    val context = LocalContext.current
    Button(onClick = {
        context.startActivity(Intent(context, activ::class.java))},
        Modifier
            .size(340.dp, 54.dp)
            .clip(RoundedCornerShape(15)),
        colors = ButtonDefaults.buttonColors(Color.Red)) {
        Text(text = text, fontSize = 24.sp, color = Color.White)
    }
}