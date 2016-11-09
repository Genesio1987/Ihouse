package br.com.DAO;

import br.com.entidades.Usuario;
import br.com.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @Genesio
 */
public class UsuariosDao {

    private Session sessao;
    private Transaction trans;
    private List<Usuario> list;
    private int id = 0;

    public int getId() {
        return id;
    }

   
    

    public List<Usuario> getList() {
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        Criteria cri = sessao.createCriteria(Usuario.class);
        this.list = cri.list();
        return list;
    }

    public void setList(List<Usuario> list) {
        this.list = list;
    }

    //metodo adicionar usuario
    public void addUsuario(Usuario u) {
        try {
            // iniciar uma nova sessao, e abrindo esta sessão
            sessao = HibernateUtil.getSessionFactory().openSession();
            // iniciando uma transação
            trans = sessao.beginTransaction();
            // iniciando um novo usuario
            Usuario usuario = new Usuario();
            usuario.setNome(u.getNome());
            usuario.setLogin(u.getLogin());
            usuario.setSenha(u.getSenha());
            //salvando o objeto usuario
            sessao.save(usuario);
            //comitando o objeto usuario gravando no banco de dados
            trans.commit();
        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            // fechando a sessão
            sessao.close();

        }
    }

    // metodo que deleta no banco de dados objeto Usuario
    public void removeUsuario(Usuario u) {
        try {
            // iniciar uma nova sessao, e abrindo esta sessão
            sessao = HibernateUtil.getSessionFactory().openSession();
            // iniciando uma transação
            trans = sessao.beginTransaction();
            //deletando o objeto usuario
            sessao.delete(u);
            //comitando o objeto usuario gravando no banco de dados
            trans.commit();
        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            // fechando a sessão
            sessao.close();

        }
    }

    public void updateUsuario(Usuario u) {

        try {
            sessao = HibernateUtil.getSessionFactory().openSession(); //Iniciando uma nova sessão
            trans = sessao.beginTransaction(); // Iniciando uma nova Transação
            u.setId(id);
            System.out.println("Usuario" + u.getNome());   
            sessao.update(u);//Alterando o objeto cliente
            trans.commit();//comitando a transação granvando no banco de dados

        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            // fechando a sessão
            sessao.close();

        }
    }

}
