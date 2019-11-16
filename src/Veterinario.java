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
		//Criar ArrayList para receber os dados do arquivo:
		ArrayList<String> listaDeVeterinarios = new ArrayList<>();
		listaDeVeterinarios=listarVeterinarios();
		
		
		FileWriter file = new FileWriter("ListaDeVeterinarios.txt", false);
		PrintWriter writer = new PrintWriter(file);
		
		//receber os dados do arquivo na ArrayList:
		//Iterando lista:
		int flag = 0;
		for(String iterador: listaDeVeterinarios) {
			//Percorre o ArrayList e armazena os dados do veterinário atual 
			String veterinario = listaDeVeterinarios.get(flag);
		
			//Quebra a string de dados
			String arrayVeterinario[] = veterinario.split(";"); 
			if(Integer.toString(crmv) != arrayVeterinario[0]) {
				writer.println("["+iterador+"]");
				file.close();
			}
			flag++;
		}
	}
		
}

