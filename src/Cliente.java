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
	public String buscaCpf(String cpf) throws IOException{
		
		//Cria um ArrayList e o preenche com o retorno do método listarClientes():
		ArrayList<String> clientes= new ArrayList<>();
		clientes=listarClientes();
		
		//Captura o tamanho do ArrayList criado:
		int total = clientes.size();
		
		//Cria um array simples para armazenar os dados de um único cliente cadastrado:
		
		int flag = 0;
		while(flag < total) {
			//Percorre o ArrayList e armazena os dados do veterinário atual 
			String cliente = clientes.get(flag);
			//Quebra a string de dados
			String arrayCliente[] = cliente.split(";"); 
			//Verifica se o nome buscado é igual ao nome cadastrado
			if( cpf.equals(arrayCliente[0])) {
				//Se o nome verificado for igual, retorna toda a string de dados
				return cliente;
			}else {
				flag++;
			}
		}
		
		//Se o nome não for encontrado retorna nulo:
		return null;
	}
	
	
	/*
	 * ############ Atualizar cliente cadastrado por cpf: ##############
	 */
	
	public void editarClienteCadastrado(String cpfBuscado, String novoCpf, String nome, String endereco, String telefone) throws IOException{

		//Verificar se o cpf do paciente está cadastrado ( caso encontre, flag ==0, senão flag ==-1):
		int flag = 0;
		if(buscaCpf(buscaCpf(cpfBuscado)) == null) {
			flag = 1;
		}else {
			flag =0;
		}
		
		//Se o cpf foi encontrado, lista os clientes anteriormente cadastrados:
		if(flag == 1) {
			System.out.println("Paciente não encontrado. O CPF digitado não está cadastrado.\n");
		}else{
			excluirPacienteCadastrado(cpfBuscado);
		}
		paciente pacienteEditado = new paciente(novoCpf, nome, endereco, telefone);
		cadastroVeterinario(veterinarioEditado);			
		
		
	}
	
}
