package main;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import operatingSystem.Kernel;
import operatingSystem.FileStruct;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Kernel desenvolvido pelo aluno. Outras classes criadas pelo aluno podem ser
 * utilizadas, como por exemplo: - Arvores; - Filas; - Pilhas; - etc...
 *
 * @author nome do aluno...
 */
public class MyKernel implements Kernel {
    HashMap<Integer, FileStruct> inodeTable = new HashMap<>();
    FileStruct root = new FileStruct("root",0);
	private String diretorioAtual = "root";
    public MyKernel() {
        inodeTable.put(0,root);
        setNodeNumber();
    }
    int nodeNumber = 0;
    int actualNodeNum = 0;
    public void setNodeNumber(){
        this.nodeNumber++;
    }
    public void setDiretorioAtual(String diretorioAtual) {
        this.diretorioAtual = diretorioAtual;
    }

    public String ls(String parameters) {
        //variavel result deverah conter o que vai ser impresso na tela apos comando do usuário
        String result = "";
        System.out.println("Chamada de Sistema: ls");
        System.out.println("\tParametros: " + parameters);
        int num = 0;
        String comando[] = parameters.split(" ");


        if(comando[0].equals("-l") && comando.length == 1){
            String permArquivos = "";
            FileStruct actualFile = inodeTable.get(actualNodeNum);

            for (FileStruct permission: actualFile.fileChildren.values()) {
                permArquivos = permArquivos + " " + permission.permission + " " + permission.date + " " + permission.nome + "\n";



            }
            if (!(actualFile.filePermission.isEmpty())) {
                for (String arquivos : actualFile.fileArquivo.keySet()) {
                    permArquivos = permArquivos + " " + actualFile.filePermission.get(arquivos) + " " + actualFile.fileDate.get(arquivos) + " " + arquivos + "\n";
                }

            }
            result = permArquivos;
        }else if (comando[0].equals("-l")) {

            num = FileStruct.findNode(comando[1].split("/"),inodeTable.get(actualNodeNum));
            FileStruct fileLs = inodeTable.get(num);

            String arquivos = "";

            for (FileStruct permission: fileLs.fileChildren.values()) {
                arquivos = arquivos +" " +permission.permission +" "+permission.date + " " + permission.nome + "\n";


            }

            if(!(fileLs.filePermission.isEmpty())) {

                for(String arq: fileLs.fileArquivo.keySet()){
                    arquivos= arq + " " + fileLs.filePermission.get(arq) + " " + fileLs.fileDate.get(arq)  +"\n" + arquivos + "\n";
                }
            }

        result = arquivos;
        } else{
            FileStruct actualFile = inodeTable.get(actualNodeNum);

            if(!(parameters.isEmpty())){
                num = FileStruct.findNode(comando,inodeTable.get(actualNodeNum));

                FileStruct fileLs = inodeTable.get(num);
                String arquivos = "";

                for(String dir : fileLs.fileChildren.keySet()){
                    arquivos = arquivos +" "+ dir;
                }
                if(!(fileLs.fileArquivo.isEmpty())){
                    for(String dir1: fileLs.fileArquivo.keySet()){
                        arquivos = arquivos + " " + dir1;
                    }
                }
                return  arquivos;
            }
            if(parameters.isEmpty()){
               num = actualNodeNum;

                FileStruct fileLs = inodeTable.get(num);
                String arquivos = "";

                for(String dir : fileLs.fileChildren.keySet()){
                    arquivos = arquivos +" "+ dir;
                }

                return  arquivos;
            }


        }


        return result;
    }

    public String mkdir(String parameters) {
        //variavel result deverah conter o que vai ser impresso na tela apos comando do usuário
        String result = "";
        System.out.println("Chamada de Sistema: mkdir");
        System.out.println("\tParametros: " + parameters);
        if(parameters.isBlank())
        {
            return "Diretorio vazio";
        }
        else if(diretorioAtual == "root") {

            if(parameters.contains("/")) {
                int i = 0;
                // fazer busca
                String[] caminho = parameters.split("/");
                FileStruct novoNo = new FileStruct(caminho[caminho.length - 1],nodeNumber);
                FileStruct filho = root;
                //caminho n final
                while(i < caminho.length-1){
                    filho = filho.fileChildren.get(caminho[i]);
                    i++;
                }
                filho.addChild(novoNo.nome, novoNo);
                novoNo.fileParent = filho;
                inodeTable.put(nodeNumber, novoNo);
                setNodeNumber();
                return "Criado com sucesso";
            }


            FileStruct file = new FileStruct(parameters,nodeNumber);
            root.addChild(parameters,file);
            file.fileParent = root;
            inodeTable.put(nodeNumber, file);
            setNodeNumber();
            result = "Diretorio criado com sucesso";
        }

        else {
            if(parameters.contains("/")){
                int i = 0;
                // fazer busca
                String[] caminho = parameters.split("/");
                FileStruct novoNo = new FileStruct(caminho[caminho.length - 1],nodeNumber); // cria o novo no
                FileStruct filho = inodeTable.get(actualNodeNum); // busca na tabela i-node o filho
                //caminho n final
                while(i < caminho.length-1){
                    filho = filho.fileChildren.get(caminho[i]); // buscar o filho do diretorio
                    i++;
                }
                filho.addChild(novoNo.nome, novoNo);
                novoNo.fileParent = filho;
                inodeTable.put(nodeNumber, novoNo);
                setNodeNumber();
                return "Criado com sucesso";
            }
            FileStruct actualFile = inodeTable.get(actualNodeNum);
            FileStruct file = new FileStruct(parameters,nodeNumber);
            actualFile.addChild(parameters,file);
            file.fileParent = actualFile;
            inodeTable.put(nodeNumber,file);
            setNodeNumber();
            result = "Diretorio criado com sucesso";
        }
        return result;
    }

    public String cd(String parameters) {
        //variavel result deverah conter o que vai ser impresso na tela apos comando do usuário
        String result = "";
        String currentDir = "";


        if(parameters.equals("..") & diretorioAtual.equals("root")){
            return "Nao eh possivel fazer esse movimento";
        } else if(parameters.equals("..")){
            currentDir = inodeTable.get(actualNodeNum).fileParent.nome;
        }

        for(String path: parameters.split("/")){


            if(path.equals("")){
                System.out.println(path);
                currentDir = "root";
                actualNodeNum = 0;
            }
            else if (path.equals("..")){
                currentDir = inodeTable.get(actualNodeNum).fileParent.nome;
                actualNodeNum = inodeTable.get(actualNodeNum).fileParent.nodeNumber;

            } else if (path.equals(".")) {
                currentDir = diretorioAtual;
                actualNodeNum = inodeTable.get(actualNodeNum).nodeNumber;
            }
            else {
                currentDir = inodeTable.get(actualNodeNum).fileChildren.get(path).nome;
                actualNodeNum= inodeTable.get(actualNodeNum).fileChildren.get(path).nodeNumber;
            }
        }
        diretorioAtual = currentDir;

        //setando parte gráfica do diretorio atual
        operatingSystem.fileSystem.FileSytemSimulator.currentDir = currentDir  + "/";

        //fim da implementacao do aluno
        return result;
    }

    public String rmdir(String parameters) {
        //variavel result deverah conter o que vai ser impresso na tela apos comando do usuário
        String result = "";
        int num = 0;
        System.out.println("Chamada de Sistema: rmdir");
        System.out.println("\tParametros: " + parameters);

        //inicio da implementacao do aluno
        num = FileStruct.findNodeRemove(parameters.split("/"), inodeTable.get(actualNodeNum));
        if(num == actualNodeNum) {
            FileStruct fileToRemove = inodeTable.get(num);
            FileStruct fileTransfer = fileToRemove.fileParent;

            fileTransfer.fileChildren.remove(fileToRemove.nome);
            inodeTable.remove(num);

            actualNodeNum = fileTransfer.nodeNumber;
        }else {
            FileStruct fileToRemove = inodeTable.get(num);
            FileStruct fileTransfer = fileToRemove.fileParent;

            fileTransfer.fileChildren.remove(fileToRemove.nome);
            inodeTable.remove(num);

        }
        System.out.println("node num atual: " + actualNodeNum);
        //fim da implementacao do aluno
        return result;
    }

    public String cp(String parameters) {
        //variavel result deverah conter o que vai ser impresso na tela apos comando do usuário
        String result = "";
        System.out.println("Chamada de Sistema: cp");
        System.out.println("\tParametros: " + parameters);
        int num = 0;
        int cmp = 0;
        String[] param = parameters.split(" ");

        if(param[0].equals("-R")){
            num = FileStruct.findNode(param[1].split("/"),inodeTable.get(actualNodeNum)); //pega num do node
            System.out.println("num: " + num);
            FileStruct oldNode = inodeTable.get(num); // nó para comparar
            FileStruct newNode = new FileStruct(oldNode.nome, nodeNumber); //node copia
            setNodeNumber();
            System.out.println("nome: " + newNode.nome);
            System.out.println("Old node: " + oldNode.nome);
            newNode.fileChildren = oldNode.fileChildren;
            newNode.fileParent = inodeTable.get(FileStruct.findNode(param[2].split("/"),inodeTable.get(actualNodeNum)));

            newNode.fileParent.fileChildren.put(newNode.nome, newNode);


        }else{
            num = FileStruct.findNode(param[0].split("/"),inodeTable.get(actualNodeNum));
            cmp = FileStruct.findNode(param[1].split("/"),inodeTable.get(actualNodeNum));

            if(num == cmp){
                FileStruct fileCmp = inodeTable.get(FileStruct.findNode(param[0].split("/"),inodeTable.get(actualNodeNum)));
                String[] cmp1 = param[0].split("/");
                String nomeC = cmp1[cmp1.length-1];
                String[] cpm2 = param[1].split("/");
                String nomeTo = cpm2[cpm2.length-1];

                FileWriter ob = fileCmp.fileArquivo.remove(nomeC);


                fileCmp.addFileHash(nomeTo,  ob);
                return "Arquivo renomeado com sucesso";
            }

            FileStruct fileCmp = inodeTable.get(FileStruct.findNode(param[0].split("/"),inodeTable.get(actualNodeNum)));
            FileStruct fileNew = inodeTable.get(FileStruct.findNode(param[1].split("/"),inodeTable.get(actualNodeNum)));

            String[] cmp1 = param[0].split("/");
            String nomeC = cmp1[cmp1.length-1];

            FileWriter object = fileCmp.fileArquivo.remove(nomeC);

            fileNew.addFileHash(nomeC,object);

            result = "Arquivo movido com sucesso";
        }
        
        return result;
    }

    public String mv(String parameters) {
        //variavel result deverah conter o que vai ser impresso na tela apos comando do usuário
        String result = "";
        System.out.println("Chamada de Sistema: mv");
        System.out.println("\tParametros: " + parameters);
        
        FileStruct fileTo = new FileStruct("cmp",-1); //file de comparacao
        
		for(String path: parameters.split("/")) {
				if(path.equals("..")) {
					fileTo = inodeTable.get(actualNodeNum).fileParent;
				}
				else if(path.equals(".")) {
					fileTo = inodeTable.get(actualNodeNum);
				}
				else {
					fileTo = inodeTable.get(actualNodeNum);
				}
		        }
		        
		FileStruct.copyChild(inodeTable.get(actualNodeNum),fileTo);
        
        return result;
    }

    public String rm(String parameters) {
        //variavel result deverah conter o que vai ser impresso na tela apos comando do usuário
        String result = "";
        System.out.println("Chamada de Sistema: rm");
        System.out.println("\tParametros: " + parameters);
        int num = 0;


        if(parameters.split(" ")[0].equals("-R")){ //remove diretorio
            String[] separador = parameters.split(" ");

            num = FileStruct.findNodeRemove(separador[1].split("/"), inodeTable.get(actualNodeNum));
            if(num == actualNodeNum) {
                FileStruct fileToRemove = inodeTable.get(num);
                FileStruct fileTransfer = fileToRemove.fileParent;

                fileTransfer.fileChildren.remove(fileToRemove.nome);
                inodeTable.remove(num);

                actualNodeNum = fileTransfer.nodeNumber;
            }else {
                FileStruct fileToRemove = inodeTable.get(num);
                FileStruct fileTransfer = fileToRemove.fileParent;

                fileTransfer.fileChildren.remove(fileToRemove.nome);
                inodeTable.remove(num);

            }
        }else {
            String[] fileSplit = parameters.split("/");
            String fileName = fileSplit[fileSplit.length-1];
            num = FileStruct.findNodeRemove(fileSplit, inodeTable.get(actualNodeNum));
            System.out.println(num);

            FileStruct fileRemove = inodeTable.get(num);
            fileRemove.fileArquivo.remove(fileName);
        }

        return result;
    }

    public String chmod(String parameters) {
        //variavel result deverah conter o que vai ser impresso na tela apos comando do usuário
        String result = "";
        System.out.println("Chamada de Sistema: chmod");
        System.out.println("\tParametros: " + parameters);
        if (parameters.isEmpty()) {
            return "nao eh possivel realizar operacao";
        }
        // char at 0,1,2

        String comando[] = parameters.split(" ");
        String permissao = comando[0]; // sempre será a permissão

        String[] pathArray  = comando[1].split("/");

        String newPermission = "";
        int i = 0;
        char user = permissao.charAt(0);
        char group = permissao.charAt(1);
        char others = permissao.charAt(2);

        // transformando para binario
        int usuario = Integer.parseInt(String.valueOf(user));
        String binaryUser = Integer.toBinaryString(usuario);

        int grupo = Integer.parseInt(String.valueOf(group));
        String binaryGroup = Integer.toBinaryString(grupo);

        int outros = Integer.parseInt(String.valueOf(others));
        String binaryOthers = Integer.toBinaryString(outros);


        if(binaryUser.length() == 2){
            binaryUser = '0' + binaryUser;
        } if(binaryUser.length()  == 1){
            binaryUser = "00" + binaryUser;
        } if(binaryGroup.length()  == 2){
            binaryGroup = "0" + binaryGroup;
        } if(binaryOthers.length()  == 2){
            binaryOthers = "0" + binaryOthers;
        } if(binaryGroup.length()  == 1){
            binaryGroup = "00" + binaryGroup;
        } if(binaryOthers.length()  == 1){
            binaryOthers = "00" + binaryOthers;
        }
        System.out.println("nova: " + binaryUser + binaryOthers + binaryGroup);
        //quebrando String e permissoes

        for (char bit : binaryUser.toCharArray()) {
            if (bit == '1' && i == 0) {
                newPermission += 'r';
            } else if (bit == '1' && i == 1) {
                newPermission += 'w';
            } else if (bit == '1' && i == 2) {
                newPermission += 'x';
            } else { // caso char == 0
                newPermission += '-';
            }
            i++;
        }
        i = 0;
        for (char bit : binaryGroup.toCharArray()) {
            if (bit == '1' && i == 0) {
                newPermission += 'r';
            } else if (bit == '1' && i == 1) {
                newPermission += 'w';
            } else if (bit == '1' && i == 2) {
                newPermission += 'x';
            } else { // caso char == 0
                newPermission += '-';
            }
            i++;
        } i=0;
        for (char bit : binaryOthers.toCharArray()) {
            if (bit == '1' && i == 0) {
                newPermission += 'r';
            } else if (bit == '1' && i == 1) {
                newPermission += 'w';
            } else if (bit == '1' && i == 2) {
                newPermission += 'x';
            } else { // caso char == 0
                newPermission += '-';
            }
            i++;
        }

        int nodeNum = FileStruct.findNode(pathArray,inodeTable.get(actualNodeNum));
        System.out.println(inodeTable.get(nodeNum));
        FileStruct nodePermission = inodeTable.get(nodeNum);
        nodePermission.permission = newPermission;
        FileStruct.recurssiveNodePermission(nodePermission.fileChildren.values(),newPermission);

        result = "Permissao alterada com succeso";

        return result;
    }

    public String createfile(String parameters) {
        //variavel result deverah conter o que vai ser impresso na tela apos comando do usuário
        String result = "";
        System.out.println("Chamada de Sistema: createfile");
        System.out.println("\tParametros: " + parameters);

        //inicio da implementacao do aluno

        String[] divider = parameters.split(" "); // divider em 0 == caminho, divider em 1 == texto
        String[] pathFile = divider[0].split("/");
        FileStruct nodeToFile = inodeTable.get(FileStruct.findNodeFile(pathFile, inodeTable.get(actualNodeNum)));

        if(pathFile[pathFile.length-1].contains(".txt")){

        nodeToFile.addFile(pathFile[pathFile.length-1],divider);
            nodeToFile.filePermission.put(pathFile[pathFile.length-1],"rwxrwxrwx");

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();

        nodeToFile.fileDate.put(pathFile[pathFile.length-1], formatter.format(date));


        result = "Arquivo Criado com succeso";
        }else{
            return "Só é possivel criar arquivo txt";
        }
        //fim da implementacao do aluno
        return result;
    }

    public String cat(String parameters) {
        //variavel result deverah conter o que vai ser impresso na tela apos comando do usuário
        String result = "";
        String[] path = parameters.split("/");
        String fileCat = path[path.length - 1];
        String content = "";

        content = FileStruct.getContentOfFile(fileCat);
        result = content;

        return result;
    }

    public String batch(String parameters) {
        //variavel result deverah conter o que vai ser impresso na tela apos comando do usuário
        String result = "";
        System.out.println("Chamada de Sistema: batch");
        System.out.println("\tParametros: " + parameters);

        try {
            String linha = null;
            FileReader fileBatch = new FileReader(parameters);
            BufferedReader buffer = new BufferedReader(fileBatch);
            String param = "";

            while ((linha = buffer.readLine()) != null){
                String[] linhaCmp = linha.split(" ");

                if(linhaCmp[0].equals("mkdir")){

                    mkdir(linhaCmp[1]);

                }else if(linhaCmp[0].equals("cat")){

                    cat(linhaCmp[1]);

                }else if(linhaCmp[0].equals("cd")){
                    cd(linhaCmp[1]);

                }else if(linhaCmp[0].equals("chmod")){

                    param = linhaCmp[1] + linhaCmp[2];
                    chmod(param);

                }else if(linhaCmp[0].equals("cp")){

                    if(linhaCmp.length == 4){

                        param = linhaCmp[1] + linhaCmp[2] + linhaCmp[3];

                    }else{
                        param = linhaCmp[1] + linhaCmp[2];
                    }
                    cp(param);

                }else if(linhaCmp[0].equals("createfile")){

                    param = linhaCmp[1] + linhaCmp[2];
                    createfile(param);

                }else if(linhaCmp[0].equals("info")){

                    info();

                }else if(linhaCmp[0].equals("ls")){

                    for(int i = 1; i<linhaCmp.length; i++){
                            param = param + linhaCmp[i];
                    }

                    ls(param);

                }else if(linhaCmp[0].equals("mv")){

                    for(int i = 1; i<=linhaCmp.length; i++){
                        param = param + linhaCmp[i];
                    }

                    mv(param);

                }else if(linhaCmp[0].equals("rm")){

                    for(int i = 1; i<=linhaCmp.length; i++){
                        param = param + linhaCmp[i];
                    }

                    rm(param);

                }else if(linhaCmp[0].equals("rmdir")){

                    for(int i = 1; i<=linhaCmp.length; i++){
                        param = param + linhaCmp[i];
                    }

                    rmdir(param);

                }
            }

        }catch (FileNotFoundException fl){
            return "Arquivo não existe";
        } catch (IOException e) {
            return "Erro de entrada";
        }


        return "Comandos executados";
    }

    public String dump(String parameters) {
        //variavel result deverah conter o que vai ser impresso na tela apos comando do usuário
        String result = "";
        System.out.println("Chamada de Sistema: dump");
        System.out.println("\tParametros: " + parameters);
        if(parameters.contains(".txt")) {


            result = FileStruct.recurssiveRebuild(inodeTable.get(0));

            try {
                FileWriter fileDump = new FileWriter(parameters);
                fileDump.write(result);
                fileDump.close();
            } catch (IOException io) {
                result = "Erro io ";
            }
            return result;
        }else {
            return "Apenas arquivos txt permitidos";
        }
    }

    public String info() {
        //variavel result deverah conter o que vai ser impresso na tela apos comando do usuário
        String result = "";
        System.out.println("Chamada de Sistema: info");
        System.out.println("\tParametros: sem parametros");

        //nome do aluno
        String name = "Rafael Carvalho Ferreira";
        //numero de matricula
        String registration = "2022";
        //versao do sistema de arquivos
        String version = "0.1";

        result += "Nome do Aluno:        " + name;
        result += "\nMatricula do Aluno:   " + registration;
        result += "\nVersao do Kernel:     " + version;

        return result;
    }

}
