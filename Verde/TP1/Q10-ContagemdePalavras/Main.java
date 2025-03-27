import java.util.*;

public class Main {

    public static int countWords(String line){
        int size = line.length();
        int space = 0;
        for(int i = 0 ; i < size ; i++){
            char c = line.charAt(i);
            if(c == ' '){
                space++;
            }
        }
        return space + 1;
    }
    public static void main(String[] aStrings){
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        while(line.compareTo("FIM") != 0){
            int words = countWords(line);
            System.out.println(words);
            line = sc.nextLine();
        }

        sc.close();
    }
}
