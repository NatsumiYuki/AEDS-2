#include <stdio.h>
#include <string.h>

int main() {
    char entrada[100];
    char resultado[100];
    
    while (fgets(entrada, 100, stdin) != NULL) {
        // Remove o '\n' se existir
        entrada[strcspn(entrada, "\n")] = '\0';
        
        int inicio = 0;
        int fim = 0;
        int pos = 0;
        int len = strlen(entrada);
        
        for (int i = 0; i < len; i++) {
            char c = entrada[i];
            
            if (c == '[') {
                pos = inicio; 
            } 
            else if (c == ']') {
                pos = fim; 
            } 
            else {
                for (int j = fim; j > pos; j--) {
                    resultado[j] = resultado[j-1];
                }
                resultado[pos] = c;
                pos++;
                fim++;
            }
        }
        
        resultado[fim] = '\0';
        printf("%s\n", resultado);
    }
    
    return 0;
}