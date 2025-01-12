package br.com.maternidades.bebe.repository;

import br.com.maternidades.bebe.model.Bebe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface BebeRepository extends JpaRepository<Bebe, Long> {

    //Busca todos os bebês.
    List<Bebe> findByNomeBebeContainingIgnoreCase(String nomeBebe);

    //Busca Bebê com o peso maior qu eo informado.
    List<Bebe> findByPesoGreaterThan(BigDecimal peso);

    //Busca o bebê por nome da mãe.
    Page<Bebe> findByNomeMae(String nomeMae, Pageable pageable);

    //Consulta Personalizada para buscar bebês com altura dentro de um ranger.
    @Query("SELECT b FROM Bebe b WHERE b.altura BETWEEN :alturaMin AND :alturaMax")
    List<Bebe> findBebesByAlturaBetween(BigDecimal alturaMin, BigDecimal alturaMax);

    //Consulta de bebê por peso
    @Query(value = "SELECT COUNT(*) FROM bebe WHERE peso_bebe = :peso", nativeQuery = true)
    Long countBebesByPeso(BigDecimal peso);

}
