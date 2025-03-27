#include <stdio.h>
#include <stdlib.h>
#include <string.h>


typedef struct{
    char pais[50];
    int ouro;
    int prata;
    int bronze;
} Paises;

void sortWinner(Paises p[], int n){
    for(int i = 0 ; i < n - 1; i ++){
        int maior = i;
        for(int j = i + 1 ; j < n ; j++){
            if(p[maior].ouro < p[j].ouro){
                maior = j;
            }else if(p[maior].ouro == p[j].ouro){
                if(p[maior].prata < p[j].prata){
                    maior = j;
                } else if (p[maior].prata == p[j].prata){
                    if (p[maior].bronze < p[j].bronze){
                        maior = j;
                    } else if (p[j].bronze == p[maior].bronze){
                        if(strcmp(p[j].pais, p[maior].pais) < 0){
                            maior = j;
                        }
                    }
                }
                
            }
        }
        Paises tmp = p[i];
        p[i] = p[maior];
        p[maior] = tmp;
    }

}



int main (){
    int numPaises;
    
    scanf("%d", &numPaises);
    //array de paises
    Paises p[numPaises];

    for(int i = 0 ; i < numPaises ; i++){
        scanf("%s", p[i].pais);
        scanf("%d", &p[i].ouro);
        scanf("%d", &p[i].prata);
        scanf("%d", &p[i].bronze);
    }

    sortWinner(p, numPaises);
    for(int i = 0 ; i < numPaises; i++){
        printf("%s %d %d %d\n", p[i].pais, p[i].ouro, p[i].prata, p[i].bronze);
    }

    return 0;
}