class view {
	int CodCidade;
	String Ncidade;
	int QtdAcidentes;

	view(){
		this(0 , " " ,0);
	}
	view(int Cod,
		String nome,
		int Acidentes){
		
		CodCidade = Cod;
		Ncidade = nome;
		QtdAcidentes = Acidentes;
	}
	
	}
