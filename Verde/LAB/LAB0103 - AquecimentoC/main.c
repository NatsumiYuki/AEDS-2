#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int countUpperCase(char *word, int size){
    int count = 0;
    char upperCase[] = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    for(int i = 0 ; i < size ; i++){
        for(int j = 0 ; j < strlen(upperCase) ; j++){
            if(word[i] == upperCase[j]){
                count++;
            }
        }
    }


    return count;
}




int main(){
    char *word = (char*)malloc(100*sizeof(char));
    if(word == NULL){
        return 1;
    }

    fgets(word, 100, stdin);

    while(strcmp(word, "FIM\n") != 0){
        int size = strlen(word);
        if(size > 0 && word[size - 1] == '\n'){
            word[size - 1] = '\0';
            size--;
        }

        int upperCase = countUpperCase(word, size);
        printf("%d\n", upperCase);

        fgets(word, 100, stdin);

    }

    return 0;
}