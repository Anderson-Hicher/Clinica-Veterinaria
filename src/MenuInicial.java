import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;;

/**
 * @author andersonhicher
 *
 */


public class MenuInicial {

	public static void main(String[] args) {
		int flag = -1;
		Scanner scan = new Scanner(System.in);
		/*
		 * ############################ Exibição do menu principal: ########################################## 
		 */
		do {
			System.out.println("\n\n\n\n########################################################################");
			System.out.println("#                  Selecione entre os menus abaixo:                    #");
			System.out.println("#                                                                      #");
			System.out.println("#  ___________________________________________________________________ #");
			System.out.println("#  |______Menu:_______|____________________________________|__Opção:_| #");
			System.out.println("#  |__________________|____________________________________|_________| #");
			System.out.println("#  |__Menu Cliente____|____________________________________|____1____| #");
			System.out.println("#  |_ Menu Paciente___|____________________________________|____2____| #");
			System.out.println("#  |_ Menu Veterinario|____________________________________|____3____| #");
			System.out.println("#  |__________________|____________________________________|_________| #");
			System.out.println("#  |____Para sair_____|____________________________________|____0____| #");
			System.out.println("#                                                                      #");
			System.out.println("########################################################################");
			flag=Integer.parseInt(scan.nextLine());
			switch (flag) {
			
			case 1:
				Cliente cliente = new Cliente();
				do {
					/*
					 * ######################### Exibindo Menu de clientes: ###########################################
					 */
					System.out.println("\n\n\n\n########################################################################");
					System.out.println("#   Você está no menu de Clientes, Selecione entre as opções abaixo:   #");
					System.out.println("#                                                                      #");
					System.out.println("#  ___________________________________________________________________ #");
					System.out.println("#  |______Menu:_______|____________________________________|__Opção:_| #");
					System.out.println("#  |__Listar Clientes_|____________________________________|____1____| #");
					System.out.println("#  |__Novo Cadastro___|____________________________________|____2____| #");
					System.out.println("#  |__Buscar Cliente__|____________________________________|____3____| #");
					System.out.println("#  |__Editar Cliente__|____________________________________|____4____| #");
					System.out.println("#  |__Excluir Cliente_|____________________________________|____5____| #");
					System.out.println("#  |__Menu Anterior___|____________________________________|___-1____| #");
					System.out.println("#                                                                      #");
					System.out.println("########################################################################");
					System.out.print("Digite Sua escolha: ");
					flag=Integer.parseInt(scan.nextLine());
					/*
					 * ######################### Início do switch do menu Cliente: ###############################
					 */
					switch (flag) {
					case 2: //Cadastro de Clientes:
						/*
						 * ######################### Cadastro de Cliente: ################################
						 */
						//Recebendo dados de cadastro
						System.out.println("\n\n\n\n########################################################################");
						System.out.print("Digite o CPF do cliente: ");
						String cpf=scan.nextLine();
						cliente.setCpf(cpf);
						System.out.print("Digite o nome do cliente: ");
						String nome=scan.nextLine();
						cliente.setNome(nome);
						System.out.print("Digite o endereço do cliente: ");
						String endereco=scan.nextLine();
						cliente.setEndereco(endereco);
						System.out.print("Digite o telefone do cliente: ");
						String telefone=scan.nextLine();
						cliente.setTelefone(telefone);
						
						//Cadastrando Cliente:
						try {
							cliente.cadastroCliente(cliente);
							System.out.println("\n###################################");
							System.out.println("#~Cliente Cadastrado com sucesso!~#");
							System.out.println("###################################");
							
						} catch (IOException e) {
							System.out.println("\n############################################");
							System.out.println("#Erro! Não foi possível cadastrar o cliente.#");
							System.out.println("#############################################");
							
						}
						break;
					case 1: //Listando clientes:
						/*
						 * ##################### Listando Clientes Cadastrados: ######################
						 */
						try {
							ArrayList<String> lista = cliente.listarClientes();
							//Verificando conteudo da lista: 
							if(lista.get(0).equals(null)) {
								System.out.println("Não há clientes cadastrados no sistema.");
							}else {
								//Imprimindo lista de clientes
								System.out.println("#############################################################");
								System.out.println("Clientes cadastrados: ");
								for(String linha: lista) {
									System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
									System.out.println("~~"+linha);
								}
								System.out.println("#############################################################");
							}
							
						} catch (IOException e) {
							System.out.println("Erro! Não foi possivel listar pois o arquivo de cadastro de clientes não pode ser encontrado.");
						}
						break;
					case 3:
						/*
						 * ########################## Buscando Cliente: ##############################
						 */
						//Recebendo CPF do cliente que será buscado:
						System.out.println("Digite o CPF do cliente que será buscado:");
						String cpfBuscado = scan.nextLine();
						try {
							//Verificando Conteudo recebido
							if(cliente.buscaCpf(cpfBuscado).equals(null)) {
								System.out.println("\"Não há clientes cadastrados com este CPF no sistema.\"");
							}else {
								System.out.println("#############################################################");
								System.out.println("Cliente Encontrado: ");
								System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
								System.out.println(cliente.buscaCpf(cpfBuscado));
								System.out.println("#############################################################");
								
							}
						} catch (IOException e) {
							System.out.println("Erro. Busca não pode ser realizada pois o arquivo de cadastro de clientes não pode ser aberto.");
						}
						break;
					case 4:
						/*
						 * ####################### Editando cliente cadastrado: #####################################
						 */
						System.out.print("Digite o CPF que será alterado: ");
						cpfBuscado = scan.nextLine();
						System.out.print("Digite o novo CPF que será cadastrado: ");
						String novoCpf = scan.nextLine();
						System.out.print("Digite o novo nome que será cadastrado: ");
						nome = scan.nextLine();
						System.out.print("Digite o novo endereço que será cadastrado: ");
						endereco = scan.nextLine();
						System.out.print("Digite o novo telefone que será cadastrado: ");
						telefone = scan.nextLine();
						try {
							cliente.editarClienteCadastrado(cpfBuscado, novoCpf, nome, endereco, telefone);
							System.out.println("\n###################################");
							System.out.println("#~Cliente Cadastrado com sucesso!~#");
							System.out.println("###################################");
						} catch (IOException e) {
							System.out.println("Erro! Cliente não pode ser alterado pois o arquivo de cadastro do cliente não pode ser aberto.");
						}
						break;
					case 5:
						System.out.println("Digite o CPF do cliente que será removido removido do sistema:");
						cpfBuscado = scan.nextLine();
						try {
							cliente.excluirClienteCadastrado(cpfBuscado);
						} catch (IOException e) {
							System.out.println("Erro! Cliente não foi removido pois o sistema não pode abrir o arquivo de cadastrode clientes.");
						}
						break;

					default:
						System.out.println("Selecione alguma das opções do menu.");
						break;
					}
					
				}while(flag != -1);
				/*
				 * ######################### Fim do switch do Menu Cliente: ###############################
				 */
				break;
				/*
				 * ######################### Fim do Menu Cliente: ###############################
				 */
			case 2:
				/*
				 * ######################### Inicio do Menu Paciente: ###############################
				 */
				Paciente paciente = new Paciente();
				do {
					/*
					 * ######################### Exibindo Menu de Pacientes: ###########################################
					 */
					System.out.println("\n\n\n\n########################################################################");
					System.out.println("#  Você está no menu de Pacientes, Selecione entre as opções abaixo:   #");
					System.out.println("#                                                                      #");
					System.out.println("#  ___________________________________________________________________ #");
					System.out.println("#  |______Menu:_______|____________________________________|__Opção:_| #");
					System.out.println("#  |__Listar Pacientes|____________________________________|____1____| #");
					System.out.println("#  |__Novo Cadastro___|____________________________________|____2____| #");
					System.out.println("#  |__Buscar Paciente_|____________________________________|____3____| #");
					System.out.println("#  |__Editar Paciente_|____________________________________|____4____| #");
					System.out.println("#  |__Excluir Paciente|____________________________________|____5____| #");
					System.out.println("#  |__Menu Anterior___|____________________________________|___-1____| #");
					System.out.println("#                                                                      #");
					System.out.println("########################################################################");
					System.out.print("Digite Sua escolha: ");
					flag=Integer.parseInt(scan.nextLine());
					/*
					 * ######################### Início do switch do menu Paciente: ###############################
					 */
					switch (flag) {
					case 1:
						 //Listando clientes:
						/*
						 * ##################### Listando Clientes Cadastrados: ######################
						 */
						try {
							ArrayList<String> lista = paciente.listarPacientes();
							//Verificando conteudo da lista: 
							if(lista.get(0).equals(null)) {
								System.out.println("Não há pacientes cadastrados no sistema.");
							}else {
								//Imprimindo lista de pacientes
								System.out.println("#############################################################");
								System.out.println("Pacientes cadastrados: ");
								for(String linha: lista) {
									System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
									System.out.println("~~"+linha);
								}
								System.out.println("#############################################################");
							}
							
						} catch (IOException e) {
							System.out.println("Erro! Não foi possivel listar pois o arquivo de cadastro de pacientes não pode ser encontrado.");
						}
						break;
					case 2://Cadastro de Pacientes
						/*
						 * #################### Cadastrando Novo Paciente: ################################
						 */
						break;

					default:
						System.out.println("Selecione alguma das opções do menu.");
						break;
					}
				}while(flag != -1);
				break;
			case 3:
				break;
			case 0:
				break;

			default:
				break;
			}
			
		}while(flag!=0);
		scan.close();
		
	} 

}
