package util;

public enum SituacaoComanda {

	DISPONIVEL("DISPONIVEL"),ABERTO("ABERTO"),FECHADO("FECHADO"),TODAS("%");
	
	private String value;
	
	SituacaoComanda(String value){
		this.value=value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}
