
package model;

/**
 * @author Paula Belmiro
 */
public class Linhas {
    
    private int id;
    private String codigo;
    private String nome;

    public Linhas(int id, String codigo, String nome) {
        this.id = id;
        this.codigo = codigo;
        this.nome = nome;
    }

   public Linhas() {

    } 
   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Linhas{" + "id=" + id + ", codigo=" + codigo + ", nome=" + nome + '}';
    }
    
       
}