package prova1;

import java.util.Objects;

public class Delivery {
    private String produto;
    private String fornecedor;
    private int idCliente;
    private String status;

    public Delivery(String produto, String fornecedor, int idCliente) {
        this.produto = produto;
        this.fornecedor = fornecedor;
        this.idCliente = idCliente;
        this.status = "ready";
    }

    public String getProduto() {
        return produto;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delivery delivery = (Delivery) o;
        return Objects.equals(produto, delivery.produto) &&
                Objects.equals(fornecedor, delivery.fornecedor) &&
                Objects.equals(idCliente, delivery.idCliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(produto, fornecedor, idCliente);
    }

    @Override
    public String toString() {
        return String.format("Delivery [idCliente=%s, pedido=%s, fornecedor=%s, status=%s", getIdCliente(),getProduto(),getFornecedor(), getStatus());
    }
}
