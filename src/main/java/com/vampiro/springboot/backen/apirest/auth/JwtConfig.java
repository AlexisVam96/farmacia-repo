package com.vampiro.springboot.backen.apirest.auth;

public class JwtConfig {
	
	public static final String LLAVE_SECRETA = "alguna.clave.secreta.12345678";
	public static final String RSA_PRIVATE = "-----BEGIN RSA PRIVATE KEY-----\r\n" + 
			"MIIEpQIBAAKCAQEA5u0C2Ule9NtiAidxU77laFJM8GWWBaME4TschzIn3uArnkJa\r\n" + 
			"pgkepmBE5W1w2FeShS2uqdsAsmfmkKFD9cc3O6qGDZgzkUsqyxH6rYdKoqWjoCaq\r\n" + 
			"ebqgGKj7YAdbX1jZ6rRSuFMZlm6GZGwpM7XsHkh9FM2A44xVh/uGFnt1DggXU1Qm\r\n" + 
			"pOD0bpVlkJBS9+w5yf6rH3l8U5gSip5zw1mk2vG1iOmBZHVkcAiGti0850lrAKrc\r\n" + 
			"3EqPW2WcIRPkj0mdrbEcRhpji8iujonzX1608oBKYncytZCPDDs7kGIiijNtcU/6\r\n" + 
			"GNupRUWFZkje/4c+LcXZJuPICiUxx6oMYHIxjQIDAQABAoIBAHkHRzLyjV3vjRJr\r\n" + 
			"8a1eo4VlfQWReGtD4U7aWD1TQCpDexja1f+nT/ULB5DnJvl8DELYim5jZZ4bbm/m\r\n" + 
			"1WN/IaeX2+JMHtrLdoYvyh4ghjFwdq19FmPuN/I0vmq58F2sh6nHEIOiqgp5qt3/\r\n" + 
			"Aikj87h7bXL1sdOQvVMjtEccNWFARUboI5Qp68JTYF3L7vp/3caxrf7u8GcxoVXJ\r\n" + 
			"/AdShHp6lzIh3v0zPKdSrSjHX8pSrF5oqWRysdKMOB9YLoVkm7B+Vd9iF0VTvC/j\r\n" + 
			"/CWLr3OyVCbIdk1pDkjsRJvOgfyN4bFBE1WSLTIXEYEQeHtjClj5J4lxmKMYKdyJ\r\n" + 
			"g4GwwwECgYEA/Sz/Q5Si7AJP5R90eXBNMJW6mJkHqAQh0Ru4jL4Hpx+jKEIxYGl3\r\n" + 
			"PBqifuCCqW+fVjWjMpkNL49Z8oTpeHRdEqUFcxKoC6kpGTv7maBY88/dl9geiPjz\r\n" + 
			"4Rl8u8x3hxYWSeFL5ATRcmzFgMrgIBB/ne/nSOVgaZxjCmXbA1xAR/ECgYEA6YB5\r\n" + 
			"W+QrEp3yEPbQzk1YrSdkFfqWUyWPadVeZBq06RgPfGWgeqnTme4Syl2ElzYO+fvL\r\n" + 
			"p2wVDP+bIVceICk17vUJ8LVXC4otVJoxuQucsA6tfZ1r+TP0zroruH95N4du7X02\r\n" + 
			"pNSlshav3r6DeeOV2TaZTiRoX38xWOzb4lNf/10CgYEA6Lh+BE8S28LcUg7x79cM\r\n" + 
			"/UYE+dRhN05lD2Rd5fGf8z2fqpf971PC6JrLF7mkIb+bRZGUbCRH/JnW4pjOS40b\r\n" + 
			"KNJMChTyJ5XdU3bRtcuxOJywYq2kk9/TvezBvZcboC7rWgogyn6rUHUvr03Na2v/\r\n" + 
			"AtzNSzKdxzaby6kJAzO/WuECgYEAsVfpVFhsOlyJkEbU+gsWsZQ8WNEUwRvC25+5\r\n" + 
			"bBA4nNywTkulYeSAGOYPkXELlgjxwP1zhLn7Fv8/ZEgVUlnaY53qKc6gyNvuZ9Yg\r\n" + 
			"s6lVHQZY0BHzArdqVGRjdmIiv4D2SBuUmAYFvseqVWOe2cF3ex0TvJy8ROOGqEJl\r\n" + 
			"EnU+cOUCgYEA74hF+TBc4zKfMouZen+/eoPzvOTIt7nclP+heSJa4I6MeQNZoY63\r\n" + 
			"0xPWMeiHJDbDRRLUmfiaFL3HuDBmNr+qr8fWH38ySw8RYfS/S9Dcur9Z0bs9B8m5\r\n" + 
			"5vzJXe4hBxB0WmDk/Ft5iTal7Xrv3hSdRiuxytW2ULDO9HwUotE6wwI=\r\n" + 
			"-----END RSA PRIVATE KEY-----";
	
	public static final String RSA_PUBLIC ="-----BEGIN PUBLIC KEY-----\r\n" + 
			"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA5u0C2Ule9NtiAidxU77l\r\n" + 
			"aFJM8GWWBaME4TschzIn3uArnkJapgkepmBE5W1w2FeShS2uqdsAsmfmkKFD9cc3\r\n" + 
			"O6qGDZgzkUsqyxH6rYdKoqWjoCaqebqgGKj7YAdbX1jZ6rRSuFMZlm6GZGwpM7Xs\r\n" + 
			"Hkh9FM2A44xVh/uGFnt1DggXU1QmpOD0bpVlkJBS9+w5yf6rH3l8U5gSip5zw1mk\r\n" + 
			"2vG1iOmBZHVkcAiGti0850lrAKrc3EqPW2WcIRPkj0mdrbEcRhpji8iujonzX160\r\n" + 
			"8oBKYncytZCPDDs7kGIiijNtcU/6GNupRUWFZkje/4c+LcXZJuPICiUxx6oMYHIx\r\n" + 
			"jQIDAQAB\r\n" + 
			"-----END PUBLIC KEY-----";
}
