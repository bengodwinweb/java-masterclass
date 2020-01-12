package com.bengodwinweb;

public class Main {

    public static void main(String[] args) {
	    Door door = new Door();
	    Window window = new Window();
	    Light light = new Light();

	    Room room = new Room(door, window, light, "Bedroom");
	    room.enterRoom();
	    room.freshenUp();
	    room.leaveRoom();
    }
}
