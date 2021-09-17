package view;

import javax.swing.JOptionPane;

import controller.HistoricoController;

import br.edu.fateczl.adamczuk.pilhastrings.Pilha;

public class Main {

	public static void main(String[] args) {

		int op = 0;

		Pilha stack = new Pilha();

		HistoricoController hController = new HistoricoController(stack);

		do {

			String opMenu = JOptionPane.showInputDialog("" + "ESCOLHA UMA OP��O:\n\n"
					+ "1 - Inserir um site no hist�rico \n\n" + "2 - Remover o �ltimo endere�o inserido\n\n"
					+ "3 - Consultar o �ltimo endere�o do hist�rico");

			if (opMenu == null) {
				op = 9;
			}

			else {

				try {
					op = Integer.parseInt(opMenu);
					hController.callOpcoes(op);

				}

				catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Op��o inv�lida. Tente novamente");

				}
			}
		} while (op != 9);

	}

}
