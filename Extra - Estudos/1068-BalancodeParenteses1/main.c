#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>

bool verifyString(char *word, int size){
    int count = 0;
    for(int i = 0 ; i < size ; i++){
        if(word[i] == '('){
            count++;
        } else if(word[i] == ')'){
            count--;
            //Toda vez q ver que a funcao esta negativa percebe se que tem uma ) que nao da pra fechar
            if(count < 0){
                return false;
            }
        }
        
    }
    return count == 0;
}



int main (){
    char *word;
    word = (char*)malloc(1000);

    if(word == NULL){
        return 1;
    }

    while(fgets(word, 1000, stdin) != 0){
        int size = strlen(word);
        if(size > 0 && word[size - 1] == '\n'){
            word[size - 1] = '\0';
            size--;
        }

        bool isTrue = verifyString(word, size);
        if(isTrue){
            printf("correct\n");
        } else {
            printf("incorrect\n");
        }
    }
    return 0;
}