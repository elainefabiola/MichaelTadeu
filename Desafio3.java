/**
 * Sistema de Controle de Acesso com Modificadores
 */

// Classe abstrata base para usuários
abstract class Usuario {
    private String senha;
    protected String email;
    public String nome;
    
    // Construtor
    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
    // Método abstrato que deve ser implementado pelas subclasses
    public abstract boolean autenticar(String senha);
    
    // Método final que não pode ser sobrescrito
    public final void exibirUsuario() {
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
    }
    // Getter para senha (necessário para validação nas subclasses)
    protected String getSenha() {
        return senha;
    }
    // Setter para senha
    protected void setSenha(String senha) {
        this.senha = senha;
    }
}
// Classe Administrador que herda de Usuario
class Administrador extends Usuario {
    
    public Administrador(String nome, String email, String senha) {
        super(nome, email, senha);
    }
    // Implementação do método abstrato autenticar
    @Override
    public boolean autenticar(String senha) {
        return this.getSenha().equals(senha);
    }
    // Método para redefinir senha
    public void redefinirSenha(String novaSenha) {
        if (SegurancaUtils.validarSenhaForte(novaSenha)) {
            this.setSenha(novaSenha);
            System.out.println("Senha redefinida com sucesso!");
        } else {
            System.out.println("Erro: A nova senha não atende aos critérios de segurança.");
        }
    }
}
// Classe utilitária para validações de segurança
class SegurancaUtils {
    // Método estático para validar se a senha é forte
    public static boolean validarSenhaForte(String senha) {
        if (senha == null || senha.length() <= 8) {
            return false;
        }
        // Verifica se contém pelo menos um número
        boolean contemNumero = false;
        for (char c : senha.toCharArray()) {
            if (Character.isDigit(c)) {
                contemNumero = true;
                break;
            }
        }
        return contemNumero;
    }
}

// Classe principal para testar o sistema
public class Desafio3 {
    
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE CONTROLE DE ACESSO ===\n");
        // 1. Instanciando um Administrador
        Administrador admin = new Administrador("João Silva", "joao@empresa.com", "senha123");
        // 2. Testando acesso aos atributos
        System.out.println("--- Teste de Acesso aos Atributos ---");
        // Atributo público - acessível
        System.out.println("Nome (público): " + admin.nome);
        // Atributo protected - acessível na mesma hierarquia
        System.out.println("Email (protected): " + admin.email);
        // Atributo private - NÃO acessível diretamente
        // System.out.println("Senha (private): " + admin.senha); // Isso causaria erro de compilação
        System.out.println();
        // 3. Testando métodos
        System.out.println("--- Teste dos Métodos ---");
        // Exibindo informações do usuário
        System.out.println("Informações do usuário:");
        admin.exibirUsuario();
        System.out.println();
        // Testando autenticação
        System.out.println("Teste de autenticação:");
        System.out.println("Senha correta: " + admin.autenticar("senha123"));
        System.out.println("Senha incorreta: " + admin.autenticar("senha456"));
        System.out.println();
        // 4. Testando SegurancaUtils
        System.out.println("--- Teste de Validação de Senha ---");
        String[] senhasTeste = {
            "senha123",      // 8 caracteres, tem número
            "senha1234",     // 9 caracteres, tem número
            "senhafraca",    // 10 caracteres, sem número
            "123456789",     // 9 caracteres, só números
            "abc",           // 3 caracteres, sem número
            "abcdefgh",      // 8 caracteres, sem número
            "abcdefghi",     // 9 caracteres, sem número
            "abc123def"      // 9 caracteres, tem número
        };
        
        for (String senha : senhasTeste) {
            boolean ehForte = SegurancaUtils.validarSenhaForte(senha);
            System.out.println("Senha '" + senha + "': " + (ehForte ? "FORTE" : "FRACA"));
        }
        System.out.println();
        
        // 5. Testando redefinição de senha
        System.out.println("--- Teste de Redefinição de Senha ---");
        
        // Tentativa com senha fraca
        System.out.println("Tentando redefinir com senha fraca:");
        admin.redefinirSenha("abc");
        
        // Tentativa com senha forte
        System.out.println("Tentando redefinir com senha forte:");
        admin.redefinirSenha("novaSenha123");
        
        // Verificando se a autenticação funciona com a nova senha
        System.out.println("Testando autenticação com nova senha:");
        System.out.println("Autenticação com 'novaSenha123': " + admin.autenticar("novaSenha123"));
        System.out.println("Autenticação com 'senha123': " + admin.autenticar("senha123"));
        
        System.out.println("\n=== FIM DOS TESTES ===");
    }
}