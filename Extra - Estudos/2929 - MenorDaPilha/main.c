#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define CAPACIDADE 1000

typedef struct {
    int presentes[CAPACIDADE];
    int topo;
} Pilha;

// Função para encontrar o menor valor na pilha
void acharMinimo(Pilha *pilha) {
    if (pilha->topo == -1) {
        printf("EMPTY\n");
    } else {
        int menor = pilha->presentes[0];
        for (int i = 1; i <= pilha->topo; i++) {
            if (pilha->presentes[i] < menor) {
                menor = pilha->presentes[i];
            }
        }
        printf("%d\n", menor);
    }
}

// Função para remover o topo da pilha
void removerPilha(Pilha *pilha) {
    if (pilha->topo == -1) {
        printf("EMPTY\n");
    } else {
        pilha->topo--;
    }
}

// Função para inserir valor na pilha
void inserirPilha(Pilha *pilha, int valor) {
    if (pilha->topo >= CAPACIDADE - 1) {
        printf("STACK FULL\n");
    } else {
        pilha->presentes[++pilha->topo] = valor;
    }
}

int main() {
    int numOperacoes;
    char operacao[20];
    Pilha pilha;
    pilha.topo = -1;

    scanf("%d", &numOperacoes);
    getchar(); // Consumir a nova linha após a leitura de numOperacoes

    for (int i = 0; i < numOperacoes; i++) {
        fgets(operacao, sizeof(operacao), stdin);
        
        // Remover o caractere '\n' no final da string, se houver
        int size = strlen(operacao);
        if (operacao[size - 1] == '\n') {
            operacao[size - 1] = '\0';
        }

        if (strcmp(operacao, "MIN") == 0) {
            acharMinimo(&pilha); // Passa a pilha por referência
        } else if (strcmp(operacao, "POP") == 0) {
            removerPilha(&pilha); // Passa a pilha por referência
        } else if (strncmp(operacao, "PUSH", 4) == 0) {
            int valor;
            sscanf(operacao + 5, "%d", &valor); // Extrai o valor após "PUSH "
            inserirPilha(&pilha, valor); // Passa a pilha por referência
        }
    }
    return 0;
}
