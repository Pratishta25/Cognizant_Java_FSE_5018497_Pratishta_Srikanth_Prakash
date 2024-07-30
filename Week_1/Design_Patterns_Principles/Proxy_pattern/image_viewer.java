package com.proxy.pattern;

public class ImageViewer {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("test_image1.jpg");
        Image image2 = new ProxyImage("test_image2.jpg");

        // Display images
        image1.display(); // Loads from disk and displays
        System.out.println();
        image1.display(); // Displays from cache
        System.out.println();
        image2.display(); // Loads from disk and displays
        System.out.println();
        image2.display(); // Displays from cache
    }
}
