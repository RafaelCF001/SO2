package operatingSystem;

import java.io.BufferedReader;
import java.io.FileReader;
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
	public HashMap<String,FileWriter> fileArquivo = new HashMap<>();
	public String date;
	public HashMap<String, String> filePermission = new HashMap<>();
	public HashMap<String, String> fileDate = new HashMap<>();

	public static String commands = "";

	public  void addFile(String nomeArquivo, String[] conteudo)  {
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
	public void addFileHash(String fileName, FileWriter fileTo){
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
		try{
			for (int i = 0; i < comando.length; i++) {
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
			System.out.println("O arquivo nao existe");
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
	public static String recurssiveRebuild(FileStruct node){

		if(node == null){
			return "";
		}
		if(node.nome.equals("root") && node.nodeNumber == 0){
			buildCommand(node);
		}
		for(FileStruct nodeCp: node.fileChildren.values()){
			buildCommand(nodeCp);
			recurssiveRebuild(nodeCp);
		}
		return commands;
	}
	public static void buildCommand(FileStruct node){

		String finalPermission = buildPermission(node);
		String fileContent = "";


		for(String nomeArquivo: node.fileArquivo.keySet()){
			fileContent = fileContent + "createfile "+ getAbsolutePath(node)+ "/"+ nomeArquivo+" " + getContentOfFile(nomeArquivo).replace("\n","\\n") + "\n";
		}

		if(node.nodeNumber != 0) {
			if ((finalPermission.equals(""))) {
				commands = commands + "mkdir " + getAbsolutePath(node) + "\n";
			} else {
				commands = commands + "mkdir " + getAbsolutePath(node) + "\n" + "chmod " + finalPermission + " " + node.nome + "\n";
			}
		}
		System.out.println("Final: " + finalPermission);
		commands = commands  + fileContent;

	}
	public static String getContentOfFile(String fileName){
		String content = "";
		String result = "";
		try {
			FileReader fileToShow = new FileReader(fileName);
			String line = null;

			BufferedReader buffer = new BufferedReader(fileToShow);

			while((line = buffer.readLine())!= null){
				content = content + line + "\n";
			}
			result = content;
		}catch (Exception ex ){
			return "arquivo nao existe";
		}
		return result;

	}
	public static String buildPermission(FileStruct node){
		String binaryC = "";

		String read = node.permission.substring(0,3);
		String write = node.permission.substring(3,6);
		String user = node.permission.substring(6,9);
		int userI = 0;
		int readI = 0;
		int writeI = 0;

		if( !(node.permission.equals("rwxrwxrwx"))){

			for(char cmp: read.toCharArray()){
				if(cmp == '-'){
					binaryC += "0";
				}
				else{
					binaryC +="1";
				}
			}
			readI = Integer.parseInt(binaryC.substring(0,3),2);
			for(char cmp: write.toCharArray()){
				if(cmp == '-'){
					binaryC += "0";
				}
				else{
					binaryC +="1";
				}
			}
			writeI = Integer.parseInt(binaryC.substring(3,6),2);

			for(char cmp: user.toCharArray()){
				if(cmp == '-'){
					binaryC += "0";
				}
				else{
					binaryC +="1";
				}
			}
			userI = Integer.parseInt(binaryC.substring(6,9),2);
			return readI + "" + writeI + "" + userI;
		}else{
			return "";
		}

	}
	public static String getAbsolutePath(FileStruct node){
		if(node.nome.equals("root")){
			return "";
		}
		else{
			return getAbsolutePath(node.fileParent) + "/" + node.nome;
		}
	}
}
