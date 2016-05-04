package process;

import java.io.IOException;
import java.util.Scanner;

public class TestProcessBuilder {
    public static void main(String[] args) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("cmd", "mvn");

        Process process = pb.start();

        Scanner scanner = new Scanner(process.getInputStream());

        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
        scanner.close();
    }

}