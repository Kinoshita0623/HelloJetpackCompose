package jp.panta.hellojetpackcompose

import android.os.Bundle
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.widget.Toolbar
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jp.panta.hellojetpackcompose.ui.theme.HelloJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(
                topBar = {
                    TopAppBar {
                        Text("Hello Jetpack compose")
                    }
                },
            ) {
                NewsStory()
            }

        }
    }
}

@Composable
fun AppBar() {

}

@Composable
fun NewsStory(){
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.header),
            contentDescription = null,
            modifier = Modifier.height(180.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Text("A day in Shark Fin Cove")
        Text("Davenport, California")
        Text("December 2018")
    }
}

@Composable
fun CounterContent() {
    val state = remember {
        mutableStateOf(0)
    }
    val textState = remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier.padding(8.dp),
    ) {
        Greeting("Android")
        Greeting("Android")
        Text(text = state.value.toString())
        Image(
            painter = painterResource(id = R.drawable.header),
            contentDescription = null
        )
        Button(
            onClick = {
                state.value = state.value + 1
            },

        ) {
            Text(text = "カウントアップ")
        }
        Row {
            Text(text = "文字数:")
            Text(text = textState.value.length.toString())
        }
        TextField(
            value = textState.value,
            onValueChange = { text ->
                textState.value = text
            },
            modifier = Modifier.padding(4.dp)
        )

    }

}
@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HelloJetpackComposeTheme {
        CounterContent()
    }
}