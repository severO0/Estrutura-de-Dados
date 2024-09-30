import java.time.LocalDateTime;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Pedido pedidos = new Pedido(0, null,null, 0);
        List<Pedido> listaPedidos = pedidos.generateAuto(100000);
        MergeSort ms = new MergeSort();
        
        System.out.println("Lista de Pedidos:");
        for (Pedido pedido : listaPedidos) {
            System.out.println(pedido);
        }

        System.out.println("---------------------------\n");
        System.out.println("Lista de Pedidos Ordenada por data e hora(Merge Sort)");
        LocalDateTime startTime = LocalDateTime.now(); 
        ms.ordenarMergeSort(listaPedidos);
        for (Pedido pedido : listaPedidos) {
            System.out.println(pedido);
        }
         LocalDateTime endTime = LocalDateTime.now();
         long duration = java.time.Duration.between(startTime, endTime).toMillis();
        System.out.println("Tempo de execução mergeSort: " + duration + " milissegundos");
    }
    
}
