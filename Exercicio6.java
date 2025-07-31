/** 
Exercício 6 – Caixa de Compras com Descontos
Contexto:
Imagine um sistema de compras que calcula o total da compra com base em itens comprados e ainda aplica um desconto se o valor for acima de R$ 100.
Objetivo:
Criar métodos com lógica condicional e retorno.
Instruções:
Crie uma classe CaixaDeCompras com um método:
Copiar
Editar
public double calcularTotalComDesconto(double valor1, double valor2, double valor3)
O método deve:
Somar os três valores recebidos;
Se a soma for maior que R$ 100, aplicar 10% de desconto;
Retornar o valor final (com ou sem desconto).
Crie uma classe Principal para testar três situações:
Total menor que 100 (sem desconto);
Total igual a 100 (sem desconto);
Total maior que 100 (com desconto).

*/

// Classe CaixaDeCompras
class CaixaDeCompras {
    
    // Método para calcular total com desconto
    public double calcularTotalComDesconto(double valor1, double valor2, double valor3) {
        // Somar os três valores
        double total = valor1 + valor2 + valor3;
        
        // Se a soma for maior que R$ 100, aplicar 10% de desconto
        if (total > 100.0) {
            total = total * 0.90; // Aplicar 10% de desconto (100% - 10% = 90% = 0.90)
        }
        
        return total;
    }
}

// Classe Principal
public class Exercicio6 {
    public static void main(String[] args) {
        System.out.println("=== CAIXA DE COMPRAS COM DESCONTOS ===\n");
        
        // Criando objeto da classe CaixaDeCompras
        CaixaDeCompras caixa = new CaixaDeCompras();
        
        // Teste 1: Total menor que 100 (sem desconto)
        System.out.println("Teste 1 - Total menor que 100 (sem desconto):");
        double valor1 = 30.0;
        double valor2 = 25.0;
        double valor3 = 20.0;
        double total1 = caixa.calcularTotalComDesconto(valor1, valor2, valor3);
        System.out.printf("Valores: R$ %.2f + R$ %.2f + R$ %.2f = R$ %.2f%n", 
                         valor1, valor2, valor3, total1);
        System.out.println("Resultado: " + (total1 == (valor1 + valor2 + valor3) ? "Sem desconto aplicado" : "Desconto aplicado"));
        System.out.println();
        
        // Teste 2: Total igual a 100 (sem desconto)
        System.out.println("Teste 2 - Total igual a 100 (sem desconto):");
        double valor4 = 40.0;
        double valor5 = 30.0;
        double valor6 = 30.0;
        double total2 = caixa.calcularTotalComDesconto(valor4, valor5, valor6);
        System.out.printf("Valores: R$ %.2f + R$ %.2f + R$ %.2f = R$ %.2f%n", 
                         valor4, valor5, valor6, total2);
        System.out.println("Resultado: " + (total2 == (valor4 + valor5 + valor6) ? "Sem desconto aplicado" : "Desconto aplicado"));
        System.out.println();
        
        // Teste 3: Total maior que 100 (com desconto)
        System.out.println("Teste 3 - Total maior que 100 (com desconto):");
        double valor7 = 50.0;
        double valor8 = 40.0;
        double valor9 = 30.0;
        double total3 = caixa.calcularTotalComDesconto(valor7, valor8, valor9);
        double totalSemDesconto = valor7 + valor8 + valor9;
        System.out.printf("Valores: R$ %.2f + R$ %.2f + R$ %.2f = R$ %.2f%n", 
                         valor7, valor8, valor9, totalSemDesconto);
        System.out.printf("Total com desconto: R$ %.2f%n", total3);
        System.out.println("Resultado: " + (total3 < totalSemDesconto ? "Desconto de 10% aplicado" : "Sem desconto aplicado"));
    }
}
