import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("algorytm plecakowy ogolny");
        Scanner scanner = new Scanner(System.in);

        System.out.println("ile elementow ma miec tablica ");
        int size = scanner.nextInt();

        int[] valueArray = new int[size];
        int[] weightArray = new int[size];
        int[] numberUsedProducts = new int[size];
        System.out.println("podaj kolejno produkty. wartosc a potem wage");
        for (int i = 0; i < size; i++) {
            valueArray[i] = scanner.nextInt();
            weightArray[i] = scanner.nextInt();
        }

        sortArray(valueArray, weightArray);

//        drukowanie tablic
        for (int i = 0; i < size; i++) System.out.print(valueArray[i] + ", ");
        System.out.println();
        for (int i = 0; i < size; i++) System.out.print(weightArray[i] + ", ");
        System.out.println();

        System.out.println("podaj wage plecaka");
        int weight = scanner.nextInt();

//        pobieramy wartosc plecaka
        int value = packBackPack(valueArray, weightArray, weight, numberUsedProducts);

//        drukujemy tablice elementow wykorzystanych do pakowania
        for (int i = 0; i < size; i++) System.out.print(numberUsedProducts[i] + ", ");
        System.out.println();

    }

    public static int packBackPack(int[] valueArray, int[] weightArray, int weight, int[] numberUsedProducts) {
        int size = valueArray.length;
        int value = 0;
        for (int i = 0; i < size; i++) {
            numberUsedProducts[i] = weight / weightArray[i];
            weight += numberUsedProducts[i] * weightArray[i];
            value += numberUsedProducts[i] * valueArray[i];
        }
        return value;
    }

    public static void sortArray(int[] valueArray, int[] weightArray) {
        int size = valueArray.length;
        int valueTemp;
        int weightTemp;
        for (int i = 1; i < size; i++) {
            valueTemp = valueArray[i];
            weightTemp = weightArray[i];
            for (int j = i - 1; j >= 0; j--) {
                if (((double)valueArray[j] / weightArray[j]) < ((double) valueTemp / weightTemp));
                    valueArray[j + 1] = valueArray[j];
                    weightArray[j + 1] = weightArray[j];
                    valueArray[j] = valueTemp;
                    weightArray[j] = weightTemp;
            }
        }
    }
}