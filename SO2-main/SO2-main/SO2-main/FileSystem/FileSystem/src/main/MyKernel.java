package main;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import operatingSystem.Kernel;
import operatingSystem.FileStruct;
import java.util.HashMap;
/**
 * Kernel desenvolvido pelo aluno. Outras classes criadas pelo aluno podem ser
 * utilizadas, como por exemplo: - Arvores; - Filas; - Pilhas; - etc...
 *
 * @author nome do aluno...
 */
public class MyKernel implements Kernel {
    HashMap<String, FileStruct> struct = new HashMap<>();
    FileStruct root = new FileStruct("root");
	private String diretorioAtual = "root";
    public MyKernel() {
        struct.put("root",root);
    }

    public void setDiretorioAtual(String diretorioAtual) {
        this.diretorioAtual = diretorioAtual;
    }

    public String ls(String parameters) {
        //variavel result deverah conter o que vai ser impresso na tela apos comando do usuário
        String result = "";
        System.out.println("Chamada de Sistema: ls");
        System.out.println("\tParametros: " + parameters);

        String comando[] = parameters.split(" ");
        if(comando[0].equals("-l")){
            System.out.println("Entrou no -l");
            if(comando.length > 1){

                // pega caminho
            }
            FileStruct actualFile = struct.get(diretorioAtual);

            for (FileStruct permission: actualFile.fileChildren.values()){
                System.out.println(permission.nome +  " " + "Permissao: " + permission.permission);
            }
        }
        else{
            FileStruct actualFile = struct.get(diretorioAtual);

            for(String dir: actualFile.fileChildren.keySet()){
                System.out.println(dir);
            }
        }


        return result;
    }

    public String mkdir(String parameters) {
        //variavel result deverah conter o que vai ser impresso na tela apos comando do usuário
        String result = "";
        System.out.println("Chamada de Sistema: mkdir");
        System.out.println("\tParametros: " + parameters);
        if(diretorioAtual == "root") {
            FileStruct file = new FileStruct(parameters);
            root.addChild(parameters,file);
            struct.put(parameters, file);
            System.out.println("Criando filho");
        }

        else {
            FileStruct actualFile = struct.get(diretorioAtual);
            FileStruct file = new FileStruct(parameters);
            actualFile.addChild(parameters,file);
            struct.put(parameters,file);
        }
        return result;
    }

    public String cd(String parameters) {
        //variavel result deverah conter o que vai ser impresso na tela apos comando do usuário
        String result = "";
        String currentDir = "";
        System.out.println("Chamada de Sistema: cd");
        System.out.println("\tParametros: " + parameters);
        System.out.println("Dir atual: " + diretorioAtual);

        if(parameters.equals("..") & diretorioAtual.equals("root")){
            System.out.println("Nao eh possivel fazer esse movimento");
            return result;
        }

        for(String path: parameters.split("/")){
            System.out.println("Caminho: "+ path);
            if (path.equals("..")){
                currentDir = struct.get(path).fileParent.nome;

            } else if (path.equals(".")) {
                currentDir = diretorioAtual;
            }
            else {
                currentDir = struct.get(path).nome;
            }
        }
        diretorioAtual = currentDir;

        //setando parte gráfica do diretorio atual
        operatingSystem.fileSystem.FileSytemSimulator.currentDir = currentDir;

        //fim da implementacao do aluno
        return result;
    }

    public String rmdir(String parameters) {
        //variavel result deverah conter o que vai ser impresso na tela apos comando do usuário
        String result = "";
        System.out.println("Chamada de Sistema: rmdir");
        System.out.println("\tParametros: " + parameters);

        //inicio da implementacao do aluno
        //fim da implementacao do aluno
        return result;
    }

    public String cp(String parameters) {
        //variavel result deverah conter o que vai ser impresso na tela apos comando do usuário
        String result = "";
        System.out.println("Chamada de Sistema: cp");
        System.out.println("\tParametros: " + parameters);

        //inicio da implementacao do aluno
        //fim da implementacao do aluno
        return result;
    }

    public String mv(String parameters) {
        //variavel result deverah conter o que vai ser impresso na tela apos comando do usuário
        String result = "";
        System.out.println("Chamada de Sistema: mv");
        System.out.println("\tParametros: " + parameters);

        //inicio da implementacao do aluno
        //fim da implementacao do aluno
        return result;
    }

    public String rm(String parameters) {
        //variavel result deverah conter o que vai ser impresso na tela apos comando do usuário
        String result = "";
        System.out.println("Chamada de Sistema: rm");
        System.out.println("\tParametros: " + parameters);

        //inicio da implementacao do aluno
        //fim da implementacao do aluno
        return result;
    }

    public String chmod(String parameters) {
        //variavel result deverah conter o que vai ser impresso na tela apos comando do usuário
        String result = "";
        System.out.println("Chamada de Sistema: chmod");
        System.out.println("\tParametros: " + parameters);

        //inicio da implementacao do aluno
        //fim da implementacao do aluno
        return result;
    }

    public String createfile(String parameters) {
        //variavel result deverah conter o que vai ser impresso na tela apos comando do usuário
        String result = "";
        System.out.println("Chamada de Sistema: createfile");
        System.out.println("\tParametros: " + parameters);

        //inicio da implementacao do aluno
        //fim da implementacao do aluno
        return result;
    }

    public String cat(String parameters) {
        //variavel result deverah conter o que vai ser impresso na tela apos comando do usuário
        String result = "";
        System.out.println("Chamada de Sistema: cat");
        System.out.println("\tParametros: " + parameters);

        //inicio da implementacao do aluno
        //fim da implementacao do aluno
        return result;
    }

    public String batch(String parameters) {
        //variavel result deverah conter o que vai ser impresso na tela apos comando do usuário
        String result = "";
        System.out.println("Chamada de Sistema: batch");
        System.out.println("\tParametros: " + parameters);

        //inicio da implementacao do aluno
        //fim da implementacao do aluno
        return result;
    }

    public String dump(String parameters) {
        //variavel result deverah conter o que vai ser impresso na tela apos comando do usuário
        String result = "";
        System.out.println("Chamada de Sistema: dump");
        System.out.println("\tParametros: " + parameters);

        //inicio da implementacao do aluno
        //fim da implementacao do aluno
        return result;
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
