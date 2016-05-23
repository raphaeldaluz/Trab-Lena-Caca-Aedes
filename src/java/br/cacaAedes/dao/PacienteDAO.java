package br.cacaAedes.dao;

import br.cacaAedes.entidade.Paciente;
import br.cacaAedes.util.HibernateUtil;
import br.cacaAedes.util.exception.ErroSistema;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PacienteDAO {

    public void salvar(Paciente paciente) throws ErroSistema {
        try {
            Session session = HibernateUtil.getSession();
            Transaction t = session.beginTransaction();
            session.save(paciente);
            t.commit();
            /*Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps;
            if (paciente.getId() == null) {
                ps = conexao.prepareStatement("INSERT INTO `carro` (`modelo`,`fabricante`,`cor`,`ano`) VALUES (?,?,?,?)");
            } else {
                ps = conexao.prepareStatement("update carro set modelo=?, fabricante=?, cor=?, ano=? where id=?");
                ps.setInt(5, paciente.getId());
            }
            ps.setInt(1, paciente.getId());
            ps.setString(2, paciente.getNome());
            ps.execute();
            FabricaConexao.fecharConexao();*/
        } catch (Exception ex) {
            throw new ErroSistema("Erro ao tentar salvar!", ex);
        }
    }

    public void update(Paciente paciente) throws ErroSistema {
        try {
            Session session = HibernateUtil.getSession();
            Transaction t = session.beginTransaction();
            session.update(paciente);
            t.commit();
        } catch (Exception ex) {
            throw new ErroSistema("Erro ao tentar salvar!", ex);
        }
    }

    public void deletar(Paciente paciente) throws ErroSistema {
        try {
            Session session = HibernateUtil.getSession();
            Transaction t = session.beginTransaction();
            session.delete(paciente);
            t.commit();

        } catch (Exception ex) {
            throw new ErroSistema("Erro ao deletar o carro!", ex);
        }
    }

    public List<Paciente> listar() throws ErroSistema {
        try {
            Session session = HibernateUtil.getSession();
            Transaction t = session.beginTransaction();
            List lista = session.getNamedQuery("Paciente.findAll").list();
            t.commit();
            /*
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("select * from carro");
            ResultSet resultSet = ps.executeQuery();
            List<Paciente> carros = new ArrayList<>();
            while (resultSet.next()) {
                Paciente carro = new Paciente();
                carro.setId(resultSet.getInt("id"));
                carro.setModelo(resultSet.getString("modelo"));
                carro.setFabricante(resultSet.getString("fabricante"));
                carro.setCor(resultSet.getString("cor"));
                carro.setAno(resultSet.getInt("ano"));
                carros.add(carro);
            }
            FabricaConexao.fecharConexao();*/
            return lista;

        } catch (Exception ex) {
            throw new ErroSistema("Erro ao buscar os dados!", ex);
        }
    }
}
