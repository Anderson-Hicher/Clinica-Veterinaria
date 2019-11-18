import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;;

/**
 * @authors andersonhicher, nayara, joseaparecido and larissalima;
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
						cliente.setCpf(scan.nextLine());
						System.out.print("Digite o nome do cliente: ");
						cliente.setNome(scan.nextLine());
						System.out.print("Digite o endereço do cliente: ");
						cliente.setEndereco(scan.nextLine());
						System.out.print("Digite o telefone do cliente: ");
						cliente.setTelefone(scan.nextLine());
						
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
						System.out.print("\nDigite o novo CPF que será cadastrado: ");
						String novoCpf = scan.nextLine();
						System.out.print("\nDigite o novo nome que será cadastrado: ");
						String nomeCliente = scan.nextLine();
						System.out.print("\nDigite o novo endereço que será cadastrado: ");
						String enderecoCliente = scan.nextLine();
						System.out.print("\nDigite o novo telefone que será cadastrado: ");
						String telefoneCliente = scan.nextLine();
						try {
							cliente.editarClienteCadastrado(cpfBuscado, novoCpf, nomeCliente, enderecoCliente, telefoneCliente);
							System.out.println("\n################################");
							System.out.println("#~Cliente Editado com sucesso!~#");
							System.out.println("################################");
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
						 * ##################### Listando Pacientes Cadastrados: ######################
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
						//Recebendo dados do Paciente:
						System.out.print("Digite o nome completo do paciente: ");
						paciente.setNome(scan.nextLine().toUpperCase());
						System.out.print("\nDigite o Sexo do paciente: ");
						paciente.setSexo(scan.nextLine().toLowerCase());
						System.out.print("\nDigite a raça do paciente: ");
						paciente.setRaca(scan.nextLine().toLowerCase());
						System.out.print("\nDigite o peso do paciente: ");
						String entradaPeso = scan.nextLine();
						entradaPeso.replace(",", ".");
						paciente.setPeso(Double.parseDouble(entradaPeso));
						System.out.print("\nDigite a idade do paciente: ");
						paciente.setIdade(Integer.parseInt(scan.nextLine()));
						System.out.print("\nDigite o CPF do dono do paciente: ");
						paciente.setCpfDono(scan.nextLine());
						boolean valido = true;
						//Inserindo data de cadastro:
						String dataCadastro;
						do {
							System.out.print("\nDigite a data de hoje (DD/MM/AAAA): ");
							//--------------------------
							dataCadastro = scan.next();

							if (dataCadastro.length() != 10) {
								System.out.println("ERRO: Você não digitou no formato DD/MM/YYYY com 10 caracteres!");
								valido = false;
							} else {

								if (dataCadastro.charAt(2) != '/' && dataCadastro.charAt(5) != '/') {
									System.out.println("ERRO: Você não digitou no formato DD/MM/YYYY!");
									valido = false;
								}
							}
							//--------------------------
							
						}while(!valido);
						paciente.setDataCadastro(dataCadastro);
						//Inserindo data de nascimento do paciente:
						String dataNascimento;
						do {
							System.out.print("\nDigite a data de nascimento do paciente(DD/MM/AAAA): ");
							//--------------------------
							dataNascimento = scan.next();

							if (dataNascimento.length() != 10) {
								System.out.println("ERRO: Você não digitou no formato DD/MM/YYYY com 10 caracteres!");
								valido = false;
							} else {

								if (dataNascimento.charAt(2) != '/' && dataNascimento.charAt(5) != '/') {
									System.out.println("ERRO: Você não digitou no formato DD/MM/YYYY!");
									valido = false;
								}
							}
							//--------------------------
							
						}while(!valido);
						paciente.setDataNascimento(dataNascimento);
						
						//Setando Id do Paciente:
						paciente.setId(paciente.getNome(), paciente.getDataNascimento());
						break;
						/*
						 * ################################## Buscando Paciente: #################################
						 */
					case 3:
						//Recebendo Id do cliente que será buscado:
						System.out.println("Digite o Id do paciente que será buscado:");
						String idBuscado = scan.nextLine();
						try {
							//Verificando Conteudo recebido
							if(paciente.buscaId(idBuscado).equals(null)) {
								System.out.println("\"Não há pacientes cadastrados com este id no sistema.\"");
							}else {
								System.out.println("#############################################################");
								System.out.println("Paciente Encontrado: ");
								System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
								System.out.println(paciente.buscaId(idBuscado));
								System.out.println("#############################################################");
								
							}
						} catch (IOException e) {
							System.out.println("Erro. Busca não pode ser realizada pois o arquivo de cadastro de Pacientes não pode ser aberto.");
						}
						break;
						// Fim da busca deId's do paciente;
					/*
					 * ################################### Editando Paciente Cadastrado ################################
					 */
					case 4:
						//Recebendo id do paciente que será alterado:
						System.out.print("Digite o Id do paciente que será alterado:");
						idBuscado = scan.nextLine();
						System.out.print("\nDigite o novo valor para o nome do paciente:");
						String nomePaciente = scan.nextLine().toUpperCase();
						System.out.print("\nDigite o novo valor para o sexo do paciente: ");
						String sexoPaciente = scan.nextLine().toLowerCase();
						System.out.print("\nDigite o novo valor para a raça do paciente: ");
						String racaPaciente = scan.nextLine();
						System.out.print("\nDigite o novo valor para o peso do paciente: ");
						double pesoPaciente = Double.parseDouble(scan.nextLine());
						System.out.print("\nDigite o novo valor para a idade do paciente: ");
						int idadePaciente = Integer.parseInt(scan.nextLine());
						System.out.print("\nDigite o novo valor para o CPF do dono do paciente: ");
						String cpfDonoPaciente = scan.nextLine();
						String novaDataCadastroPaciente;
						valido = true;
						do {
							System.out.print("\nDigite a data de hoje (DD/MM/AAAA): ");
							//--------------------------
							novaDataCadastroPaciente = scan.next();

							if (novaDataCadastroPaciente.length() != 10) {
								System.out.println("ERRO: Você não digitou no formato DD/MM/YYYY com 10 caracteres!");
								valido = false;
							} else {

								if (novaDataCadastroPaciente.charAt(2) != '/' && novaDataCadastroPaciente.charAt(5) != '/') {
									System.out.println("ERRO: Você não digitou no formato DD/MM/YYYY!");
									valido = false;
								}
							}
							//--------------------------
							
						}while(!valido);
						String novaDataNascimentoPaciente;
						do {
							System.out.print("\nDigite a data de nascimento do paciente(DD/MM/AAAA): ");
							//--------------------------
							novaDataNascimentoPaciente = scan.next();

							if (novaDataNascimentoPaciente.length() != 10) {
								System.out.println("ERRO: Você não digitou no formato DD/MM/YYYY com 10 caracteres!");
								valido = false;
							} else {

								if (novaDataNascimentoPaciente.charAt(2) != '/' && novaDataNascimentoPaciente.charAt(5) != '/') {
									System.out.println("ERRO: Você não digitou no formato DD/MM/YYYY!");
									valido = false;
								}
							}
							//--------------------------
							
						}while(!valido);
						
						//Enviando dados cadastrados para o método editarPacienteCadastrado() na classe Paciente:
						try {
							paciente.editarPacienteCadastrado(idBuscado,nomePaciente, sexoPaciente, racaPaciente, pesoPaciente, idadePaciente,cpfDonoPaciente,novaDataCadastroPaciente, novaDataNascimentoPaciente);
							System.out.println("\n#################################");
							System.out.println("#~Paciente Editado com sucesso!~#");
							System.out.println("#################################");
						} catch (IOException e) {
							System.out.println("Erro! Paciente não pode ser alterado pois o arquivo de cadastro do paciente não pode ser aberto.");
						}
						break;
					case 5:
						//Excluido paciente cadastrado:
						System.out.println("Digite o Id do Paciente que será removido removido do sistema:");
						idBuscado = scan.nextLine();
						try {
							paciente.excluirPacienteCadastrado(idBuscado);
						} catch (IOException e) {
							System.out.println("Erro! Paciente não foi removido pois o sistema não pode abrir o arquivo de cadastro de pacientes.");
						}
						break;

					default:
						System.out.println("Selecione alguma das opções do menu.");
						break;
					}
				}while(flag != -1);
				break;
				/*
				 * ################################## Fim do Menu Paciente  ############################
				 */
			case 3:
				/*
				 * ################################ Inicio do menu Veterinário ##########################
				 */
				do {
					/*
					 * ######################### Exibindo Menu de clientes: ###########################################
					 */
					System.out.println("\n\n\n\n########################################################################");
					System.out.println("# Você está no menu de Veterinários, Selecione entre as opções abaixo: #");
					System.out.println("#                                                                      #");
					System.out.println("#  ___________________________________________________________________ #");
					System.out.println("#  |______Menu:_________|__________________________________|__Opção:_| #");
					System.out.println("#  |Listar Veterinários_|__________________________________|____1____| #");
					System.out.println("#  |__Novo Cadastro_____|__________________________________|____2____| #");
					System.out.println("#  |__Buscar Cliente__|____________________________________|____3____| #");
					System.out.println("#  |__Editar Cliente__|____________________________________|____4____| #");
					System.out.println("#  |__Excluir Cliente_|____________________________________|____5____| #");
					System.out.println("#  |__Menu Anterior___|____________________________________|___-1____| #");
					System.out.println("#                                                                      #");
					System.out.println("########################################################################");
					System.out.print("Digite Sua escolha: ");
					flag=Integer.parseInt(scan.nextLine());
					
				}while(flag != -1);
				break;
			case 0:
				break;

			default:
				System.out.println("Selecione uma das opções ofertadas acima!");
				break;
			}
			
		}while(flag!=0);
		scan.close();
		
	} 

}
