package service;

public class BuscadorServiceFactory {
	public static BuscadorService getBuscadorService() {
		return new BuscadorServiceImpl();//usa el constructor por defecto
	}

}
