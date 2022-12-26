package com.deflatedpickle.guikt.backend.swt

import com.deflatedpickle.guikt.ComponentMap
import com.deflatedpickle.guikt.api.CloseOperation
import com.deflatedpickle.guikt.api.Dimension
import com.deflatedpickle.guikt.impl.Layout
import com.deflatedpickle.guikt.widget.Frame
import org.eclipse.swt.graphics.Point
import org.eclipse.swt.widgets.Display
import org.eclipse.swt.widgets.Shell

class SwtFrame<T : Layout>(
    override val layout: T,
    override val _title: String,
    override val _size: Dimension,
    override val closeOperation: CloseOperation,
    override val components: ComponentMap,
) : Frame<T> {
    init {
        val display = Display()
        val shell = Shell(display)

        shell.text = _title
        shell.size = Point(_size.width, _size.height)

        shell.open()

        while (!shell.isDisposed) {
            if (!display.readAndDispatch()) {
                display.sleep()
            }
        }

        display.dispose()
    }
}