package br.com.mildevs.pecas.api.SistemadePecas.repository;

import br.com.mildevs.pecas.api.SistemadePecas.entity.Peca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PecaRepository extends JpaRepository<Peca, Long> {

    Optional<Peca> findBycodBarras(int codBarras);

}
