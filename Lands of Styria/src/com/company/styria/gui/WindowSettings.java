package com.company.styria.gui;

public class WindowSettings {
	private static boolean fullscreen = false;
	private static Integer width=1024;
	private static Integer height=768;
	private static Double FPS=60.0;
	private static boolean vsync=true;
	
	public static void setWindowSize(Integer height, Integer width) {
		WindowSettings.width = width; WindowSettings.height = height;
	}
	public static void setVsync(boolean newVal) {WindowSettings.vsync = newVal;}
	public static void setFPS(Double newFPS) {WindowSettings.FPS = newFPS;}
	public static void setFullscreen(boolean newVal) {WindowSettings.fullscreen = newVal;}
	
	public static boolean getVsync() {return WindowSettings.vsync;}
	public static Integer getWindowWidth() {return WindowSettings.width;}
	public static Integer getWindowHeight() {return WindowSettings.height;}
	public static Double getFPS() {return WindowSettings.FPS;}
}