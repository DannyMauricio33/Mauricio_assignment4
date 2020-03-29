import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DuplicateCounter {
    private Integer wordCounter;
    private Map<String, Integer> map;

    //set counter to 0 and initiate the hash map
    public DuplicateCounter() {
        this.wordCounter = 0;
        this.map = new HashMap<>();
    }

    public void count(String dataFile) {
        Scanner input = null;

        //Start reading the input file
        try {
            input = new Scanner(new File(dataFile));

            while(input.hasNextLine()) {
                String line = input.nextLine().trim();
                String[] data = line.split("[\\W]+");

                //Puts the words into the hash set in order to get frequency
                for(String word : data) {
                    this.wordCounter = map.get(word);
                    this.wordCounter = (this.wordCounter == null) ? 1 : ++this.wordCounter;
                    map.put(word, this.wordCounter);
                }
            }
        }
        //catches any exception to deal with
        catch(Exception e) {
            System.out.println("Error occurred while opening the file: "+dataFile);
        }

        if(input != null) {
            input.close();
        }
    }

    public void write(String outputFile) {
        FileWriter f;
        PrintWriter p;

        try {
            f = new FileWriter(new File(outputFile));
            p = new PrintWriter(f);

            //Output file will write frequency of words
            for(Map.Entry<String, Integer> entry : map.entrySet()) {
                p.write(entry.getKey() + " occurs " + entry.getValue() + " times." + System.lineSeparator());
            }

            //prevent the resource leak
            p.flush();
            f.close();
            p.close();
        }
        catch(Exception e) {
            System.out.println("Error occurred while writing in the file: "+outputFile);
        }
    }

}
