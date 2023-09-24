import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class App {
    public static void main(String[] args) {
    
        Object[] options = {"Convertir divisas", "Convertir temperatura", "Salir"};
        
        int choice = JOptionPane.showOptionDialog(
            null,
            "¿Qué quieres hacer?",
            "Conversor",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.PLAIN_MESSAGE,
            null,
            options,
            options[0]
        );
        
        if (choice == 0) {
            // El usuario eligió "Convertir divisas"
            DecimalFormat divisa = new DecimalFormat("#.##");
            boolean continuarPrograma = true;
            while (continuarPrograma) {
                String[] monedas = {"Pesos a Dólares", "Pesos a Euros"};
                String cambio = (String) JOptionPane.showInputDialog(
                    null,
                    "Elige una opción",
                    "Conversor de Moneda",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    monedas,
                    monedas[0]
                );
                
                if (cambio == null) {
                    // El usuario canceló la selección, salimos del bucle
                    continuarPrograma = false;
                } else {
                    String input = JOptionPane.showInputDialog(
                        null,
                        "Ingrese cantidad de pesos argentinos:",
                        "Conversor de Moneda",
                        JOptionPane.QUESTION_MESSAGE
                    );
                    
                    if (input == null) {
                        // El usuario canceló 
                        continuarPrograma = true;
                    } else {
                        try {
                            double pesos = Double.parseDouble(input);
                            double resultado = 0;
                            
                            if (cambio.equals("Pesos a Dólares")) {
                                resultado = pesos / 745; // tasa
                                JOptionPane.showMessageDialog(
                                    null,
                                    pesos + " Pesos argentinos son: " + divisa.format(resultado) + " Dólares",
                                    "Resultado",
                                    JOptionPane.INFORMATION_MESSAGE
                                );
                            } else if (cambio.equals("Pesos a Euros")) {
                                resultado = pesos / 880; // Cambia la tasa según el valor real
                                JOptionPane.showMessageDialog(
                                    null,
                                    pesos + " Pesos argentinos son: " + divisa.format(resultado) + " Euros",
                                    "Resultado",
                                    JOptionPane.INFORMATION_MESSAGE
                                );
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(
                                null,
                                "Ingrese un número válido",
                                "Error",
                                JOptionPane.ERROR_MESSAGE
                            );
                        }
                    }
                }
            }
        } else if (choice == 1) {
            // El usuario eligió "Convertir temperatura"
            System.out.println("Realizando la conversión de temperatura...");
        } else if (choice == 2) {
            // El usuario eligió "Salir"
            JOptionPane.showMessageDialog(null, "Bueno chau");
            System.exit(0);
        }
    }
}
