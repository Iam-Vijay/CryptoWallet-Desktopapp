package Ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import firstcolor
import maincolor1
import navback


@Composable
fun DepositPage(){
    val list = remember { mutableListOf<SmallCardModel>() }

    list.add(SmallCardModel("binance.png","Binance Coin","xsdgasdyagdsyagdsadsadgsyagdasvdadvasdasd"))
    list.add(SmallCardModel("bitcoin.png","BitCoin","sfdsgdrtfdfsdfsdfsdfsdfsdfsdfdsfsdfsd"))
    list.add(SmallCardModel("ethereum.png","Ethereum","vdserfweegdfgdfgsdgdfsdfdsfdfsdfsdfsdf"))
    list.add(SmallCardModel("shiba.png","Shibu","fdgdfgdgretersdsfsdfsfsdfsdfsdfsdfsdfsdf"))
    list.add(SmallCardModel("binance.png","Binance Coin","xsdgasdyagdsyagdsadsadgsyagdasvdadvasdasd"))
    list.add(SmallCardModel("bitcoin.png","BitCoin","sfdsgdrtfdfsdfsdfsdfsdfsdfsdfdsfsdfsd"))
    list.add(SmallCardModel("ethereum.png","Ethereum","vdserfweegdfgdfgsdgdfsdfdsfdfsdfsdfsdf"))
    list.add(SmallCardModel("shiba.png","Shibu","fdgdfgdgretersdsfsdfsfsdfsdfsdfsdfsdfsdf"))
    list.add(SmallCardModel("binance.png","Binance Coin","xsdgasdyagdsyagdsadsadgsyagdasvdadvasdasd"))
    list.add(SmallCardModel("bitcoin.png","BitCoin","sfdsgdrtfdfsdfsdfsdfsdfsdfsdfdsfsdfsd"))
    list.add(SmallCardModel("ethereum.png","Ethereum","vdserfweegdfgdfgsdgdfsdfdsfdfsdfsdfsdf"))
    list.add(SmallCardModel("shiba.png","Shibu","fdgdfgdgretersdsfsdfsfsdfsdfsdfsdfsdfsdf"))
    val clicktext = remember { mutableStateOf(list[0].symbol) }
    val address = remember { mutableStateOf(list[0].adress) }

    Row (Modifier.fillMaxSize().padding(top = 50.dp)){
        Column(Modifier.weight(1f).fillMaxSize()) {
           Text("Deposit Using",color = Color.LightGray,fontSize = 20.sp)
            Card (border = BorderStroke(1.dp, Color.Transparent),backgroundColor = Color.Transparent,modifier = Modifier.padding(10.dp)){
                LazyColumn {
                    itemsIndexed(items = list) { index, item ->
                        SmallCard(item) {
                            clicktext.value = it.symbol
                            address.value = it.adress
                        }
                    }
                }
            }
        }
        Box(Modifier.weight(4f).fillMaxSize().padding( 100.dp)){
                Column {
                    Row {
                        Text("Deposit",fontSize = 25.sp,color = Color.White)
                        Spacer(Modifier.size(10.dp))
                        Text(clicktext.value,fontSize = 25.sp,fontWeight = FontWeight.Bold,color = Color.White)
                    }
                  Spacer(Modifier.size(20.dp))
                    Row {
                        Row(verticalAlignment = Alignment.CenterVertically,modifier = Modifier.weight(1f)) {
                            Icon(
                                painter = painterResource("time.png"),
                                "",
                                modifier = Modifier.size(35.dp).padding(5.dp),
                                tint = Color.White
                            )
                            Column(Modifier.padding(5.dp)) {
                                Text("Reflection Time", color = Color.LightGray, fontSize = 12.sp)
                                Spacer(Modifier.size(10.dp))
                                Text(
                                    "24 Hours",
                                    maxLines = 1,
                                    color = Color.White,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }

                        Row(verticalAlignment = Alignment.CenterVertically,modifier = Modifier.weight(1f)) {
                            Icon(
                                painter = painterResource("amount.png"),
                                "",
                                modifier = Modifier.size(35.dp).padding(5.dp),
                                tint = Color.White
                            )
                            Column(Modifier.padding(5.dp)) {
                                Text("Commission Fee", color = Color.LightGray, fontSize = 12.sp)
                                Spacer(Modifier.size(10.dp))
                                Text(
                                    "Free",
                                    maxLines = 1,
                                    color = Color.White,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                    Spacer(Modifier.size(10.dp))
                    Row {
                        Row(verticalAlignment = Alignment.CenterVertically,modifier = Modifier.weight(1f)) {
                            Icon(
                                painter = painterResource("minimum.png"),
                                "",
                                modifier = Modifier.size(35.dp).padding(5.dp),
                                tint = Color.White
                            )
                            Column(Modifier.padding(5.dp)) {
                                Text("Minimum Deposit ", color = Color.LightGray, fontSize = 12.sp)
                                Spacer(Modifier.size(10.dp))
                                Text(
                                    "0.01BTC",
                                    maxLines = 1,
                                    color = Color.White,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }

                        Row(verticalAlignment = Alignment.CenterVertically,modifier = Modifier.weight(1f)) {
                            Icon(
                                painter = painterResource("maximum.png"),
                                "",
                                modifier = Modifier.size(35.dp).padding(5.dp),
                                tint = Color.White
                            )
                            Column(Modifier.padding(5.dp)) {
                                Text("Maximum Deposit", color = Color.LightGray, fontSize = 12.sp)
                                Spacer(Modifier.size(10.dp))
                                Text(
                                    "None",
                                    maxLines = 1,
                                    color = Color.White,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                    Spacer(Modifier.size(30.dp))
                    Spacer(Modifier.size(50.dp))
                    Text("Deposit Address",fontSize = 25.sp,color = Color.White)
                        Spacer(Modifier.size(50.dp))
                    Row (modifier = Modifier.fillMaxWidth(),verticalAlignment = Alignment.CenterVertically) {
                        Column(Modifier.weight(2f)) {
                            Text(
                                "Use QR Code Scanner or Copy Address.\nRemember this address 'one-time' Deposit only.\n" +
                                        "You cannot reuse this address for the second time .",color = Color.White,fontSize = 16.sp
                            )
                            Spacer(Modifier.size(50.dp))
                            Card(border = BorderStroke(1.dp, maincolor1),backgroundColor = Color.White,modifier = Modifier.padding(10.dp).height(60.dp)) {
                                Row(Modifier.fillMaxWidth(),verticalAlignment = Alignment.CenterVertically) {
                                    Text(
                                        address.value,
                                        color = Color.Black,
                                        fontSize = 15.sp,
                                        maxLines = 1,
                                        modifier = Modifier.padding(20.dp).weight(3f)
                                    )

                                    OutlinedButton(modifier = Modifier.weight(1f).padding(10.dp),onClick = {

                                    },colors = ButtonDefaults.buttonColors(maincolor1)){
                                        Text("Copy",color = Color.White)
                                    }
                                }
                            }
                        }


                        Box(Modifier.weight(1f).padding(30.dp)){
                            Image(painterResource("chart.png",),"",modifier = Modifier.fillMaxSize())
                        }

                    }

                }
        }
    }
}

data class SmallCardModel(var image:String,var symbol:String,var adress:String)
@Composable
fun SmallCard(smallCardModel: SmallCardModel,Onclick:(smallcard:SmallCardModel) -> Unit){
   Row (verticalAlignment = Alignment.CenterVertically,modifier = Modifier.padding(20.dp).clickable {
       Onclick.invoke(smallCardModel)
   }){
       Image(painter = painterResource(smallCardModel.image),"",modifier = Modifier.size(30.dp).padding(2.dp))
       Column(Modifier.padding(5.dp)) {
           Text(smallCardModel.symbol,color = Color.White,fontSize = 15.sp)
           Text(smallCardModel.adress,maxLines = 1,color = Color.LightGray,fontSize = 12.sp)
       }
   }
}