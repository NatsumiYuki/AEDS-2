import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

            int rodadas = sc.nextInt();
            while (rodadas != 0) {
            
            int[] mark = new int[rodadas];
            int[] leti = new int[rodadas];

            for (int i = 0; i < rodadas; i++) mark[i] = sc.nextInt();
            for (int i = 0; i < rodadas; i++) leti[i] = sc.nextInt();

            int pontosM = 0, pontosL = 0;
            for (int i = 0; i < rodadas; i++) {
                pontosM += mark[i];
                pontosL += leti[i];
            }

            boolean markExtra = false, letiExtra = false;
            int markRodada = rodadas, letiRodada = rodadas;

            // Verifica a primeira ocorrência para cada jogador
            for (int i = 2; i < rodadas; i++) {
                if (!markExtra && mark[i] == mark[i-1] && mark[i] == mark[i-2]) {
                    markExtra = true;
                    markRodada = i;
                }
                if (!letiExtra && leti[i] == leti[i-1] && leti[i] == leti[i-2]) {
                    letiExtra = true;
                    letiRodada = i;
                }
            }

            int extraM = 0, extraL = 0;
            
            // Só concede extras se for o único ou se ocorrer primeiro
            if (markExtra && (!letiExtra || markRodada < letiRodada)) {
                extraM = 30;
            }
            if (letiExtra && (!markExtra || letiRodada < markRodada)) {
                extraL = 30;
            }

            int totalM = pontosM + extraM;
            int totalL = pontosL + extraL;

            if (totalL > totalM) System.out.println("L");
            else if (totalM > totalL) System.out.println("M");
            else System.out.println("T");
            rodadas = sc.nextInt();
        }
        sc.close();
    }
}