package usuarioProfic_Q1;

public class Usuario {
    private String login;
    private String senha;
    private String nome;
    private int categoria;

    public Usuario(String login, String senhaCriptografada, String nome, int categoria) {
    }

    // Implementação do método criptografaSenha()
    public static String criptografaSenha(String senha) {
        StringBuilder senhaCriptografada = new StringBuilder();

        for (int i = 0; i < senha.length(); i++) {
            char c = senha.charAt(i);

            // Não modificar os caracteres @ e $
            if (c == '@' || c == '$') {
                senhaCriptografada.append(c);
            }
            // Para o primeiro caractere, mover 1 letra para direita
            else if (i == 0) {
                senhaCriptografada.append((char) (c + 1));
            }
            // Para todos os demais caracteres, mover 2 letras (ou números) para a direita
            else {
                senhaCriptografada.append((char) (c + 2));
            }
        }

        return senhaCriptografada.toString();
    }

    public static String descriptografaSenha(String senha) {
        StringBuilder senhaDescriptografada = new StringBuilder();

        for (int i = 0; i < senha.length(); i++) {
            char c = senha.charAt(i);

            // Não modificar os caracteres @ e $
            if (c == '@' || c == '$') {
                senhaDescriptografada.append(c);
            }
            // Para o primeiro caractere, mover 1 letra para direita
            else if (i == 0) {
                senhaDescriptografada.append((char) (c + 1));
            }
            // Para o último caractere, mover 1 letra para esquerda
            else if (i == senha.length() - 1) {
                senhaDescriptografada.append((char) (c - 1));
            }
            // Para todos os demais caracteres, mover 2 letras (ou números) para a esquerda
            else {
                senhaDescriptografada.append((char) (c - 2));
            }
        }

        return senhaDescriptografada.toString();
    }

    // Getters
    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public String getNome() {
        return nome;
    }

    public int getCategoria() {
        return categoria;
    }

    // Setters
    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = criptografaSenha(senha);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }
}
