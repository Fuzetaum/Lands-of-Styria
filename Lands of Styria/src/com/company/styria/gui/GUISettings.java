package com.company.styria.gui;

public class GUISettings {
	private static Integer width=768;
	private static Integer height=1024;
	
	public static void setWindowSize(Integer height, Integer width) {
		GUISettings.width = width; GUISettings.height = height;
	}
	
	public static Integer getWindowWidth() {return GUISettings.width;}
	public static Integer getWindowHeight() {return GUISettings.height;}
}
