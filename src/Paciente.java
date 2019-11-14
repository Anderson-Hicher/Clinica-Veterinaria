/**
 * @author andersonhicher
 *
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;



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
	public Paciente(String nome, String sexo, String raca, double peso, int idade, String cpfDono, String dataCadastro) {
		this.id = iteradorAutomaticoDeIds();
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
		if(paciente.getId()==-1) {
			System.out.println("Erro no cadastro do Paciente. O arquivo de dados não pode ser aberto ou está corrompido");
		}else {
			//Criando o ArrayList:
			ArrayList<Object> pacientes = new ArrayList<>();
			
			//Abrindo arquivo onde será salva a lista de pacientes:
			FileWriter file = new FileWriter("ListaDePacientes.txt", true);
			PrintWriter writer = new PrintWriter(file);
			
			//Adicionando Objeto à lista de cadastro:
			pacientes.add(paciente.getId()+";"+paciente.getNome()+";"+paciente.getSexo()+";"+paciente.getRaca()+";"+paciente.getPeso()+";"+paciente.getCpfDono()+";"+paciente.getIdade()+";"+paciente.getDataCadastro());
			
			//Cadastrando Vetor de pacientes:
			writer.println(pacientes);
			
			//Fechando Arquivo de pacientes:
			file.close();
		}
		
	}
	
	/*
	 ######################### Listar Pacientes cadastrados: #########################
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

	public String buscaId(int id) throws IOException{
		
		//Cria um ArrayList e o preenche com o retorno do método listarPacientes():
		ArrayList<String> pacientes = new ArrayList<>();
		pacientes = listarPacientes();
		
		//Captura o tamanho do ArrayList criado:
		int total = pacientes.size();
		
		//Cria um array simples para armazenar os dados de um único paciente cadastrado:
		String arrayPacientes[] = new String[8]; 
		int flag = 0;
		while(flag < total) {
			
			//Percorre o ArrayList e armazena os dados do paciente atual 
			String paciente = pacientes.get(flag);
			
			//Quebra a string de dados
			arrayPacientes = paciente.split(";");
			
			//Verifica se o id buscado é igual ao id cadastrado
			int idCarregado = Integer.parseInt(arrayPacientes[0]);
			if( idCarregado == id) {
				
				//Se o nome verificado for igual, retorna toda a string de dados
				return paciente;
			}else {
				flag++;
			}
		}
		
		//Se o id não for encontrado retorna nulo:
		return null;
	}
	
	/*
	 ######################### Atualizar Paciente Cadastrado por seu Id:#########################
	 */
	
	public void editarPacienteCadastrado(int idBusca, int novoId, String nome, String sexo, String raca, double peso, int idade, String cpfDono, String dataCadastro) throws IOException{
		
		ArrayList<String> ListaPacientes= new ArrayList<>();
		
		//Verificar se o Id do paciente está cadastrado ( caso encontre, flag ==1, senão flag ==0):
		int flag = 0;
		//Implementando verificação dentro do metodo buscaId():
		if(buscaId(idBusca) != null) {
			flag = 1;
		}else {
			flag =0;
		}
		
		//Se o Id foi encontrado, lista os pacientes cadastrados:
		if(flag == 0) {
			System.out.println("Paciente não encontrado. O Id digitado não está cadastrado.\n");
		}else {
			ListaPacientes=listarPacientes();
			
			//Iterando sobre a lista copiada do arquivo para realizar alteração:
			//Cria um array simples para armazenar os dados de um único paciente cadastrado:
			String arrayPaciente[] = new String[8]; 
			int indiceDoArray = 0;
			int total = ListaPacientes.size();
			while(indiceDoArray < total) {
				
				//Percorre o ArrayList e armazena os dados do Paciente atual 
				String paciente = ListaPacientes.get(indiceDoArray);
				
				//Quebra a string de dados
				arrayPaciente = paciente.split(";");
				
				//Verifica se o nome buscado é igual ao nome cadastrado
				int idCarregado = Integer.parseInt(arrayPaciente[0]);
				if( idCarregado == idBusca) {
					
					//Se o Id verificado for igual, remove o indice do paciente cadastrado:
					ListaPacientes.remove(indiceDoArray);				
				}else {
					indiceDoArray++;
				}
			}
			//Cria novo objeto paciente com os novos dados:
			Paciente pacienteEditado = new Paciente(nome,sexo, raca, peso, idade, cpfDono, dataCadastro);
			
			//Adicionando Objeto à lista de cadastro:
			ListaPacientes.add(pacienteEditado.getId()+";"+pacienteEditado.getNome()+";"+pacienteEditado.getSexo()+";"+pacienteEditado.getPeso()+";"+pacienteEditado.getIdade()+";"+pacienteEditado.getCpfDono()+";"+pacienteEditado.getDataCadastro());
			
			//Abre e reseta o conteudo de ListaDeVeterinarios.txt, salvando nova lista de Pacientes:
			FileWriter file = new FileWriter("ListaDePacientes.txt", false);
			PrintWriter writer = new PrintWriter(file);
			writer.println(ListaPacientes);
			writer.println(pacienteEditado);
			
			file.close();			
		}
		
	}
	
	/*
	 ######################### Excluir Paciente Cadastrado por Id:#########################
	 */

	public void excluirPacienteCadastrado(int id) throws IOException{
		ArrayList<String> ListaPacientes= new ArrayList<>();
		
		//Verificar se o id do paciente está cadastrado ( caso encontre, flag ==1, senão flag ==0):
		int flag = 0;
		//Implementando verificação dentro do metodo buscaId():
		if(buscaId(id) != null) {
			flag = 1;
		}else {
			flag =0;
		}
		
		
		//Se o id foi encontrado, lista os pacientes cadastrados:
		if(flag == 0) {
			System.out.println("Paciente não encontrado. O Id digitado não está cadastrado.\n");
		}else {
			ListaPacientes=listarPacientes();
						
			//Iterando sobre a lista copiada do arquivo para realizar alteração:
			//Cria um array simples para armazenar os dados de um único Paciente cadastrado:
			String arrayPaciente[] = new String[8]; 
			int indiceDoArray = 0;
			int total = ListaPacientes.size();
			while(indiceDoArray < total) {
				
				//Percorre o ArrayList e armazena os dados do Paciente atual 
				String paciente = ListaPacientes.get(indiceDoArray);
				
				//Quebra a string de dados
				arrayPaciente = paciente.split(";");
				
				//Verifica se o Id buscado é igual ao Id cadastrado
				int idCarregado = Integer.parseInt(arrayPaciente[0]);
				if( idCarregado == id) {
					
					//Se o id verificado for igual, remove o indice do Paciente cadastrado:
					ListaPacientes.remove(indiceDoArray);				
				}else {
					indiceDoArray++;
				}
			}
		}
		//Abre e reseta o conteudo de ListaDePacientes.txt, salvando nova lista de Pacientes:
		FileWriter file = new FileWriter("ListaDePacientes.txt", false);
		PrintWriter writer = new PrintWriter(file);
		writer.println(ListaPacientes);
		
		file.close();
	}
	
	public int iteradorAutomaticoDeIds(){
		int id = -1;
		try {
			id = listarPacientes().size();
			id++;
		} catch (IOException e) {
			System.out.println("Erro na função de listar parcientes");
			System.out.println("Informações técnicas do erro: \n" + e.getMessage() );
		}

		return id;
	}
	
	
}
