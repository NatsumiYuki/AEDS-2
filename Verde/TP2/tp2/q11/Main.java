import java.io.*;
import java.util.*;

class Main {
    public static void sort(Show[] lista, int n) {
        if (n <= 1) return;
    
        int minYear = lista[0].getYear();
        int maxYear = lista[0].getYear();
        for (int i = 1; i < n; i++) {
            int currentYear = lista[i].getYear();
            if (currentYear < minYear) minYear = currentYear;
            if (currentYear > maxYear) maxYear = currentYear;
        }
    
        int range = maxYear - minYear + 1;
    
        int[] count = new int[range];
        for (int i = 0; i < n; i++) {
            count[lista[i].getYear() - minYear]++;
        }
    
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }
    
        Show[] output = new Show[n];
        for (int i = n - 1; i >= 0; i--) {
            int yearIndex = lista[i].getYear() - minYear;
            output[count[yearIndex] - 1] = lista[i];
            count[yearIndex]--;
        }
    
        System.arraycopy(output, 0, lista, 0, n);
    
        for (int i = 1; i < n; i++) {
            if (lista[i].getYear() == lista[i - 1].getYear()) {
                int j = i;
                while (j > 0 && lista[j].getYear() == lista[j - 1].getYear() &&
                       lista[j].getTitle().toLowerCase().compareTo(lista[j - 1].getTitle().toLowerCase()) < 0) {
                    Show temp = lista[j];
                    lista[j] = lista[j - 1];
                    lista[j - 1] = temp;
                    j--;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String path = "/tmp/disneyplus.csv";
        // String path = "../disneyplus.csv";

        Show[] lista = new Show[1369];
        int i = 0;

        String lerId = sc.nextLine();
        while (!lerId.equals("FIM"))  {
            try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                String line = br.readLine(); // ignorar primeira linha
                // br.readLine();

                while ((line = br.readLine()) != null) {
                    String[] campos = Show.splitCSV(line);

                    if (campos.length > 0 && campos[0].equals(lerId)) {
                        Show show = new Show();
                        show.ler(line);
                        lista[i++] = show;
                        break;
                    }

                }
            } catch (Exception e) {}
            
            lerId = sc.nextLine();
        }

        sort(lista, i);
        for (int j = 0; j < i; j++) {
            lista[j].imprimir();
        }

        sc.close();
    }
}

class Show {
    private String id;
    private String type;
    private String title;
    private String director;
    private String[] cast;
    private String country;
    private String date;
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
    public String getDate() { return date; }
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
    public void setDate(String date) { this.date = date; }
    public void setYear(int year) { this.year = year; }
    public void setRating(String rating) { this.rating = rating; }
    public void setDuration(String duration) { this.duration = duration; }
    public void setListed(String[] listed) { this.listed = listed; }

    public Show(String id, String type, String title, String director, String[] cast, String country, String date, int year, String rating, String duration, String[] listed) {
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

            String dateStr = campos[6].replace("\"", "").trim();
            setDate(dateStr.isEmpty() ? "NaN" : dateStr);

            setYear(campos[7].isEmpty() ? 0 : Integer.parseInt(campos[7]));
            setRating(campos[8].isEmpty() ? "NaN" : campos[8]);
            setDuration(campos[9].isEmpty() ? "NaN" : campos[9]);

            String[] listedArray = campos[10].isEmpty() ? new String[]{"NaN"} : campos[10].split(", ");
            setListed(listedArray);
        }
    }

    public void imprimir() {
        System.out.printf("=> %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ##\n",
            id, title, type, director, Arrays.toString(cast), country,
            date, // Imprime a string diretamente
            year == 0 ? "NaN" : String.valueOf(year),
            rating, duration, Arrays.toString(listed));
    }

    public Show clone() {
        Show clone = new Show();
        clone.id = this.id != null ? new String(this.id) : null;
        clone.type = this.type != null ? new String(this.type) : null;
        clone.title = this.title != null ? new String(this.title) : null;
        clone.director = this.director != null ? new String(this.director) : null;
        clone.country = this.country != null ? new String(this.country) : null;
        clone.date = this.date != null ? new String(this.date) : null;
        clone.year = this.year;
        clone.rating = this.rating != null ? new String(this.rating) : null;
        clone.duration = this.duration != null ? new String(this.duration) : null;

        if (this.cast != null) {
            clone.cast = new String[this.cast.length];
            for (int i = 0; i < this.cast.length; i++) {
                clone.cast[i] = this.cast[i] != null ? new String(this.cast[i]) : null;
            }
        } else {
            clone.cast = null;
        }

        if (this.listed != null) {
            clone.listed = new String[this.listed.length];
            for (int i = 0; i < this.listed.length; i++) {
                clone.listed[i] = this.listed[i] != null ? new String(this.listed[i]) : null;
            }
        } else {
            clone.listed = null;
        }

        return clone;
    }
}