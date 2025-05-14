  
import java.util.*;

class Date {
    String dia;
    String mes;
    String ano;
}

class Jogadores {
    public String nome;
    public String foto;
    public Date nascimento;
    public int id;
    public int[] times;

    public void imprimir() {
        System.out.print(this.id + " " + this.nome + " " + this.foto + " ");
        System.out.print(this.nascimento.dia + "/" + this.nascimento.mes + "/" + this.nascimento.ano + " (");
        for (int i = 0; i < times.length; i++) {
            System.out.print(times[i]);
            if (i < times.length - 1)
                System.out.print(", ");
        }
        System.out.println(")");
    }

    public void ler(String input) {
        int i = 0;

        String[] partes = input.split(",", 5); 
        this.nome = partes[0];
        this.foto = partes[1];
        this.nascimento = new Date();

        String[] data = partes[2].split("/");
        this.nascimento.dia = data[0];
        this.nascimento.mes = data[1];
        this.nascimento.ano = data[2];

        this.id = Integer.parseInt(partes[3]);

        String timesStr = partes[4];
        timesStr = timesStr.replace("[", "").replace("]", "").replace(" ", "");
        String[] numeros = timesStr.split(",");
        this.times = new int[numeros.length];
        for (int j = 0; j < numeros.length; j++) {
            this.times[j] = Integer.parseInt(numeros[j]);
        }
    }
}
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        ArrayList<Jogadores> lista = new ArrayList<>();

        // Parte 1: leitura dos jogadores
        while (true) {
            String linha = sc.nextLine();
            if (linha.equals("FIM"))
                break;

            Jogadores j = new Jogadores();
            j.ler(linha);
            lista.add(j);
        }

        // Parte 2: pesquisa de nomes
        while (true) {
            String nomeBusca = sc.nextLine();
            if (nomeBusca.equals("FIM"))
                break;

            boolean encontrado = false;
            for (Jogadores j : lista) {
                if (j.nome.equals(nomeBusca)) {
                    encontrado = true;
                    break;
                }
            }

            if (encontrado)
                System.out.println("SIM");
            else
                System.out.println("NAO");
        }

        sc.close();
    }
}

