package mock;

import in.v8delta.template.myWebAppTmpl.core.utils.KeyValPair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * Mock controller to test various controller options
 * 
 * @author v8-suresh
 *
 */
@Controller
@RequestMapping("mock")
public class MockController {

	@RequestMapping("first")
	@ResponseBody
	public String firstMockController(){
		System.out.println("1111111");
		return "Summa";
	}
	
	@RequestMapping("second")
	@ResponseBody
	public MockObject secondMockController(){
		System.out.println("222222");
		System.out.println("243342354"); 
		System.out.println("243342354))))");
		System.out.println("------------");
		System.out.println("%%%%%%%%%");
		return new MockObject("One", "Two");
	}
	
	@RequestMapping("resources/{file}")
	@ResponseBody
	public String getResources(@PathVariable String file){
//	public List<KeyValPair> getResources(@PathVariable String file){
//	public Map<String, List<KeyValPair>> getResources(@PathVariable String file){
		System.out.println("Sent file is : " + file);
		Map<String, List<KeyValPair>> bundle = new HashMap<String, List<KeyValPair>>();
		List<KeyValPair> out = new ArrayList<KeyValPair>();
		out.add(new KeyValPair("one", "Oneee"));
		out.add(new KeyValPair("two", "Twooo"));
		bundle.put("bundle", out);
//		return bundle;
//		return out;
		String s = "ss=suresh" + 
					System.getProperty("line.separator") + 
					"kk=Kirthika" +
					System.getProperty("line.separator") +
					"ss.kk=Our Kid";
		return s;
		
	}
	
}

class MockObject{
	private String propOne;
	private String propTwo;
	public MockObject(String propOne, String propTwo) {
		super();
		this.propOne = propOne;
		this.propTwo = propTwo;
	}
	/**
	 * @return the propOne
	 */
	public String getPropOne() {
		return propOne;
	}
	/**
	 * @param propOne the propOne to set
	 */
	public void setPropOne(String propOne) {
		this.propOne = propOne;
	}
	/**
	 * @return the propTwo
	 */
	public String getPropTwo() {
		return propTwo;
	}
	/**
	 * @param propTwo the propTwo to set
	 */
	public void setPropTwo(String propTwo) {
		this.propTwo = propTwo;
	}
	
}