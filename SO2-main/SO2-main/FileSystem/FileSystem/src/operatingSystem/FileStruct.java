package operatingSystem;

import java.util.ArrayList;

public class FileStruct {
	
	
	public static class NovoNo {
			
	public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public FileStruct getPonto() {
			return ponto;
		}
		public void setPonto(FileStruct ponto) {
			this.ponto = ponto;
		}
		public FileStruct getPontoPonto() {
			return pontoPonto;
		}
		public void setPontoPonto(FileStruct pontoPonto) {
			this.pontoPonto = pontoPonto;
		}
		public ArrayList<FileStruct> getChild() {
			return child;
		}
		public void setChild(ArrayList<FileStruct> child) {
			this.child = child;
		}
	private String nome; 
	private FileStruct ponto;
	private FileStruct pontoPonto;
	private ArrayList<FileStruct> child = new ArrayList<>();
	};
	
	public static NovoNo novoNo(String nome) {
		
		NovoNo no = new NovoNo();
		no.nome = nome; 
		return no; 
	}
	
}
