import com.deflatedpickle.guikt.GuiKT
import com.deflatedpickle.guikt.api.Listener
import com.deflatedpickle.guikt.api.Orientation
import com.deflatedpickle.guikt.api.x
import com.deflatedpickle.guikt.backend.SwingBackend
import com.deflatedpickle.guikt.impl.Constraint
import com.deflatedpickle.guikt.impl.Layout
import com.deflatedpickle.guikt.widget.ComboBox
import com.deflatedpickle.guikt.widget.button
import com.deflatedpickle.guikt.widget.checkbox
import com.deflatedpickle.guikt.widget.combobox
import com.deflatedpickle.guikt.widget.frame
import com.deflatedpickle.guikt.widget.label
import com.deflatedpickle.guikt.widget.list
import com.deflatedpickle.guikt.widget.panel
import com.deflatedpickle.guikt.widget.progressbar
import com.deflatedpickle.guikt.widget.radiobutton
import com.deflatedpickle.guikt.widget.slider
import com.deflatedpickle.guikt.widget.splitpane
import com.deflatedpickle.guikt.widget.textarea
import com.deflatedpickle.guikt.widget.textfield
import com.deflatedpickle.guikt.widget.togglebutton

fun main() {
    GuiKT.backend = SwingBackend

    frame(Layout.Border()) {
        title = "Settings"
        size = 500 x 500

        splitpane(Constraint.Border()) {
            orientation = Orientation.VERTICAL
            touchExpand = true

            left = panel(Constraint.Border(), Layout.Flow()) {
                label(Constraint.Flow()) {
                    text = "Button:"
                }

                button(Constraint.Flow()) {
                    text = "Click"
                    onClick += Listener {
                        println("Click")
                    }
                }

                togglebutton(Constraint.Flow()) {
                    text = "Toggle"
                }

                checkbox(Constraint.Flow()) {
                    text = "Check"
                }

                radiobutton(Constraint.Flow()) {
                    text = "Radio"
                }

                combobox<String>(Constraint.Flow()) {
                    items += listOf("Swing", "Swt", "JavaFX", "LeGUI")
                    onItem += Listener {
                        println(it.source)
                    }
                }

                list<String>(Constraint.Flow()) {
                    items += listOf("Swing", "Swt", "JavaFX", "LeGUI")
                    onSelection += Listener {
                        println(it.source)
                    }
                }

                textfield(Constraint.Flow()) {
                    columns = 10
                }

                slider(Constraint.Flow()) {
                    min = 25
                    max = 50
                    value = 35
                }
            }

            right = panel(Constraint.Flow(), Layout.Flow()) {
                textarea(Constraint.Flow()) {
                    text = """Hello,
                    |World!
                """.trimMargin()
                }

                progressbar(Constraint.Flow()) {
                    value = 50
                }
            }
        }
    }
}