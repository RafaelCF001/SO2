package operatingSystem;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

public class FileStruct {
	public String nome;
	public HashMap<String, FileStruct> fileChildren;
	public FileStruct fileParent;
	public String permission = "rwxrwxrwx";
	public int nodeNumber;
	public static HashMap<String,FileWriter> fileArquivo = new HashMap<>();
	public String date;
	public HashMap<String, String> filePermission = new HashMap<>();
	public HashMap<String, String> fileDate = new HashMap<>();
	public static void addFile(String nomeArquivo, String[] conteudo)  {
		try {
			int i = 0;
			FileWriter meuEscritor = new FileWriter(nomeArquivo);
			for (String linha : conteudo) {
				if(i == 0){
					i++;
					continue;
				}
				if(linha.contains("\\n")){
					String x = linha.replace("\\n","\n");
					meuEscritor.write(x);
					continue;
				}

				meuEscritor.write(linha + " ");

			}

			addFileHash(nomeArquivo,meuEscritor);
			meuEscritor.close();
		} catch(IOException io){
			System.out.println("Erro");
		}
	}
	public static void addFileHash(String fileName, FileWriter fileTo){
		fileArquivo.put(fileName,fileTo);
	}

	public FileStruct(){
		fileChildren = new HashMap<>();
	}
	public FileStruct(String nome, int nodeNumber){
		fileChildren = new HashMap<>();
		this.nome = nome;
		this.nodeNumber = nodeNumber;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();

		this.date = formatter.format(date);
	}
	public FileStruct addChild(String nome,FileStruct file){
		fileChildren.put(nome,file);
		file.fileParent = this;
		return this;
	}
	public static void copyChild( FileStruct file1, FileStruct file2) {
		file2.fileParent = file1;
	}
	public static int findNodeFile(String[] comando, FileStruct nodeAtual){

		int nodeNum = 0;
		try{
			for (int i = 0; i < comando.length-1; i++) {
				if (comando[i].equals(" ")) { //verifica se o comando é igual a / -> va para root
					nodeNum = 0;
				}
				if (comando[i].equals(".")) {
					nodeNum = nodeAtual.nodeNumber;
					nodeAtual = nodeAtual;
				}
				if (comando[i].equals("..")) {
					nodeNum = nodeAtual.fileParent.nodeNumber;
					nodeAtual = nodeAtual.fileParent;
				} else {
					nodeNum = nodeAtual.fileChildren.get(comando[i]).nodeNumber;
					nodeAtual = nodeAtual.fileChildren.get(comando[i]);
				}
			}
			return nodeNum;
		}catch( Exception ex){
			return 0;
		}

	}
	public static int findNode(String[] comando,  FileStruct nodeAtual){
		int nodeNum = 0;
		try{
				for (int i = 0; i < comando.length; i++) {
					if (comando[i].equals(" ")) { //verifica se o comando é igual a / -> va para root
						nodeNum = 0;
					}
					if (comando[i].equals(".")) {
						nodeNum = nodeAtual.nodeNumber;
						nodeAtual = nodeAtual;
					}
					if (comando[i].equals("..")) {
						nodeNum = nodeAtual.fileParent.nodeNumber;
						nodeAtual = nodeAtual.fileParent;
					} else {
						nodeNum = nodeAtual.fileChildren.get(comando[i]).nodeNumber;
						nodeAtual = nodeAtual.fileChildren.get(comando[i]);
					}
				}
			return nodeNum;
		}catch( Exception ex){
			return 0;
		}
	}
	public static int findNodeRemove(String[] comando,  FileStruct nodeAtual){
		int nodeNum = 0;
		System.out.println("Comando: " + comando.length);
		try{
			for (int i = 0; i < comando.length; i++) {
				System.out.println("Comando" + comando[i]);
				if (comando[i].equals(" ")) { //verifica se o comando é igual a / -> va para root
					nodeNum = 0;
				}
				else if (comando[i].equals(".")) {
					nodeNum = nodeAtual.nodeNumber;
					nodeAtual = nodeAtual;
				}
				else if (comando[i].equals("..")) {
					nodeNum = nodeAtual.fileParent.nodeNumber;
					nodeAtual = nodeAtual.fileParent;
				} else if ((comando.length == 1) &&( comando[i].equals(nodeAtual.nome))) {
					return nodeAtual.nodeNumber;
				} else {
					nodeNum = nodeAtual.fileChildren.get(comando[i]).nodeNumber;
					nodeAtual = nodeAtual.fileChildren.get(comando[i]);
				}
			}
			return nodeNum;
		}catch( Exception ex){
			System.out.println("Ex");
			return 0;
		}
	}
	public static void recurssiveNodePermission(Collection<FileStruct> node, String nodePermission){
		if(node == null){
			return;
		}
		for(FileStruct nodeCp: node){
			nodeCp.permission = nodePermission;
			recurssiveNodePermission(nodeCp.fileChildren.values(), nodePermission);
		}
	}
}
