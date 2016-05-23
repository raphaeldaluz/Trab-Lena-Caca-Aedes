package br.cacaAedes.bean;

import br.cacaAedes.dao.PacienteDAO;
import br.cacaAedes.entidade.Paciente;
import br.cacaAedes.util.exception.ErroSistema;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class PacienteBean {
    
    private Paciente paciente = new Paciente();
    private List<Paciente> pacientes = new ArrayList<>();
    private PacienteDAO pacienteDAO = new PacienteDAO();

    public void adicionar() {
        try {
            if (paciente.getId() == null) {
                pacienteDAO.salvar(paciente);
                paciente = null;
            } else {
                pacienteDAO.update(paciente);
                paciente = null;
            }

            adicionarMensagem("Salvo!", "Caso salvo com sucesso!", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }
            
    public void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public List<Paciente> listar() {
        try {
            pacientes = pacienteDAO.listar();
            if (paciente == null || pacientes.isEmpty()) {
                adicionarMensagem("Nenhum dado encontrado!", "Sua busca não retornou nenhum caso!", FacesMessage.SEVERITY_WARN);
            }

        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
        return pacientes;
    }

    public void deletar(Paciente p) {
        try {
            pacienteDAO.deletar(p);
            adicionarMensagem("Deletado!", "Caso deletado com sucesso!", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }
    
    public void adicionarLatLng(double lat, double lng)
    {
        /*paciente.setLat(lat);
        paciente.setLng(long);*/
        addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Localização do Caso", "Lat:" + paciente.getLat() + ", Lng:" + paciente.getLng()));
    }

    public String editar(Paciente p) {
        paciente = p;
        return "gerenciar-paciente.xhtml?faces-redirect=true";
    }

    public void adicionarMensagem(String sumario, String detalhe, FacesMessage.Severity tipoErro) {
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage(tipoErro, sumario, detalhe);
        context.addMessage(null, message);
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }  
    
}
