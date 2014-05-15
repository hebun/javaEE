package jsf;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;


public class CDIBean {


	
	public CDIBean() {
		System.out.println("cdi constructor");
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void init(){
		System.out.println("from cdi bean");
	}
}
