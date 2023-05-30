package org.osu.game;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

public class GameWindow {
    private long window;
    private int screenWidth;
    private int screenHeight;
    // Other member variables as needed

    public GameWindow(int width, int height, String title) {
        this.screenWidth = width;
        this.screenHeight = height;
        // Set other member variables

        // Create the window
        createWindow(width, height, title);

        // Initialize OpenGL context
        initOpenGL();
    }

    private void createWindow(int width, int height, String title) {
        // Initialize GLFW
        if (!GLFW.glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }

        // Configure window hints
        GLFW.glfwDefaultWindowHints();
        GLFW.glfwWindowHint(GLFW.GLFW_VISIBLE, GLFW.GLFW_FALSE);
        GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, GLFW.GLFW_TRUE);

        // Create the window
        window = GLFW.glfwCreateWindow(width, height, title, 0, 0);
        if (window == 0) {
            throw new RuntimeException("Failed to create the GLFW window");
        }

        // Set callbacks and make the window context current
        // ...

        // Center the window on the screen
        GLFW.glfwSetWindowPos(window, (screenWidth - width) / 2, (screenHeight - height) / 2);

        // Make the window visible
        GLFW.glfwShowWindow(window);
    }

    private void initOpenGL() {
        // Make the OpenGL context current
        GLFW.glfwMakeContextCurrent(window);

        // Enable v-sync
        GLFW.glfwSwapInterval(1);

        // Initialize OpenGL capabilities
        GL.createCapabilities();

        // Set the viewport
        GL11.glViewport(0, 0, screenWidth, screenHeight);
    }

    public boolean shouldClose() {
        return GLFW.glfwWindowShouldClose(window);
    }

    public void update() {
        // Update window events
        GLFW.glfwPollEvents();
    }

    public void swapBuffers() {
        GLFW.glfwSwapBuffers(window);
    }

    public void close() {
        // Terminate GLFW and release resources
        GLFW.glfwDestroyWindow(window);
        GLFW.glfwTerminate();
    }

    public int getWidth() {
        return screenWidth;
    }

    public int getHeight() {
        return screenHeight;
    }

    public long getWindowHandle() {
        return window;
    }
}

