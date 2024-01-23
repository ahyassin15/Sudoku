package loginassignment.login;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {

    public static void write(String[] information) {
        try {
            FileWriter writer = new FileWriter("database.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            String info = String.join(", ", information);

            bufferedWriter.write(info);
            bufferedWriter.newLine();

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}