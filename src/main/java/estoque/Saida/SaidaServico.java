package estoque.Saida;

import java.text.ParseException;
import java.util.Date;

import estoque.Visualizar;
import estoque.Item.Item;
import estoque.Item.ItemServico;

public class SaidaServico implements ISaidaServico {
	private Visualizar visualizar = new Visualizar();
	private ItemServico itemServico = new ItemServico();
	private Saida saida = new Saida();
	
	@Override
	public void saida() throws ParseException {
		
		Date dataSaida = visualizar.dataSaida();
		
		while (true) {
			
			ItemSaida itemSaida = visualizar.itensSaida(); 
			
			if (itemSaida == null) {break;}
			
			String nomeItem = itemSaida.getItem().getNome();
			
			System.out.println("Nome do item: " + nomeItem);
		        
			float qtdSaidaItem = itemSaida.getQtdSaida();		
			//busca o item cadastrado
			Item item = itemServico.selecionarItem(nomeItem);
			
			if (item != null) {
				
				float subtracao = item.getQtdEstoque() - qtdSaidaItem;
				item.setQtdEstoque(subtracao);
				
				saida.setDataSaida(dataSaida);
				
				itemServico.editarItem(item);
				
			} else if (item == null){
				visualizar.msgErro();
				visualizar.itensSaida();
			}
		}
	}
	
}
