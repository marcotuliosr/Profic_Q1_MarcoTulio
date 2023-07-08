package livroProfic_Q1;
public class Livro {
    private String autor;
    private String nome;
    private String editora;
    private int ano;

    public Livro() {
    }

    public Livro(String autor, String nome, String editora, int ano) {
        this.autor = autor;
        this.nome = nome;
        this.editora = editora;
        this.ano = ano;
    }

    public Livro(String codigoLivro, String nomeLivro, String editoraLivro, String autorLivro, int anoLivro) {
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String exibeBibliografia() {

        String[] partesNomeAutor = autor.split(" ");
        String ultimoNomeAutor = partesNomeAutor[partesNomeAutor.length - 1];
        StringBuilder iniciaisDemaisNomes = new StringBuilder();
        for (int i = 0; i < partesNomeAutor.length - 1; i++) {
            iniciaisDemaisNomes.append(partesNomeAutor[i].charAt(0)).append(". ");
        }

        StringBuilder bibliografia = new StringBuilder();
        bibliografia.append(ultimoNomeAutor).append(" ").append(iniciaisDemaisNomes).append(nome).append(". Ed. ").append(editora).append(".\n").append(ano).append(".");
        return bibliografia.toString();
    }
}

