package br.com.maternidades.bebe.service;

import br.com.maternidades.bebe.model.Bebe;
import br.com.maternidades.bebe.repository.BebeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BebeService {

    private final BebeRepository bebeRepository;

    @Autowired
    public BebeService(BebeRepository bebeRepository) {
        this.bebeRepository = bebeRepository;
    }

    //Listar todos os bebês.
    public List<Bebe> buscarPorNome(String nome) {
        return bebeRepository.findByNomeBebeContainingIgnoreCase(nome);
    }

    //Lista bebês com o peso maior informado.
    public List<Bebe> buscarPorPesoMaiorQue(BigDecimal peso){
        return bebeRepository.findByPesoGreaterThan(peso);
    }

    //Buscar bebês no intervalo de altura.
    public List<Bebe> buscarPorAlturaEntre(BigDecimal alturaMin, BigDecimal alturaMax){
        return bebeRepository.findBebesByAlturaBetween(alturaMin, alturaMax);
    }

    //buscar bebês por nome da mãe com paginação.
    public Page<Bebe> buscarPorNomeDaMae(String nomeMae, Pageable pageable){
        return bebeRepository.findByNomeMae(nomeMae, pageable);
    }

    //Conta bebês com o peso informado
    public Long contarBebesPorPeso(BigDecimal peso){
        return bebeRepository.countBebesByPeso(peso);
    }

    //Cadastrar Um bebê ou atualizar um.
    public Bebe salvarBebe(Bebe bebe){
        return bebeRepository.save(bebe);
    }
    //Excluir um bebê.
    public void excluirBebe(Long id){
        bebeRepository.deleteById(id);
    }

    //Buscar Por ID.
    public Bebe buscarPorId(Long id){
        return bebeRepository.findById(id).orElse(null);
    }
}
