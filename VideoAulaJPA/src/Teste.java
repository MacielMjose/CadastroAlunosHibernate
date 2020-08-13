import java.util.List;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		AlunoControler ac = new AlunoControler();
		//ac.atualiza(alun, "nome", "kebeston"bx, alun.getMatricula());
		//ac.remover(alun);
		
		List<Aluno>alunos = ac.listar();
		for (Aluno aluno : alunos) {
			System.out.println(aluno.getNome());
		}
		
	}

}
