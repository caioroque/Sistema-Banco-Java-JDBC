package model;

public class Conta {
	
	private int id_conta;
	private String numero_conta;
	private float saldo_conta;
	private String tipo_conta;
	private int cliente_conta;
	public int getId_conta() {
		return id_conta;
	}
	public void setId_conta(int id_conta) {
		this.id_conta = id_conta;
	}
	public String getNumero_conta() {
		return numero_conta;
	}
	public void setNumero_conta(String numero_conta) {
		this.numero_conta = numero_conta;
	}
	public float getSaldo_conta() {
		return saldo_conta;
	}
	public void setSaldo_conta(float saldo_conta) {
		this.saldo_conta = saldo_conta;
	}
	public String getTipo_conta() {
		return tipo_conta;
	}
	public void setTipo_conta(String tipo_conta) {
		this.tipo_conta = tipo_conta;
	}
	public int getCliente_conta() {
		return cliente_conta;
	}
	public void setCliente_conta(int cliente_conta) {
		this.cliente_conta = cliente_conta;
	}
	@Override
	public String toString() {
		return "Conta [id_conta=" + id_conta + ", numero_conta=" + numero_conta + ", saldo_conta=" + saldo_conta
				+ ", tipo_conta=" + tipo_conta + ", cliente_conta=" + cliente_conta + "]";
	}
	
}
