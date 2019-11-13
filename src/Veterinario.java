import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Veterinario {
	private int crmv;
	private String nome;
	private String especialidade;
	
	//construtor padrão:
	public Veterinario(){}
	
	//construtor da classe:
	public Veterinario(int crmv, String nome, String especialidade) {
		this.crmv = crmv;
		this.nome = nome;
		this.especialidade = especialidade;
	}
	
	//Getters and Setters:
	public int getCrmv() {
		return this.crmv;
	}
	public void setCrmv(int crmv) {
		this.crmv = crmv;
	}
	
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEspecialidade() {
		return this.especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	
	//Cadastro de Veterinario:
	public void cadastroVeterinario(Veterinario[] veterinario) throws IOException{
		FileWriter file = new FileWriter("ListaDeVeterinarios.txt", false);
		PrintWriter writer = new PrintWriter(file);
		writer.println(veterinario.length);
		for(int i=0;i<=veterinario.length;i++) {
			writer.println(veterinario[i].getCrmv() +";"+veterinario[i].getNome()+";"+veterinario[i].getEspecialidade());			
		}
		
		file.close();
	}
	
	//Listar veterinários cadastrados:
	
}
