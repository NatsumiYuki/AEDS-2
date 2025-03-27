import java.util.*;

public class Main{
    
    public static void verifyString(String word){
    int size = word.length();

    boolean parenteses = true;
    boolean chaves = true;
    boolean couchete = true;
    int parentesesA = 0;
    int coucheteA = 0;
    int chavesA = 0; 

    for(int i = 0 ; i < size ; i++){

        char c = word.charAt(i);
        if (c == '(') {
            parentesesA++;
        } else if(c == ')'){
            parentesesA--;
            if (parentesesA < 0) {
                parenteses = false;
            }
        }

        if (c == '[') {
            coucheteA++;
        } else if (c == ']'){
            coucheteA--;
            if (coucheteA < 0) {
                couchete = false;
            }
        }

        if(c == '{'){
            chavesA++;
        } else if (c == '}'){
            chavesA--;
            if (chavesA < 0) {
                chaves = false;
            }
        } 
    }
    boolean answer = parenteses && couchete && chaves && parentesesA == 0 && coucheteA == 0 && chavesA == 0; 
        if(answer){
            System.out.println("SLAY GIRL");
        } else {
            System.out.println("kk");
        }
}

        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String word = sc.nextLine();
            verifyString(word); 
        }
        sc.close();
    }
}
