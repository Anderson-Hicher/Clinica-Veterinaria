/**
 * @author andersonhicher
 *
 */
public class Cliente {
	private String cpf;
	private String nome;
	private String endereco;
	private String telefone;
	
	/*
	 * ################### Construtores :###################
	 */
	
	//Construtor padrão:
	public Cliente() {}
	//Construtor principal:
	public Cliente(String cpf, String nome, String endereco, String telefone) {
		this.cpf=cpf;
		this.nome=nome;
		this.endereco=endereco;
		this.telefone=telefone;
	}
	
	/*
	 * ################### Getters and Setters: ################
	 */
	
	public String getCpf() {
		return this.cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getNome(){
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEndereco() {
		return this.endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getTelefone() {
		return this.telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	/*
	 * ################### Cadastro de cliente: ###################
	 */
	
}
