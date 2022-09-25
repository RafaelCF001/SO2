package operatingSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FileStruct {
	public String nome;
	public HashMap<String, FileStruct> fileChildren;
	public FileStruct fileParent;
	public String permission = "77777";
	public FileStruct(String nome){
		fileChildren = new HashMap<>();
		this.nome = nome;
	}
	public FileStruct addChild(String nome,FileStruct file){
		fileChildren.put(nome,file);
		file.fileParent = this;
		return this;
	}
}
