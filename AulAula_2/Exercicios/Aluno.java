/**
 * Exercício 3
*Tema: Classe Aluno

*Descrição:
*Crie a classe Aluno com os atributos: nome, matricula e curso.
*Crie dois construtores:
*Um que recebe todos os atributos
*Um que apenas define nome e curso
*Crie um método exibirDados() para imprimir os dados do aluno
*/

public class Aluno{
	  private String nome;
	  private int matricula;
	  private String curso;

	  public Aluno(String nome, int matricula, String curso){
	  	this.nome = nome;
	  	this.matricula = matricula;
	  	this. curso = curso;
	  }
	  public Aluno(String nome){
	  	this.nome = nome;
	  	matricula = 0;
	  	String = "Desconhecido";
	  }
	  public void exibirDados(){
	  	System.out.println("Exiber Dados");
	  	System.out.println("Nome: "+ nome);
	  	System.out.println("Matricula: "+ matricula);
	  	System.out.println("curso: "+ curso);
	  }
}
 public class Main{
 public static void main(String[] args){
     
     Aluno aluno1 = new Aluno("Elaine", 8546, "Ciência da Computação");
     
     Aluno aluno1 = new Aluno("Paulo", 8546);

     System.out.println("Aluno 1");
     System.out.println(aluno1.exibirDados());
     System.out.println("Aluno 2");
     System.out.println(aluno2.exibirDados());
    

 	}
 }
