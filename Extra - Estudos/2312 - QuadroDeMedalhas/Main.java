import java.util.*;

class Paises {
    String pais;
    int ouro, prata, bronze;
    
    public Paises(String pais, int ouro, int prata, int bronze) {
        this.pais = pais;
        this.ouro = ouro;
        this.prata = prata;
        this.bronze = bronze;
    }
}

public class Main {
    public static void sortWinner(Paises[] p, int n) {
        for (int i = 0; i < n - 1; i++) {
            int maior = i;
            for (int j = i + 1; j < n; j++) {
                // Compara ouro
                if (p[j].ouro > p[maior].ouro) {
                    maior = j;
                } 
                else if (p[j].ouro == p[maior].ouro) {
                    // Se ouro igual, compara prata
                    if (p[j].prata > p[maior].prata) {
                        maior = j;
                    } 
                    else if (p[j].prata == p[maior].prata) {
                        // Se prata igual, compara bronze
                        if (p[j].bronze > p[maior].bronze) {
                            maior = j;
                        }
                        else if (p[j].bronze == p[maior].bronze) {
                            // Se tudo igual, ordena alfabeticamente
                            if (p[j].pais.compareTo(p[maior].pais) < 0) {
                                maior = j;
                            }
                        }
                    }
                }
            }
            // Troca os elementos
            Paises tmp = p[i];
            p[i] = p[maior];
            p[maior] = tmp;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numPaises = sc.nextInt();
        Paises[] paises = new Paises[numPaises];

        for (int i = 0; i < numPaises; i++) {
            String pais = sc.next();
            int ouro = sc.nextInt();
            int prata = sc.nextInt();
            int bronze = sc.nextInt();
            paises[i] = new Paises(pais, ouro, prata, bronze);
        }
        
        sortWinner(paises, numPaises);
        
        // Imprime o resultado
        for (Paises pais : paises) {
            System.out.println(pais.pais + " " + pais.ouro + " " + pais.prata + " " + pais.bronze);
        }

        sc.close();
    }
}