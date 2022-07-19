import java.util.Scanner;

/*На вход дано шестизначное число (номер билета), проверить,
что билет является счастливым (сумма первых трёх цифры равна сумме последних трёх цифр).
 */
public class Task2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int ticketNumberInt = 0;
        int ticketLength = 6;
        int leftSideTicketSum = 0;
        int rightSideTicketSum = 0;
        int counter = 0;
        int numberOfRightTicketConditions = 2;

        String ticketNumberString;

        System.out.println("Please enter a 6-digit ticket number.");

        while (counter != numberOfRightTicketConditions){

            ticketNumberString = scanner.next();
            counter = 0;

            if (ticketNumberString.length() != ticketLength){
                System.out.println("The ticket number should contain 6 digits. Please type the correct number.");
            }
            else {
                counter++;
            }
            try {
                ticketNumberInt = Integer.parseInt(ticketNumberString);
                counter++;
            }
            catch (NumberFormatException e){
                System.out.println("The ticket should contain only numbers. Please type the number again.");
            }
        }

        scanner.close();

        for (int i = 0; i <= ticketLength; i++){
            if (i < ticketLength / 2){ //calculating the right side sum of the ticket
                rightSideTicketSum += ticketNumberInt % 10; //mod 10 for getting the last digit
            }
            else { //calculating the left side sum of the ticket
                leftSideTicketSum += ticketNumberInt % 10; //mod 10 for getting the last digit
            }
                ticketNumberInt /= 10; //dividing by 10 for getting rid of last digit
            }
        if (leftSideTicketSum == rightSideTicketSum){
            System.out.println("Lucky ticket! Congrats! Now you can eat it!");
        }
        else {
            System.out.println("Regular ticket. Ride more and good luck!");
        }
    }
}
