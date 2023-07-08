package profic_Q1_MarcoTulio;

import java.util.Scanner;
import usuarioProfic_Q1.Usuario;
import livroProfic_Q1.Livro;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ETAPA 1 - VALIDAÇÃO DE LOGIN E SENHA
        String login = "";
        String senha = "";
        String nome = "";
        int categoria = 0;

        boolean validacaoLoginSenha = false;
        while (!validacaoLoginSenha) {
            // Leitura dos dados do usuário
            System.out.print("Digite o login: ");
            login = scanner.nextLine();
            System.out.print("Digite a senha: ");
            senha = scanner.nextLine();
            System.out.print("Digite o nome: ");
            nome = scanner.nextLine();
            System.out.print("Digite a categoria: ");
            categoria = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            // Validação do login e senha
            boolean loginValido = Validacao.validaLogin(login);
            boolean senhaValida = Validacao.validaSenha(senha);

            if (loginValido && senhaValida) {
                // Criptografar a senha
                String senhaCriptografada = Usuario.criptografaSenha(senha);

                // Criar o usuário efetivamente
                Usuario usuario = new Usuario(login, senhaCriptografada, nome, categoria);
                validacaoLoginSenha = true; // Validador para sair do loop
            } else {
                System.out.println("Login ou senha inválidos. Tente novamente.");
            }
        }

        // ETAPA 2 - AUTENTICAÇÃO DE SENHA
        boolean autenticacaoSenha = false;
        while (!autenticacaoSenha) {
            // Leitura do login e senha para autenticação
            System.out.print("Digite o login para autenticação: ");
            String loginAutenticacao = scanner.nextLine();
            System.out.print("Digite a senha para autenticação: ");
            String senhaAutenticacao = scanner.nextLine();

            // Descriptografar a senha criptografada
            String senhaDescriptografada = usuario.descriptografaSenha(usuario.getSenha());


            // Autenticar a senha
            if (loginAutenticacao.equals(login) && senhaAutenticacao.equals(senhaDescriptografada)) {
                autenticacaoSenha = true; // Validador para sair do loop

                // ETAPA 2.3 - CADASTRO DE LIVRO
                System.out.println("Autenticação de senha realizada com sucesso.");
                System.out.println("Realize o cadastro do livro:");

                System.out.print("Digite o código do livro: ");
                String codigoLivro = scanner.nextLine();
                System.out.print("Digite o nome do livro: ");
                String nomeLivro = scanner.nextLine();
                System.out.print("Digite a editora do livro: ");
                String editoraLivro = scanner.nextLine();
                System.out.print("Digite o autor do livro: ");
                String autorLivro = scanner.nextLine();
                System.out.print("Digite o ano do livro: ");
                int anoLivro = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer do scanner

                // Criar o objeto Livro e instanciá-lo
                Livro livro = new Livro(codigoLivro, nomeLivro, editoraLivro, autorLivro, anoLivro);

                // ETAPA 2.4 - EXIBIR DADOS DO LIVRO
                System.out.println("Dados do livro cadastrado:");
                System.out.println(livro.exibeBibliografia());
            } else {
                System.out.println("Autenticação de senha inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}
