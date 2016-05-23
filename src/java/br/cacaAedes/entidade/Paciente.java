/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cacaAedes.entidade;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Show_
 */
@Entity
@Table(name = "paciente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paciente.findAll", query = "SELECT p FROM Paciente p"),
    @NamedQuery(name = "Paciente.findById", query = "SELECT p FROM Paciente p WHERE p.id = :id"),
    @NamedQuery(name = "Paciente.findByDoenca", query = "SELECT p FROM Paciente p WHERE p.doenca = :doenca"),
    @NamedQuery(name = "Paciente.findByUf", query = "SELECT p FROM Paciente p WHERE p.uf = :uf"),
    @NamedQuery(name = "Paciente.findByMunicipio", query = "SELECT p FROM Paciente p WHERE p.municipio = :municipio"),
    @NamedQuery(name = "Paciente.findByUnidadeNotificadora", query = "SELECT p FROM Paciente p WHERE p.unidadeNotificadora = :unidadeNotificadora"),
    @NamedQuery(name = "Paciente.findByNomePaciente", query = "SELECT p FROM Paciente p WHERE p.nomePaciente = :nomePaciente"),
    @NamedQuery(name = "Paciente.findByDataNasc", query = "SELECT p FROM Paciente p WHERE p.dataNasc = :dataNasc"),
    @NamedQuery(name = "Paciente.findBySexo", query = "SELECT p FROM Paciente p WHERE p.sexo = :sexo"),
    @NamedQuery(name = "Paciente.findByRua", query = "SELECT p FROM Paciente p WHERE p.rua = :rua"),
    @NamedQuery(name = "Paciente.findByNumEndereco", query = "SELECT p FROM Paciente p WHERE p.numEndereco = :numEndereco"),
    @NamedQuery(name = "Paciente.findByBairro", query = "SELECT p FROM Paciente p WHERE p.bairro = :bairro"),
    @NamedQuery(name = "Paciente.findByCep", query = "SELECT p FROM Paciente p WHERE p.cep = :cep"),
    @NamedQuery(name = "Paciente.findByCriterioConfirmacao", query = "SELECT p FROM Paciente p WHERE p.criterioConfirmacao = :criterioConfirmacao"),
    @NamedQuery(name = "Paciente.findByLat", query = "SELECT p FROM Paciente p WHERE p.lat = :lat"),
    @NamedQuery(name = "Paciente.findByLng", query = "SELECT p FROM Paciente p WHERE p.lng = :lng"),
    @NamedQuery(name = "Paciente.findByCasoAutoctone", query = "SELECT p FROM Paciente p WHERE p.casoAutoctone = :casoAutoctone"),
    @NamedQuery(name = "Paciente.findByDataNotificacao", query = "SELECT p FROM Paciente p WHERE p.dataNotificacao = :dataNotificacao")})
public class Paciente implements Serializable {

    @Column(name = "nome_rua")
    private String nomeRua;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "doenca")
    private String doenca;
    @Column(name = "uf")
    private String uf;
    @Column(name = "municipio")
    private String municipio;
    @Column(name = "unidade_notificadora")
    private String unidadeNotificadora;
    @Column(name = "nome_paciente")
    private String nomePaciente;
    @Column(name = "data_nasc")
    @Temporal(TemporalType.DATE)
    private Date dataNasc;
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "rua")
    private String rua;
    @Column(name = "num_endereco")
    private Integer numEndereco;
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "cep")
    private Integer cep;
    @Column(name = "criterio_confirmacao")
    private String criterioConfirmacao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "lat")
    private BigDecimal lat;
    @Column(name = "lng")
    private BigDecimal lng;
    @Column(name = "caso_autoctone")
    private String casoAutoctone;
    @Column(name = "data_notificacao")
    @Temporal(TemporalType.DATE)
    private Date dataNotificacao;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @ManyToOne
    private Usuario idUsuario;

    public Paciente() {
    }

    public Paciente(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDoenca() {
        return doenca;
    }

    public void setDoenca(String doenca) {
        this.doenca = doenca;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getUnidadeNotificadora() {
        return unidadeNotificadora;
    }

    public void setUnidadeNotificadora(String unidadeNotificadora) {
        this.unidadeNotificadora = unidadeNotificadora;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumEndereco() {
        return numEndereco;
    }

    public void setNumEndereco(Integer numEndereco) {
        this.numEndereco = numEndereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public String getCriterioConfirmacao() {
        return criterioConfirmacao;
    }

    public void setCriterioConfirmacao(String criterioConfirmacao) {
        this.criterioConfirmacao = criterioConfirmacao;
    }

    public BigDecimal getLat() {
        return lat;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    public BigDecimal getLng() {
        return lng;
    }

    public void setLng(BigDecimal lng) {
        this.lng = lng;
    }

    public String getCasoAutoctone() {
        return casoAutoctone;
    }

    public void setCasoAutoctone(String casoAutoctone) {
        this.casoAutoctone = casoAutoctone;
    }

    public Date getDataNotificacao() {
        return dataNotificacao;
    }

    public void setDataNotificacao(Date dataNotificacao) {
        this.dataNotificacao = dataNotificacao;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.cacaAedes.entidade.Paciente[ id=" + id + " ]";
    }

    public String getNomeRua() {
        return nomeRua;
    }

    public void setNomeRua(String nomeRua) {
        this.nomeRua = nomeRua;
    }
    
}
