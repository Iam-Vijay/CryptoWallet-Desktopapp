import Ui.HomePage
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application

fun main() = application {

    androidx.compose.ui.window.Window(
        onCloseRequest = ::exitApplication,
        state = WindowState(size = DpSize(1500.dp, 1000.dp))
    ) {
        MaterialTheme {
            HomePage()
        }
    }
}