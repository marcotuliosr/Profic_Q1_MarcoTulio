package profic_Q1_MarcoTulio;


//        O método recebe, por parâmetro, a senha do usuário e retorna
//        verdadeiro(true), se a senha é válida, ou falso(false), no caso de senha
//        inválida. Uma senha é válida, se:
//        Exemplo:
//        Entrada Saída
//        12345 False
//        @m123jose True


public class Validacao {

    public static boolean validaLogin(String login) {
        int tamanho = login.length();

        // Verifica se o login possui entre 5 e 20 caracteres
        if (tamanho >= 5 && tamanho <= 20) {
            // Verifica se o login não contém os caracteres @ e $
            if (!login.contains("@") && !login.contains("$")) {
                return true; // O login é válido
            }
        }

        return false; // O login é inválido
    }

    public static void main(String[] args) {
        // Teste do método validaLogin()
        System.out.println(validaLogin("bruno10")); // true
        System.out.println(validaLogin("jose12@")); // false
        System.out.println(validaLogin("aluno jose")); // false
    }
    public static boolean validaSenha(String senha) {
        boolean contemArroba = false;
        boolean contemLetraMaiuscula = false;

        for (int i = 0; i < senha.length(); i++) {
            char c = senha.charAt(i);

            if (c == '@') {
                contemArroba = true;
            } else if (Character.isUpperCase(c)) {
                contemLetraMaiuscula = true;
            }
        }
        return contemArroba && contemLetraMaiuscula;
    }
}
