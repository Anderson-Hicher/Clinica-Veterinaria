
public class MenuInicial {

	public static void main(String[] args) {
		
		// teste do cadastro de veterinários usando um ArrayList
		
		Veterinario teste1 = new Veterinario(1354454, "Anderson Hicher","Felinos");
		try {
			teste1.cadastroVeterinario(teste1);
			System.out.println("Cadastrado com sucesso");
		} catch (Exception e) {
			System.out.println("Falha no cadastro do veterinário");
			System.out.println(e.getMessage());
		}

	}

}
