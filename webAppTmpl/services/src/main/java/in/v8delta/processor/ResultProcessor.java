package in.v8delta.processor;

/**
 * Interface which Result data Processor - for the data returned from DB
 * 	Each implementation is a Processor Type
 * 
 * @author v8-suresh
 *
 */
public interface ResultProcessor {

	//	TODO: Return type and Param should not be object type - must be 
	//			Changed once the api for DAO is in good shape
	public Object processResultData(Object resultData);
	
}
