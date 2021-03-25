package br.com.sarahtoscano.fullstackproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.sarahtoscano.fullstackproject.domain.GrupoPrioridades;

public interface GrupoProridadesRepository extends JpaRepository <GrupoPrioridades, Long > {
    

}