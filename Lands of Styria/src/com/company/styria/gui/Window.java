package com.company.styria.gui;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryStack.stackPush;
import static org.lwjgl.system.MemoryUtil.NULL;

import java.nio.IntBuffer;

import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.system.MemoryStack;

public class Window implements Runnable {
    private Thread thread;
    private long window;
    public boolean running = true;
	
    @Override
    public void run() {
	this.init();
        // lastTime: time when last iteration took place
        long lastTime = System.nanoTime();
        // delta: portion of a frame that has already passed
        double delta = 0.0;
        // ns: amount of nanoseconds per frame
        double ns = 1000000000.0/WindowSettings.getFPS();
        // timer: measures when a whole second has passed
        long timer = System.currentTimeMillis();
        int updates = 0;
        int frames = 0;
        // While-loop for rendering & updating screen
        while(this.running) {
            delta += (System.nanoTime() - lastTime) / ns;
            lastTime = System.nanoTime();
            if(delta >= 1.0) {
                update();
                updates++;
                delta--;
            }
            render();
            frames++;
            if(glfwWindowShouldClose(window))
            this.running = false;
        }
    }
	
    public void start() {
        this.running = true;
        this.thread = new Thread(this, "MyGame");
        this.thread.start();
    }
	
    public void init() {
    	// Setup an error callback. The default implementation
        // will print the error message in System.err.
        GLFWErrorCallback.createPrint(System.err).set();
        // Initialize GLFW. Most GLFW functions will not work before doing this.
     	if ( !glfwInit() )
     		throw new IllegalStateException("Unable to initialize GLFW");
     	// Configure GLFW
     	glfwDefaultWindowHints(); // optional, the current window hints are already the default
     	glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); // the window will stay hidden after creation
     	glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE); // the window will be resizable
     	// Create the window
     	window = glfwCreateWindow(WindowSettings.getWindowWidth(), WindowSettings.getWindowHeight(),
     			"Lands of Styria", NULL, NULL);
     	if ( window == NULL )
     		throw new RuntimeException("Failed to create the GLFW window");
		if(window == NULL) System.err.println("Window creation failed");
		// Setup a key callback. It will be called every time a key is pressed, repeated or released.
	 	glfwSetKeyCallback(window, (window, key, scancode, action, mods) -> {
	 	if ( key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE )
	 		glfwSetWindowShouldClose(window, true); // We will detect this in the rendering loop
	 		});
	 	// Get the thread stack and push a new frame
	 	try ( MemoryStack stack = stackPush() ) {
	 		IntBuffer pWidth = stack.mallocInt(1); // int*
	 		IntBuffer pHeight = stack.mallocInt(1); // int*
	 		// Get the window size passed to glfwCreateWindow
			glfwGetWindowSize(window, pWidth, pHeight);
	 		// Get the resolution of the primary monitor
			GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
	 		// Center the window
			glfwSetWindowPos(window,
				(vidmode.width() - pWidth.get(0)) / 2,
				(vidmode.height() - pHeight.get(0)) / 2
			);
	 		} // the stack frame is popped automatically
	 	// Make the OpenGL context current
	 	glfwMakeContextCurrent(window);
	 	// Enable v-sync
	 	glfwSwapInterval(1);
	 	// Make the window visible
	 	glfwShowWindow(window);
    }
	
    public void update() {
    	glfwPollEvents();
    }
	
    public void render() {
        glfwSwapBuffers(window);
    }
}
