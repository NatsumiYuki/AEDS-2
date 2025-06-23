import java.io.*;
import java.util.*;

class Main {
    private static long[] parsedDates; // Armazena as datas convertidas para YYYYMMDD
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String path = "../disneyplus.csv"; // Ajuste o caminho conforme necessário
        Show[] lista = new Show[1369];
        int i = 0;

        String lerId = sc.nextLine();
        while (!lerId.equals("FIM")) {
            try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                br.readLine(); // Ignora o cabeçalho
                String line;
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

        parsedDates = new long[i];
        for (int j = 0; j < i; j++) {
            parsedDates[j] = parseDate(lista[j].getDate());
        }

        partialQuickSort(lista, 0, i - 1, 10);

        for (int j = 0; j < 10; j++) {
            lista[j].imprimir();
        }

        sc.close();
    }

    private static long parseDate(String dateStr) {
        if (dateStr == null || dateStr.equals("NaN")) {
            return Long.MAX_VALUE; // Data inválida tratada como valor alto
        }

        String[] parts = dateStr.split(", ");
        if (parts.length != 2) return Long.MAX_VALUE;

        String yearStr = parts[1].trim();
        String[] monthDay = parts[0].trim().split(" ");
        if (monthDay.length != 2) return Long.MAX_VALUE;

        String monthStr = monthDay[0];
        String dayStr = monthDay[1];

        try {
            int year = Integer.parseInt(yearStr);
            int day = Integer.parseInt(dayStr);
            int month;
            switch (monthStr.toLowerCase()) {
                case "january":
                    month = 1;
                    break;
                case "february":
                    month = 2;
                    break;
                case "march":
                    month = 3;
                    break;
                case "april":
                    month = 4;
                    break;
                case "may":
                    month = 5;
                    break;
                case "june":
                    month = 6;
                    break;
                case "july":
                    month = 7;
                    break;
                case "august":
                    month = 8;
                    break;
                case "september":
                    month = 9;
                    break;
                case "october":
                    month = 10;
                    break;
                case "november":
                    month = 11;
                    break;
                case "december":
                    month = 12;
                    break;
                default:
                    month = 13; // Mês inválido
                    break;
            }

            return year * 10000L + month * 100L + day;
        } catch (NumberFormatException e) {
            return Long.MAX_VALUE;
        }
    }

    private static void partialQuickSort(Show[] arr, int left, int right, int k) {
        if (left < right) {
            int pivot = partition(arr, left, right);
            partialQuickSort(arr, left, pivot - 1, k);
            if (pivot < k - 1) {
                partialQuickSort(arr, pivot + 1, right, k);
            }
        }
    }

    private static int partition(Show[] arr, int left, int right) {
        long pivotDate = parsedDates[right];
        String pivotTitle = arr[right].getTitle();
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (compare(arr[j], parsedDates[j], pivotDate, pivotTitle) < 0) {
                i++;
                swap(arr, i, j);
                swapParsedDates(i, j);
            }
        }

        swap(arr, i + 1, right);
        swapParsedDates(i + 1, right);
        return i + 1;
    }

    private static int compare(Show show, long currentDate, long pivotDate, String pivotTitle) {
        if (currentDate < pivotDate) {
            return -1;
        } else if (currentDate > pivotDate) {
            return 1;
        } else {
            return show.getTitle().compareTo(pivotTitle);
        }
    }

    private static void swap(Show[] arr, int i, int j) {
        Show temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void swapParsedDates(int i, int j) {
        long temp = parsedDates[i];
        parsedDates[i] = parsedDates[j];
        parsedDates[j] = temp;
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