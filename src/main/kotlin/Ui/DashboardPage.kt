package Ui

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import firstcolor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import lightviloet
import myred
import secondcolor


@Composable
fun DashboardPage() {
    val scrollState = rememberScrollState()

    Column(modifier = Modifier.fillMaxSize()) {

        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                "Dashboard",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(10.dp),
                fontSize = 25.sp,
                fontFamily = FontFamily.Monospace
            )
            //CryptoCard("bitcoin.png","BTC","Bitcoin","$29,930.11","-14.25","15.8")
            val list = remember { mutableListOf<CryptoCard>() }
            list.add(CryptoCard("bitcoin.png", "BTC", "Bitcoin", "$29,930.11", "-14.25", "15.8"))
            list.add(CryptoCard("binance.png", "BNB", "Binance Coin", "$42.16", "23.25", "60.8"))
            list.add(CryptoCard("ethereum.png", "ETH", "Ethereum", "$12,120.16", "10.25", "3.50"))
            list.add(CryptoCard("shiba.png", "SHIB", "Shiba", "$0.00.176", "-12.55", "100.10"))
            list.add(CryptoCard("bitcoin.png", "BTC", "Bitcoin", "$29,930.11", "-14.25", "15.8"))
            list.add(CryptoCard("binance.png", "BNB", "Binance Coin", "$42.16", "23.25", "60.8"))
            list.add(CryptoCard("ethereum.png", "ETH", "Ethereum", "$12,120.16", "10.25", "3.50"))
            list.add(CryptoCard("shiba.png", "SHIB", "Shiba", "$0.00.176", "-12.55", "100.10"))
            val scrollState = rememberScrollState()

                LazyRow() {
                    itemsIndexed(items = list) { index, item ->
                        CryptoCardView(item)
                    }
                }
        }

     Box(modifier = Modifier.fillMaxSize().padding(10.dp)){
        Row {
            Box(modifier = Modifier.fillMaxSize().weight(2f)){

            }
            Box(modifier = Modifier.fillMaxSize().weight(1f)){
                Column(horizontalAlignment = Alignment.CenterHorizontally,modifier = Modifier.fillMaxSize()) {
                    Text("Recent Transactions",color = Color.White,fontSize = 20.sp,modifier = Modifier.padding(bottom = 20.dp))
                    val list = remember { mutableListOf<TransactionModel>() }
                    list.add(TransactionModel("bitcoin.png","Bitcoin","Buy","12.35","4:07AM"))
                    list.add(TransactionModel("binance.png","Binance Coin","Buy","12.35","2:15PM"))
                    list.add(TransactionModel("ethereum.png","Ethereum","Buy","12.35","9:25AM"))
                    list.add(TransactionModel("shiba.png","Shibu","Buy","12.35","6:10PM"))
                    list.add(TransactionModel("bitcoin.png","Bitcoin","Buy","12.35","4:07AM"))
                    list.add(TransactionModel("binance.png","Binance Coin","Buy","12.35","2:15PM"))
                    list.add(TransactionModel("ethereum.png","Ethereum","Buy","12.35","9:25AM"))
                    list.add(TransactionModel("shiba.png","Shibu","Buy","12.35","6:10PM"))
                    list.add(TransactionModel("bitcoin.png","Bitcoin","Buy","12.35","4:07AM"))
                    list.add(TransactionModel("binance.png","Binance Coin","Buy","12.35","2:15PM"))
                    list.add(TransactionModel("ethereum.png","Ethereum","Buy","12.35","9:25AM"))
                    list.add(TransactionModel("shiba.png","Shibu","Buy","12.35","6:10PM"))

                    LazyColumn {
                         itemsIndexed(items = list){index, item ->
                                 RecentTransactions(item)

                         }
                    }

                }

            }
        }
     }
    }
}
 data class TransactionModel(var image:String,var symbol:String,var type:String,var amount:String,var time:String)
@Composable
fun RecentTransactions(model:TransactionModel){
    Row(verticalAlignment = Alignment.CenterVertically,modifier = Modifier.padding(15.dp)) {
        Spacer(Modifier.weight(.5f))
        Image(painterResource(model.image),"",modifier = Modifier.size(25.dp).weight(.5f))
        Column(Modifier.weight(3f)) {
            Text(model.symbol,color = Color.White,fontSize = 15.sp)
            Text(model.type,color = Color.LightGray,fontSize = 10.sp)
        }

        Column(Modifier.weight(1f)) {
            Text(model.amount,color = Color.White,fontSize = 15.sp)
            Text(model.time,color = Color.LightGray,fontSize = 10.sp)
        }
    }
}

private fun lineChartData() = listOf(
    5929, 6898, 8961, 5674, 7122, 6592, 3427, 5520, 4680, 7418,
    4743, 4080, 3611, 7295, 9900, 12438, 11186, 5439, 4227, 5138,
    11115, 8386, 12450, 10411, 10852, 7782, 7371, 4983, 9234, 6847
)

@Composable
fun LineChart() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(360.dp)
            .padding(16.dp),
        elevation = 10.dp
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .wrapContentSize(align = Alignment.BottomStart)
        ) {
            Canvas(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                val distance = size.width / (lineChartData().size + 1)
                var currentX = 0F
                val maxValue = lineChartData().maxOrNull() ?: 0
                val points = mutableListOf<Offset>()

                lineChartData().forEachIndexed { index, data ->
                    if (lineChartData().size >= index + 2) {
                        val y0 = (maxValue - data) * (size.height / maxValue)
                        val x0 = currentX + distance
                        points.add(Offset(x0, y0))
                        currentX += distance
                    }
                }

                for (i in 0 until points.size - 1) {
                    drawLine(
                        start = Offset(points[i].x, points[i].y),
                        end = Offset(points[i + 1].x, points[i + 1].y),
                        color = Color(0xFFFF0000),
                        strokeWidth = 8f
                    )
                }
            }
        }
    }
}

@Composable
fun CryptoCardView(cryptoCard: CryptoCard){
Card(shape = RoundedCornerShape(10.dp),backgroundColor = secondcolor,modifier = Modifier.width(300.dp).height(200.dp).padding(10.dp).clickable {GlobalScope.launch {
print("vvv")

}},border = BorderStroke(1.dp,color = myred)) {
   Column (modifier = Modifier.fillMaxSize()) {
       Row(modifier = Modifier.fillMaxWidth().padding(10.dp),verticalAlignment = Alignment.CenterVertically,horizontalArrangement = Arrangement.Start) {
         Image(painter = painterResource(cryptoCard.name!!),"",modifier = Modifier.size(40.dp))
           Column(Modifier.weight(2f).padding(5.dp)) {
               Text(cryptoCard.coinsymbol!!,color = Color.White,fontFamily = FontFamily.Monospace,fontWeight = FontWeight.ExtraBold,fontSize = 18.sp)
               Text(cryptoCard.coinname!!,color = Color.LightGray,fontSize = 12.sp,fontFamily = FontFamily.Monospace)
           }
           if (cryptoCard.change!!.startsWith("-")){
               Icon(Icons.Outlined.KeyboardArrowDown,"",tint = Color.Red)
               Text(cryptoCard.change!! + "%",color = Color.Red)
           }else{
               Icon(Icons.Outlined.KeyboardArrowUp,"",tint = Color.Green)
               Text(cryptoCard.change!! + "%",color = Color.Green)
           }
       }

       Spacer(Modifier.size(15.dp))

       Text("Today Price",color = Color.LightGray,fontSize = 12.sp,fontFamily = FontFamily.Monospace,modifier = Modifier.padding(start = 20.dp))
       Spacer(Modifier.size(5.dp))
       Text("${cryptoCard.todayprice!!}",color = Color.White,fontSize = 18.sp,fontFamily = FontFamily.Monospace,fontWeight = FontWeight.Bold,modifier = Modifier.padding(start = 20.dp))

       Spacer(Modifier.size(15.dp))


       Text("Your Wallet",color = Color.LightGray,fontSize = 12.sp,fontFamily = FontFamily.Monospace,modifier = Modifier.padding(start = 20.dp))
       Spacer(Modifier.size(5.dp))
       Text("${cryptoCard.walletbalance!!} ${cryptoCard.coinsymbol!!}",color = Color.White,fontSize = 18.sp,fontFamily = FontFamily.Monospace,fontWeight = FontWeight.Bold,modifier = Modifier.padding(start = 20.dp))

   }
}
}
data class CryptoCard(var name:String?=null,var coinsymbol:String?= null,var coinname:String?=null,var todayprice:String?=null,var change:String?=null,var walletbalance:String?=null)

