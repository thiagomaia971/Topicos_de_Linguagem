package ClassLibary;

public class Caixa {
	private double lucro;

	public Caixa(double dinheiro) {
		lucro = dinheiro;
	}

	public double Lucro() {
		return lucro;
	}

	public void receberDinheiro(double dinheiro) {
		if (dinheiro > 0) {
			lucro += dinheiro;
		}
	}

	public void retirarDinheiro(double dinheiro) {
		if (dinheiro > 0) {
			lucro -= dinheiro;
		}
	}
}
