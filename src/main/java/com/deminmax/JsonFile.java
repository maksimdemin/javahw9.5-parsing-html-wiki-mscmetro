package com.deminmax;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class JsonFile {

    public static void toJsonFile(MyMetro metro, Path pathForSave) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter jsonFile = new FileWriter(pathForSave.toFile());
        jsonFile.write(gson.toJson(metro));
        jsonFile.flush();
        jsonFile.close();
    }


    public static Path pathFromUser() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            while (true) {
                System.out.println("Enter name file (e.g myfile.json) ");
                String nameFile = scanner.nextLine();
                if (!nameFile.matches("^[^\\\\/:*?<\">|+%!@.]+\\.json$")) {
                    System.out.println("Wrong name file, try again");
                    continue;
                }
                System.out.println("Enter destination path or press enter to save the file to the IDEA root project directory ");
                String destinationDirectory = scanner.nextLine();
                if (destinationDirectory.matches("")) {
                    Path path = Path.of(destinationDirectory + nameFile);
                    System.out.println("Json file created and saved to root project directory\n");
                    return path;
                }
                else if (Path.of(destinationDirectory).getParent() != null && Files.isWritable(Path.of(destinationDirectory).getParent()) || Files.isWritable(Path.of(destinationDirectory))) {
                    Path path = Path.of(destinationDirectory + "/" + nameFile);
                    System.out.println("Json file created and saved to " + path + "\n");
                    return path;
                }
                System.out.println("Destination directory not exist");
            }
        }
    }
}
