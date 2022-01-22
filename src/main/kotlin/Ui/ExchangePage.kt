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
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import maincolor1

@Composable
fun ExchangePage() {
    val focusManager = LocalFocusManager.current
    var expanded = remember { mutableStateOf(false)}
    var expanded1 = remember { mutableStateOf(false)}
    val enteramountvalue = remember { mutableStateOf(TextFieldValue("0.0")) }
    val list = remember { mutableListOf<SmallCardModel>() }
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
    val sclicktext = remember { mutableStateOf(list[2].symbol) }
    val saddress = remember { mutableStateOf(list[2].adress) }
    val sclickimage = remember { mutableStateOf(list[2].image) }
    Row(Modifier.fillMaxSize().padding(top = 30.dp).pointerInput(Unit) {
        detectTapGestures(onTap = {
            focusManager.clearFocus(true)
        })
    }) {
        Box(Modifier.weight(4f).fillMaxSize().padding(100.dp).align(Alignment.CenterVertically)) {
            Card(
                modifier = Modifier.fillMaxSize(),
                border = BorderStroke(1.dp, maincolor1),
                backgroundColor = Color.Transparent
            ) {
                Column {
                    Text(
                        "Exchange Details",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(10.dp),
                        color = Color.White
                    )

                    Row(modifier = Modifier.padding(10.dp)) {
                        Column(modifier = Modifier.weight(1f).padding(20.dp)) {
                            Text("Exchange :",color = Color.LightGray,modifier = Modifier.padding(bottom = 30.dp))
                            Card (border = BorderStroke(1.dp,maincolor1),backgroundColor = Color.White,modifier = Modifier.height(70.dp).fillMaxWidth()){
                                Row (verticalAlignment = Alignment.CenterVertically,modifier = Modifier.fillMaxSize().padding(start = 20.dp)){
                                    Image(painter = painterResource(clickimage.value),"",modifier = Modifier.size(35.dp).padding(2.dp))
                                    Column(Modifier.padding(start = 10.dp).weight(2f)) {
                                        Text(clicktext.value,color = Color.Black,fontSize = 15.sp,fontWeight = FontWeight.Bold)
                                        Spacer(Modifier.size(5.dp))
                                        Text(address.value,maxLines = 1,color = Color.DarkGray,fontSize = 12.sp)
                                    }
                                    Icon(Icons.Default.ArrowDropDown,"",modifier = Modifier.weight(.5f).clickable {
                                        expanded.value = true
                                    })
                                    DropdownMenu(expanded = expanded.value, onDismissRequest = {
                                        expanded.value = false
                                    }) {
                                        list.forEach{ country->
                                            DropdownMenuItem(onClick = {
                                                expanded.value = false
                                                clicktext.value = country.symbol
                                                address.value = country.adress
                                                clickimage.value = country.image
                                            }) {
                                                MyCard(country)
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        Column(modifier = Modifier.weight(1f).padding(20.dp)) {
                            Text("Exchange For :",color = Color.LightGray,modifier = Modifier.padding(bottom = 30.dp))
                            Card (border = BorderStroke(1.dp,maincolor1),backgroundColor = Color.White,modifier = Modifier.height(70.dp).fillMaxWidth()){
                                Row (verticalAlignment = Alignment.CenterVertically,modifier = Modifier.fillMaxSize().padding(start = 20.dp)){
                                    Image(painter = painterResource(sclickimage.value),"",modifier = Modifier.size(35.dp).padding(2.dp))
                                    Column(Modifier.padding(start = 10.dp).weight(2f)) {
                                        Text(sclicktext.value,color = Color.Black,fontSize = 15.sp,fontWeight = FontWeight.Bold)
                                        Spacer(Modifier.size(5.dp))
                                        Text(saddress.value,maxLines = 1,color = Color.DarkGray,fontSize = 12.sp)
                                    }
                                    Icon(Icons.Default.ArrowDropDown,"",modifier = Modifier.weight(.5f).clickable {
                                        GlobalScope.launch {
                                            expanded1.value = true
                                        }
                                    })
                                    DropdownMenu(expanded = expanded1.value, onDismissRequest = {
                                        expanded1.value = false
                                    }) {
                                        list.forEach{ country->
                                            DropdownMenuItem(onClick = {
                                                expanded1.value = false
                                                sclicktext.value = country.symbol
                                                saddress.value = country.adress
                                                sclickimage.value = country.image
                                            }) {
                                                MyCard(country)
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }



                    Row(modifier = Modifier.padding(10.dp)) {
                        Column(modifier = Modifier.weight(1f).padding(20.dp)) {
                            Text("Amount to Exchange :",color = Color.LightGray,modifier = Modifier.padding(bottom = 30.dp))
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
                        Column(modifier = Modifier.weight(1f).padding(20.dp)) {
                            Text("Amount to Get :",color = Color.LightGray,modifier = Modifier.padding(bottom = 30.dp))
                            Card (border = BorderStroke(1.dp,maincolor1),backgroundColor = Color.White,modifier = Modifier.height(70.dp).fillMaxWidth()){
                                Row(modifier = Modifier.fillMaxSize(),verticalAlignment = Alignment.CenterVertically) {
                                    Column(modifier = Modifier.fillMaxSize().weight(3f)) {
                                       Text( "4.054412 ETH",  fontSize = 20.sp,
                                           color = Color.Black,modifier = Modifier.padding(10.dp),textAlign = TextAlign.Center)
                                        Text("at 32.12454545 ETH/BTC",maxLines = 1,color = Color.DarkGray,fontSize = 15.sp,modifier = Modifier.padding(start = 10.dp))
                                    }
                                }
                            }
                        }

                    }




                    Button(onClick = {},modifier = Modifier.padding(25.dp).fillMaxWidth().height(70.dp),colors = ButtonDefaults.buttonColors(backgroundColor = maincolor1,contentColor = Color.White)){
                        Text("Exchange")
                    }


                }
            }
        }
    }
}
@Composable
fun MyCard(smallCardModel: SmallCardModel){
    Row (verticalAlignment = Alignment.CenterVertically,modifier = Modifier.padding(20.dp)){
        Image(painter = painterResource(smallCardModel.image),"",modifier = Modifier.size(30.dp).padding(2.dp))
        Column(Modifier.padding(5.dp)) {
            Text(smallCardModel.symbol,color = Color.Black,fontSize = 15.sp)
            Text(smallCardModel.adress,maxLines = 1,color = Color.LightGray,fontSize = 12.sp)
        }
    }
}