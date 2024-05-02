import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.swing.JOptionPane;

public class TemperaturasIA {
	public static void main(String[] args) {
		Map<String, Map<String, Double>> temperaturasCidades = new HashMap<>();

		temperaturasCidades.put("São Paulo", temperaturas());
		temperaturasCidades.put("João Pessoa", temperaturas());
		temperaturasCidades.put("Curitiba", temperaturas());

		String cidade = JOptionPane.showInputDialog(
				"Digite o destino:\n" + "0. Sair\n" + "1. São Paulo\n" + "2. João Pessoa\n" + "3. Curitiba\n");

		switch (cidade) {
		case "1":
			cidade = "São Paulo";
			break;
		case "2":
			cidade = "João Pessoa";
			break;
		case "3":
			cidade = "Curitiba";
			break;
		case "0":
			JOptionPane.showMessageDialog(null, "Programa encerrado.");
			return;
		default:
			JOptionPane.showMessageDialog(null, "Cidade inválida.");
			return;
		}

		String estacao = JOptionPane.showInputDialog("Digite a estação do ano:\n" + "0. Sair\n" + "1. Verão\n"
				+ "2. Inverno\n" + "3. Outono\n" + "4. Primavera\n");

		switch (estacao) {
		case "1":
			estacao = "verão";
			break;
		case "2":
			estacao = "inverno";
			break;
		case "3":
			estacao = "outono";
			break;
		case "4":
			estacao = "primavera";
			break;
		case "0":
			JOptionPane.showMessageDialog(null, "Programa encerrado.");
			return;
		default:
			JOptionPane.showMessageDialog(null, "Estação do ano inválida.");
			return;
		}

		double temperaturaMedia = temperaturasCidades.get(cidade).get(estacao);
		String sugestaoRoupa = sugerirRoupa(temperaturaMedia);

		StringBuilder resultados = new StringBuilder();
		resultados.append("\nResultados:\n");
		resultados.append("Temperatura média na cidade de ").append(cidade).append(" durante a estação de ")
				.append(estacao).append(": ").append(temperaturaMedia).append(" °C\n");
		resultados.append("Sugestão de roupa: ").append(sugestaoRoupa);

		JOptionPane.showMessageDialog(null, resultados.toString());
	}

	private static Map<String, Double> temperaturas() {
		Random random = new Random();
		Map<String, Double> temperaturas = new HashMap<>();
		temperaturas.put("verão", 20 + random.nextDouble() * 15);
		temperaturas.put("inverno", 5 + random.nextDouble() * 15);
		temperaturas.put("outono", 10 + random.nextDouble() * 15);
		temperaturas.put("primavera", 15 + random.nextDouble() * 15);
		return temperaturas;
	}

	private static String sugerirRoupa(double temperaturaMedia) {
		if (temperaturaMedia > 25) {
			return "Roupas leves.";
		} else if (temperaturaMedia >= 15) {
			return "Roupas casuais.";
		} else {
			return "Roupas quentes.";
		}
	}
}
