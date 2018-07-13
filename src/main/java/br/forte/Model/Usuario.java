package br.forte.Model;

public class Usuario {
    private String idusuario;
    private String nome;
    private String sobrenome;
    private String email;
    private String telefone;
    private String endereco;
    private String senha;
    private String userzabbix;
    private String senhazabbix;
    private int tipo;
    private String grupo;

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getUserzabbix() {
        return userzabbix;
    }

    public void setUserzabbix(String userzabbix) {
        this.userzabbix = userzabbix;
    }

    public String getSenhazabbix() {
        return senhazabbix;
    }

    public void setSenhazabbix(String senhazabbix) {
        this.senhazabbix = senhazabbix;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getIdUsuario() {
        return idusuario;
    }

    public void setIdUsuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
