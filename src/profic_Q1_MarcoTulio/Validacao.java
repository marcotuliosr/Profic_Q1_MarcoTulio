package profic_Q1_MarcoTulio;

public class Validacao {

    public static boolean validaLogin(String login) {
        int tamanho = login.length();

        if (tamanho >= 5 && tamanho <= 20 && !login.contains("@") && !login.contains("$") && !login.matches(".*\\s.*")) {
            return true;
        }
        return false;
    }

    public static boolean validaSenha(String senha) {
        if (senha.length() < 5) {
            return false;
        }

        boolean hasLowerCase = false;
        boolean hasDigit = false;

        for (int i = 0; i < senha.length(); i++) {
            char c = senha.charAt(i);
            if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            }
        }
        if (hasLowerCase && hasDigit) {
            return true;
        }
        return false;
    }

}
