import java.util.Scanner;

public class Calculator {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String calculatorState = "start";
        String wordToStopCalculator = "stop";

        while (!calculatorState.equals(wordToStopCalculator)){

            double firstNumber = getNumber();
            double secondNumber = getNumber();
            char operator = getOperator();

            //checking if secondNumber is null and operation is division
            while (secondNumber == 0 && String.valueOf(operator).equals("/")) {
                System.out.println("You can't divide by zero. Please enter another number");
                secondNumber = scanner.nextDouble();
            }

            double result = getResult(firstNumber, secondNumber, operator);

            System.out.println(firstNumber + " " + operator + " " + secondNumber + " = " + result);
            System.out.println("Please type any letter to continue.\nType 'stop' to exit.");
            calculatorState = scanner.next();
        }
        scanner.close();
    }
    public static double getNumber(){
        double number;
        System.out.println("Please enter a number.");
        if (scanner.hasNextDouble()){
            number = scanner.nextDouble();
        }
        else {
            System.out.println("Error! Please enter a number.");
            scanner.next();
            number = getNumber();
        }
        return number;
    }

    public static char getOperator(){
        System.out.println("Please type operation from the list: +, -, *, /");
        char operator;
        operator = scanner.next().charAt(0);
        String operatorsString = "+-*/";
        String operatorCheck = String.valueOf(operator);
        if (operatorsString.contains(operatorCheck)){
            return operator;
        }
        else {
            System.out.println("Error!");
            operator = getOperator();
        }
        return operator;
    }

    public static double getResult(double firstNumber, double secondNumber, char operator){
        double result = 0;
        switch (operator) {
            case '+':
                result = firstNumber + secondNumber;
                break;
            case '-':
                result = firstNumber - secondNumber;
                break;
            case '*':
                result = firstNumber * secondNumber;
                break;
            case '/':
                result = firstNumber / secondNumber;
                break;
        }
        return result;
    }
}

