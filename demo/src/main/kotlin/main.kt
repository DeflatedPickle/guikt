import com.deflatedpickle.guikt.GuiKT
import com.deflatedpickle.guikt.api.Listener
import com.deflatedpickle.guikt.api.Orientation.VERTICAL
import com.deflatedpickle.guikt.api.x
import com.deflatedpickle.guikt.backend.SwingBackend
import com.deflatedpickle.guikt.impl.Constraint
import com.deflatedpickle.guikt.impl.Constraint.Border
import com.deflatedpickle.guikt.impl.Layout
import com.deflatedpickle.guikt.impl.Layout.Flow
import com.deflatedpickle.guikt.impl.Model.BoundedRange.Integer
import com.deflatedpickle.guikt.impl.Model.ComboBox.Default
import com.deflatedpickle.guikt.impl.Model.List
import com.deflatedpickle.guikt.impl.Model.Spinner.Number
import com.deflatedpickle.guikt.widget.TabbedPanel.Tab
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
import com.deflatedpickle.guikt.widget.spinner
import com.deflatedpickle.guikt.widget.splitpanel
import com.deflatedpickle.guikt.widget.tabbedpanel
import com.deflatedpickle.guikt.widget.textarea
import com.deflatedpickle.guikt.widget.textfield
import com.deflatedpickle.guikt.widget.togglebutton

fun main() {
    GuiKT.backend = SwingBackend

    frame(Layout.Border()) {
        title = "Settings"
        size = 500 x 500

        tabbedpanel(Border()) {
            tabs += Tab(
                "My Tab",
                component = splitpanel(Border()) {
                    orientation = VERTICAL
                    touchExpand = true

                    left = panel(Border(), Flow()) {
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
                            model = Default(
                                listOf("Swing", "Swt", "JavaFX", "LeGUI")
                            )
                            onItem += Listener {
                                println(it.source)
                            }
                        }

                        list<String>(Constraint.Flow()) {
                            model = List.Default(
                                listOf("Swing", "Swt", "JavaFX", "LeGUI")
                            )
                            onSelection += Listener {
                                println(it.source)
                            }
                        }

                        textfield(Constraint.Flow()) {
                            columns = 10
                        }

                        slider(Constraint.Flow()) {
                            model = Integer(
                                50,
                                0,
                                0,
                                100,
                            )
                        }

                        spinner<Double>(Constraint.Flow()) {
                            model = Number(
                                50.0,
                                0.0,
                                100.0,
                                0.1,
                            )
                        }
                    }

                    right = panel(Constraint.Flow(), Flow()) {
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
            )

            tabs += Tab(component = button(Border()))
        }
    }
}