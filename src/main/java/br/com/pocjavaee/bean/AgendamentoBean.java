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

@ManagedBean(name="agendamentoBean")
@SessionScoped
public class AgendamentoBean {
	
	private Laboratorio selectedLaboratorio;
	private Agendamento agendamento= null;
	private List<Laboratorio> laboratorios = null;
	private Date dataAgendamento = null;
	
	public AgendamentoBean(){
		
		dataAgendamento = new Date();
		
		setAgendamento(new Agendamento());
		laboratorios = new ArrayList<Laboratorio>();
		Laboratorio lab1 = new Laboratorio();
		lab1.setCodigo(100l);
		lab1.setNome("Lab 1");
		
		Endereco endereco1 = new Endereco();
		endereco1.setBairro("Centro");
		endereco1.setCep("31000000");
		endereco1.setCidade("Belo Horizonte");
		endereco1.setEstado("MG");
		endereco1.setLogradouro("RUA A");
		endereco1.setNumero(1);
		
		lab1.setEndereco(endereco1);
		
		laboratorios.add(lab1);
		
		
		Laboratorio lab2 = new Laboratorio();
		lab2.setCodigo(100l);
		lab2.setNome("Lab 2");
		
		Endereco endereco2 = new Endereco();
		endereco2.setBairro("Centro");
		endereco2.setCep("31000000");
		endereco2.setCidade("Belo Horizonte");
		endereco2.setEstado("MG");
		endereco2.setLogradouro("RUA A");
		endereco2.setNumero(1);
		
		lab2.setEndereco(endereco2);
		
		laboratorios.add(lab2);
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
