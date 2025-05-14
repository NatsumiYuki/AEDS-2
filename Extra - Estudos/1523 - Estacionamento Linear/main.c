#include <stdio.h>

typedef struct {
    int chegada;
    int saida;
} Carro;

int main() {
    int numMotoristas, carros;

    while (scanf("%d %d", &numMotoristas, &carros), numMotoristas || carros) {
        Carro pilha[1000];
        int topo = -1;
        int ok = 1;

        for (int i = 0; i < numMotoristas; i++) {
            int C, S;
            scanf("%d %d", &C, &S);

            while (topo >= 0 && pilha[topo].saida <= C) {
                topo--;
            }

            if (topo + 1 >= carros || (topo >= 0 && pilha[topo].saida > S)) {
                ok = 0;
            } else {
                pilha[++topo].chegada = C;
                pilha[topo].saida = S;
            }
        }

        printf("%s\n", ok ? "Sim" : "Nao");
    }

    return 0;
}
