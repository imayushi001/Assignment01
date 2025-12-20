import java.util.Scanner;

public class assignment1B {
    static int n;

    // Display Array
    static void display(int arr[]) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Insert element
    static void insert(int arr[], Scanner sc) {
        System.out.print("Enter position: ");
        int pos = sc.nextInt();

        System.out.print("Enter element: ");
        int ele = sc.nextInt();

        for (int i = n; i > pos; i--) {
            arr[i] = arr[i - 1];
        }
        arr[pos] = ele;
        n++;
    }

    // Delete element
    static void delete(int arr[], Scanner sc) {
        System.out.print("Enter position: ");
        int pos = sc.nextInt();

        for (int i = pos; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }
        n--;
    }

    // Linear Search
    static void linearSearch(int arr[], Scanner sc) {
        System.out.print("Enter element to search: ");
        int key = sc.nextInt();

        for (int i = 0; i < n; i++) {
            if (arr[i] == key) {
                System.out.println("Element found at index " + i);
                return;
            }
        }
        System.out.println("Element not found");
    }

    // Binary Search
    static void binarySearch(int arr[], Scanner sc) {
        System.out.print("Enter element to search: ");
        int key = sc.nextInt();

        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == key) {
                System.out.println("Element found at index " + mid);
                return;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("Element not found");
    }

    // Find Maximum
    static void findMax(int arr[]) {
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("Maximum element: " + max);
    }

    // Even Odd Count
    static void evenOdd(int arr[]) {
        int even = 0, odd = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0)
                even++;
            else
                odd++;
        }
        System.out.println("Even count: " + even);
        System.out.println("Odd count: " + odd);
    }

    // Insertion Sort
    static void insertionSort(int arr[]) {
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        System.out.println("Array sorted using Insertion Sort");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[50];

        System.out.print("Enter number of elements: ");
        n = sc.nextInt();

        System.out.println("Enter elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Linear Search");
            System.out.println("4. Binary Search");
            System.out.println("5. Find Maximum");
            System.out.println("6. Count Even/Odd");
            System.out.println("7. Insertion Sort");
            System.out.println("8. Display Array");
            System.out.println("9. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: insert(arr, sc); break;
                case 2: delete(arr, sc); break;
                case 3: linearSearch(arr, sc); break;
                case 4: binarySearch(arr, sc); break;
                case 5: findMax(arr); break;
                case 6: evenOdd(arr); break;
                case 7: insertionSort(arr); break;
                case 8: display(arr); break;
                case 9: System.out.println("Exiting"); break;
                default: System.out.println("Invalid choice");
            }
        } while (choice != 9);

        sc.close();
    }
}
