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
public class Task3_v2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int possibleCombinations = 0;

        System.out.println("Please enter weight of present.");

        int weightOfPresent = scanner.nextInt();

        while(weightOfPresent <= 0){
            System.out.println("Please enter weight greater than zero.");
            weightOfPresent = scanner.nextInt();}

        System.out.println("Please enter weight of orange.");
        int weightOfOrange = scanner.nextInt();
        System.out.println("Please enter weight of apple.");
        int weightOfApple = scanner.nextInt();
        System.out.println("Please enter weight of pear.");
        int weightOfPear = scanner.nextInt();

        int maxCapacityPear = weightOfPresent/weightOfPear;
        int maxCapacityApple = weightOfPresent/weightOfApple;

        int currTotalWeightPear;
        int currTotalWeightApple;
        int currTotalWeightOrange;
        int currPossibleAmountOrange;
        int currTotalWeight;

        for (int i = 0; i <= maxCapacityPear; i++){
            for (int j = 0; j <= maxCapacityApple; j++){
                currTotalWeightPear = weightOfPear * i;
                currTotalWeightApple = weightOfApple * j;
                currPossibleAmountOrange = (weightOfPresent - currTotalWeightPear - currTotalWeightApple)
                        / weightOfOrange;
                currTotalWeightOrange = weightOfOrange * currPossibleAmountOrange;
                currTotalWeight = currTotalWeightPear + currTotalWeightApple + currTotalWeightOrange;
                if (currPossibleAmountOrange >= 0 && currTotalWeight == weightOfPresent){
                    possibleCombinations++;
                }
            }
        }
        System.out.println("Number of possible combinations: " + possibleCombinations);
    }
}
