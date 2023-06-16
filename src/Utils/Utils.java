package Utils;

import DAO.AmigoDAO;
import DAO.FerramentaDAO;
import Model.Amigo;
import Model.Ferramenta;
import View.MensagensException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Utils {
    private static final AmigoDAO objetoamigo = new AmigoDAO();;
    private static final FerramentaDAO objetoferramenta = new FerramentaDAO();;
    public static List<Amigo> filtrarAmigos(String nomeAmigo, String emailAmigo) throws MensagensException {
        List<Amigo> amigosConvertidos = new ArrayList<>();

        List<Amigo> amigosEncontrados = null;
        try {
            amigosEncontrados = objetoamigo.getMinhaLista();
        } catch (MensagensException ex) {
            
        } catch (SQLException ex) {
            
        }

        for (Amigo amigo : amigosEncontrados) {
            if (!nomeAmigo.isEmpty() && emailAmigo.isEmpty()) {
                if (amigo.getNome().toLowerCase().contains(nomeAmigo.toLowerCase())) {
                    amigosConvertidos.add(amigo);
                }
            }
            if (!emailAmigo.isEmpty() && nomeAmigo.isEmpty()) {
                if (amigo.getEmail().toLowerCase().contains(emailAmigo.toLowerCase())) {
                    amigosConvertidos.add(amigo);
                }
            }
            if (!emailAmigo.isEmpty() && !nomeAmigo.isEmpty()) {
                if (amigo.getNome().toLowerCase().contains(nomeAmigo.toLowerCase()) && amigo.getEmail().toLowerCase().contains(emailAmigo.toLowerCase())) {
                    amigosConvertidos.add(amigo);
                }
            }
            if (emailAmigo.isEmpty() && nomeAmigo.isEmpty()) {
                if (amigo.getNome().toLowerCase().contains(nomeAmigo.toLowerCase()) || amigo.getEmail().toLowerCase().contains(emailAmigo.toLowerCase())) {
                    amigosConvertidos.add(amigo);
                }
            }
        }
        return amigosConvertidos;
    }
    
    public static List<Ferramenta> filtrarFerramenta(String termo1, String termo2) throws MensagensException, SQLException {
        List<Ferramenta> ferramentaConvertidas = new ArrayList<>();

        List<Ferramenta> ferramentaEncontradas = null;
        try {
            ferramentaEncontradas = objetoferramenta.getMinhaLista();
        } catch (MensagensException ex) {
            
        } catch (SQLException ex) {
            
        }
        if (termo2.isEmpty()) {
            for (Ferramenta ferramenta : ferramentaEncontradas) {
                if (ferramenta.getNome().toLowerCase().contains(termo1.toLowerCase()) || ferramenta.getMarca().toLowerCase().contains(termo1.toLowerCase())) {
                    ferramentaConvertidas.add(ferramenta);
                }
            }
        }
        if (!termo1.isEmpty() && !termo2.isEmpty()) {
            for (Ferramenta ferramenta : ferramentaEncontradas) {
                if (ferramenta.getNome().toLowerCase().equals(termo1.toLowerCase()) && ferramenta.getMarca().toLowerCase().equals(termo2.toLowerCase())) {
                    ferramentaConvertidas.add(ferramenta);
                }
            }
        }
        return ferramentaConvertidas;
    }
    
    public static boolean isValidDate(LocalDate date) {
        LocalDate dataAtual = LocalDate.now();

        if (date.isBefore(dataAtual)) {
            return false;
        }

        int dia = date.getDayOfMonth();
        int mes = date.getMonthValue();
        int ano = date.getYear();

        if (mes > 12 || dia > 31) {
            return false;
        }

        if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            if (dia > 30) {
                return false;
            }
        } else if (mes == 2) {
            if (ano % 4 == 0 && (ano % 100 != 0 || ano % 400 == 0)) {
                if (dia > 29) {
                    return false;
                }
            } else {
                if (dia > 28) {
                    return false;
                }
            }
        }

        return true;
    }
    
    public static boolean validarNome(String nome) {
        String padrao = "^[A-Za-z\\s]+$";

        Pattern pattern = Pattern.compile(padrao);
        Matcher matcher = pattern.matcher(nome);

        return matcher.matches();
    }
    
}
