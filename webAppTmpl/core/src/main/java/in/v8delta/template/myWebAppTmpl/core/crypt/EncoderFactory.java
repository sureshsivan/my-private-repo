package in.v8delta.template.myWebAppTmpl.core.crypt;

public class EncoderFactory {

	
	private EncoderFactory() {
		super();
	}
	
	public static Encoder getEncoder(HashingType type){
		Encoder encoder = null;
		switch (type) {
		case MD5:
			encoder = new MD5Encoder();
			break;
		case SHA_256:
			encoder = new SHA256Encoder();
			break;
		case SHA_384:
			encoder = new SHA384Encoder();
			break;
		case SHA_512:
			encoder = new SHA512Encoder();
			break;
		default:
			encoder = new SHA512Encoder();
			break;
		}
		
		return encoder;
		
	}
	
}
