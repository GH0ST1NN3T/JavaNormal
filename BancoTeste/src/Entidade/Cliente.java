
package Entidade;


public class Cliente {
    int id= 1;
    int cpf= 00000000;
    String nome="";
    String email="";
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
