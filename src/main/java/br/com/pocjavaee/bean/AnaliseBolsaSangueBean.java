package br.com.pocjavaee.bean;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.pocjavaee.model.Agendamento;
import br.com.pocjavaee.model.Endereco;
import br.com.pocjavaee.model.Laboratorio;
import br.com.pocjavaee.model.Paciente;
import br.com.pocjavaee.model.SolicitacaoSangue;

@ManagedBean(name="analiseBean")
@SessionScoped
public class AnaliseBolsaSangueBean {
	
	private List<SolicitacaoSangue> solicitacoes = null;
	private Date dataAnalise = null;
	private String responsavelAnalise;
	
	public AnaliseBolsaSangueBean(){
		
		dataAnalise = new Date();
		
		setAgendamento(new Agendamento());
		solicitacoes = new ArrayList<SolicitacaoSangue>();
		SolicitacaoSangue solicitacao1 = new SolicitacaoSangue();
		solicitacao1.setCodigo(1);
		solicitacao1.setDataSolicitacao(new Date());
		solicitacao1.setJustificativa("TESTE 1");
		solicitacao1.setPacienteBeneficiario((Paciente) new Paciente().setNome("PACIENTE 1"));
		
	}
	
	public Laboratorio getSelectedLaboratorio() {
		return selectedLaboratorio;
	}

	public void setSelectedLaboratorio(Laboratorio selectedLaboratorio) {
		this.selectedLaboratorio = selectedLaboratorio;
	}

	public Agendamento getAgendamento() {
		return agendamento;
	}

	public void setAgendamento(Agendamento agendamento) {
		this.agendamento = agendamento;
	}
	
	public List<SelectItem> getLaboratorios() {  
	    List<SelectItem> items = new ArrayList<SelectItem>();  
	    for (Laboratorio e : this.laboratorios) {  
	        // observem que o value do meu SelectItem a própria entidade  
	        items.add(new SelectItem(e, e.getNome() + "-" + e.getEndereco().getLogradouro() + "-" + e.getEndereco().getBairro()));  
	    }  
	    return items;  
	}

	public Date getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(Date dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}	

	public void setLaboratorios(List<Laboratorio> laboratorios) {
		this.laboratorios = laboratorios;
	}
	
	public void agendar() throws IOException{
		
		HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		
		response.sendRedirect(request.getRequestURL().toString().replace("solicitarDoacao.xhtml", "confirmacao.xhtml"));
		
		System.out.println(selectedLaboratorio);
		
		System.out.println(dataAgendamento);
		
		//response.sendRedirect("/confirmacao.xhtml");
		
		//return "/confirmacao.xhtml?faces-redirect=true";
	}

}
