
public class MenuInicial {

	public static void main(String[] args) {
		
		// teste da lista de veterinários cadastrados usando um ArrayList
		
		Veterinario teste = new Veterinario();
		
		try {
			String retorno = teste.buscaNome("Jadsmir Aragonunes");
			System.out.println(retorno);
		} catch (Exception e) {
			System.out.println("Falha em abrir arquivo");
			System.out.println(e.getMessage());
		}
	}

}
