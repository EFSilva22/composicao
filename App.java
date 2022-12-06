package AppAvaInter2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner s = new Scanner(System.in);
        String nome="";
        String laboratorio="";
        String unidade="";
        String variedade;
        int quantidade;
        boolean verificar = true;
        HashMap<String, String> unidadesDeMedidas = new HashMap<>();
        unidadesDeMedidas.put("ml", "mililitro");
        unidadesDeMedidas.put("cp", "comprimido");
        unidadesDeMedidas.put("gr", "grama");
        unidadesDeMedidas.put("un", "unidade");
        

        ArrayList<Remedio> listaRemedios = new ArrayList<Remedio>();
        System.out.println("Quantos remédios estarão disponíveis?");
        variedade = s.nextLine();
        quantidade = Integer.parseInt(variedade);
        for (int i = 0; i < quantidade; i++) {
            System.out.println("\nQual é o nome do "+ (i + 1) +"º remédio?");
            nome = s.nextLine();
            System.out.println("Qual é o laboratorio do "+ (i + 1) +"º remédio?");
            laboratorio = s.nextLine();
            System.out.println("    UNIDADES:");
            for(Map.Entry<String,String> par : unidadesDeMedidas.entrySet()) 
                  System.out.println("Abreviação: "+par.getKey()+"      Unidade: "+par.getValue());
            do {
                    try{
                           System.out.println("Qual a abreviação do remédio? (2 caracteres)");
                           unidade = s.nextLine();
                           if (unidade.length() != 2) 
                               throw new Exception("A Unidade deve ter exatamente dois caracteres");
                               verificar = false;
                    } catch (Exception e){
                           System.err.println(e.getMessage());
                    }   
            }while(verificar);           
            listaRemedios.add(new Remedio(nome, laboratorio, unidade.toLowerCase()));                    
        }
        
        // Seguindo a consulta       
        System.out.println("Qual é o nome do Animal?");
        String nomeAnimal = s.nextLine();
        System.out.println("Quais são as observacões?");
        String observacoes = s.nextLine();
        System.out.println("Qual é a queixa?");
        String queixa = s.nextLine();
        System.out.println("Qual é o histórico?");
        String historico = s.nextLine();
        Consulta consulta = new Consulta(nomeAnimal, observacoes, queixa, historico);
       System.out.println("\nRemedios disponiveis:");
        for (int i = 0; i < listaRemedios.size(); i++) {
            Remedio remedio = listaRemedios.get(i);
            System.out.println("(" + (i + 1) + ") : " + remedio.getNome() + " - " + remedio.getLaboratorio());
        }
        System.out.println("\nQuantos remédios você deseja utilizar na consulta?");
        quantidade = s.nextInt();
        
        // Seguindo a prescrição
        int count = 0;
        do {
            System.out.println("Qual o número do rémedio a partir da lista?");
            int opcao = s.nextInt();
            Remedio remedio = listaRemedios.get(opcao - 1);
            System.out.println("Qual a dosagem do remedio!");
            double dose = s.nextDouble();
            System.out.println("Qual a duração do remédio (em dias)!");
            int duracao = s.nextInt();
            consulta.setItens(dose,duracao,remedio); 
            count++;
            System.out.println("");
        } while (quantidade != count);
        
        // Exibindo a consulta
        System.out.println("CONSULTA\n\nNome do animal: "+consulta.getNomeAnimal());
        System.out.println("Observações: "+consulta.getObservacoes());
        System.out.println("Queixa: "+consulta.getQueixa());
        System.out.println("Histórico: "+consulta.getHistorico());
        System.out.println("Prescrição: ");
        for (int i = 0; i < consulta.getItens().size(); i++) {
            System.out.println("Remédio: "+consulta.getItens().get(i).getRemedio().getNome() + 
                    " - Laboratório: " + consulta.getItens().get(i).getRemedio().getLaboratorio() + 
                    " - Dosagem: " + consulta.getItens().get(i).getDose() + 
                    " " + unidadesDeMedidas.get(consulta.getItens().get(i).getRemedio().getUnidade()) + 
                    " - Duração: " + consulta.getItens().get(i).getDuracao() + " dias ");
        }
    }
}
