package in.v8delta.template.myWebAppTmpl.core.crypt;

/**
 * <pre>
 * Interface for Encoder. 
 * All Different type of Encoder implementation will implement this Interface
 * </pre>
 * 
 * @author v8-suresh
 *
 */
public interface Encoder {

	public byte[] encode(byte[] input) throws Exception;
	public byte[] encode(String input) throws Exception;
	
}
