import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Renat0
 */
public class Alexa {
        public static void escreva(String texto){
        System.out.print(texto);
    }
    public static String leia(){
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
    public static int leiaInteiro(){
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
    public static double leiaDouble(){
        Scanner input = new Scanner(System.in);
        return input.nextDouble();
    }
    public static String escrevaLeiaJanela(String texto){
        return JOptionPane.showInputDialog(texto);
    }
    public static void escrevaJanela(String texto){
        JOptionPane.showMessageDialog(null, texto);
    }
}