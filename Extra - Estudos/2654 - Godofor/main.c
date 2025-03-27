#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct{
    char nome[1000];
    int poder;
    int matou;
    int morreu;
} Seres;


void sortGanhador(Seres s[], int c){

    for(int i = 0 ; i < c - 1 ; i++){
        int maior = i;
        for(int j = i + 1 ; j < c ; j++){
            if(s[maior].poder < s[j].poder){
                maior = j;
            }  else if(s[maior].poder == s[j].poder){
                if(s[maior].matou < s[j].matou){
                    maior = j;
                } else if(s[maior].matou == s[j].matou){
                    if(s[maior].morreu > s[j].morreu){
                        maior = j;
                    } else if(s[maior].morreu == s[j].morreu){
                        if(strcmp(s[maior].nome, s[j].nome) > 0){
                            maior = j;
                        }
                    }
                }    
            }
        }
        Seres tmp = s[i];
        s[i] = s[maior];
        s[maior] = tmp;
    }   
    printf("%s\n", s[0].nome);
}

int main (){
    int concorrentes;

    scanf("%d", &concorrentes);
    getchar();

    Seres s[concorrentes];

    for(int i = 0 ; i < concorrentes ; i++){
        scanf("%s %d %d %d", s[i].nome, &s[i].poder, &s[i].matou, &s[i].morreu);
    }

    sortGanhador(s, concorrentes);

    return 0;
}