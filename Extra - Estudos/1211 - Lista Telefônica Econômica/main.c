#include <stdio.h>
#include <string.h>

#define MAX_N 100000
#define MAX_LEN 205

char telefones[MAX_N][MAX_LEN];

int main() {
    int N;

    while (scanf("%d\n", &N) != EOF) {
        for (int i = 0; i < N; i++) {
            fgets(telefones[i], MAX_LEN, stdin);

            size_t len = strlen(telefones[i]);
            if (telefones[i][len - 1] == '\n') {
                telefones[i][len - 1] = '\0';
            }
        }

        int total = 0;

        for (int i = 1; i < N; i++) {
            int cont = 0;
            for (int j = 0; telefones[i][j] && telefones[i - 1][j]; j++) {
                if (telefones[i][j] == telefones[i - 1][j]) {
                    cont++;
                } else {
                    break;
                }
            }
            total += cont;
        }

        printf("%d\n", total);
    }

    return 0;
}
