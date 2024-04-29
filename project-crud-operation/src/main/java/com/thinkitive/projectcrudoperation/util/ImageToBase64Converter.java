package com.thinkitive.projectcrudoperation.util;

import java.util.Base64;
import java.io.IOException;
import java.nio.file.Files;
import java.io.File;

public class ImageToBase64Converter {

    public static void main(String[] args) {
        try {
            // Read image file into byte array
            File file = new File("/home/lnv-0033/Pictures/download.jpeg");
            byte[] imageData = Files.readAllBytes(file.toPath());

            // Convert byte array to base64 string
            String base64Image = convertToBase64(imageData);

            // Print base64 encoded image
            System.out.println("Base64 encoded image:\n" + base64Image);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String convertToBase64(byte[] imageData) {
        return Base64.getEncoder().encodeToString(imageData);
    }
}