package pos_java_jdbc.pos_java_jdbc;

import java.util.List;

import org.junit.Test;

import conexaojdbc.SingleConnection;
import dao.UserPosDao;
import model.BeanUserFone;
import model.Telefone;
import model.Userposjava;

public class TesteBancoJdbc {
	
	@Test
	public void initBanco() {
		UserPosDao userPosDao = new UserPosDao();
		Userposjava userposjava = new Userposjava();
		
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
	
	@Test
	public void initAtualizar() {	
		
		try {
			
			UserPosDao dao = new UserPosDao();
			Userposjava objetoBanco = dao.buscar(5L);
			objetoBanco.setNome("Nome alterado com metodo atualizar");
			dao.atualizar(objetoBanco);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void initDeletar() {
		try {
			
			UserPosDao dao= new UserPosDao();
			dao.deletar(7L);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testeInsertTelefone() {
		
		Telefone telefone = new Telefone();
		telefone.setNumero("(31) 9944-5147");
		telefone.setTipo("Celular");
		telefone.setUsuario(8L);
		
		UserPosDao dao = new UserPosDao();
		dao.salvarTelefone(telefone);
		
	}
	
	@Test
	public void testeCarregaFonesUser() {
		
		UserPosDao dao = new UserPosDao();
		List<BeanUserFone> beanUserFones = dao.listaUserFone(2L);
		
		for (BeanUserFone beanUserFone : beanUserFones) {
			System.out.println("\n" + beanUserFone);
			System.out.println("----------------------------");
		}
		
	}
	

}
