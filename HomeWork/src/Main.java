import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] update;
        String[] array = inputArray();
        update = updateArray(array);
        sortArray(update);
        displayArray(update);

        System.out.println("Menu");
        System.out.println("1: Add product");
        System.out.println("2: Delete product");
        System.out.println("3: Search product");
        System.out.println("4: Sort product");
        System.out.println("0: Exit");
        int choice = scanner.nextInt();
        scanner.nextLine();
        do {
            switch (choice) {
                case 1: {
                    System.out.println("Enter name product add : ");
                    String add_product = scanner.nextLine();
                    String[] newArray = addProduct(add_product, array);
                    update = updateArray(newArray);
                    displayArray(update);
                    break;
                }
                case 2: {
                    System.out.println("Enter name delete product : ");
                    String del_product = scanner.nextLine();
                    String[] newArrayDelete = deleteProduct(del_product, update);
                    update = updateArray(newArrayDelete);
                    displayArray(update);
                    break;
                }
                case 3: {
                    System.out.println("Enter the name you want to search : ");
                    String name_search = scanner.nextLine();
                    if (findIndex(update, name_search) != -1) {
                        System.out.printf("Find '%s' at : %d", findProduct(update, name_search), findIndex(update, name_search));
                    } else {
                        System.out.println("Not found !!");
                    }
                    break;
                }
                case 4: {
                    sortArray(update);
                    break;
                }
                case 0: {
                    System.out.println("Exit application");
                    System.exit(0);
                    break;
                }
                default: {
                    System.out.println("Does not exist. Please re-enter!!");
                }
            }
        } while (choice != 0);


    }

    public static String[] createArray(int size) {
        String[] array = new String[size];
        return array;
    }

    static public String[] inputArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size of array : ");
        int size = scanner.nextInt();
        scanner.nextLine();
        String[] array = createArray(size);
        for (int i = 0; i < size; i++) {
            System.out.println("Enter product " + i + " : ");
            array[i] = scanner.nextLine();
        }
        return array;
    }

    static public void displayArray(String[] array) {
        System.out.println("Array product " + Arrays.toString(array));
    }

    static public String[] addProduct(String add_product, String[] array) {
        String[] newArray = createArray(array.length + 1);
        for (int i = 0; i < newArray.length - 1; i++) {
            newArray[i] = array[i];
        }
        newArray[newArray.length - 1] = add_product;
        return newArray;
    }

    public static int findIndex(String[] array, String str) {
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (str.equals(array[i])) {
                index = i;
                break;
            }
            index = -1;
        }
        return index;
    }

    static public String[] deleteProduct(String del_product, String[] array) {
        String[] newArrayDelete = createArray(array.length - 1);
        int index = findIndex(array, del_product);
        for (int i = 0; i < newArrayDelete.length; i++) {
            if (i < index) {
                newArrayDelete[i] = array[i];
            } else {
                newArrayDelete[i] = array[i + 1];
            }
        }
        return newArrayDelete;
    }

    static public String findProduct(String[] array, String name) {
        int index = findIndex(array, name);
        return array[index];
    }

    static public void sortArray(String[] array) {
        Arrays.sort(array);
    }

    static public String[] updateArray(String[] array) {
        String[] update = array;
        return update;
    }
}