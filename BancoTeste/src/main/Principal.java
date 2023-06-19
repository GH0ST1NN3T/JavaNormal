package main;
import java.util.LinkedList;
import java.util.List;
import Entidade.Cliente;
import Controle.ClienteDao;
public class Principal {
       public static void main(String[] args) {
           Cliente cliente = new Cliente();
        ClienteDao clienteDao = new ClienteDao();
        List<Cliente> clientes = new LinkedList<Cliente>();
        //exclusao por ID
//        clienteDao.excluir(1);
        //Visao de cada tabela
//        for(Cliente c : clientes){
//            System.out.println("" + c.getNome());
//        }
        //visão de cada linha de dados
//        cliente = clienteDao.buscar(1);
//        System.out.println("" + cliente.getNome());
        //inserção de dados
//        clienteDao.inserir(cliente);
        //atualização de dados
//        cliente.setId(1);
//        cliente.setNome("Jose Maria");
//        clienteDao.atualizar(cliente);
       }
}
