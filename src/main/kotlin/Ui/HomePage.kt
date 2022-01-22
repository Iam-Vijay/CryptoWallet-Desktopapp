package Ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import firstcolor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import mygreen
import myred
import secondcolor
import thirdcolor
import kotlin.concurrent.thread

@Composable
fun HomePage(){
    Card(shape = RoundedCornerShape(20.dp),modifier = Modifier.background(Color.Black).padding(5.dp).fillMaxSize()){
        Box(
            modifier = Modifier
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                          firstcolor,secondcolor, thirdcolor
                        )
                    )
                ).fillMaxSize()
        ) {

            Column(modifier = Modifier.fillMaxSize()) {

                TopBar()
                MenuBar()
            }

        }
    }
}

@Composable
fun TopBar(){
    Box(modifier = Modifier.fillMaxWidth().height(100.dp)){
        Row (modifier = Modifier.fillMaxSize(),verticalAlignment = Alignment.CenterVertically){
            Text("My Wallet",fontSize = 25.sp,fontWeight = FontWeight.ExtraBold,modifier = Modifier.padding(start = 50.dp).weight(2f),color = Color.White)

            Card(modifier = Modifier.width(350.dp).height(50.dp).weight(2f),shape = RoundedCornerShape(30.dp),backgroundColor = Color.Transparent) {
                Row (verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Search, "", modifier = Modifier.width(50.dp), tint = Color.White)
                    TextField("", {}, label = { Text("Search", color = Color.White) })
                }
            }
            Spacer(Modifier.size(300.dp).weight(1f))
            Row(verticalAlignment = Alignment.CenterVertically,modifier = Modifier.fillMaxHeight().weight(1f)) {


                Card(
                    Modifier.padding(10.dp),
                    shape = CircleShape,
                    border = BorderStroke(1.dp, color = Color.White),
                    backgroundColor = Color.Black
                ) {
                    Icon(Icons.Outlined.Notifications, "", tint = Color.White, modifier = Modifier.padding(5.dp))
                }

                Card(
                    Modifier.padding(10.dp),
                    shape = CircleShape,
                    border = BorderStroke(1.dp, color = Color.White),
                    backgroundColor = Color.Black
                ) {
                    Icon(Icons.Outlined.MailOutline, "", tint = Color.White, modifier = Modifier.padding(5.dp))
                }
            }
            Spacer(Modifier.size(300.dp).weight(1f))

            Row(verticalAlignment = Alignment.CenterVertically,modifier = Modifier.fillMaxHeight().weight(1f)){
                Text("Jan 17,2022" ,color = Color.White,modifier = Modifier.padding(5.dp))
                Card(
                    shape = CircleShape,
                ) {
                    Image(painter = painterResource("chaticon.jpg"), "",contentScale = ContentScale.Crop, modifier = Modifier.size(40.dp))

                }
                Icon(Icons.Outlined.ArrowDropDown, "", tint = Color.White, modifier = Modifier.padding(5.dp))

            }
            }


    }
}
@OptIn(DelicateCoroutinesApi::class)
@Composable
fun MenuBar(){
    val index = remember { mutableStateOf(0 ) }

    Row(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxHeight().width(250.dp).padding(top = 50.dp)) {
            var list = mutableListOf<Menu>()
            list.add(Menu("DashBoard", "dash.png"))
            list.add(Menu("Deposit", "wallet.png"))
            list.add(Menu("Withdraw", "trans.png"))
            list.add(Menu("Exchange", "exchange.png"))

            NavigationMenu(list) {
                GlobalScope.launch {
                    index.value = it
                }
            }
        }

        Box (modifier = Modifier.fillMaxSize()){
            when(index.value){
                0 ->{
                        DashboardPage()
                    }

                1->{
                        DepositPage()
                }
                2->{
                        WithdrawPage()
                }
                3->{
                        ExchangePage()
                }
            }
        }
    }
}
