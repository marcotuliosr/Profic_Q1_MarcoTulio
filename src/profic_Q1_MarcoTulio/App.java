package profic_Q1_MarcoTulio;

import java.util.Scanner;

import usuarioProfic_Q1.Usuario;
import livroProfic_Q1.Livro;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String login = "";
        String senha = "";
        String nome = "";
        int categoria = 0;

        Usuario usuario = null;

        boolean validacaoLoginSenha = false;
        while (!validacaoLoginSenha) {

            System.out.print("Digite o login: ");
            login = scanner.nextLine();
            System.out.print("Digite a senha: ");
            senha = Usuario.criptografaSenha(scanner.nextLine());
            System.out.print("Digite o nome: ");
            nome = scanner.nextLine();
            System.out.print("Digite a categoria: ");
            categoria = scanner.nextInt();
            scanner.nextLine();

            boolean loginValido = Validacao.validaLogin(login);
            boolean senhaValida = Validacao.validaSenha(senha);

            if (loginValido && senhaValida) {

                usuario = new Usuario(login, senha, nome, categoria);
                validacaoLoginSenha = true;
            } else {
                System.out.println("Login ou senha inválidos. Tente novamente.");
            }
        }

        boolean autenticacaoSenha = false;
        while (!autenticacaoSenha) {

            System.out.print("Digite o login para autenticação: ");
            String loginAutenticacao = scanner.nextLine();
            System.out.print("Digite a senha para autenticação: ");
            String senhaAutenticacao = scanner.nextLine();


            if (loginAutenticacao.equals(usuario.getLogin()) && senhaAutenticacao.equals(usuario.getSenha())) {
                autenticacaoSenha = true;

                System.out.println("Autenticação de senha realizada com sucesso.");
                System.out.println("Realize o cadastro do livro:");

                System.out.print("Digite o autor do livro: ");
                String autorLivro = scanner.nextLine();

                System.out.print("Digite o nome do livro: ");
                String nomeLivro = scanner.nextLine();

                System.out.print("Digite a editora do livro: ");
                String editoraLivro = scanner.nextLine();

                System.out.print("Digite o ano do livro: ");
                int anoLivro = scanner.nextInt();
                scanner.nextLine();

                Livro livro = new Livro(autorLivro, nomeLivro, editoraLivro, anoLivro);

                System.out.println("Dados do livro cadastrado:");
                System.out.println(livro.exibeBibliografia());

            } else {
                System.out.println("Autenticação de senha inválida. Tente novamente.");
                continue;
            }
        }
        scanner.close();
    }
}
