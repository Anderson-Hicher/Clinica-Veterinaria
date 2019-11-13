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
	
	//Listar veterinários cadastrados:
	public ArrayList<String> listarVeterinarios() throws IOException{
		
		//Abrindo arquivo para leitura:
		FileReader file = new FileReader("ListaDeVeterinarios.txt");
		BufferedReader reader = new BufferedReader(file);
		
		//Criando ArrayList para manter salvo os dados do arquivo:
		ArrayList<String> veterinarios = new ArrayList<>();
		
		//Lendo dados do arquivo e salvando-os na ArrayList:
		String linha =reader.readLine();
		while(linha != null){
            veterinarios.add(linha);
            linha = reader.readLine();
        }
        
        //Fechando arquivo utilizado:
		file.close();
		
		//Retornando o ArrayList preenchido;
		return veterinarios;
	
	}
	
	//Buscar Veterinario Cadastrado pelo Nome:
	
	public String buscaNome(String nome) throws IOException{
		
		//Cria um ArrayList e o preenche com o retorno do método listarVeterinarios():
		ArrayList<String> veterinarios= new ArrayList<>();
		veterinarios = listarVeterinarios();
		
		//Captura o tamanho do ArrayList criado:
		int total = veterinarios.size();
		
		//Cria um array simples para armazenar os dados de um único veterinário cadastrado:
		String arrayVeterinario[] = new String[3]; 
		int flag = 0;
		while(flag < total) {
			
			//Percorre o ArrayList e armazena os dados do veterinário atual 
			String veterinario = veterinarios.get(flag);
			
			//Quebra a string de dados
			arrayVeterinario = veterinario.split(";");
			
			//Verifica se o nome buscado é igual ao nome cadastrado
			String nomeCarregado = arrayVeterinario[1];
			if( nomeCarregado.equals(nome)) {
				
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
