import javax.swing.*;
import java.io.*;
public class FileScan {
    public static void main(String[] args) {
        File file;
        if (args.length > 0) {
            file = new File(args[0]);
            if (!file.exists()) {
                System.out.println("The file " + args[0] + " does not exist.");
                return;
            }
        } else {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("src"));
            int result = fileChooser.showOpenDialog(null);
            if (result != JFileChooser.APPROVE_OPTION) {
                System.out.println("No file selected.");
                return;
            }
            file = fileChooser.getSelectedFile();
        }
        System.out.println("File selected: " + file.getName());
        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
                System.out.println(line);
                String[] words = line.split("\\s+");
                wordCount += words.length;
                charCount += line.length();
            }
        } catch (IOException e) {
            System.out.println("Couldn't read the file: " + e.getMessage());
        }
        System.out.println("\nSummary Report:");
        System.out.println("File name: " + file.getName());
        System.out.println("Line count: " + lineCount);
        System.out.println("Word count: " + wordCount);
        System.out.println("Character count: " + charCount);
    }
}
