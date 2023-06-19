import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        
        /* questão 1: imc
        * fórmula == "peso / (altura**2)
        *<18.5|18.5 25 | 25 30 | 30 35 | 35 40 | > 40
        *abaixo, normal, sobrepeso, Obeso, OBEso, OBESO
        * temos que pegar altura e peso
        *questão 2
        */
        Scanner sc = new Scanner(System.in);
        String hun=null; 
        Construct calc = new Construct(0,0);
        
            
        System.out.println("Escolha o que você quer\n 1 para imc \n 2 para etapas de natação\n 3 para pagar uma média de lucro\n 4 para tomar remedio\n digite 0 para encerrar: ");
        hun = sc.nextLine(); 
        

        
        switch (hun){
            case "1":
                System.out.println("digita o peso");
                calc.setVal1(sc.nextFloat());
                System.out.println("digita a altura");
                calc.setVal2(sc.nextFloat());
                calc.retorno();
                break;
            case "2":
                System.out.println("digite sua idade");
                calc.setVal1(sc.nextFloat());
                calc.natacao();
                break;
            case "3":
                System.out.println("digite o valor de compra");
                calc.setVal1(sc.nextFloat());
                calc.Lucro();
                break;
            case "4":
                System.out.println("digite o peso ");
                calc.setVal1(sc.nextFloat());
                System.out.println("digite a idade ");
                calc.setVal2(sc.nextFloat());
                calc.Remedio();
            default:
            System.out.println("\nacabemo");
             break;
                
        }
          
                        
                        
       
    }
    
}
