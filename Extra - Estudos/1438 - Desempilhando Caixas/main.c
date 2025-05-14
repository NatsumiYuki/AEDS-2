#include <stdio.h>

#define MAX_PILHAS 1000
#define MAX_ALTURA 1000

int main() {
    int N, P;
    while (scanf("%d %d", &N, &P) && (N != 0 || P != 0)) {
        int pilhas[MAX_PILHAS][MAX_ALTURA];
        int alturas[MAX_PILHAS];

        int posPilha = -1, posAltura = -1;

        for (int i = 0; i < P; i++) {
            int q;
            scanf("%d", &q);
            alturas[i] = q;
            for (int j = 0; j < q; j++) {
                scanf("%d", &pilhas[i][j]);
                if (pilhas[i][j] == 1) {
                    posPilha = i;
                    posAltura = j;
                }
            }
        }

        int desempilhar = alturas[posPilha] - posAltura - 1;

        int livre = 0;
        if (posPilha == 0 || alturas[posPilha - 1] <= posAltura) {
            livre = 1;
        }
        if (posPilha == P - 1 || alturas[posPilha + 1] <= posAltura) {
            livre = 1;
        }

        if (livre) {
            printf("%d\n", desempilhar);
        } else {
           
            printf("%d\n", desempilhar);
        }
    }

    return 0;
}
