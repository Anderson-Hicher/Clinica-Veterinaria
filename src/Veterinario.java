import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;

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
	public void cadastroVeterinario(Veterinario veterinario) throws IOException{
		ArrayList<Object> veterinarios = new ArrayList<Object>();
		FileWriter file = new FileWriter("ListaDeVeterinarios.txt", true);
		PrintWriter writer = new PrintWriter(file);
		veterinarios.add(veterinario.getCrmv()+";"+veterinario.getNome()+";"+veterinario.getEspecialidade());
		writer.println(veterinarios);
		
		file.close();
	}
	
	//Listar veterinários cadastrados:
	public void listarVeterinarios(String ListaDeVeterinarios) throws IOException{
		FileReader file = new FileReader(ListaDeVeterinarios);
		
		BufferedReader reader = new BufferedReader(file);
		String linha = reader.readLine();
		while (linha != null) {
			System.out.println(linha);
			linha = reader.readLine();
		}
		file.close();
	}
	
	//Editar Veterinario Cadastrado:
	
	
}
