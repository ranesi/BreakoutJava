package breakout;

/**
 * All File I/O operations take place here.
 *
 * Functions:
 *  -getAuth
 *      - returns string reading credentials from info.txt
 *      - used for database
 */

import java.io.*;

public class FileIO implements Constants {

    public static String[] getAuth(){
        StringBuilder sb = new StringBuilder();
        String fromFile = "";
        try (BufferedReader br = new BufferedReader(new FileReader(DB_AUTH_FILE))) {
            fromFile += br.readLine();
            while (fromFile != null) {
                String toBuilder = fromFile + ";"; // you get yelled at for concatenating directly in a stringbuilder's parameters
                sb.append(toBuilder);
                fromFile = br.readLine();
            }
            br.close();
        } catch (IOException fnfe) {
            System.out.println("Error locating file, aborting...");
            System.exit(-1);
        }
        return sb.toString().split(";");
    }

}
