#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct{
    int cobaias;
    char tipo;

} Quantia;


int main (){
    int casos;
    int totalCobaias = 0;
    int totalCoelhos = 0;
    int totalRatos = 0;
    int totalSapos = 0;

    scanf("%d", &casos);
    Quantia q[casos];

    for(int i = 0 ; i < casos ; i++){
        scanf("%d", &q[i].cobaias);
        getchar();
        scanf(" %c", &q[i].tipo);
        totalCobaias += q[i].cobaias;

        if(q[i].tipo == 'C'){
            totalCoelhos += q[i].cobaias;
        } else if (q[i].tipo == 'R'){
            totalRatos += q[i].cobaias;
        } else if (q[i].tipo == 'S') {
            totalSapos += q[i].cobaias;
        }
    }

    float ratosP = ((float)totalRatos / totalCobaias) * 100;
    float coelhosP = ((float)totalCoelhos / totalCobaias) * 100;
    float saposP = ((float)totalSapos / totalCobaias) * 100;


    
    printf("Total: %d cobaias\n", totalCobaias);
    printf("Total de coelhos: %d\n", totalCoelhos);
    printf("Total de ratos: %d\n", totalRatos);
    printf("Total de sapos: %d\n", totalSapos);
    printf("Percentual de coelhos: %.2f %%\n", coelhosP);
    printf("Percentual de ratos: %.2f %%\n", ratosP);
    printf("Percentual de sapos: %.2f %%\n", saposP);
    
    

     




    return 0;
}