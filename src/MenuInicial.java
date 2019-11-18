import java.io.IOException;


/**
 * @author andersonhicher
 *
 */


public class MenuInicial {

	public static void main(String[] args) {
		Paciente teste = new Paciente("Snow", "Masculino", "Akita", 30, 1, "13113319641", "14/11/2019", "24/04/1997");
		
		
		
		//Teste de cadastro:
		try {
			System.out.println("Entrou no cadastro:");
			teste.cadastroPaciente(teste);
		} catch (IOException e) {
			System.out.println("Falha ao entrar no cadastro: ");
			System.out.println(e.getMessage());
		}
		
		
		//Teste de listagem :
		try {
			System.out.println("Entrou no método de listagem:");
			System.out.println(teste.listarPacientes());
		} catch (IOException e) {
			System.out.println("Falha ao listar ");
			System.out.println(e.getMessage());
		}
		
		
		//Teste de busca:
		try {
			System.out.println("Entrou na busca:");
			System.out.println(teste.buscaId("S52"));
		} catch (IOException e) {
			System.out.println("Falha ao entrar na busca: ");
			System.out.println(e.getMessage());
		}
		
		
		//Teste de edição:
		try {
			System.out.println("Entrou na edição:");
			teste.editarPacienteCadastrado("S52", "Kira", "Femea", "Fila", 75, 6, "35930926620", "14/11/2019", "22/06/2010");
		} catch (IOException e) {
			System.out.println("Falha ao entrar na edição: ");
			System.out.println(e.getMessage());
		}
		
		
		//Teste de exclusão:
		try {
			System.out.println("Entrou na exclusão:");
			teste.excluirPacienteCadastrado("K80");
		} catch (IOException e) {
			System.out.println("Falha ao entrar na exclusão: ");
			System.out.println(e.getMessage());
		}
		
		
		
	} 

}
