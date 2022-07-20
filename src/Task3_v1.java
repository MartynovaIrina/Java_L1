import java.util.Scanner;
/*На вход программы подаётся 4 числа: вес подарка, вес апельсина, вес яблока, вес груши. Каждый подарок состоит из произвольного набора апельсинов, яблок и груш, необходимо вывести количество способов составить подарок с заданными весом.
	Пример:
	Вход программы: 40 25 15 10
	Ответ: 3
	Пояснение:
	1 вариант - 1 апельсин весом 25 и 1 яблоко весом 15.
	2 вариант - 2 яблока весом 15 и 1 груша.
	3 вариант - 4 груши.
*/
public class Task3_v1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int amountOfFruits = 3;
        int[] weightOfFruits = new int[amountOfFruits];
        int[] arr = new int[amountOfFruits]; //array for current quantity options

        System.out.println("Please enter weight of present.");

        int weightOfPresent = scanner.nextInt();
        int sum;
        int possibleCombinations = 0;

        System.out.printf("Please enter weight of %d fruits.", amountOfFruits);
        System.out.println();

        for (int i = 0; i < amountOfFruits; i++) {
            weightOfFruits[i] = scanner.nextInt();
        }

        outer:
        while (true) {
            sum = 0;
            for (int j = 0; j < amountOfFruits; j++){
                sum += weightOfFruits[j] * arr[j];
            }
            if (sum == weightOfPresent && weightOfPresent != 0) {
                possibleCombinations++;
            }

            int i = amountOfFruits - 1;//placing the pointer on the last index
            while (arr[i] * weightOfFruits[i] > weightOfPresent) {
                //moving left every time when the cell is no longer suit the condition
                arr[i] = 0;//putting 0 since moving forward to the next cell
                i--;//moving left
                //we should stop once we reach the beginning of the array
                if (i < 0) break outer;
            }
            arr[i]++;
        }
        System.out.println("Number of possible combinations: " + possibleCombinations);
    }
}
