import java.util.*;

public class Main{

    public static boolean findAnagrama(String w1, String w2){
        int size1 = w1.length();
        int size2 = w2.length();
        if(size1 != size2){
            return false;
        }

        //Trsform String to a array of chars
        char[] c1 = w1.toLowerCase().toCharArray();
        char[] c2 = w2.toLowerCase().toCharArray();

        //Sort the word if they have the same size INSERTIONNN
        insertionSort(c1);
        insertionSort(c2);

        for(int i = 0 ; i < size1 ; i++){
            if(c1[i] != c2[i]){
                return false;
            } 
        } 
        return true;
    }
        
    public static void insertionSort(char[] word){
        int size = word.length;
        for(int i = 1 ; i < size ; i++){
            char tmp = word[i];
            int j = i - 1;
            while((j >= 0) && (word[j] > tmp)){
                word[j + 1] = word[j];
                j--;
            }
            word[j + 1] = (char) tmp;
        }
        
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        while(line.compareTo("FIM") != 0){
            //POHA QUE ENTRADA DE MERDAAAAAAAAAA
            String[] word = line.split(" - ");
            String firstWord = word[0].trim(); 
            String secondWord = word[1].trim();

            boolean anagrama = findAnagrama(firstWord, secondWord);
            if(anagrama){
                System.out.println("SIM");
            } else {
                System.out.println("N\u00C3O");
            }

            line = sc.nextLine();
        }
        sc.close();
    }



}