#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int countVowels(char *vowels, char *word, int sizeVowels, int sizeWord){
    int count = 0;
    
    for(int i = 0; i < sizeWord ; i++){
        for(int j = 0 ; j < sizeVowels ; j++){
            if(word[i] == vowels[j]){
                count++;
            }
        }
    }
    return count;
}

int main(){
    char vowels[100];
    char word[100];

    while(fgets(vowels, 100, stdin) != NULL){
        int sizeVowels = strlen(vowels); 
        if(vowels >= 0 && vowels[sizeVowels - 1]){
            vowels[sizeVowels - 1] = '\0';
            sizeVowels--;
        }
        fgets(word, 100, stdin);
        int sizeWord = strlen(word);
        if(word >= 0 && word[sizeWord - 1]){
            word[sizeWord - 1] = '\0';
            sizeWord--;
        }

        int answer = countVowels(vowels, word, sizeVowels, sizeWord);
        printf("%d\n", answer);

    }

    return 0;
}