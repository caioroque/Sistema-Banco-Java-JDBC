package model;

public class UsuarioCliente {

	private int idCliente;
	private String nomeCliente;
	private String cpfCliente;
	private String rgCliente;
	private String emailCliente;
	private String telefoneCliente;
	private String enderecoCliente;
	private int idadeCliente;
	
	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	public String getNomeCliente() {
		return nomeCliente;
	}
	
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
	public String getCpfCliente() {
		return cpfCliente;
	}
	
	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}
	
	public String getRgCliente() {
		return rgCliente;
	}
	
	public void setRgCliente(String rgCliente) {
		this.rgCliente = rgCliente;
	}
	
	public String getEmailCliente() {
		return emailCliente;
	}
	
	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}
	
	public String getTelefoneCliente() {
		return telefoneCliente;
	}
	
	public void setTelefoneCliente(String telefoneCliente) {
		this.telefoneCliente = telefoneCliente;
	}
	
	public String getEnderecoCliente() {
		return enderecoCliente;
	}
	
	public void setEnderecoCliente(String enderecoCliente) {
		this.enderecoCliente = enderecoCliente;
	}
	
	public int getIdadeCliente() {
		return idadeCliente;
	}
	
	public void setIdadeCliente(int idadeCliente) {
		this.idadeCliente = idadeCliente;
	}

	@Override
	public String toString() {
		return "UsuarioCliente [idCliente=" + idCliente + ", nomeCliente=" + nomeCliente + ", cpfCliente=" + cpfCliente
				+ ", rgCliente=" + rgCliente + ", emailCliente=" + emailCliente + ", telefoneCliente=" + telefoneCliente
				+ ", enderecoCliente=" + enderecoCliente + ", idadeCliente=" + idadeCliente + "]";
	}
	
	

}
