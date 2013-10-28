package mock;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

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
	public List<String> getResources(@PathVariable String file){
		List<String> out = new ArrayList<String>();
		out.add("one=11111111111");
		out.add("two=222222222");
		out.add("two.three=222222222.3333333333");
		out.add(HtmlUtils.htmlEscape("two.three.custom={0}222222 222.33333 333{1}33.44{2}44{3}"));
		return out;

//	public Map<String, List<KeyValPair>> getResources(@PathVariable String file){	
//		Map<String, List<KeyValPair>> bundle = new HashMap<String, List<KeyValPair>>();
//		List<KeyValPair> out = new ArrayList<KeyValPair>();
//		out.add(new KeyValPair("one", "11111"));
//		out.add(new KeyValPair("two", "22222"));
//		bundle.put("bundle", out);
//		return bundle;

//		public String getResources(@PathVariable String file){	
//		String s = "ss=suresh" + 
//					System.getProperty("line.separator") + 
//					"kk=Kirthika" +
//					System.getProperty("line.separator") +
//					"ss.kk=Our Kid";
//		return s;
		
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