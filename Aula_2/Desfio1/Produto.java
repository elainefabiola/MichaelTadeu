public class Produto {
    // Atributos da classe
    private String nome;
    private double preco;
    private int estoque;
    
    // Construtor que define todos os atributos
    public Produto(String nome, double preco, int estoque) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }
    
    // Construtor que define apenas nome e preco, com estoque inicial = 0
    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = 0;
    }
    
    // Método para adicionar estoque
    public void adicionarEstoque(int quantidade) {
        if (quantidade > 0) {
            this.estoque += quantidade;
            System.out.println("Estoque adicionado com sucesso!");
        } else {
            System.out.println("Quantidade deve ser maior que zero!");
        }
    }
    
    // Método para vender produtos
    public void vender(int quantidade) {
        if (quantidade <= 0) {
            System.out.println("Quantidade deve ser maior que zero!");
            return;
        }
        
        if (this.estoque >= quantidade) {
            this.estoque -= quantidade;
            double valorTotal = this.preco * quantidade;
            System.out.println("Venda realizada com sucesso!");
            System.out.println("Valor total: R$ " + String.format("%.2f", valorTotal));
        } else {
            System.out.println("Estoque insuficiente! Estoque disponível: " + this.estoque);
        }
    }
    
    // Método para exibir resumo do produto
    public void exibirResumo() {
        System.out.println("=== RESUMO DO PRODUTO ===");
        System.out.println("Nome: " + this.nome);
        System.out.println("Preço: R$ " + String.format("%.2f", this.preco));
        System.out.println("Estoque: " + this.estoque + " unidades");
        System.out.println("Valor total em estoque: R$ " + String.format("%.2f", this.preco * this.estoque));
        System.out.println("========================");
    }
    
    // Método main para testar a classe
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE CADASTRO DE PRODUTOS ===\n");
        
        // Criando produtos usando os dois construtores
        Produto produto1 = new Produto("Notebook", 2500.00, 10);
        Produto produto2 = new Produto("Mouse", 50.00);
        
        // Exibindo resumo inicial
        System.out.println("Produto 1 - Resumo inicial:");
        produto1.exibirResumo();
        
        System.out.println("\nProduto 2 - Resumo inicial:");
        produto2.exibirResumo();
        
        // Testando adicionar estoque
        System.out.println("\n=== TESTANDO ADICIONAR ESTOQUE ===");
        produto2.adicionarEstoque(15);
        produto2.exibirResumo();
        
        // Testando vendas
        System.out.println("\n=== TESTANDO VENDAS ===");
        produto1.vender(3);
        produto1.exibirResumo();
        
        produto1.vender(10); // Tentativa de vender mais que o estoque
        produto1.exibirResumo();
        
        produto2.vender(5);
        produto2.exibirResumo();
        
        // Testando adicionar estoque negativo
        System.out.println("\n=== TESTANDO ADICIONAR ESTOQUE NEGATIVO ===");
        produto1.adicionarEstoque(-5);
        
        // Testando venda com quantidade negativa
        System.out.println("\n=== TESTANDO VENDA COM QUANTIDADE NEGATIVA ===");
        produto1.vender(-2);
    }
}
