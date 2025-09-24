import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        example();
    }
    public static void example() {
        String input = """
                등록
                너자신을 알라.
                """;
        Scanner scanner = new Scanner(input);
        String cmd = scanner.nextLine();
        String saying = scanner.nextLine();
        System.out.println("입력 : " + cmd);
        System.out.println("명언 : " + saying);

    }
}
