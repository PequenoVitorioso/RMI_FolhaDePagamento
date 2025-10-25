package model;

public class PagamentoModel {
    private int id_pagamento;
    private int id_cliente;
    private float valor_liquido;
    private float desconto;

    public PagamentoModel(int id_pagamento, int id_cliente, float valor_liquido) {
        this.id_pagamento = id_pagamento;
        this.id_cliente = id_cliente;
        this.valor_liquido = valor_liquido;
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

    public float getValor_liquido() {
        return valor_liquido;
    }

    public void setValor_liquido(float valor_liquido) {
        this.valor_liquido = valor_liquido;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }
}
