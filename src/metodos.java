import java.io.*;
import java.io.IOException;

import javax.swing.JOptionPane;
public class metodos {
	public view[] CadastrarCidade(view[] transito )throws IOException {
	int i;
	String fileName = "ArquivoTransito.txt";
	
	BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
	for(i=0;i<4;i++)
		transito[i]=new view();
	
		for(i=0 ; i<4;i++)
		{
			transito[i].CodCidade = Integer.parseInt(JOptionPane.showInputDialog("Digite o Codigo da cidade")); 
			writer.write(transito[i].CodCidade);
			writer.newLine();
			transito[i].Ncidade = JOptionPane.showInputDialog("Digite o nome da cidade");
			writer.write(transito[i].Ncidade);
			writer.newLine();
			transito[i].QtdAcidentes = Integer.parseInt(JOptionPane.showInputDialog("Digite  a Quantidade de acidentes"));
			writer.write(transito[i].QtdAcidentes);
			writer.newLine();}
		System.out.println("GRAVAÇÃO REALIZADA COM SUCESSO");
		writer.close();
	return transito;
	}
	public void ConsultaQuantidade(view[] transito)throws IOException {
		int i;
		String fileName = "ArquivoTransito.txt";
		  BufferedReader ler = new BufferedReader(new FileReader( fileName ));
		  for(i=0; i<4;i++) 
		{
			if ((transito[i].QtdAcidentes >100) && (transito[i].QtdAcidentes <500)) 
			{
				System.out.println("Cod "+transito[i].CodCidade + " Cidade " + transito[i].Ncidade+ " Acidentes "+transito[i].QtdAcidentes);
			}
		}
		  ler.close();
		
	}
	public void ConsultaEstatistica(view[] transito)throws IOException {
		int i, maior=0, menor=99999, codmaior=0, codmenor=0;
		String fileName = "ArquivoTransito.txt";
		BufferedReader ler = new BufferedReader(new FileReader(fileName));
		for(i=0;i<4;i++)
		{
			if(transito[i].QtdAcidentes>maior) 
			{
				maior = transito[i].QtdAcidentes;
				codmaior = transito[i].CodCidade;
				
			}
			if(transito[i].QtdAcidentes<menor)
			{
				menor = transito[i].QtdAcidentes;
				codmenor = transito[i].CodCidade;
			}
			
		}
		System.out.println("A cidade: "+codmenor+ " tem o menor número de acidentes "+menor);
		System.out.println("A cidade: "+codmaior+ " tem o menor número de acidentes "+maior);
	}
	public void ConsultaAcimaMedia(view[] transito)throws IOException {
		int i, total_acidentes=0;
		double media=0;
		String fileName = "ArquivoTransito.txt";
		BufferedReader ler = new BufferedReader(new FileReader(fileName));
		for(i=0;i<4;i++) {
			total_acidentes = total_acidentes + transito[i].QtdAcidentes;
		}
		media = total_acidentes/4;
		for(i=0;i<4;i++) {
			if(transito[i].QtdAcidentes>media) {
				System.out.println("Cidade com QTD de acidentes acima da media "+transito[i].CodCidade+ " " +transito[i].Ncidade+ " " +transito[i].QtdAcidentes);
			}
		}
	}
	public void ConsultarCodigo(view[] transito)throws IOException {
		int Cod=0;
		String fileName = "ArquivoTransito.txt";
		BufferedReader ler = new BufferedReader(new FileReader(fileName));
		Cod = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo"));
		System.out.println("Resultado busca " +FBusca(Cod,transito));
	}
	static int FBusca(int Cod, view[] transito){
		int i=Cod;
		if ( i != transito[i].CodCidade) {
			i = i + FBusca(i+1, transito);
			return Cod;
		}else {
			System.out.println("Cidade nao encontrada ");
			return 0;
		}
	
	}
}
