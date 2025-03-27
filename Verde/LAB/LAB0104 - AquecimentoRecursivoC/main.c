#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int upperCase(char *word, int isUpper, int i) {
    if (word[i] == '\0') {  
        return isUpper;
    }

    if (word[i] >= 'A' && word[i] <= 'Z') {
        isUpper++;
    }

    return upperCase(word, isUpper, i + 1);
}

int main() {
    char word[100];  
    int isUpper;

    fgets(word, sizeof(word), stdin);  

    while (strcmp(word, "FIM\n") != 0) {
        word[strcspn(word, "\n")] = '\0';  

        isUpper = upperCase(word, 0, 0);
        printf("%d\n", isUpper);

        fgets(word, sizeof(word), stdin); 
    }
    return 0;
}
