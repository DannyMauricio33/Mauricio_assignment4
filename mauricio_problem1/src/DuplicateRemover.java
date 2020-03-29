import java.io.File;
import java.io.FileWriter;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class DuplicateRemover {
    Set<String> uniqueWords;

    public void remove(String dataFile) {
        Scanner input = null;

        try {
            // Set variable to store words and read them
            uniqueWords = new LinkedHashSet<>();
            input = new Scanner(new File(dataFile));

            // Start reading file
            while(input.hasNextLine()) {
                String line = input.nextLine();
                String[] words = line.split(" ");

                //For loop to add words in the hash set
                for(int i = 0; i < words.length; i++) {
                    String str = words[i].toLowerCase();
                    uniqueWords.add(str);
                }
            }
        }
        //Used when code runs into any exception
        catch(Exception e) {
            System.out.println("Error occurred while opening the file: "+dataFile);
        }

        if(input != null) {
            input.close();
        }
    }

    public void write(String outputFile) {
        FileWriter output = null;

        //Opens file to write words in the output file
        try {
            output = new FileWriter(outputFile);

            for(String s : uniqueWords) {
                output.write(s+"\n");
            }
            output.close();
        }
        catch(Exception e) {
            System.out.println("Error occurred while writing in the file: "+outputFile);
        }
    }
}
