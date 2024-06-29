import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            cars.add(new Car("Model " + i, 2020 + i));
        }

        List<Item> items = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            items.add(new Item(i, "Item " + i));
        }

        List<Item> firstFiveItems = items.subList(0, 5);
        HashSet<Item> itemHashSet = new HashSet<>(firstFiveItems);

        int[] array = new int[10];
        try {
            fillArray(array);
        } catch (NegativeNumberException e) {
            System.out.println("Exception occurred: " + e.getMessage());
            array[0] = 0; // Fill array with 0 if exception occurs
        }


        System.out.println("Cars:");
        for (Car car : cars) {
            System.out.println("Model: " + car.getModelName() + ", Year: " + car.getProductionYear());
        }
        System.out.println();

        System.out.println("HashSet content:");
        for (Item item : itemHashSet) {
            System.out.println("Item id: " + item.getItemId() + ", Item name: " + item.getItemName());
        }
        System.out.println();

        System.out.println("Array content:");
        System.out.println(Arrays.toString(array));
    }

    public static int readNumber() throws NegativeNumberException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        if (number < 0) {
            throw new NegativeNumberException("Negative numbers are not allowed.");
        }
        return number;
    }

    public static void fillArray(int[] array) throws NegativeNumberException {
        for (int i = 0; i < array.length; i++) {
            try {
                array[i] = readNumber();
            } catch (NegativeNumberException e) {
                throw new NegativeNumberException("Negative number encountered at index " + i);
            }
        }
    }
}