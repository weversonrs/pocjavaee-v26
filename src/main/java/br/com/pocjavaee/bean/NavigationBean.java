package br.com.pocjavaee.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="navigationBean")
public class NavigationBean {
	
	public String inicio() {
		System.out.println("navegacao");
		return "index";
	}

}
