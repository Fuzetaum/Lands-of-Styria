package com.company.styria.gui;

import org.lwjgl.glfw.GLFW;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryUtil.NULL;

public class GUI implements Runnable {
    
    private Thread thread;
    private long window;
    private double FPS = 60.0;
    public boolean running = true;
	
    @Override
    public void run() {
	this.init();
        // lastTime: time when last iteration took place
        long lastTime = System.nanoTime();
        // delta: portion of a frame that has already passed
        double delta = 0.0;
        // ns: amount of nanoseconds per frame
        double ns = 1000000000.0/this.FPS;
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
	// glfwInit returns false when a problem occurs during GLFW initalization
	if(! glfwInit()) System.err.println("GLFW initialization failed");
	glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
	window = glfwCreateWindow(640, 480, "Lands of Styria", NULL, NULL);
	if(window == NULL) System.err.println("Window creation failed");
	long vidmode = nglfwGetVideoMode(glfwGetPrimaryMonitor());
	glfwSetWindowPos(window, 100, 100);
	glfwMakeContextCurrent(window);
	glfwShowWindow(window);
    }
	
    public void update() {
	glfwPollEvents();
    }
	
    public void render() {
        glfwSwapBuffers(window);
    }
	
    public static void main(String[] args) {
	GUI window = new GUI();
	window.start();
    }
}
