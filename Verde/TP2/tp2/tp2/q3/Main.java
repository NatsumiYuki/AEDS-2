import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Main {
    public static int comparacoes = 0;

    public static boolean pesqseq(Show lista[], String title, int n) {
        boolean resp = false;

        for (int i = 0; i < n; i++) {
            comparacoes++;
            if (lista[i].getTitle().equals(title)) {
                resp = true;
                break; // podemos parar assim que encontrar
            }
        }

        return resp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String path = "/tmp/disneyplus.csv";
        Show[] lista = new Show[1369];
        int i = 0;

        String lerId = sc.nextLine();
        while (!lerId.equals("FIM")) {
            try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                String line = br.readLine(); // pular cabeçalho

                while ((line = br.readLine()) != null) {
                    String[] campos = Show.splitCSV(line);
                    if (campos.length > 0 && campos[0].equals(lerId)) {
                        Show show = new Show();
                        show.ler(line);
                        lista[i++] = show;
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            lerId = sc.nextLine();
        }

        // Início da contagem de tempo
        long inicio = System.nanoTime();

        String lerTitle = sc.nextLine();
        while (!lerTitle.equals("FIM")) {
            boolean res = pesqseq(lista, lerTitle, i);
            System.out.println(res ? "SIM" : "NAO");
            lerTitle = sc.nextLine();
        }

        // Fim da contagem de tempo
        long fim = System.nanoTime();
        long tempo = fim - inicio;

        // Gravação do log
        String matricula = "858399"; 
        try {
            PrintWriter pw = new PrintWriter(matricula + "_sequencial.txt");
            pw.printf("%s\t%.3f\t%d\n", matricula, tempo / 1e6, comparacoes);
            pw.close();
        } catch (IOException e) {
            System.out.println("Erro ao gravar o arquivo de log.");
        }

        sc.close();
    }
}


class Show {
    private String id;
    private String type;
    private String title;

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("MMMM dd, yyyy", Locale.ENGLISH);

    private String director;
    private String[] cast;
    private String country;
    private LocalDate date;
    private int year;
    private String rating;
    private String duration;
    private String[] listed;

    public String getId() { return id; } 
    public String getType() { return type; }
    public String getTitle() { return title; }
    public String getDirector() { return director; }
    public String[] getCast() { return cast; }
    public String getCountry() { return country; }
    public LocalDate getDate() { return date; }
    public int getYear() { return year; }
    public String getRating() { return rating; }
    public String getDuration() { return duration; }
    public String[] getListed() { return listed; }
    
    public void setId(String id) { this.id = id; }
    public void setType(String type) { this.type = type; }
    public void setTitle(String title) { this.title = title; }
    public void setDirector(String director) { this.director = director; }
    public void setCast(String[] cast) { this.cast = cast; }
    public void setCountry(String country) { this.country = country; }
    public void setDate(LocalDate date) { this.date = date; }
    public void setYear(int year) { this.year = year; }
    public void setRating(String rating) { this.rating = rating; }
    public void setDuration(String duration) { this.duration = duration; }
    public void setListed(String[] listed) { this.listed = listed; }

    public Show(String id, String type, String title, String director, String[] cast, String country, LocalDate date, int year, String rating, String duration, String[] listed) {
        setId(id);
        setType(type);
        setTitle(title);
        setDirector(director);
        setCast(cast);
        setCountry(country);
        setDate(date);
        setYear(year);
        setRating(rating);
        setDuration(duration);
        setListed(listed);
    }

    public Show() {}

    public static String[] splitCSV(String line) {
        List<String> campos = new ArrayList<>();
        boolean entreAspas = false;
        StringBuilder campo = new StringBuilder();

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            if (c == '"') {
                entreAspas = !entreAspas;
            } else if (c == ',' && !entreAspas) {
                campos.add(campo.toString().trim());
                campo.setLength(0); // resetar stringbuilder
            } else {
                campo.append(c);
            }
        }
        campos.add(campo.toString().trim());

        return campos.toArray(new String[0]);
    }

    public void ler(String csv) {
        String[] campos = splitCSV(csv);
    
        if (campos.length >= 11) {
            setId(campos[0].isEmpty() ? "NaN" : campos[0]);
            setType(campos[1].isEmpty() ? "NaN" : campos[1]);
            setTitle(campos[2].isEmpty() ? "NaN" : campos[2]);
            setDirector(campos[3].replace("\"", "").isEmpty() ? "NaN" : campos[3].replace("\"", ""));
    
            String castStr = campos[4].replace("\"", "");
            String[] castArray = castStr.isEmpty() ? new String[]{"NaN"} : castStr.split(", ");
            if (!castStr.isEmpty()) Arrays.sort(castArray);
            setCast(castArray);
    
            setCountry(campos[5].replace("\"", "").isEmpty() ? "NaN" : campos[5].replace("\"", ""));
    
            String dateStr = campos[6].replace("\"", "");
            try {
                setDate(dateStr.isEmpty() ? null : LocalDate.parse(dateStr, DATE_FORMATTER));
            } catch (Exception e) {
                setDate(null);
            }
    
            setYear(campos[7].isEmpty() ? 0 : Integer.parseInt(campos[7]));
            setRating(campos[8].isEmpty() ? "NaN" : campos[8]);
            setDuration(campos[9].isEmpty() ? "NaN" : campos[9]);
    
            String[] listedArray = campos[10].isEmpty() ? new String[]{"NaN"} : campos[10].split(", ");
            setListed(listedArray);
        }
    }

    public void imprimir() {
        System.out.printf("=> %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ##\n",
            id, type, title, director, Arrays.toString(cast), country,
            date == null ? "NaN" : DATE_FORMATTER.format(date),
            year == 0 ? "NaN" : String.valueOf(year),
            rating, duration, Arrays.toString(listed));
    }
}
