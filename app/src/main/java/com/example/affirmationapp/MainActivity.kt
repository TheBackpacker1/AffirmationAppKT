import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Divider
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.MaterialTheme
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.affirmationapp.AppData.Companion.photoWithTexts

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyScreen(photoWithTexts)
        }
    }
}

data class PhotoWithText(val imageResId: Int, val text: String)

@Composable
fun MyScreen(photoWithTexts: List<PhotoWithText>) {
    Column {
        photoWithTexts.forEach { photoWithText ->
            Image(
                painter = painterResource(photoWithText.imageResId),
                contentDescription = null
            )
            Text(
                text = photoWithText.text,
                modifier = Modifier.padding(16.dp)
            )
            if (photoWithText != photoWithTexts.last()) {
                Divider(
                    color = MaterialTheme.colors.onSurface.copy(alpha = 0.12f),
                    thickness = 1.dp,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
        }
    }
}