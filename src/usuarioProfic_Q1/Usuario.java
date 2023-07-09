package usuarioProfic_Q1;

public class Usuario {
    private String login;
    private String senha;
    private String nome;
    private int categoria;

    public Usuario(String login, String senha, String nome, int categoria) {
        this.login = login;
        this.senha = criptografaSenha(senha);
        this.nome = nome;
        this.categoria = categoria;
    }

    public static String criptografaSenha(String senha) {
        StringBuilder senhaCriptografada = new StringBuilder();

        for (int i = 0; i < senha.length(); i++) {
            char c = senha.charAt(i);

            if (c == '@' || c == '$') {
                senhaCriptografada.append(c);
            }

            else if (i == 0) {
                senhaCriptografada.append((char) (c - 1));
            }

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

            if (c == '@' || c == '$') {
                senhaDescriptografada.append(c);
            }

            else if (i == 0) {
                senhaDescriptografada.append((char) (c + 1));
            }

            else if (i == senha.length() - 1) {
                senhaDescriptografada.append((char) (c - 1));
            }

            else {
                senhaDescriptografada.append((char) (c - 2));
            }
        }
        return senhaDescriptografada.toString();
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return descriptografaSenha(senha);
    }

    public String getSenhaCriptografada() {
        return senha;
    }

    public String getNome() {
        return nome;
    }

    public int getCategoria() {
        return categoria;
    }

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
