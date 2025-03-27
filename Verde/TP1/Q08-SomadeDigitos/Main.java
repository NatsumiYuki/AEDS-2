import java.util.*;

public class Main {

    public static Integer numbersSum(int num){
        if(num < 10){
            return num;
        } else {
            return (num % 10) + numbersSum(num / 10);
        }
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String number = sc.nextLine();
        
        while(number.compareTo("FIM") != 0){
            int num = Integer.parseInt(number);
            int sum = numbersSum(num);
            System.out.println(sum);
            number = sc.nextLine();
        }


        sc.close();
    }
    
}
