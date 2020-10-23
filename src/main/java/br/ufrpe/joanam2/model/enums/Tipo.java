package br.ufrpe.joanam2.model.enums;

public enum Tipo {
	
	PREFIXADO(1, "Pré-fixado"),
	POSFIXADO(2, "Posfixado");
	
	private int codigo;
	private String descricao;
	
	Tipo(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

	public int getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	 public static Tipo toEnum(Integer codigo) {
	        if(codigo == null) {
	            return null;
	        }

	        for(Tipo tipo : Tipo.values()) {
	            if(codigo.equals(tipo.getCodigo())) {
	                return tipo;
	            }
	        }
	        
	        return null;
	    }
	 
}
