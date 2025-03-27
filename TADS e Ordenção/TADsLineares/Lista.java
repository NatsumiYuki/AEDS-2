package TADsLineares;

public class Lista {
    int[] arr;  // Declaração do array que armazenará os elementos da lista
    int n;      // Contador de elementos na lista (tamanho atual da lista)

    public Lista(int size){
        int[] arr = new int[size];  // Declara uma nova variável local "arr" no método, que não é usada na classe
        int n = 0;  // Declara uma nova variável local "n", que também não altera o "n" da classe
    }

    public void inserirLista(int x){
        
        if(n >= arr.length){ // Verifica se há espaço no array (se o número de elementos é maior ou igual ao tamanho do array)
            return;  // Se não houver espaço, o método termina sem adicionar o novo valor
        }
        arr[n] = x;  // Insere o valor "x" na posição "n" do array
        n++;  // Incrementa o número de elementos, ou seja, ajusta o contador para refletir a adição do novo valor
    }

    public void inserirPosLista(int x, int pos){
        if(n >= arr.length || pos < 0 || pos > arr.length){ // Verifica se o índice de posição é válido e se há espaço suficiente no array
            return;  // Se o índice for inválido ou não há espaço no array, a função retorna sem fazer nada
        }

        for(int i = n; i > pos; i-- ){ // Desloca os elementos da lista para a direita para abrir espaço para o novo elemento
            arr[i] = arr[i - 1];  // Move o elemento para a posição à direita (fazendo o "shift")
        }

        arr[pos] = x; // Insere o novo valor na posição especificada
        n++; // Aumenta o contador de elementos (n) para refletir que um novo elemento foi inserido
    }

    public int removerFimLista(int x) {
        if(n == 0) { //Lista vazia
            return 1;
        }
        int valorRemovido = arr[n - 1];  // Pega o valor do último elemento
        n--;  // Decrementa n para "remover" o último elemento
        return valorRemovido;  // Retorna o valor do elemento removido
    }

    public int removerInicioLista(){
        
        if(n == 0){
            return 1;
        }
    
        int removido = arr[0]; // Armazena o valor do primeiro elemento para retorná-lo depois
        n--; // Decrementa n para refletir que um elemento foi removido
        for(int i = 0 ; i < n ; i++){  // Loop para deslocar todos os elementos para a esquerda, preenchendo a posição 0 com o próximo elemento da lista
            arr[i] = arr[i + 1];  // Move o elemento da posição i + 1 para a posição i
        }
    
        return removido;
    }


    public int removerPosLista(int x, int pos){
        if(n >= arr.length || pos > arr.length || pos < 0){
            return 1;
        }
        int resp = 0;
        arr[pos] = resp;
        for(int i = n-1 ; n > 0 ; i--){
            arr[i] = arr[i - 1];
        }

        arr[pos] = 0;
        n++;
        
        return arr[pos];
    }





}

