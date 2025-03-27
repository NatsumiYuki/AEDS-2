#include <stdio.h>
#include <string.h>
#include <stdlib.h>

void combineString(char *word1, char *word2){
    int s1 = strlen(word1);
    int s2 = strlen(word2);

    char answer[200];

    int i = 0, j = 0, k = 0;

    while(word1[i] != '\0' && word2[j] != '\0'){
        if(k % 2 == 0){
            answer[k++] = word1[i++];
        } else {
            answer[k++] = word2[j++];
        }
    }
    
    while(word1[i] != '\0'){
        answer[k++] = word1[i++];
    }

    while(word2[j] != '\0'){
        answer[k++] = word2[j++];
    }

    answer[k] = '\0';

    printf("%s\n", answer);

}

int main (){
    char word1[100], word2[100];
   
    while(scanf("%s %s", word1, word2) != EOF){
        combineString(word1, word2);
    }

    return 0;
}