import java.util.Scanner;

public class StringOperations {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking input from user
        System.out.print("Enter a string: ");
        String s1 = sc.nextLine();

        System.out.print("Enter another string: ");
        String s2 = sc.nextLine();

        // length()
        System.out.println("Length: " + s1.length());

        // isEmpty()
        System.out.println("Is Empty: " + s1.isEmpty());

        // charAt()
        if (s1.length() > 0)
            System.out.println("Char at index 0: " + s1.charAt(0));

        // toString()
        System.out.println("ToString: " + s1.toString());

        // equals()
        System.out.println("Equals: " + s1.equals(s2));

        // compareTo()
        System.out.println("CompareTo: " + s1.compareTo(s2));

        // contains()
        System.out.println("Contains second string: " + s1.contains(s2));

        // indexOf()
        System.out.print("Enter character to find index: ");
        char ch = sc.next().charAt(0);
        System.out.println("IndexOf: " + s1.indexOf(ch));

        // lastIndexOf()
        System.out.println("LastIndexOf: " + s1.lastIndexOf(ch));

        sc.nextLine(); // clear buffer

        // startsWith()
        System.out.print("Enter prefix: ");
        String prefix = sc.nextLine();
        System.out.println("StartsWith: " + s1.startsWith(prefix));

        // endsWith()
        System.out.print("Enter suffix: ");
        String suffix = sc.nextLine();
        System.out.println("EndsWith: " + s1.endsWith(suffix));

        // matches()
        System.out.print("Enter regex: ");
        String regex = sc.nextLine();
        System.out.println("Matches: " + s1.matches(regex));

        // substring()
        if (s1.length() >= 2)
            System.out.println("Substring(0,3): " + s1.substring(0, 3));

        // toLowerCase()
        System.out.println("Lowercase: " + s1.toLowerCase());

        // trim()
        System.out.println("Trim: '" + s1.trim() + "'");

        // replace()
        System.out.print("Enter word to replace: ");
        String oldWord = sc.nextLine();
        System.out.print("Enter new word: ");
        String newWord = sc.nextLine();
        System.out.println("Replace: " + s1.replace(oldWord, newWord));

        // split()
        String arr[] = s1.split(" ");
        System.out.println("Split words:");
        for (String x : arr) {
            System.out.println(x);
        }

        // join()
        String joined = String.join("-", arr);
        System.out.println("Join: " + joined);

        // valueOf()
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        System.out.println("ValueOf: " + String.valueOf(num));

        sc.close();
    }
}

