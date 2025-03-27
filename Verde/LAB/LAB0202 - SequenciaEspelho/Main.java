import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (sc.hasNext()) {  // Continua enquanto houver mais entradas
            int inicio = sc.nextInt();
            int fim = sc.nextInt();
            
            String normal = "";
           
            for (int i = inicio; i <= fim; i++) { // Criando a sequência crescente
                normal += i; // Concatenando os números na sequência
            }

            String espelho = "";
           
            for (int i = normal.length() - 1; i >= 0; i--) { // Criando a parte espelhada (invertida)
                espelho += normal.charAt(i); // Percorrendo a string ao contrário
            }

            // Exibindo o resultado final
            System.out.println(normal + espelho);
        }
        
        sc.close(); 
    }
}
