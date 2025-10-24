package model;

public class PagamentoModel {
    private int id_pagamento;
    private int id_cliente;
    private float valor_bruto;
    private float desconto;

    public PagamentoModel(int id_pagamento, int id_cliente, float valor_bruto) {
        this.id_pagamento = id_pagamento;
        this.id_cliente = id_cliente;
        this.valor_bruto = valor_bruto;
    }

    public PagamentoModel() {}

    public int getId_pagamento() {
        return id_pagamento;
    }

    public void setId_pagamento(int id_pagamento) {
        this.id_pagamento = id_pagamento;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public float getValor_bruto() {
        return valor_bruto;
    }

    public void setValor_bruto(float valor_bruto) {
        this.valor_bruto = valor_bruto;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }
}
