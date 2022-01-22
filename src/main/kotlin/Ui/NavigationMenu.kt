package Ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import maincolor1
import navback

@Composable
fun NavigationMenu(list: List<Menu>, onSelected: (index: Int) -> Unit) {

    val selection = remember {
        mutableStateListOf(*list.map { false }.toTypedArray())
    }
    val oldstate = remember { mutableStateOf(0) }
    val selected = remember { mutableStateOf(false) }


    selection[oldstate.value] = true

    LazyColumn {

        itemsIndexed (items = list){index,data ->

              if (!selection[index]) {

                  Row(
                      modifier = Modifier.fillMaxSize().height(80.dp).padding(5.dp)
                          .selectable(selected = selection[index] == selected.value) {
                              onSelected(index)
                               selection[oldstate.value] = false
                              selection[index] = true
                              oldstate.value = index
                          }, verticalAlignment = Alignment.CenterVertically,horizontalArrangement = Arrangement.Center
                  ) {
                      Image(painterResource(data.icon), data.tittle, modifier = Modifier.padding(start = 50.dp).size(20.dp))
                      Text(
                          data.tittle!!,
                          fontSize = 14.sp,
                          fontFamily = FontFamily.Cursive,
                          color = White,
                          modifier = Modifier.padding(5.dp).fillMaxWidth()
                      )

                  }
              }
           else {
                Card(
                    backgroundColor = navback,
                    shape = RoundedCornerShape(5.dp),
                    modifier = Modifier.padding(5.dp).fillMaxWidth().height(80.dp)
                ) {
                    Row(modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically,horizontalArrangement = Arrangement.Center) {
                        Box(
                            modifier = Modifier
                                .fillMaxHeight()
                                .width(3.dp)
                                .background(color = maincolor1)
                        )
                        Image(painterResource(data.icon), data.tittle, modifier = Modifier.padding(start = 50.dp).size(30.dp))
                        Text(
                            data.tittle!!,
                            fontSize = 18.sp,
                            fontFamily = FontFamily.Cursive,
                            color = White,
                            modifier = Modifier.padding(5.dp).fillMaxWidth()
                        )

                    }

                }


            }
        }

    }
}

data class Menu(var tittle:String? = null,var icon:String)


