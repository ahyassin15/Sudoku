package loginassignment.login;

import java.io.*;

public class ReadFile {
    
    public static boolean isUsername(String username) {
        try {
            FileReader reader = new FileReader("database.txt");
            BufferedReader bufferedreader = new BufferedReader(reader);
            
            String line;

            while ((line = bufferedreader.readLine()) != null) {
                if (line.split(", ")[1].equalsIgnoreCase(username) || line.split(", ")[0].equalsIgnoreCase(username)) {
                    return true;
                }
            }

            reader.close();
            
        } catch (IOException e) {

        }

        return false;

    }

    public static boolean passwordMatch(String username, String password) {
        try {
            FileReader reader = new FileReader("database.txt");
            BufferedReader bufferedreader = new BufferedReader(reader);

            String line;

            while ((line = bufferedreader.readLine()) != null) {
                if (line.split(", ")[1].equalsIgnoreCase(username) || line.split(", ")[0].equalsIgnoreCase(username)) {
                    if (line.split(", ")[2].equals(password)) {
                        return true;
                    }
                }
            }

            reader.close();

        } catch (IOException e) {

        }

        return false;

    }
    
}