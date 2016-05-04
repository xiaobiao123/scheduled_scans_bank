package process;

import java.io.IOException;
import java.util.Scanner;

public class TestProcess {
    public static void main(String[] args) throws IOException {
        String cmd = "cmd " + "java";
        Process process = Runtime.getRuntime().exec(cmd);
        Scanner scanner = new Scanner(process.getInputStream());

        while (scanner.hasNextLine()) {

            System.out.println(new String(scanner.nextLine().getBytes("gbk"), "utf-8"));
        }
        scanner.close();
    }
}