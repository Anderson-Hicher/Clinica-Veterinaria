import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
	
	public void cadastroCliente(Cliente cliente) throws IOException{
		
		//Criando o ArrayList:
		ArrayList<Object> clientes = new ArrayList<>();
		//Abrindo arquivo onde será salva a lista de clientes:
		FileWriter file = new FileWriter("ListaDeClientes.txt", true);
		PrintWriter writer = new PrintWriter(file);
		
		//Adicionando Objeto à lista de cadastro:
		clientes.add(cliente.getCpf()+";"+cliente.getNome()+";"+cliente.getEndereco()+";"+cliente.getTelefone());
		
		//Cadastrando Vetor de clientes:
		writer.println(clientes);
		
		//Fechando Arquivo de clientes:
		file.close();
	}
	
	/*
	 * #################### Listar clientes cadastrados: #################
	 */
	
	public ArrayList<String> listarVeterinarios() throws IOException{
		
		//Abrindo arquivo para leitura:
		FileReader file = new FileReader("ListaDeVeterinarios.txt");
		BufferedReader reader = new BufferedReader(file);
		
		//Criando ArrayList para manter salvo os dados do arquivo:
		ArrayList<String> veterinarios = new ArrayList<>();
		
		//Lendo dados do arquivo e salvando-os na ArrayList:
		String vetor =reader.readLine();
		while(vetor != null){
			String linha = vetor.substring(1, vetor.length()-1);
            veterinarios.add(linha);
            vetor = reader.readLine();
        }
        
        //Fechando arquivo utilizado:
		file.close();
		
		//Retornando o ArrayList preenchido;
		
		return veterinarios;
	
	}
	
	
}
