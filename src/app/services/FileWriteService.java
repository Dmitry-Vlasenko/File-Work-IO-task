package app.services;

import app.config.Config;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriteService {
    public static void writeToFile(String writePath, String content) {
        try (BufferedWriter buffWriter = new BufferedWriter(new FileWriter(writePath))) {
            buffWriter.write(content);
            buffWriter.flush();
        } catch (IOException e) {
            System.out.println("Problem with write file");
        }
    }

    public static String makeNewFilePath(String newFileName) {
        return Config.BASE_DIRECTORY + newFileName;
    }

}
