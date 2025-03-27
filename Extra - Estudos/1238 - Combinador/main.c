#include <stdio.h>
#include <stdlib.h>
#include <string.h>


void newWord(char *palavra1, char *palavra2){
    int s1 = strlen(palavra1);
    int s2 = strlen(palavra2);
    int total = s1 + s2;
    char newWord[total + 1];
    int i = 0, j = 0, k =0;

    while(i < s1 && j < s2){
        if(k % 2 == 0){
            newWord[k++] = palavra1[i++];
        } else {
            newWord[k++] = palavra2[j++];
        }
    }
    
    while(i < s1){
        newWord[k++] = palavra1[i++];
    } 
    
    while(j < s2){
        newWord[k++] = palavra2[j++];
    }

    newWord[k] = '\0'; //pra fechar a string
    printf("%s\n", newWord);
}

int main (){
    char palavra1[50];
    char palavra2[50];

    int casos;

    scanf("%d", &casos);

    for(int i = 0 ; i < casos ; i++){
        scanf("%s", palavra1);
        scanf("%s", palavra2);

        newWord(palavra1, palavra2);
    }

    return 0;
}