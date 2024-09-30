

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pedido {
    private int id;
    private LocalDateTime dataHora;
    private String nomeCliente;
    private double valorTotal;

    public Pedido(
        int id, 
        LocalDateTime dataHora, 
        String nomeCliente, 
        double valorTotal) {

        this.id = id;
        this.dataHora = dataHora;
        this.nomeCliente = nomeCliente;
        this.valorTotal = valorTotal;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter 
        = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataHoraFormatada 
        = dataHora.format(formatter);
        DecimalFormat df 
        = new DecimalFormat("#,##0.00");
        return "Pedido [ID: " + id + 
        ", Data/Hora: " + dataHoraFormatada + 
        ", Cliente: " + nomeCliente + 
        ", Valor Total: R$ " + df.format(valorTotal) 
        + "]";
    }

    public List<Pedido> generateAuto(int quantidade) {

        List<Pedido> listaDePedidos = new ArrayList<>();
        LocalDateTime dataHoraBase = LocalDateTime.now();
        Random random = new Random();
        String[] nomesClientes = {"Walace ", "João ", "Ana ", "Carlos ", "Luiza ", 
                                  "Erick ", "Lucas ", "Antônio ", "Luiz ", "Ricardo", "Pedro"," Guilherme", "Laisla"};

        for (int i = 1; i <= quantidade; i++) {
            int id = i;
            int diasAleatorios = random.nextInt(30);
            int horasAleatorias = random.nextInt(24); 
            int minutosAleatorios = random.nextInt(60); 
            int segundosAleatorios = random.nextInt(60);
            LocalDateTime dataHora = dataHoraBase.minusDays(diasAleatorios)
                                                   .withHour(horasAleatorias)
                                                   .withMinute(minutosAleatorios)
                                                   .withSecond(segundosAleatorios)
                                                   .truncatedTo(ChronoUnit.SECONDS);
            
            String nomeCliente = nomesClientes[random.nextInt(nomesClientes.length)];
            double valorTotal = 100 + (900 * random.nextDouble());
            listaDePedidos.add(new Pedido(id, dataHora, nomeCliente, valorTotal));
        }
        return listaDePedidos;
        }
}
    
