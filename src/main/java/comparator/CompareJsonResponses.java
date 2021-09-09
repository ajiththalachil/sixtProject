package comparator;

import utilities.ReqUtils;
import java.io.*;
import java.util.Scanner;


public class CompareJsonResponses extends ReqUtils {

    private static final String PROJECTPATH = System.getProperty("user.dir");
    private static final String RESOURCEPATH = "\\src\\main\\resources\\";
    private static final String FILE1 = PROJECTPATH.concat(RESOURCEPATH).concat("File1.txt");
    private static final String FILE2 = PROJECTPATH.concat(RESOURCEPATH).concat("File2.txt");

    public static void main(String[] args) {
        try {
            Scanner file1 = new Scanner(new File(FILE1));
            Scanner file2 = new Scanner(new File(FILE2));
            while (file1.hasNextLine() && file2.hasNextLine()) {
                String req1 = file1.nextLine();
                String req2 = file2.nextLine();
                if (compareResponse(req1, req2)) {
                    System.out.println(req1.concat(" equals ").concat(req2));
                } else {
                    System.out.println(req1.concat(" not equals ").concat(req2));
                }
            }
            file1.close();
            file2.close();

        } catch (IOException io) {
            System.out.println(io.getMessage());
        }
    }
}
