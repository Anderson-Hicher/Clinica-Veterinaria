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
	
	
	
	/*
	 ######################### Iterador automático de Id's do paciente: #########################
	 */
	
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
