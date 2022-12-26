package com.deflatedpickle.guikt.backend.legui

import com.deflatedpickle.guikt.ComponentMap
import com.deflatedpickle.guikt.api.CloseOperation
import com.deflatedpickle.guikt.impl.LayoutManager
import com.deflatedpickle.guikt.widget.Frame
import com.spinyowl.legui.animation.AnimatorProvider
import com.spinyowl.legui.listener.processor.EventProcessorProvider
import com.spinyowl.legui.system.context.CallbackKeeper
import com.spinyowl.legui.system.context.Context
import com.spinyowl.legui.system.context.DefaultCallbackKeeper
import com.spinyowl.legui.system.handler.processor.SystemEventProcessor
import com.spinyowl.legui.system.handler.processor.SystemEventProcessorImpl
import com.spinyowl.legui.system.renderer.nvg.NvgRenderer
import org.lwjgl.glfw.GLFW
import org.lwjgl.glfw.GLFW.glfwCreateWindow
import org.lwjgl.glfw.GLFW.glfwDestroyWindow
import org.lwjgl.glfw.GLFW.glfwMakeContextCurrent
import org.lwjgl.glfw.GLFW.glfwPollEvents
import org.lwjgl.glfw.GLFW.glfwShowWindow
import org.lwjgl.glfw.GLFW.glfwSwapBuffers
import org.lwjgl.glfw.GLFW.glfwSwapInterval
import org.lwjgl.glfw.GLFW.glfwTerminate
import org.lwjgl.opengl.GL
import org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT
import org.lwjgl.opengl.GL11.GL_STENCIL_BUFFER_BIT
import org.lwjgl.opengl.GL11.glClear
import org.lwjgl.opengl.GL11.glClearColor
import org.lwjgl.opengl.GL11.glViewport
import org.lwjgl.system.MemoryUtil.NULL
import com.spinyowl.legui.component.Frame as LeFrame
import com.spinyowl.legui.system.layout.LayoutManager as LeLayoutManager

class LeGUIFrame<T : LayoutManager>(
    override val layout: T,
    override val _title: String,
    override val _size: com.deflatedpickle.guikt.api.Dimension,
    override val closeOperation: CloseOperation,
    override val components: ComponentMap,
) : Frame<T> {
    init {
        if (!GLFW.glfwInit()) {
            throw RuntimeException("Can't initialize GLFW")
        }
        val window: Long = glfwCreateWindow(_size.width, _size.height, _title, NULL, NULL)
        glfwShowWindow(window)

        glfwMakeContextCurrent(window)
        GL.createCapabilities()
        glfwSwapInterval(0)

        val frame = LeFrame(_size.width.toFloat(), _size.height.toFloat())

        val context = Context(window)
        val keeper: CallbackKeeper = DefaultCallbackKeeper()
        CallbackKeeper.registerCallbacks(window, keeper)

        val systemEventProcessor: SystemEventProcessor = SystemEventProcessorImpl()
        SystemEventProcessor.addDefaultCallbacks(keeper, systemEventProcessor)

        val renderer = NvgRenderer()
        renderer.initialize()

        while (true) {
            context.updateGlfwWindow()
            val windowSize = context.framebufferSize
            glClearColor(1f, 1f, 1f, 1f)
            glViewport(0, 0, windowSize.x, windowSize.y)
            glClear(GL_COLOR_BUFFER_BIT or GL_STENCIL_BUFFER_BIT)

            renderer.render(frame, context)

            glfwPollEvents()
            glfwSwapBuffers(window)

            systemEventProcessor.processEvents(frame, context)
            EventProcessorProvider.getInstance().processEvents()
            LeLayoutManager.getInstance().layout(frame)
            AnimatorProvider.getAnimator().runAnimations()
        }

        renderer.destroy()

        glfwDestroyWindow(window)
        glfwTerminate()
    }
}