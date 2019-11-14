import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * @author andersonhicher
 *
 */

public class Paciente {
	private int id;
	private String nome;
	private String sexo;
	private String raca;
	private double peso;
	private int idade;
	private String cpfDono;
	private String dataCadastro;
	
	/*
	 ######################### Construtores: ###########################
	 */
	//construtor padrão:
	public Paciente() {}

	//construtor da classe:
	public Paciente(int id, String nome, String sexo, String raca, double peso, int idade, String cpfDono, String dataCadastro) {
		this.id = id;
		this.nome = nome;
		this.sexo = sexo;
		this.raca = raca;
		this.peso = peso;
		this.idade = idade;
		this.cpfDono = cpfDono;
		this.dataCadastro = dataCadastro;
	}

	
	/*
	 #########################Getters and Setters:###########################
	 */
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getCpfDono() {
		return cpfDono;
	}

	public void setCpfDono(String cpfDono) {
		this.cpfDono = cpfDono;
	}

	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	
	/*
	 ######################### Cadastro de Paciente: #########################
	 */
	
	public void cadastroPaciente(Paciente paciente) throws IOException{
		
		//Criando o ArrayList:
		ArrayList<Object> pacientes = new ArrayList<>();
		
		//Abrindo arquivo onde será salva a lista de veterinários:
		FileWriter file = new FileWriter("ListaDePacientes.txt", true);
		PrintWriter writer = new PrintWriter(file);
		
		//Adicionando Objeto à lista de cadastro:
		pacientes.add(paciente.getId()+";"+paciente.getNome()+";"+paciente.getSexo()+";"+paciente.getRaca()+";"+paciente.getPeso()+";"+paciente.getCpfDono()+";"+paciente.getIdade()+";"+paciente.getDataCadastro());
		
		//Cadastrando Vetor de veterinários:
		writer.println(pacientes);
		
		//Fechando Arquivo de veterinários:
		file.close();
	}
	
	
}
