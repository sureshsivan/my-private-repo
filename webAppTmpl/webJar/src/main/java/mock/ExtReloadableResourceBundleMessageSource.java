package mock;

import org.springframework.context.support.ReloadableResourceBundleMessageSource;

public class ExtReloadableResourceBundleMessageSource extends
		ReloadableResourceBundleMessageSource {

	
	@Override
	protected String getDefaultMessage(String code) {
		// TODO Auto-generated method stub
		return super.getDefaultMessage(code);
	}
	
	public Object getAll(){
		return new Object();
	}
	
}
