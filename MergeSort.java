import java.util.List;

public class MergeSort {

    // Método para ordenar por data e hora (mais recente para o mais antigo)
    public void ordenarMergeSort(List<Pedido> listaDePedidos) {
        if (listaDePedidos == null || listaDePedidos.size() < 2) {
            return;
        }
        mergeSort(listaDePedidos, 0, listaDePedidos.size() - 1);
    }

    private void mergeSort(List<Pedido> listaDePedidos, int esquerda, int direita) {
        if (esquerda < direita) {
            int meio = (esquerda + direita) / 2;
            mergeSort(listaDePedidos, esquerda, meio);
            mergeSort(listaDePedidos, meio + 1, direita);
            merge(listaDePedidos, esquerda, meio, direita);
        }
    }

    private void merge(List<Pedido> listaDePedidos, int esquerda, int meio, int direita) {
        int n1 = meio - esquerda + 1;
        int n2 = direita - meio;
    
        Pedido[] esquerdaArray = new Pedido[n1];
        Pedido[] direitaArray = new Pedido[n2];
    
        for (int i = 0; i < n1; i++) {
            esquerdaArray[i] = listaDePedidos.get(esquerda + i);
        }
        for (int j = 0; j < n2; j++) {
            direitaArray[j] = listaDePedidos.get(meio + 1 + j);
        }
    
        int i = 0, j = 0;
        int k = esquerda;
    
        while (i < n1 && j < n2) {

            if (esquerdaArray[i].getDataHora().isBefore(direitaArray[j].getDataHora())) {
                listaDePedidos.set(k, esquerdaArray[i]);
                i++;
            } else {
                listaDePedidos.set(k, direitaArray[j]);
                j++;
            }
            k++;
        }
    
        while (i < n1) {
            listaDePedidos.set(k, esquerdaArray[i]);
            i++;
            k++;
        }
    
        while (j < n2) {
            listaDePedidos.set(k, direitaArray[j]);
            j++;
            k++;
        }
    }
}
