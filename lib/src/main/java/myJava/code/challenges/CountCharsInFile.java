package myJava.code.challenges;

import java.io.FileReader;
import java.io.IOException;

public class CountCharsInFile {
    public static String main(String[] args) {
        StringBuilder resultMsg = new StringBuilder();

        if (args.length < 2 || args[0].trim().length() < 2 || args[1].trim().length() != 1) {
            resultMsg.append("Invalid input. Enter a filename with path and extension, and a single-character search term.");
            System.out.print(resultMsg.toString());
            return resultMsg.toString();
        }

        String filename = args[0].trim();
        String searchChar = args[1].trim();

        try {
            int count = getCount(filename, searchChar);
            resultMsg.append("Found ").append(searchChar).append(" ").append(count).append(" times in ").append(filename).append(".");
        } catch (IOException ioex) {
            resultMsg.append("Error occurred accessing file ").append(filename).append(".");
            System.out.printf(ioex.getMessage());
        }

        return resultMsg.toString();
    }

    public static int getCount(String filename, String searchChar) throws IOException {
        FileReader inputStream = null;
        int inputCharCode = searchChar.toCharArray()[0];
        int character;
        int counter = 0;
        try {
            inputStream = new FileReader(filename);
            while ((character = inputStream.read()) != -1) {
                if (character == inputCharCode){
                    counter++;
                }
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return counter;
    }
}
