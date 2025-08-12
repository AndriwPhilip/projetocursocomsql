package pos_java_jdbc.pos_java_jdbc;

import java.util.List;

import org.junit.Test;

import conexaojdbc.SingleConnection;
import dao.UserPosDao;
import model.Userposjava;

public class TesteBancoJdbc {
	
	@Test
	public void initBanco() {
		UserPosDao userPosDao = new UserPosDao();
		Userposjava userposjava = new Userposjava();
		
		userposjava.setId(4L);
		userposjava.setNome("Cristiano");
		userposjava.setEmail("cristianoronaldo@gmail.com");
		
		userPosDao.salvar(userposjava);
	}
	
	@Test
	public void initListar() {//busca todos os objetos do banco
		UserPosDao dao = new UserPosDao();
		try {
			List<Userposjava> list = dao.listar();
			for (Userposjava userposjava : list) {
				System.out.println(userposjava);
				System.out.println("------------------------------");
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	@Test
	public void initBuscat() {//Busca apenas o objeto especifico
		UserPosDao dao = new UserPosDao();
		try {
			Userposjava userposjava = dao.buscar(2L);
			System.out.println(userposjava);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
