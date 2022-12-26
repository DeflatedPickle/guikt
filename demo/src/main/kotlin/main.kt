import com.deflatedpickle.guikt.GuiKT
import com.deflatedpickle.guikt.api.x
import com.deflatedpickle.guikt.backend.SwingBackend
import com.deflatedpickle.guikt.impl.Constraint
import com.deflatedpickle.guikt.impl.Layout
import com.deflatedpickle.guikt.widget.button
import com.deflatedpickle.guikt.widget.frame
import com.deflatedpickle.guikt.widget.label
import com.deflatedpickle.guikt.widget.panel

fun main() {
    GuiKT.backend = SwingBackend

    frame(Layout.Border()) {
        title = "Settings"
        size = 500 x 500

        panel(Constraint.Border(), Layout.Flow()) {
            label(Constraint.Flow()) {
                text = "Button:"
            }

            button(Constraint.Flow()) {
                text = "Click"
            }
        }
    }
}