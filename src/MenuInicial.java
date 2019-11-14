
public class MenuInicial {

	public static void main(String[] args) {
		
		// teste da lista de veterinários cadastrados usando um ArrayList
		
		Veterinario teste = new Veterinario();
		
		try {
			System.out.println(teste.buscaCrmv("1354454"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
