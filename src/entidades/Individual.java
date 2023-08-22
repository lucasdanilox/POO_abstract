package entidades;

public class Individual extends Pessoa {
    private Double gastosSaude;

    public Individual() {

    }

    public Individual(String nome, Double rendaAnual, Double gastosSaude) {
        super(nome, rendaAnual);
        this.gastosSaude = gastosSaude;
    }

    public Double getGastosSaude() {
        return gastosSaude;
    }

    public void setGastosSaude(Double gastosSaude) {
        this.gastosSaude = gastosSaude;
    }

    @Override
    public Double tax() {
        double soma = 0;
        if (getRendaAnual() < 20000) {
            soma += getRendaAnual() * 0.15;
        } else {
            soma += getRendaAnual() * 0.25;
        }
        if (getGastosSaude() > 0) {
            soma = (getRendaAnual() * 0.25) - (getGastosSaude() * 0.50);

        }
        return soma;
    }

}
