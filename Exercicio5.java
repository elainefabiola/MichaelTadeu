/**
 * 
 * Exercício 5 – Agenda Telefônica
Contexto:
Você está criando uma agenda simples para armazenar e exibir o nome e número de telefone de uma pessoa.
Objetivo:
Criar métodos com retorno e parâmetros que lidem com os dados da agenda.
Instruções:
Crie uma classe chamada Contato com os seguintes atributos:
String nome
String telefone
Implemente os seguintes métodos:

public void atualizarTelefone(String novoTelefone) → Atualiza o número de telefone.
public String obterContatoFormatado() → Retorna uma String no formato:
"Nome: João - Telefone: 99999-9999"
Crie uma classe Principal que:
Instancia dois objetos Contato;
Atualiza o telefone de um deles;
Imprime o retorno do método obterContatoFormatado() para ambos os objetos.
 */

// Classe Contato
class Contato {
    String nome;
    String telefone;
    
    // Construtor
    Contato(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }
    
    // Método para atualizar o telefone
    public void atualizarTelefone(String novoTelefone) {
        this.telefone = novoTelefone;
    }
    
    // Método para obter contato formatado
    public String obterContatoFormatado() {
        return "Nome: " + nome + " - Telefone: " + telefone;
    }
}

// Classe Principal
public class Exercicio5 {
    public static void main(String[] args) {
        System.out.println("=== AGENDA TELEFÔNICA ===\n");
        
        // Instanciando dois objetos Contato
        Contato contato1 = new Contato("João", "99999-9999");
        Contato contato2 = new Contato("Maria", "88888-8888");
        
        // Exibindo contatos iniciais
        System.out.println("Contatos iniciais:");
        System.out.println(contato1.obterContatoFormatado());
        System.out.println(contato2.obterContatoFormatado());
        System.out.println();
        
        // Atualizando o telefone do primeiro contato
        System.out.println("Atualizando telefone do João...");
        contato1.atualizarTelefone("77777-7777");
        
        // Exibindo contatos após atualização
        System.out.println("Contatos após atualização:");
        System.out.println(contato1.obterContatoFormatado());
        System.out.println(contato2.obterContatoFormatado());
    }
}
