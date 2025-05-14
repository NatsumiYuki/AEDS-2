#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main (){

    int N;
    scanf("%d", &N);

    for(int i = 0; i < N; i++){
        char expressao[100];
        scanf("%s", expressao);

        char pilha[100];
        int topo = -1;

        for(int j = 0; expressao[j] != '\0'; j++){
            if(expressao[j] >= 'a' && expressao[j] <= 'z'){
                printf("%c", expressao[j]);
            } else if(expressao[j] == '('){
                topo++;
                pilha[topo] = '(';
            } else if(expressao[j] == ')'){
                while(pilha[topo] != '('){
                    printf("%c", pilha[topo]);
                    topo--;
                }
                topo--;
            } else {
                while(topo != -1 && pilha[topo] != '('){
                    printf("%c", pilha[topo]);
                    topo--;
                }
                topo++;
                pilha[topo] = expressao[j];
            }
        }

        while(topo != -1){
            printf("%c", pilha[topo]);
            topo--;
        }
        printf("\n");
    }


    return 0;
}