
package teste;

import controller.LinhasController;
import java.util.List;
import model.Linhas;

/**
 *
 * @author Paula Belmiro
 */
public class Main {

    
    public static void main(String[] args) {
         
       LinhasController linhasController = new LinhasController();
/*
       Linhas linhas = new Linhas();
       linhas.setId(5039);
       linhas.setCodigo("2141-1");
       linhas.setNome("5\\u00aa UNIDADE\\/ESCOLAR II");
       linhasController.save(linhas); */

        List<Linhas> linha = linhasController.getAll();
        System.out.println("Total de Linhas = " + linha.size());
        System.out.println(linha);
       
    }
    
}
