#include <stdio.h>
#include <stdlib.h>

int main() {
    int N, K;
    
    while (scanf("%d %d", &N, &K) != EOF) {
        int X[N];
        for (int i = 0; i < N; i++) {
            scanf("%d", &X[i]);
        }

        char result[K + 1]; 
        int resultIndex = 0;

        for (int i = 0; i < K; i++) {
            char command;
            int I, J;
            scanf(" %c %d %d", &command, &I, &J);
            I--; 
            J--;

            if (command == 'C') {
                X[I] = J + 1; 
            } else if (command == 'P') {
                bool zero = false;
                int negativeCount = 0;

                for (int k = I; k <= J; k++) {
                    if (X[k] == 0) {
                        zero = true;
                        break;
                    } else if (X[k] < 0) {
                        negativeCount++;
                    }
                }

                if (zero) {
                    result[resultIndex++] = '0';
                } else if (negativeCount % 2 == 0) {
                    result[resultIndex++] = '+';
                } else {
                    result[resultIndex++] = '-';
                }
            }
        }

        result[resultIndex] = '\0'; 
        printf("%s\n", result);
    }

    return 0;
}
