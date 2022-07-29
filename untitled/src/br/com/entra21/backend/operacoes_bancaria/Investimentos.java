package br.com.entra21.backend.operacoes_bancaria;

public enum Investimentos {

    TESOURO_IPCA(3208.18, "IPCA + 5,30%", "15/08/2026"),
    TESOURO_SELIC(11757.60, "SELIC + 0,1120%", "01/03/2025"),
    TESOURO_PREFIXADO(739.47, "12,64%", "01/01/2025");

    private final double precoUnitario;
    private final String rentabilidade;
    private final String dataDeVencimento;

    private Investimentos(double precoUnitario, String rentabilidade, String dataDeVencimento) {
        this.precoUnitario = precoUnitario;
        this.rentabilidade = rentabilidade;
        this.dataDeVencimento = dataDeVencimento;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public String getRentabilidade() {
        return rentabilidade;
    }

    public String getDataDeVencimento() {
        return dataDeVencimento;
    }

}
