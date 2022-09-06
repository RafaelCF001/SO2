package operatingSystem;

import java.util.ArrayList;

public class FileStruct {
	
	
	static class NovoNo {
	private String nome; 
	private FileStruct ponto;
	private ArrayList<FileStruct> child = new ArrayList<>();
	};
	
	public NovoNo novoNo(String nome) {
		
		NovoNo no = new NovoNo();
		no.nome = nome; 
		
		return no; 
	}
	
}
