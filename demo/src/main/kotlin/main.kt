import com.deflatedpickle.guikt.GuiKT
import com.deflatedpickle.guikt.api.x
import com.deflatedpickle.guikt.backend.JavaFXBackend
import com.deflatedpickle.guikt.backend.LeGUIBackend
import com.deflatedpickle.guikt.backend.SwingBackend
import com.deflatedpickle.guikt.backend.SwtBackend
import com.deflatedpickle.guikt.impl.LayoutManager
import com.deflatedpickle.guikt.widget.frame

fun main() {
    GuiKT.backend = SwingBackend

    frame(LayoutManager.Border()) {
        title = "Note"
        size = 500 x 500
    }
}