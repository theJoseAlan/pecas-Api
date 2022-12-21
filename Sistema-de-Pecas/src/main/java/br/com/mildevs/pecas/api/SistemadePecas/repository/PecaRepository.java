package br.com.mildevs.pecas.api.SistemadePecas.repository;

import br.com.mildevs.pecas.api.SistemadePecas.entity.Peca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//Aqui fica a busca pelo código de barras, mas pode ser por outros
//parâmetros também, o código de barras é bom porque é único. É tipo o CPF da peça (rsrsrs)
//Então o que for feito (delete, insert, alter, search) verifica logo o cod de barras


@Repository
public interface PecaRepository extends JpaRepository<Peca, Long> {

    Optional<Peca> findBycodBarras(int codBarras);

}
