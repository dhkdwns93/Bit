package mini.util;

import kr.or.kobis.kobisopenapi.consumer.rest.KobisOpenAPIRestService;

public class ApiConnection {//singleton apiconnection
	private static KobisOpenAPIRestService instance = new KobisOpenAPIRestService("5eb9751149f521b9799205d8a2d23d81");

	public static KobisOpenAPIRestService getInstance() {
		return instance;
	}

}
