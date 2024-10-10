

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;
import com.estruturadedados.*;
import com.leituraescita.*;
import com.classes.*;
public class Aplicativo {
	private Lista lista = new Lista();
	private ControleCliente controle;
	private Compra compras[];
	public void initialize() {
		ArquivoTextoLeitura entradaDeJogos = new ArquivoTextoLeitura();
		
		entradaDeJogos.abrirArquivo("Base_De_Dados.txt");
		int quantJogos =  Integer.parseInt(entradaDeJogos.lerArquivo());
		for(int i =0; i <quantJogos; ++i) {
			String leituraJogos = entradaDeJogos.lerArquivo();
			String [] dadosJogos = leituraJogos.split(";");
			JogoDigital jogo = new JogoDigital(Integer.parseInt(dadosJogos[0]) , dadosJogos[1] , dadosJogos[2] , Integer.parseInt(dadosJogos[3]), Double.parseDouble(dadosJogos[4]));
			lista.adicionar(jogo);
		}
		
		entradaDeJogos.fecharArquivo();
		ArquivoTextoLeitura entradaDeClientes = new ArquivoTextoLeitura();
		
		entradaDeClientes.abrirArquivo("Clientes.txt");
		
		int quantClientes = Integer.parseInt(entradaDeClientes.lerArquivo());
		controle = new ControleCliente(quantClientes*2);
		for(int i =0; i <quantClientes;++i) {
		  String leituraClientes = entradaDeClientes.lerArquivo();
		  String dadosCliente [] = leituraClientes.split(";");
		  Cliente cliente = new Cliente(dadosCliente[0] , dadosCliente[1]);
		  controle.adicionarCliente(cliente);
		}
		entradaDeClientes.fecharArquivo();
		
		ArquivoTextoLeitura entradaCompras = new ArquivoTextoLeitura();
		entradaCompras.abrirArquivo("Compras.txt");
		int quantLinhasCompras = Integer.parseInt(entradaCompras.lerArquivo());
		compras = new Compra[quantLinhasCompras];
		for(int i =0; i < quantLinhasCompras; ++i ) {
			String entradaCompra = entradaCompras.lerArquivo();
			String dadosCompra [] = entradaCompra.split(";");
			Compra compra = new Compra(dadosCompra[0] , Integer.parseInt(dadosCompra[1]) , dadosCompra[2] , Double.parseDouble(dadosCompra[3]));
			compras[i] = compra;
		}
		registrarCompras();
	}
	private void registrarCompras() {
		for(int i =0; i < compras.length; ++i) {
			JogoDigital jogoAdicionar = lista.mostrarJogo(compras[i].getIdJogo());
			jogoAdicionar.registrarCompra(compras[i]);
		}
		
		for(int i =0; i < compras.length; ++i) {
			Cliente clienteAdicionar = controle.retornarCliente(compras[i].getNickname());
			clienteAdicionar.registrarCompra(compras[i]);
		}
	}

	public void menuAplicativo(int indice) {
		Scanner in = new Scanner(System.in);
		switch(indice) {
		case 1:
			int opcaoJogos =0;
			while(opcaoJogos != 6) {
				String menuJogos ="1 - Adicionar Jogo \n" +
		                 "2 - Excluir Jogo \n" +
					     "3 - Mostrar Jogo Especifico \n" + 
		                 "4 - Mostrar Todos os Jogos por Ordem de Inser��o \n"+
					     "5 - Mostrar Todos os Jogos por Ordem de Lan�amento \n"  +
		                 "6 - Sair \n";
				System.out.println(menuJogos);
				opcaoJogos = in.nextInt();
				menuJogos(opcaoJogos);
				
			}

		break;
		case 2 :
			int opcaoClientes =0;
			while(opcaoClientes != 5) {
				String menuClientes = "1 - Adicionar Cliente \n"
						+ "2 - Excluir Cliente \n"
						+ "3 - Mostrar Cliente Espec�fico \n"
						+ "4 - Mostrar Todos os Clientes \n"
						+ "5 - Sair\n";
				System.out.println(menuClientes);
				opcaoClientes = in.nextInt();
				menuClientes(opcaoClientes);
			}
		break;
		case 3 : 
			int opcaoLoja =0;
			while( opcaoLoja!=5) {  
			                                                  
			String lojaDeJogos ="1 - Comprar Jogo \n"
							+ "2 - Mostrar Todas as Compras de um Cliente \n"
							+ "3 - Mostrar Media de Avalia��es de um Jogo \n"
							+ "4 - Mostrar Todas as Compras Atualmente \n"
							+ "5 - Sair \n";
			System.out.println(lojaDeJogos);
			opcaoLoja = in.nextInt();
			menuLoja(opcaoLoja);
			}
		break;
		case 4:
			ArquivoTextoEscrita saidaJogos = new ArquivoTextoEscrita();
			saidaJogos.criarArquivo("New_Base_De_Dados.txt");
			saidaJogos.escrever(lista.mostrarLista());
			saidaJogos.fecharArquivo();
			ArquivoTextoEscrita saidaClientes =  new ArquivoTextoEscrita();
			saidaClientes.criarArquivo("New_Clientes.txt");
			saidaClientes.escrever(controle.mostrarClientes());
			saidaClientes.fecharArquivo();
			ArquivoTextoEscrita saidaCompras = new ArquivoTextoEscrita();
			saidaCompras.criarArquivo("New_Compras_Realizadas.txt");
			saidaCompras.escrever(controle.mostrarFilaDeCompras());
			saidaCompras.fecharArquivo();
		break;
		default:
		break;
		}
	}
	public void menuJogos(int indice) {
		Scanner in = new Scanner(System.in);
		switch(indice) {
		case 1:
			String vetor []= {"Id do Jogo : ", "Nome do Jogo : ", "Plataforma : ", "Ano de Lan�amento : ", "Pre�o do Jogo : "};
			String entrada ="";	
			for(int i =0; i < vetor.length;++i) {
					System.out.println(vetor[i] + " ");
					 entrada += in.nextLine()+";";
				}
			String dados [] = entrada.split(";");
			JogoDigital jogo = new JogoDigital(Integer.parseInt(dados[0]) , dados[1] , dados[2] , Integer.parseInt(dados[3]), Double.parseDouble(dados[4]));
			lista.adicionar(jogo);
			System.out.println("Jogo Adicionado");
		break;
		
		case 2:
			System.out.print("Qual o nome do Jogo a ser Excluido : ");	
			String parametro = in.nextLine();
			JogoDigital jogoRemovido = lista.remover(parametro);
			if(jogoRemovido != null) {
				System.out.println("Jogo Removido : " + jogoRemovido.toString());
			}
			else {
				System.out.println("Jogo N�o Existe");
			}

			break;
			
		case 3:
			System.out.println("Qual o Nome do Jogo a Ser Buscado ? ");
			parametro = in.nextLine();
			JogoDigital jogoEncontrado = lista.mostrarJogo(parametro);
			if(jogoEncontrado != null) {
				System.out.println("Jogo Encontrado : " + jogoEncontrado.toString());	
			}
			else {
				System.out.println("Jogo N�o Existe");
			}
			
		break;
		case 4:
			System.out.println("Jogos em Ordem de Inser��o : ");
			System.out.println(lista.mostrarLista());
		break;
		case 5:
			System.out.println("Jogos em Ordem de Lan�amento : ");
			System.out.println(lista.mostrarListaOrdenada());
			break;
		case 6:
			System.out.println("Systema de Controle de Jogos Encerrado");
			break;
		default:
			System.out.println("Op��o Inv�lida");
	    break;
		}
	}
	public void menuClientes(int indice) {
		Scanner in = new Scanner(System.in);
		switch(indice) {
		case 1 : 
			System.out.println("Nome do Cliente : ");
			String nomeCliente = in.nextLine();
			System.out.println("Nickname do Cliente");
			String nickname = in.nextLine();
			controle.adicionarCliente(nomeCliente, nickname);
			System.out.println("Cliente Adicionado");
		break;
		case 2 :
			System.out.println("Nick do Cliente a ser Excluido");
			nickname = in.nextLine();
			Cliente clienteExcluido = controle.excluirCliente(nickname);
			if(clienteExcluido != null ){
				System.out.println("Cliente Excluido : " + clienteExcluido);
			}
			else {
				System.out.println("Este Cliente n�o Existe");
			}
			
			
		break;
		case 3 :
			System.out.println("Nick do Cliente a ser Localizado");
			nickname = in.nextLine();
			Cliente clienteBuscado = controle.retornarCliente(nickname);
			if(clienteBuscado != null ){
				System.out.println("Cliente Localizado : " + clienteBuscado);
			}
			else {
				System.out.println("Este Cliente n�o Existe");
			}
			
		break;
		case 4:
			System.out.println("Clientes : ");
			System.out.println(controle.mostrarClientes());
		break;
		case 5:
			System.out.println("Systema de Controle de Clientes Encerrado");
		break;
		default:
			System.out.println("Op��o Inv�lida");
		break;
		
		
		}
	}
	public void menuLoja(int indice) {
		Scanner in  = new Scanner(System.in);
		switch(indice) {
		case 1:
			System.out.println("Qual o nick do Cliente a Realizar a Compra : ");
			String nickCliente = in.nextLine();
			Cliente comprador = controle.retornarCliente(nickCliente);
			System.out.println("Qual Jogo " + nickCliente + " deseja comprar? ");
			String nomeJogo = in.nextLine();
			System.out.println("Qual a Avalia��o do Jogo : ");
			int avaliacao = in.nextInt();
			JogoDigital jogoComprado = lista.mostrarJogo(nomeJogo);
			Calendar calendario = Calendar.getInstance();
			String dataAtual = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(calendario.getTime());
			Compra compra = new Compra(comprador.getnickCliente() , jogoComprado.getIdJogo() , dataAtual, avaliacao);
			System.out.println("Jogo Comprado");
			comprador.registrarCompra(compra);
			jogoComprado.registrarCompra(compra);
			
			
		break;
		case 2:
			System.out.println("Qual o Nick do Cliente que deseja ver a fila de Compras ? ");
			nickCliente = in.nextLine();
			comprador = controle.retornarCliente(nickCliente);
			if(comprador != null) {
				System.out.println(comprador.mostrarFilaDeCompras());
			}
			else {
				System.out.println("Este Cliente N�o Existe");
			}
		break;
		case 3:
			System.out.println("Qual o nome do Jogo que deseja ver a m�dia de Avalia��o ? ");
			nomeJogo = in.nextLine();
			jogoComprado = lista.mostrarJogo(nomeJogo);
			if(jogoComprado != null) {
				System.out.println("A M�dia de Avalia��o de " +  nomeJogo + " � : " + jogoComprado.mostrarMediaDeAvaliacao());
			}
			else {
				System.out.println("Este Jogo N�o Existe");
			}
		break;
		case 4 :
			System.out.println(controle.mostrarFilaDeCompras());
		break;
		case 5:
			System.out.println("Systema de Loja de Jogos Encerrado");
			break;
		default:
			System.out.println("Op��o Inv�lida");
		break;
		}
	}
}
