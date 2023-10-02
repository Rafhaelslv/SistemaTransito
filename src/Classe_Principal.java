import java.io.IOException;	
import javax.swing.JOptionPane;
	public class Classe_Principal {
		public static void main (String args[])throws IOException  { 
		view[] transito = new view[4];
		metodos m = new metodos();
		int opc=0;
		while(opc!=9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("1 - Cadastrar Estatistica \\n 2 - Consulta por quantidade de acidentes \\n 3 - Consulta por estatisticas de acidentes \\n 4 - Acidentes acima da media das 10 cidades \\n 5 - Consultar cidade \\n 9 - Finaliza\""));
		switch (opc) {
		case 1: transito = m.CadastrarCidade(transito);
				System.out.println(JOptionPane.showInputDialog("Cadastro concluido"));
			break;
		case 2: m.ConsultaQuantidade(transito);
			break;
		case 3: m.ConsultaEstatistica(transito);
			break;
		case 4: m.ConsultaAcimaMedia(transito);
			break;
		case 5: m.ConsultarCodigo(transito);
			break;
		case 9:JOptionPane.showMessageDialog(null,"FINALIZADO");
			break;
		default:JOptionPane.showMessageDialog(null, "OPÇÃO INVALIDA");
		}
		}
		}

	}