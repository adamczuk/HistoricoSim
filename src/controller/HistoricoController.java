package controller;

import javax.swing.JOptionPane;

import br.edu.fateczl.adamczuk.pilhastrings.Pilha;

public class HistoricoController {
	private Pilha stack;

	public HistoricoController(Pilha stack) {

		this.stack = stack;
	}

	public void callOpcoes(int op) {

		switch (op) {
		case 1:
			insereSite();
			break;
		case 2:
			removeSite();
			break;
		case 3:
			consultaSite();
			break;
		default:
			JOptionPane.showMessageDialog(null, "OPCAO INVALIDA!!\nTENTE NOVAMENTE");
		}

	}

	private void consultaSite() {
		String ultimoSite = null;
		try {
			ultimoSite = stack.top();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Não há sites no histórico");
			return;
		}

		JOptionPane.showMessageDialog(null, "Ultimo site do histórico: \n\n" + ultimoSite);

	}

	private void removeSite() {
		String siteRemovido = null;
		try {
			siteRemovido = stack.pop();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Não há sites a serem removidos do histórico");
			return;
		}

		JOptionPane.showMessageDialog(null, "Site removido do histórico: \n\n" + siteRemovido);

	}

	private void insereSite() {
		boolean siteValido = false;
		do {
			try {

				String entrada = JOptionPane.showInputDialog(
						"Digite um site para inserir no histórico, no formato:" + "\n\nhttp://www.google.com");

				if (entrada.contains("http://www.")) {
					stack.push(entrada);
					siteValido = true;
				} else {
					JOptionPane.showMessageDialog(null, "ENDEREÇO INVALDO. TENTE NOVAMENTE");
					siteValido = false;
				}
			} catch (NullPointerException e) {
				siteValido = true;
			}

		} while (!siteValido);

	}

}
