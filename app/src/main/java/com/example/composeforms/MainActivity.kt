package com.example.composeforms

import android.os.Bundle
import android.util.Size
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.alpha
import com.example.composeforms.ui.theme.ComposeFormsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeFormsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Bg()


                    SignupScreen(
                        modifier = Modifier.padding(innerPadding)

                    )



                }
            }
        }
    }
}



@Composable
fun SignupScreen(modifier: Modifier=Modifier) {


    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var verifypassword by remember { mutableStateOf("") }
    var isformvisible by remember { mutableStateOf(false) }



    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){

        AnimatedVisibility(visible = !isformvisible) {
            ExtendedFloatingActionButton(onClick = {
                isformvisible = true
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription =null
                )
                Spacer(modifier = Modifier.padding(8.dp))
                Text(text = "Create New Account")


            }
        }
        AnimatedVisibility(visible = isformvisible) {
            Card (
                modifier = Modifier
                    .padding(20.dp)
            ){
                Column(
                    modifier= Modifier
                        .fillMaxWidth()
                        .padding(32.dp)
                        .height(400.dp), horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(30.dp)
                ) {
                    TextField(
                        value = username,
                        onValueChange = { username = it },
                        label = { Text(text = "Username")},
                        leadingIcon = {
                            Icon(imageVector = Icons.Default.Person, contentDescription =null)
                        }
                    )
                    TextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text(text = "Email") },
                        leadingIcon = {
                            Icon(imageVector = Icons.Default.Email, contentDescription =null)
                        }
                    )
                    TextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text(text = "Password") },
                        leadingIcon = {
                            Icon(imageVector = Icons.Default.Lock, contentDescription =null)
                        }
                    )
                    TextField(
                        value = verifypassword,
                        onValueChange = { verifypassword = it },
                        label = { Text(text = "Verify Password") },
                        leadingIcon = {
                            Icon(imageVector = Icons.Default.Lock, contentDescription =null)
                        },
                        visualTransformation = PasswordVisualTransformation()
                    )

                    ElevatedButton(onClick = { /*TODO*/ }) {
                        Text(text = "Sign up")

                    }





                }
            }

        }
    }
    Row (
        modifier = Modifier
            .fillMaxWidth()

    ) {
        ElevatedButton(onClick = { /*TODO*/ }, Modifier.padding(20.dp))
        {
            Icon(imageVector = Icons.Default.Menu, contentDescription = null)


        }

        }










}
@Composable
fun Bg(modifier: Modifier=Modifier) {

    Image(
        painter = painterResource(id = R.drawable.stones),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxSize()
    )}




@Preview
@Composable
private fun SignupPreview(){
    Bg()
    SignupScreen()



}