import java.util.Scanner;
import java.util.Arrays;

public class Products {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] array = inputArray();
        displayArray(array);
        int choice = -1;
        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: {
                    System.out.println("Enter name product add : ");
                    String nameAddProduct = scanner.nextLine();
                    array = addProduct(nameAddProduct, array);
                    System.out.println("Added " + nameAddProduct);
                    displayArray(array);
                    break;
                }
                case 2: {
                    System.out.println("Enter name delete product : ");
                    String nameDeleteProduct = scanner.nextLine();
                    array = deleteProduct(nameDeleteProduct, array);
                    if (findIndex(array, nameDeleteProduct) == -1) {
                        System.out.println(nameDeleteProduct + " not in array");
                        displayArray(array);
                    } else {
                        System.out.println("Deleted " + nameDeleteProduct);
                        displayArray(array);
                    }
                    break;
                }
                case 3: {
                    System.out.println("Enter the name you want to search : ");
                    String nameProductSearch = scanner.nextLine();
                    if (findIndex(array, nameProductSearch) != -1) {
                        System.out.printf("Product '%s' found at index %d \n", findProduct(array, nameProductSearch), findIndex(array, nameProductSearch));
                    } else {
                        System.out.printf("Product %s was not found !! \n", nameProductSearch);
                    }
                    break;
                }
                case 4: {
                    sortArray(array);
                    System.out.println("Sorted!");
                    displayArray(array);
                    break;
                }
                case 5: {
                    displayArray(array);
                    break;
                }
                case 6: {
                    System.out.println("Enter index edit : ");
                    int indexEdit = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter name product edit : ");
                    String nameEdit = scanner.nextLine();
                    updateProduct(array, indexEdit, nameEdit);
                    displayArray(array);
                    break;
                }
                case 0: {
                    System.exit(0);
                    break;
                }
                default: {
                    System.out.println("Does not exist. Please re-enter!!");
                    break;
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

    static public String[] addProduct(String nameAddProduct, String[] array) {
        String[] newArray = createArray(array.length + 1);
        for (int i = 0; i < newArray.length - 1; i++) {
            newArray[i] = array[i];
        }
        newArray[newArray.length - 1] = nameAddProduct;
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

    static public String[] deleteProduct(String nameDeleteProduct, String[] array) {
        String[] newArrayDelete = createArray(array.length - 1);
        int index = findIndex(array, nameDeleteProduct);
        if (index != -1) {
            for (int i = 0; i < newArrayDelete.length; i++) {
                if (i < index) {
                    newArrayDelete[i] = array[i];
                } else {
                    newArrayDelete[i] = array[i + 1];
                }
            }
        } else {
            newArrayDelete = array;
        }
        return newArrayDelete;
    }

    static public String findProduct(String[] array, String name) {
        int index = findIndex(array, name);
        return array[index];
    }

    static public void updateProduct(String[] array, int indexProduct, String nameEdit) {
        array[indexProduct] = nameEdit;
    }

    static public void sortArray(String[] array) {
        Arrays.sort(array);
    }

    static public void displayMenu() {
        System.out.println("Menu");
        System.out.println("1: Add product");
        System.out.println("2: Delete product");
        System.out.println("3: Search product");
        System.out.println("4: Sort product");
        System.out.println("5: Display array product");
        System.out.println("6: Update product");
        System.out.println("0: Exit");
    }
}