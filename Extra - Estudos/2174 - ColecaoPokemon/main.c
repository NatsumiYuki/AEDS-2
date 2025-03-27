#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int sortPokemons(char p[][21], int cap) {
    int iguais = 0;

    for (int i = 0; i < cap - 1; i++) {
        int menor = i;
        for (int j = i + 1; j < cap; j++) {
            if (strcmp(p[menor], p[j]) > 0) {
                menor = j;
            }
        }
        if (menor != i) {
            char tmp[21];
            strcpy(tmp, p[i]);
            strcpy(p[i], p[menor]);
            strcpy(p[menor], tmp);
        }
    }

    for (int i = 0; i < cap - 1; i++) {
        if (strcmp(p[i], p[i + 1]) == 0) {
            iguais++;
        }
    }

    return iguais;
}

int main() {
    int capturados;
    scanf("%d", &capturados);

    char nomesPokemons[capturados][21];

    for (int i = 0; i < capturados; i++) {
        scanf("%s", nomesPokemons[i]);
    }

    int same = sortPokemons(nomesPokemons, capturados);
    int semRepetidos = capturados - same; 
    int answer = 151 - semRepetidos; 

    printf("Falta(m) %d pomekon(s).\n", answer);

    return 0;
}
