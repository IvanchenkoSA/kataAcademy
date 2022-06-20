import java.util.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        RomanNotation notation = new RomanNotation();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] subStr = str.split(" ");
        if (isNumeric(subStr[0])) {
            String x1 = subStr[0];
            String op = subStr[1];
            String x2 = subStr[2];
            Integer i = Integer.valueOf(x1);
            Integer h = Integer.valueOf(x2);
            int answer = 0;
            switch (op) {
                case "-":
                    answer = i - h;
                    break;
                case "+":
                    answer = i + h;
                    break;
                case "/":
                    answer = i / h;
                    break;
                case "*":
                    answer = i * h;
                    break;
            }
            System.out.println(answer);
        } else {
            int x = getRom(subStr[0]);
            String op = subStr[1];
            int y = getRom(subStr[2]);
            int answer = 0;
            switch (op) {
                case "-":
                    answer = x - y;
                    break;
                case "+":
                    answer = x + y;
                    break;
                case "/":
                    answer = x / y;
                    break;
                case "*":
                    answer = x * y;
                    break;
            }
            System.out.println(notation.toRomanNotation(answer));
        }
    }

    public static int getRom(String str) {
        HashMap<Character, Integer> myMap = new HashMap<>();
        myMap.put('I', 1);
        myMap.put('V', 5);
        myMap.put('X', 10);
        int e1 = 0;
        int e2 = 0;
        int e3 = 0;
        int e4 = 0;
        int val1 = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.length() == 1) {
                char c1 = str.charAt(0);
                e1 = myMap.get(c1);
                val1 = e1;
                break;
            } else if (str.length() == 2) {
                char c1 = str.charAt(0);
                e1 = myMap.get(c1);
                char c2 = str.charAt(1);
                e2 = myMap.get(c2);
                if (e1 < e2) {
                    val1 = e2 - e1;
                    break;
                } else
                    val1 = e1 + e2;
                break;
            } else if (str.length() == 3) {
                char c1 = str.charAt(0);
                char c2 = str.charAt(1);
                char c3 = str.charAt(2);
                e1 = myMap.get(c1);
                e2 = myMap.get(c2);
                e3 = myMap.get(c3);
                val1 = e1 + e2 + e3;
                break;
            } else if (str.length() == 4) {
                char c1 = str.charAt(0);
                char c2 = str.charAt(1);
                char c3 = str.charAt(2);
                char c4 = str.charAt(3);
                e1 = myMap.get(c1);
                e2 = myMap.get(c2);
                e3 = myMap.get(c3);
                e4 = myMap.get(c4);
                val1 = e1 + e2 + e3 + e4;
                break;
            }
        }
        return val1;
    }

    public static boolean isNumeric(String string) {
        String regex = "[0-9]+[\\.]?[0-9]*";
        return Pattern.matches(regex, string);
    }
}