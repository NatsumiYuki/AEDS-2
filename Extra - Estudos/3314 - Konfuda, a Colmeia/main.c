#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAXN 100005
#define MAXL 205

char nomes[MAXN][MAXL]; // nomes das abelhas
char temp[MAXL];
int ordem[MAXN];        // indices para ordenação

// Função para comparação de nomes
int cmp(const void *a, const void *b) {
    int i = *(int *)a;
    int j = *(int *)b;
    return strcmp(nomes[i], nomes[j]);
}

// Função para calcular prefixo comum
int prefixo_comum(char *a, char *b) {
    int i = 0;
    while (a[i] && b[i] && a[i] == b[i]) i++;
    return i;
}

int main() {
    int N, Q;
    scanf("%d %d", &N, &Q);

    nomes[1][0] = '\0'; // Nome da abelha 1 (rainha) é vazio

    for (int i = 2; i <= N; i++) {
        int p;
        char c;
        scanf("%d %c", &p, &c);
        strcpy(nomes[i], nomes[p]);
        int len = strlen(nomes[i]);
        nomes[i][len] = c;
        nomes[i][len + 1] = '\0';
    }

    // Preencher vetor de índices
    for (int i = 1; i <= N; i++) {
        ordem[i] = i;
    }

    // Ordenar os índices baseado nos nomes
    qsort(ordem + 1, N, sizeof(int), cmp);

    // Mapeamento de posições ordenadas
    int pos[MAXN];
    for (int i = 1; i <= N; i++) {
        pos[ordem[i]] = i;
    }

    // Responder perguntas
    for (int i = 0; i < Q; i++) {
        int a, b;
        scanf("%d %d", &a, &b);
        printf("%d\n", prefixo_comum(nomes[a], nomes[b]));
    }

    return 0;
}
