package br.edu.fatec.fatecapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.ArrayList;

@RestController
public class AlunoController {
	
	private List<Aluno> ListaAlunos = new ArrayList<>();

	@GetMapping(path = "/alunos")
	public List<Aluno> getAlunos() {
		
		return this.ListaAlunos;
	}
	
	@GetMapping(path = "/alunos/{codigo}")
	public ResponseEntity<?> getAlunoById(@PathVariable(name = "codigo") Integer codigo){
		
		for(Aluno a : this.ListaAlunos) {
			if(codigo.equals(a.getCodigo())) {
				return ResponseEntity.status(HttpStatus.OK).body(a);
			}
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		
	}
	
	@DeleteMapping(path = "/alunos/{codigo}")
	public ResponseEntity<?> removerById(@PathVariable(name = "codigo") Integer codigo){
		
		Aluno alunoRemocao = null;
		
		for(Aluno a : this.ListaAlunos) {
			if(codigo.equals(a.getCodigo())) {
			alunoRemocao = a;
			}
		}
		this.ListaAlunos.remove(alunoRemocao);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	
	@PostMapping(path = "/alunos")
	public ResponseEntity<?> save(@RequestBody Aluno aluno) {
		
		for(Aluno a : this.ListaAlunos) {
			
			if(a.getCpf().equals(aluno.getCpf())) {
				return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
			}
			
		}
		
		Integer codigo = (int) (Math.random() * 1000);
		aluno.setCodigo(codigo);
		
		this.ListaAlunos.add(aluno);
		return ResponseEntity.status(HttpStatus.CREATED).body(aluno);
	}
	
	@PutMapping(path = "/alunos/{codigo}")
	public ResponseEntity<?> update(@PathVariable Integer codigo, @RequestBody Aluno alunoAtualizado) {

	    for (Aluno aluno : this.ListaAlunos) {
	        if (aluno.getCodigo().equals(codigo)) {
	            aluno.setNome(alunoAtualizado.getNome());
	            aluno.setCurso(alunoAtualizado.getCurso());
	            aluno.setCpf(alunoAtualizado.getCpf());

	            return ResponseEntity.status(HttpStatus.OK).body(aluno);
	        }
	    }

	    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado.");
	}

}