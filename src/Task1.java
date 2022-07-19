//Вывести числа от 1000 до 1 с шагом -2.
public class Task1 {
    public static void main(String[] args) {
        int startNumber = 1000;
        int endNumber = 1;
        int step = 2;
        for (int i = startNumber; i > endNumber; i -= step){
            System.out.println(i);
        }
    }
}
