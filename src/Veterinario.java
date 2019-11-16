/**
 * @author andersonhicher
 *
 */

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
	
	/*
	 ######################### Construtores: ###########################
	 */
	//construtor padrão:
	public Veterinario(){}
	
	//construtor da classe:
	public Veterinario(int crmv, String nome, String especialidade) {
		this.crmv = crmv;
		this.nome = nome;
		this.especialidade = especialidade;
	}
	
	/*
	 ######################### Getters and Setters: ###########################
	 */
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
	
	/*
	 ######################### Cadastro de Veterinario: #########################
	 */
	public void cadastroVeterinario(Veterinario veterinario) throws IOException{
		
		//Criando o ArrayList:
		ArrayList<Object> veterinarios = new ArrayList<>();
		
		//Abrindo arquivo onde será salva a lista de veterinários:
		FileWriter file = new FileWriter("ListaDeVeterinarios.txt", true);
		PrintWriter writer = new PrintWriter(file);
		
		//Adicionando Objeto à lista de cadastro:
		veterinarios.add(veterinario.getCrmv()+";"+veterinario.getNome()+";"+veterinario.getEspecialidade());
		
		//Cadastrando Vetor de veterinários:
		writer.println(veterinarios);
		
		//Fechando Arquivo de veterinários:
		file.close();
	}
	
	
	/*
	 ######################### Listar veterinários cadastrados: #########################
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
	
	/*
	 ######################### Buscar Veterinario Cadastrado pelo CRMV:#########################
	 */
	
	public String buscaCrmv(int crmv) throws IOException{
		
		//Cria um ArrayList e o preenche com o retorno do método listarVeterinarios():
		ArrayList<String> veterinarios= new ArrayList<>();
		veterinarios = listarVeterinarios();
		
		//Captura o tamanho do ArrayList criado:
		int total = veterinarios.size();
		
		//Cria um array simples para armazenar os dados de um único veterinário cadastrado:
		String arrayVeterinario[] = new String[3]; 
		int flag = 1;
		while(flag < total) {
			
			//Percorre o ArrayList e armazena os dados do veterinário atual 
			String veterinario = veterinarios.get(flag);
			
			//Quebra a string de dados
			arrayVeterinario = veterinario.split(";");
			//Verifica se o nome buscado é igual ao nome cadastrado
			int crmvCarregado = Integer.parseInt(arrayVeterinario[0]);
			if( crmvCarregado == crmv) {
				
				//Se o nome verificado for igual, retorna toda a string de dados
				return veterinario;
			}else {
				flag++;
			}
		}
		
		//Se o nome não for encontrado retorna nulo:
		return null;
	}
	
	/*
	 ######################### Atualizar Veterinário Cadastrado por CRMV:#########################
	 */
	
	public void editarVeterinarioCadastrado(int crmvBusca, int novoCrmv, String nome, String especialidade) throws IOException{

		//Verificar se o crmv do veterinário está cadastrado ( caso encontre, flag ==0, senão flag ==-1):
		int flag = 0;
		if(buscaCrmv(crmvBusca) == null) {
			flag = 1;
		}else {
			flag =0;
		}
		
		//Se o CRMV foi encontrado, lista os veterinários cadastrados:
		if(flag == 1) {
			System.out.println("Veterinário não encontrado. O CRMV digitado não está cadastrado.\n");
		}else{
			excluirVeterinarioCadastrado(crmvBusca);
		}
		Veterinario veterinarioEditado = new Veterinario(novoCrmv, nome, especialidade);
		cadastroVeterinario(veterinarioEditado);			
		
		
	}
	
	/*
	 ######################### Excluir Veterinário Cadastrado por CRMV:#########################
	 */
	
	public void excluirVeterinarioCadastrado(int crmv) throws IOException{
		ArrayList<String> ListaVeterinarios= new ArrayList<>();
		
		//Verificar se o crmv do veterinário está cadastrado ( caso encontre, flag ==1, senão flag ==0):
		int flag = 0;
		
		//Se o CRMV foi encontrado, lista os veterinários cadastrados:
		if(flag == 0) {
			System.out.println("Veterinário não encontrado. O CRMV digitado não está cadastrado.\n");
		}else {
			ListaVeterinarios=listarVeterinarios();
						
			//Iterando sobre a lista copiada do arquivo para realizar alteração:
			//Cria um array simples para armazenar os dados de um único veterinário cadastrado:
			String arrayVeterinario[] = new String[3]; 
			int indiceDoArray = 0;
			int total = ListaVeterinarios.size();
			while(indiceDoArray < total) {
				
				//Percorre o ArrayList e armazena os dados do veterinário atual 
				String veterinario = ListaVeterinarios.get(indiceDoArray);
				
				//Quebra a string de dados
				arrayVeterinario = veterinario.split(";");
				
				//Verifica se o crmv buscado é igual ao nome cadastrado
				int crmvCarregado = Integer.parseInt(arrayVeterinario[0]);
				if( crmvCarregado == crmv) {
					
					//Se o crmv verificado for igual, remove o indice do veterinário cadastrado:
					ListaVeterinarios.remove(indiceDoArray);				
				}else {
					indiceDoArray++;
				}
			}
		}
		//Abre e reseta o conteudo de ListaDeVeterinarios.txt, salvando nova lista de Veterinários:
		FileWriter file = new FileWriter("ListaDeVeterinarios.txt", false);
		PrintWriter writer = new PrintWriter(file);
		writer.println(ListaVeterinarios);
		
		file.close();
	}
}
