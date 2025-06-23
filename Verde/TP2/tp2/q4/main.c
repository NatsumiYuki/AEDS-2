#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <stdbool.h>

#define MAX_LINE_LENGTH 1024
#define MAX_FIELDS 12
#define MAX_CAST 100
#define MAX_LISTED 10

typedef struct {
    char* id;
    char* type;
    char* title;
    char* director;
    char** cast;
    int cast_count;
    char* country;
    char* date;
    int year;
    char* rating;
    char* duration;
    char** listed;
    int listed_count;
} Show;

char** splitCSV(const char* line, int* field_count) {
    char** fields = malloc(MAX_FIELDS * sizeof(char*));
    *field_count = 0;
    bool in_quotes = false;
    char field[256];
    int field_index = 0;

    for (int i = 0; line[i] != '\0'; i++) {
        char c = line[i];
        if (c == '"') {
            in_quotes = !in_quotes;
        } else if (c == ',' && !in_quotes) {
            field[field_index] = '\0';
            fields[*field_count] = strdup(field);
            (*field_count)++;
            field_index = 0;
        } else {
            field[field_index++] = c;
        }
    }
    field[field_index] = '\0';
    if (field_index > 0) {
        fields[*field_count] = strdup(field);
        (*field_count)++;
    }
    return fields;
}

void freeFields(char** fields, int count) {
    for (int i = 0; i < count; i++) {
        free(fields[i]);
    }
    free(fields);
}

int compareStrings(const void* a, const void* b) {
    return strcmp(*(const char**)a, *(const char**)b);
}

int compareTitles(const void* a, const void* b) {
    const Show* showA = (const Show*)a;
    const Show* showB = (const Show*)b;
    return strcmp(showA->title, showB->title);
}

void ler(Show* show, const char* csv) {
    int field_count;
    char** campos = splitCSV(csv, &field_count);

    if (field_count >= 11) {
        show->id = strdup(campos[0][0] == '\0' ? "NaN" : campos[0]);
        show->type = strdup(campos[1][0] == '\0' ? "NaN" : campos[1]);
        show->title = strdup(campos[2][0] == '\0' ? "NaN" : campos[2]);

        char* director = campos[3];
        if (director[0] == '"') {
            director++;
            director[strlen(director) - 1] = '\0';
        }
        show->director = strdup(director[0] == '\0' ? "NaN" : director);

        char* cast_str = strdup(campos[4]);
        if (cast_str[0] == '"') {
            cast_str++;
            cast_str[strlen(cast_str) - 1] = '\0';
        }
        if (cast_str[0] == '\0') {
            show->cast = malloc(sizeof(char*));
            show->cast[0] = strdup("NaN");
            show->cast_count = 1;
        } else {
            show->cast = malloc(MAX_CAST * sizeof(char*));
            show->cast_count = 0;
            char* start = cast_str;
            char* end;
            while ((end = strstr(start, ", ")) != NULL && show->cast_count < MAX_CAST) {
                *end = '\0';
                show->cast[show->cast_count++] = strdup(start);
                start = end + 2;
            }
            if (*start != '\0' && show->cast_count < MAX_CAST) {
                show->cast[show->cast_count++] = strdup(start);
            }
            qsort(show->cast, show->cast_count, sizeof(char*), compareStrings);
        }
        free(cast_str);
        
        char* country = campos[5];
        if (country[0] == '"') {
            country++;
            country[strlen(country) - 1] = '\0';
        }
        show->country = strdup(country[0] == '\0' ? "NaN" : country);

        char* date_str = campos[6];
        if (date_str[0] == '"') {
            date_str++;
            date_str[strlen(date_str) - 1] = '\0';
        }
        show->date = strdup(date_str[0] == '\0' ? "NaN" : date_str);

        show->year = campos[7][0] == '\0' ? 0 : atoi(campos[7]);
        show->rating = strdup(campos[8][0] == '\0' ? "NaN" : campos[8]);
        show->duration = strdup(campos[9][0] == '\0' ? "NaN" : campos[9]);

        char* listed_str = strdup(campos[10]);
        if (listed_str[0] == '"') {
            listed_str++;
            listed_str[strlen(listed_str) - 1] = '\0';
        }
        if (listed_str[0] == '\0') {
            show->listed = malloc(sizeof(char*));
            show->listed[0] = strdup("NaN");
            show->listed_count = 1;
        } else {
            show->listed = malloc(MAX_LISTED * sizeof(char*));
            show->listed_count = 0;
            char* start = listed_str;
            char* end;
            while ((end = strstr(start, ", ")) != NULL && show->listed_count < MAX_LISTED) {
                *end = '\0';
                show->listed[show->listed_count++] = strdup(start);
                start = end + 2;
            }
            if (*start != '\0' && show->listed_count < MAX_LISTED) {
                show->listed[show->listed_count++] = strdup(start);
            }
        }
        free(listed_str);
    }

    freeFields(campos, field_count);
}

void imprimir(const Show* show) {
    printf("=> %s ## %s ## %s ## %s ## [", show->id, show->type, show->title, show->director);
    for (int i = 0; i < show->cast_count; i++) {
        printf("%s", show->cast[i]);
        if (i < show->cast_count - 1) printf(", ");
    }
    printf("] ## %s ## %s ## %d ## %s ## %s ## [", show->country, show->date,
           show->year, show->rating, show->duration);
    for (int i = 0; i < show->listed_count; i++) {
        printf("%s", show->listed[i]);
        if (i < show->listed_count - 1) printf(", ");
    }
    printf("] ##\n");
}

void freeShow(Show* show) {
    free(show->id);
    free(show->type);
    free(show->title);
    free(show->director);
    for (int i = 0; i < show->cast_count; i++) {
        free(show->cast[i]);
    }
    free(show->cast);
    free(show->country);
    free(show->date);
    free(show->rating);
    free(show->duration);
    for (int i = 0; i < show->listed_count; i++) {
        free(show->listed[i]);
    }
    free(show->listed);
}

void sortByTitle(Show* lista, int n) {
    qsort(lista, n, sizeof(Show), compareTitles);
}

bool pesqbin(Show* lista, char* title, int n) {
    bool resp = false;
    
    int esq = 0, dir = n - 1, meio;
    while (esq <= dir) {
        meio = (esq + dir) / 2;
        int cmp = strcmp(lista[meio].title, title);
        if (cmp == 0) {
            resp = true;
            esq = n;
        } else if (cmp < 0) {
            esq = meio + 1;
        } else {
            dir = meio - 1;
        }
    }

    return resp;
}

int main() {
    char path[] = "/tmp/disneyplus.csv";
    Show lista[1369];
    int i = 0;

    char lerId[10];
    scanf("%s", lerId);
    while (strcmp(lerId, "FIM") != 0) {
        FILE* file = fopen(path, "r");
        if (file == NULL) {
            printf("Erro ao abrir o arquivo.\n");
            return 1;
        }

        char line[MAX_LINE_LENGTH];
        fgets(line, MAX_LINE_LENGTH, file);

        while (fgets(line, MAX_LINE_LENGTH, file) != NULL) {
            int field_count;
            char** campos = splitCSV(line, &field_count);
            if (field_count > 0 && strcmp(campos[0], lerId) == 0) {
                Show show;
                ler(&show, line);
                lista[i++] = show;
                freeFields(campos, field_count);
                break;
            }
            freeFields(campos, field_count);
        }
        fclose(file);

        scanf("%s", lerId);
    }

    sortByTitle(lista, i); // Ordena a lista por título

    char lerTitle[121];
    getchar(); // Consome o \n deixado pelo último scanf
    fgets(lerTitle, 121, stdin);
    lerTitle[strcspn(lerTitle, "\n")] = '\0'; // Remove o \n do fgets
    while (strcmp(lerTitle, "FIM") != 0) {
        bool res = pesqbin(lista, lerTitle, i);
        printf("%s\n", res ? "SIM" : "NAO");
        fgets(lerTitle, 121, stdin);
        lerTitle[strcspn(lerTitle, "\n")] = '\0'; // Remove o \n do fgets
    }


    return 0;
}
