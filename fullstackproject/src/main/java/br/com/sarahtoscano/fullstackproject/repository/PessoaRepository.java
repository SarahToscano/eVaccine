package br.com.sarahtoscano.fullstackproject.repository;
import javax.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.sarahtoscano.fullstackproject.domain.Pessoa;

@Entity
public interface PessoaRepository  extends JpaRepository <Pessoa, Long> {
    
}

