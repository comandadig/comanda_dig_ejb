package util;

public enum SituacaoCaixa {

	ABERTO("ABERTO"),FECHADO("FECHADO");
	
	private String value;
	
	SituacaoCaixa(String value){
		this.value=value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
	
}
