package util;

public enum SituacaoCartaoComanda {

	ATIVO("ATIVO"),DESATIVADO("DESATIVADO"),ESTRAVIADO("ESTRAVIADO");
	
	private String value;
	
	SituacaoCartaoComanda(String value){
		this.value=value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}
