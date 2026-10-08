import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

public class LogAnalyzer {

    public static void main(String[] args) {

        String keyword = "ERROR";

        try {

            Files.write(Paths.get("log1.txt"), List.of(
                    "INFO Program Started",
                    "ERROR Invalid Input",
                    "INFO Program Ended"));

            Files.write(Paths.get("log2.txt"), List.of(
                    "ERROR File Missing",
                    "INFO Retry",
                    "ERROR Access Denied"));

            Files.write(Paths.get("log3.txt"), List.of(
                    "INFO Connected",
                    "INFO Running",
                    "ERROR Network Failure"));

            String[] files = {"log1.txt", "log2.txt", "log3.txt"};

            int totalLines = 0;
            int keywordCount = 0;

            for (String file : files) {

                Path path = Paths.get(file);

                List<String> lines = Files.readAllLines(path);

                totalLines += lines.size();

                for (String line : lines) {
                    if (line.contains(keyword)) {
                        keywordCount++;
                    }
                }

                BasicFileAttributes attr =
                        Files.readAttributes(path, BasicFileAttributes.class);

                System.out.println(file + " Size: " + attr.size() + " bytes");
            }

            System.out.println("Total Lines: " + totalLines);
            System.out.println("Keyword Count: " + keywordCount);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}