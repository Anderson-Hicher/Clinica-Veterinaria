/**
 * @author andersonhicher and nayara;
 *
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;



public class Paciente {
	private String id;
	private String nome;
	private String sexo;
	private String raca;
	private double peso;
	private int idade;
	private String cpfDono;
	private String dataCadastro;
	private String dataNascimento;
	
	/*
	 ######################### Construtores: ###########################
	 */
	//construtor padrão:
	public Paciente() {}

	//construtor da classe:
	public Paciente(String nome, String sexo, String raca, double peso, int idade, String cpfDono, String dataCadastro, String dataNascimento) {
		//this.id = iteradorAutomaticoDeIds();
		this.id=geradorId(nome, dataNascimento);
		this.nome = nome;
		this.sexo = sexo;
		this.raca = raca;
		this.peso = peso;
		this.idade = idade;
		this.cpfDono = cpfDono;
		this.dataCadastro = dataCadastro;
		this.dataNascimento = dataNascimento;
	}

	
	/*
	 #########################Getters and Setters:###########################
	 */
	
	public String getId() {
		return id;
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
	
	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
	/*
	 ######################### Cadastro de Paciente: #########################
	 */
	public void cadastroPaciente(Paciente paciente) throws IOException{
		
		//Criando o ArrayList:
		ArrayList<Object> pacientes = new ArrayList<>();
		//Abrindo arquivo onde será salva a lista de pacientes:
		FileWriter file = new FileWriter("ListaDePacientes.txt", true);
		PrintWriter writer = new PrintWriter(file);
		
		//Adicionando Objeto à lista de cadastro:
		pacientes.add(paciente.getId()+";"+paciente.getNome()+";"+paciente.getSexo()+";"+paciente.getRaca()+";"+paciente.getPeso()+";"+paciente.getIdade()+";"+paciente.getCpfDono()+";"+paciente.getDataCadastro()+";"+paciente.getDataNascimento());
		
		//Cadastrando Vetor de pacientes:
		writer.println(pacientes);
		
		//Fechando Arquivo de pacientes:
		file.close();
	}

	/*
	 ######################### Listar pacientes cadastrados: #########################
	 */
	
	public ArrayList<String> listarPacientes() throws IOException{
		
		//Abrindo arquivo para leitura:
		FileReader file = new FileReader("ListaDePacientes.txt");
		BufferedReader reader = new BufferedReader(file);
		
		//Criando ArrayList para manter salvo os dados do arquivo:
		ArrayList<String> pacientes = new ArrayList<>();
		
		//Lendo dados do arquivo e salvando-os na ArrayList:
		String vetor =reader.readLine();
		while(vetor != null){
			String linha = vetor.substring(1, vetor.length()-1);
            pacientes.add(linha);
            vetor = reader.readLine();
        }
		
        
        //Fechando arquivo utilizado:
		file.close();
		
		//Retornando o ArrayList preenchido;
		
		return pacientes;
	
	}
	
	/*
	 ######################### Buscar Paciente Cadastrado pelo Id:#########################
	 */
	
	public String buscaId(String id) throws IOException{
		
		//Cria um ArrayList e o preenche com o retorno do método listarPacientes():
		ArrayList<String> pacientes= new ArrayList<>();
		pacientes=listarPacientes();
		
		//Captura o tamanho do ArrayList criado:
		int total = pacientes.size();
		
		//Cria um array simples para armazenar os dados de um único paciente cadastrado:
		
		int flag = 0;
		while(flag < total) {
			//Percorre o ArrayList e armazena os dados do paciente atual 
			String paciente = pacientes.get(flag);
			//Quebra a string de dados
			String arrayPaciente[] = paciente.split(";"); 
			//Verifica se o id buscado é igual ao nome cadastrado
			if( arrayPaciente[0].equals(id)) {
				//Se o id verificado for igual, retorna toda a string de dados
				return paciente;
			}else {
				flag++;
			}
		}
		
		//Se o id não for encontrado retorna nulo:
		return null;
	}
	

	/*
	 ######################### Atualizar Paciente Cadastrado por Id:#########################
	 */
	
	public void editarPacienteCadastrado(String idBusca, String nome, String sexo, String raca, double peso, int idade, String cpfDono, String dataCadastro, String dataNascimento) throws IOException{
		
		Paciente pacienteEditado = new Paciente(nome, sexo, raca, peso, idade, cpfDono, dataCadastro, dataNascimento);
		//Verificar se o Id do paciente está cadastrado ( caso encontre, flag ==0, senão flag ==1):
		int flag = 0;
		if(buscaId(idBusca) == null) {
			flag = 1;
		}
		
		//Se o Id foi encontrado, lista os pacientes cadastrados:
		if(flag == 1) {
			System.out.println("Paciente não encontrado. O Id digitado não está cadastrado.\n");
		}else{
			excluirPacienteCadastrado(idBusca);
			cadastroPaciente(pacienteEditado);
		}			
		
	}
	
	

	/*
	 ######################### Excluir Paciente Cadastrado por Id:#########################
	 */
	
	public void excluirPacienteCadastrado(String id) throws IOException{
		//Criar ArrayList para receber os dados do arquivo:
		ArrayList<String> listaDePacientes = new ArrayList<>();
		listaDePacientes=listarPacientes();
		
		
		FileWriter file = new FileWriter("ListaDePacientes.txt", false);
		PrintWriter writer = new PrintWriter(file);
		
		//receber os dados do arquivo na ArrayList:
		//Iterando lista:
		int flag = 0;
		for(flag = 0; flag < listaDePacientes.size();flag ++) {
			
			//Percorre o ArrayList e armazena os dados do paciente atual 
			String paciente = listaDePacientes.get(flag);
			//Quebra a string de dados
			String arrayPaciente[] = paciente.split(";"); 
			if(!arrayPaciente[0].equals(id)){
				writer.println("["+arrayPaciente[0]+";"+arrayPaciente[1]+";"+arrayPaciente[2]+";"+arrayPaciente[3]+";"+arrayPaciente[4]+";"+arrayPaciente[5]+";"+arrayPaciente[6]+";"+arrayPaciente[7]+";"+arrayPaciente[8]+"]");
			}
			
		}
		file.close();
	}
	
	 /*
	 ######################### Iterador automático de Id's do paciente: #########################
	 */
	
	public String geradorId(String nomePaciente, String data){
		String id="";
		Scanner leia = new Scanner(System.in);
		boolean valido = true;


		id += Character.toString(nomePaciente.charAt(0)); // codigo += "" +	// nome.charAt(0);

		for (int i = nomePaciente.length() - 1; i >= 0; i--) {
			if (nomePaciente.charAt(i) == ' ') {
				id += Character.toString(nomePaciente.charAt(i + 1));
				break;
			}
		}

		int dia = Integer.parseInt(data.substring(0, 2));
		int mes = Integer.parseInt(data.substring(3, 5));
		int ano = Integer.parseInt(data.substring(6));

		// 1º Dígito
		id += String.valueOf((dia + mes + ano ) % 10);

		// 2º Dígito
		id += String.valueOf((dia * mes * ano) % 10);

		return id;
	}

}
