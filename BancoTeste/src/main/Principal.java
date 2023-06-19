package main;
import Controle.AlunoDao;
import java.util.LinkedList;
import java.util.List;
import Entidade.Cliente;
import Controle.ClienteDao;
import Controle.ColaboradorDao;
import Entidade.Aluno;
import Entidade.Colaborador;
public class Principal {
       public static void main(String[] args) {
        Cliente cliente = new Cliente();
        ClienteDao clienteDao = new ClienteDao();
        List<Cliente> clientes = new LinkedList<Cliente>();
        Colaborador colaborador = new Colaborador();
        ColaboradorDao colaboradorDao = new ColaboradorDao();
        List<Colaborador> colaboradores = new LinkedList<Colaborador>();
        Aluno aluno = new Aluno();
        AlunoDao alunoDao = new AlunoDao();
        List<Aluno> alunos = new LinkedList<Aluno>();
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
        //exclusao por ID
//        colaboradorDao.excluir(1);
        //Visao de cada tabela
//        for(Colaborador c : colaboradors){
//            System.out.println("" + c.getNome());
//        }
        //visão de cada linha de dados
//        colaborador = colaboradorDao.buscar(1);
//        System.out.println("" + colaborador.getNome());
        //inserção de dados
//        colaboradorDao.inserir(colaborador);
        //atualização de dados
//        colaborador.setId(1);
//        colaborador.setNome("Jose Maria");
//        colaboradorDao.atualizar(colaborador);
        //exclusao por ID
//        alunoDao.excluir(1);
        //Visao de cada tabela
//        for(Aluno c : alunos){
//            System.out.println("" + c.getNome());
//        }
        //visão de cada linha de dados
//        aluno = alunoDao.buscar(1);
//        System.out.println("" + aluno.getNome());
        //inserção de dados
//        alunoDao.inserir(aluno);
        //atualização de dados
//        aluno.setId(1);
//        aluno.setNome("Jose Maria");
//        alunoDao.atualizar(aluno);
       }
}
