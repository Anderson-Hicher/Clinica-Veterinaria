import java.io.IOException;


/**
 * @author andersonhicher
 *
 */


public class MenuInicial {

	public static void main(String[] args) {
		Veterinario teste = new Veterinario(5464354,"Teste1","Canideos");
		System.out.println("Inicio do teste: ");
		
		//cadastro
		try {
			System.out.println("Teste cadastro: ");
			teste.cadastroVeterinario(teste);
		} catch (IOException e) {
			System.out.println("Erro ao cadastrar Veterinario");
			e.getMessage();
		}
		
		//listar
		try {
			System.out.println("teste listar entrou: ");
			System.out.println(teste.listarVeterinarios());
		} catch (IOException e) {
			System.out.println("Teste listar falhou:");
			e.getMessage();
		}
		
		//busca por crmv
		try {
			System.out.println("Teste busca crmv");
			System.out.println(teste.buscaCrmv(5464354));
		} catch (IOException e) {
			System.out.println("Erro ao buscar crmv");
			e.getMessage();
		}
		
		
		//editar veterinario
		
		try {
			System.out.println("Teste editar entrou ");
			teste.editarVeterinarioCadastrado(5464354, 15451515, "Anderson Hicher", "Felinos");
		} catch (IOException e) {
			System.out.println("Erro ao editar Veterinario");
			e.getMessage();
		}
		
		try {
			System.out.println("teste listar entrou: ");
			System.out.println(teste.listarVeterinarios());
		} catch (IOException e) {
			System.out.println("Teste listar falhou:");
			e.getMessage();
		}
		
		//excluir veterinario
		try {
			System.out.println("Teste excluir entrou");
			teste.excluirVeterinarioCadastrado(15451515);
		} catch (Exception e) {
			System.out.println("Erro ao excluir Veterinario");
			e.getMessage();
		}
		
		try {
			System.out.println("teste listar entrou: ");
			System.out.println(teste.listarVeterinarios());
		} catch (IOException e) {
			System.out.println("Teste listar falhou:");
			e.getMessage();
		}
		
		
	}

}
