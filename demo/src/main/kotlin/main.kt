import com.deflatedpickle.guikt.GuiKT
import com.deflatedpickle.guikt.backend.JavaFXBackend
import com.deflatedpickle.guikt.backend.SwingBackend
import com.deflatedpickle.guikt.impl.LayoutManager
import com.deflatedpickle.guikt.widget.frame

fun main() {
    GuiKT.backend = SwingBackend /*JavaFXBackend*/

    frame(LayoutManager.Border()) {
        title = "Note"
        width = 500
        height = 500
    }
}