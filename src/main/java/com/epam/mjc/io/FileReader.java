package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {

        StringBuilder fileToStr = new StringBuilder();

        try (FileInputStream fin = new FileInputStream(file)) {
            int i = -1;
            while ((i = fin.read()) != -1) {

                fileToStr.append((char) i);
            }
        } catch (IOException ignored) {
        }

        String[] spitStr = fileToStr.toString().split("\n");

        Profile profile = new Profile();
        profile.setName(spitStr[0].split(" ")[1]);
        profile.setAge(Integer.parseInt(spitStr[1].split(" ")[1]));
        profile.setEmail(spitStr[2].split(" ")[1]);
        profile.setPhone(Long.parseLong(spitStr[3].split(" ")[1]));

        return profile;
    }
}
