import java.util.List;
import java.util.function.Consumer;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class AlunoControler {
	//abertura conexao com Mysql
	EntityManagerFactory emf;
	//para realizar operacoes
	EntityManager em;
	
	public AlunoControler() {
		emf = Persistence.createEntityManagerFactory("aluno");
		em = emf.createEntityManager();
	}
	
	public void salvar(Aluno _aluno) {
		em.getTransaction().begin();
		em.merge(_aluno);
		em.getTransaction().commit();
		emf.close();
	}
	public void remover(Aluno _aluno) {
		em.getTransaction().begin();
		Query q = (javax.persistence.Query) em.createNativeQuery("delete aluno from aluno where matricula ="+_aluno.getMatricula());
		q.executeUpdate();
		em.getTransaction().commit();
		emf.close();
	}
	public void atualiza(Aluno _aluno,String param,String valor,String matricula) {
		em.getTransaction().begin();
		Query q = (javax.persistence.Query) em.createNativeQuery("update aluno set "+param+"="+valor+" where matricula ="+matricula);
		q.executeUpdate();
		em.getTransaction().commit();
		emf.close();
	}
	public List<Aluno>listar(){
		em.getTransaction().begin();
		Query q = em.createQuery("SELECT aluno FROM Aluno aluno");
		List<Aluno> lista = q.getResultList();
		em.getTransaction().commit();
		em.close();
		return lista;
	}
	
}
