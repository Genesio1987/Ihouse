package br.com.Bean;

import br.com.DAO.UsuariosDao;
import br.com.entidades.Usuario;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.faces.bean.ManagedBean;

/**
 *
 * @Genésio Coutinho
 */
@ManagedBean
public class UsuarioBean implements Serializable {

    private Usuario usuario = new Usuario();
    private UsuariosDao usuariodao = new UsuariosDao();
    private List<Usuario> listarUsuario;

  

    
    public UsuarioBean() {
    }

    public String adicionarUsuario() {
        usuariodao.addUsuario(usuario);
        usuario.setId(null);
        usuario.setNome(null);
        usuario.setLogin(null);
        usuario.setSenha(null);
        System.out.println("Salvar usuário novo");
        return "index";
    }

    //metodo remover um usuario
    public String removerUsuario(Usuario u) {
        this.usuario = u;
        usuariodao.removeUsuario(this.usuario);
        this.usuario.setNome(null);
        this.usuario.setLogin(null);
        this.usuario.setSenha(null);
        return "index";
    }

    //listar usuario juntamente ao criteria
    public List listarUsuarios() {
        listarUsuario = usuariodao.getList();
        return this.listarUsuario;
    }

    //atualizar usuarios
    public String atualizarUsuario() {
        usuariodao.updateUsuario(usuario);
        usuario.setNome(null);
        usuario.setLogin(null);
        usuario.setSenha(null);
        System.out.println("Método atualizar usuário em UsuarioBean");
        return "index";
    }

    // carregar usuarios
    public String carregarUsuario(Usuario u) {
        usuario = u;
        return "edita";
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuariosDao getUsuariodao() {
        return usuariodao;
    }

    public void setUsuariodao(UsuariosDao usuariodao) {
        this.usuariodao = usuariodao;
    }

    //metodo adiconar usuario
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.usuario);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UsuarioBean other = (UsuarioBean) obj;
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return true;
    }

}
