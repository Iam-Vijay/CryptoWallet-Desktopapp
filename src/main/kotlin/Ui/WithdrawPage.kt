package Ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import maincolor1
import kotlin.math.roundToLong

@Composable
fun WithdrawPage() {
    val focusManager = LocalFocusManager.current

    val list = remember { mutableListOf<SmallCardModel>() }
    val enteramountvalue = remember { mutableStateOf(TextFieldValue("0.0")) }
    val addresstext = remember { mutableStateOf(TextFieldValue()) }
    list.add(SmallCardModel("binance.png", "Binance Coin", "xsdgasdyagdsyagdsadsadgsyagdasvdadvasdasd"))
    list.add(SmallCardModel("bitcoin.png", "BitCoin", "sfdsgdrtfdfsdfsdfsdfsdfsdfsdfdsfsdfsd"))
    list.add(SmallCardModel("ethereum.png", "Ethereum", "vdserfweegdfgdfgsdgdfsdfdsfdfsdfsdfsdf"))
    list.add(SmallCardModel("shiba.png", "Shibu", "fdgdfgdgretersdsfsdfsfsdfsdfsdfsdfsdfsdf"))
    list.add(SmallCardModel("binance.png", "Binance Coin", "xsdgasdyagdsyagdsadsadgsyagdasvdadvasdasd"))
    list.add(SmallCardModel("bitcoin.png", "BitCoin", "sfdsgdrtfdfsdfsdfsdfsdfsdfsdfdsfsdfsd"))
    list.add(SmallCardModel("ethereum.png", "Ethereum", "vdserfweegdfgdfgsdgdfsdfdsfdfsdfsdfsdf"))
    list.add(SmallCardModel("shiba.png", "Shibu", "fdgdfgdgretersdsfsdfsfsdfsdfsdfsdfsdfsdf"))
    list.add(SmallCardModel("binance.png", "Binance Coin", "xsdgasdyagdsyagdsadsadgsyagdasvdadvasdasd"))
    list.add(SmallCardModel("bitcoin.png", "BitCoin", "sfdsgdrtfdfsdfsdfsdfsdfsdfsdfdsfsdfsd"))
    list.add(SmallCardModel("ethereum.png", "Ethereum", "vdserfweegdfgdfgsdgdfsdfdsfdfsdfsdfsdf"))
    list.add(SmallCardModel("shiba.png", "Shibu", "fdgdfgdgretersdsfsdfsfsdfsdfsdfsdfsdfsdf"))
    val clicktext = remember { mutableStateOf(list[0].symbol) }
    val address = remember { mutableStateOf(list[0].adress) }
    val clickimage = remember { mutableStateOf(list[0].image) }
    Row(Modifier.fillMaxSize().padding(top = 50.dp).pointerInput(Unit){detectTapGestures(onTap = {
        focusManager.clearFocus(true)
    }) }) {
        Column(Modifier.weight(1f).fillMaxSize()) {
            Text("Withdraw Using", color = Color.LightGray, fontSize = 20.sp)
            Card(
                border = BorderStroke(1.dp, Color.Transparent),
                backgroundColor = Color.Transparent,
                modifier = Modifier.padding(10.dp)
            ) {
                LazyColumn {
                    itemsIndexed(items = list) { index, item ->
                        SmallCard(item) {
                            clicktext.value = it.symbol
                            address.value = it.adress
                            clickimage.value = it.image
                        }
                    }
                }
            }
        }
        Box(Modifier.weight(4f).fillMaxSize().padding(100.dp).align(Alignment.CenterVertically)) {
            Card (modifier = Modifier.fillMaxSize(),border = BorderStroke(1.dp,maincolor1),backgroundColor = Color.Transparent){
                Column {
                    Text("WithDraw Details",fontSize = 25.sp,fontWeight = FontWeight.Bold,modifier = Modifier.padding(10.dp),color = Color.White)
                    Row(modifier = Modifier.padding(10.dp)) {
                        Column(modifier = Modifier.weight(1f).padding(20.dp)) {
                        Text("Withdrawal wallet :",color = Color.LightGray,modifier = Modifier.padding(bottom = 30.dp))
                            Card (border = BorderStroke(1.dp,maincolor1),backgroundColor = Color.White,modifier = Modifier.height(70.dp).fillMaxWidth()){
                                Row (verticalAlignment = Alignment.CenterVertically,modifier = Modifier.fillMaxSize().padding(start = 20.dp)){
                                    Image(painter = painterResource(clickimage.value),"",modifier = Modifier.size(35.dp).padding(2.dp))
                                    Column(Modifier.padding(start = 10.dp)) {
                                        Text(clicktext.value,color = Color.Black,fontSize = 15.sp,fontWeight = FontWeight.Bold)
                                        Spacer(Modifier.size(5.dp))
                                        Text(address.value,maxLines = 1,color = Color.DarkGray,fontSize = 12.sp)
                                    }
                                }
                            }
                        }
                        Column(modifier = Modifier.weight(1f).padding(20.dp)) {
                            Text("Amount to Withdraw :",color = Color.LightGray,modifier = Modifier.padding(bottom = 30.dp))
                            Card (border = BorderStroke(1.dp,maincolor1),backgroundColor = Color.White,modifier = Modifier.height(70.dp).fillMaxWidth()){
                                Row(modifier = Modifier.fillMaxSize(),verticalAlignment = Alignment.CenterVertically) {
                                        Column(modifier = Modifier.fillMaxSize().weight(3f)) {
                                            TextField( keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                                value = enteramountvalue.value ,onValueChange = {  enteramountvalue.value = it   },
                                                maxLines = 1,modifier = Modifier.height(50.dp),colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.White,
                                                focusedIndicatorColor = Color.Transparent,disabledIndicatorColor = Color.Transparent,textColor = Color.Black,
                                                unfocusedIndicatorColor = Color.Transparent),singleLine = true
                                            )
                                            Text("0.4313152 available",maxLines = 1,color = Color.DarkGray,fontSize = 15.sp,modifier = Modifier.padding(start = 10.dp))
                                        }

                                    Icon(painterResource("plus.png"),"",modifier = Modifier.size(20.dp).weight(.5f).clickable {
                                        if (enteramountvalue.value.toString().trim() == "" && enteramountvalue.value.toString().trim() == "0.0"){
                                            enteramountvalue.value = TextFieldValue("0.0")
                                        }else{
                                            val total = enteramountvalue.value.text.toFloat().plus(1)
                                            enteramountvalue.value = TextFieldValue(total.toString())
                                        }
                                    })
                                    Icon(painterResource("minus.png"),"",modifier = Modifier.size(20.dp).weight(.5f).clickable {
                                        if (enteramountvalue.value.toString().trim() == "" && enteramountvalue.value.toString().trim() == "0.0"){
                                            enteramountvalue.value = TextFieldValue("0.0")
                                        }else{
                                            val total = enteramountvalue.value.text.toFloat().minus(1)
                                            enteramountvalue.value = TextFieldValue(total.toString())
                                        }
                                    })
                                }
                            }
                        }
                    }

                    Row(modifier = Modifier.padding( 10.dp)){
                        Column(modifier = Modifier.weight(1f).padding(20.dp)) {
                            Text(
                                "Withdrawal address :",
                                color = Color.LightGray,
                                modifier = Modifier.padding(bottom = 30.dp)
                            )
                            Card (border = BorderStroke(1.dp,maincolor1),backgroundColor = Color.White,modifier = Modifier.height(70.dp).fillMaxWidth()){
                                OutlinedTextField( keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                    value = addresstext.value ,onValueChange = {  addresstext.value = it   },
                                    maxLines = 1,modifier = Modifier.fillMaxSize(),colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.White,
                                        focusedIndicatorColor = Color.Transparent,disabledIndicatorColor = Color.Transparent,textColor = Color.Black,
                                        unfocusedIndicatorColor = Color.Transparent),singleLine = true,label = { Text("Enter BTC Address")}
                                )
                            }

                        }

                        Column(modifier = Modifier.weight(1f).padding(20.dp)) {
                            Text(
                                "Total Amount to Withdrawal :",
                                color = Color.LightGray,
                                modifier = Modifier.padding(bottom = 30.dp)
                            )
                            Card (border = BorderStroke(1.dp,maincolor1),backgroundColor = Color.White,modifier = Modifier.height(70.dp).fillMaxWidth()) {
                                Row(modifier = Modifier.fillMaxSize(),verticalAlignment = Alignment.CenterVertically) {
                                    var toll = 0.0
                                    try {
                                     toll = enteramountvalue.value.text.toFloat() + 0.008259
                                    }catch (e:NumberFormatException){e.printStackTrace()}
                                        Text(
                                            toll.toString(),
                                            fontSize = 20.sp,
                                            color = Color.Black,
                                            modifier = Modifier.padding(10.dp).weight(1.5f)
                                        )

                                        Text("Fee:", fontSize = 15.sp,color = Color.DarkGray,modifier = Modifier.padding(10.dp))
                                    Text("0.008259", fontSize = 15.sp,color = Color.Black,modifier = Modifier.padding(10.dp))

                                }
                            }

                        }
                    }

                    Button(onClick = {},modifier = Modifier.padding(25.dp).fillMaxWidth().height(70.dp),colors = ButtonDefaults.buttonColors(backgroundColor = maincolor1,contentColor = Color.White)){
                        Text("Withdraw")
                    }
                }
            }
        }
    }
}