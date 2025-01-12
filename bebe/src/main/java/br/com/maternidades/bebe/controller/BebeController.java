package br.com.maternidades.bebe.controller;

import br.com.maternidades.bebe.model.Bebe;
import br.com.maternidades.bebe.service.BebeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/bebes")
public class BebeController {

    private final BebeService bebeService;

    @Autowired
    public BebeController(BebeService bebeService) {
        this.bebeService = bebeService;
    }

    //Busca todos os Bebês contendo o nome fornecido.
    @GetMapping("/nome")
    @Transactional
    public ResponseEntity<List<Bebe>> buscarPorNome(@RequestParam @Valid String nome){
        List<Bebe> bebes = bebeService.buscarPorNome(nome);
        return ResponseEntity.ok(bebes);
    }

    //Busca bebês com o peso maior que o informado.
    @GetMapping("/peso/maior-que")
    @Transactional
    public ResponseEntity<List<Bebe>> buscarPorPesoMaiorQue(@RequestParam @Valid BigDecimal peso){
        List<Bebe> bebes = bebeService.buscarPorPesoMaiorQue(peso);
        return ResponseEntity.ok(bebes);
    }
    //Busca Bebes pelo nome da mãe com paginação.
    @GetMapping("mae")
    @Transactional
    public ResponseEntity<Page<Bebe>> buscarPorNomeMae(@RequestParam @Valid String nomeMae, Pageable pageable){
        Page<Bebe> bebes = bebeService.buscarPorNomeDaMae(nomeMae, pageable);
        return ResponseEntity.ok(bebes);
    }

    //Buscar Bebês com altura em um intervalo
    @GetMapping("/altura")
    @Transactional
    public ResponseEntity<List<Bebe>> buscarPorAlturaEntre(
            @RequestParam @Valid BigDecimal alturaMin,
            @RequestParam @Valid BigDecimal alturaMax){
        List<Bebe> bebes = bebeService.buscarPorAlturaEntre(alturaMin, alturaMax);
        return ResponseEntity.ok(bebes);
    }

    //Contar bebês com peso exato.
    @GetMapping("/peso/contar")
    @Transactional
    public ResponseEntity<Long> contarBebesPorPeso(@RequestParam @Valid BigDecimal peso){
        Long count = bebeService.contarBebesPorPeso(peso);
        return ResponseEntity.ok(count);
    }

    //Salvar um novo bebê
    @PostMapping
    @Transactional
    public ResponseEntity<Bebe> salvarBebe(@RequestBody @Valid Bebe bebe){
        Bebe salvo = bebeService.salvarBebe(bebe);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    //Atualiza o bebê existente
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Bebe> atualizarBebe(@PathVariable Long id, @RequestBody @Valid Bebe bebe){
        Bebe existente = bebeService.buscarPorId(id);
        if (existente == null){
            return ResponseEntity.notFound().build();
        }
        bebe.setId(id);
        Bebe atualizado = bebeService.salvarBebe(bebe);
        return ResponseEntity.ok(atualizado);
    }

    //Excluir um Bebe.
    public ResponseEntity<Void> excluirBebe(@PathVariable Long id){
        Bebe existente = bebeService.buscarPorId(id);
        if (existente == null){
            return ResponseEntity.notFound().build();
        }

        bebeService.excluirBebe(id);
        return ResponseEntity.noContent().build();
    }
}
