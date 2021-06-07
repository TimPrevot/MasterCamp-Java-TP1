package tp;

import java.util.Scanner;

public class ScannerUtils {
    public static Scanner scanner = new Scanner(System.in);
    private ScannerUtils() { }

    public static void skip(){
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    }

    public static int nextInt() {
        int value = scanner.nextInt();
        ScannerUtils.skip();
        return value;
    }

    public static String nextLine() {
        String input = scanner.nextLine();
        ScannerUtils.skip();
        return input;
    }

}
