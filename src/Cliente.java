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
	
	public ArrayList<String> listarClientes() throws IOException{
		
		//Abrindo arquivo para leitura:
		FileReader file = new FileReader("ListaDeClientes.txt");
		BufferedReader reader = new BufferedReader(file);
		
		//Criando ArrayList para manter salvo os dados do arquivo:
		ArrayList<String> clientes = new ArrayList<>();
		
		//Lendo dados do arquivo e salvando-os na ArrayList:
		String vetor =reader.readLine();
		while(vetor != null){
			String linha = vetor.substring(1, vetor.length()-1);
            clientes.add(linha);
            vetor = reader.readLine();
        }
        
        //Fechando arquivo utilizado:
		file.close();
		
		//Retornando o ArrayList preenchido;
		
		return clientes;
	
	}
	
	/*
	 * ############# Buscar clientes por meio do Cpf: ############
	 */
	public String buscaCpf(int crmv) throws IOException{
		
		//Cria um ArrayList e o preenche com o retorno do método listarVeterinarios():
		ArrayList<String> veterinarios= new ArrayList<>();
		veterinarios=listarVeterinarios();
		
		//Captura o tamanho do ArrayList criado:
		int total = veterinarios.size();
		
		//Cria um array simples para armazenar os dados de um único veterinário cadastrado:
		
		int flag = 0;
		while(flag < total) {
			//Percorre o ArrayList e armazena os dados do veterinário atual 
			String veterinario = veterinarios.get(flag);
			//Quebra a string de dados
			String arrayVeterinario[] = veterinario.split(";"); 
			//Verifica se o nome buscado é igual ao nome cadastrado
			if( Integer.parseInt(arrayVeterinario[0]) == crmv) {
				//Se o nome verificado for igual, retorna toda a string de dados
				return veterinario;
			}else {
				flag++;
			}
		}
		
		//Se o nome não for encontrado retorna nulo:
		return null;
	}
	
	
}
