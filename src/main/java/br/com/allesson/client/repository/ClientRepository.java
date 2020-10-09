package br.com.allesson.client.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.allesson.client.entity.Client;
import br.com.allesson.client.vo.ClientVO;
@Repository
public interface ClientRepository extends JpaRepository <Client, String> {
	@Query(value = "SELECT new br.com.allesson.client.vo.ClientVO( "
			+ "   cli.cpf "
			+ " , cli.nome "
			+ " , cli.nomeReduzido "
			+ " , cli.sexo "
			+ " , cli.email "
			+ " , cli.telefone )"
			+ " FROM Client cli")Page<ClientVO> getListClients(Pageable pageable);
	@Modifying
	@Transactional
	@Query( value = "INSERT INTO tb_cliente "
			+ " (num_cpf, nome_completo, nome_reduzido, sexo, email, telefone) "
			+ " VALUES (:cpf, :nome, :nomeReduzido, :sexo, :email, :telefone)", nativeQuery = true
			)void insertClient(@Param("cpf") String cpf, @Param("nome") String nome, @Param("nomeReduzido") String nomeReduzido
					, @Param("sexo") String sexo, @Param("email") String email, @Param("telefone") String telefone);
	
	@Query(value = "SELECT new br.com.allesson.client.vo.ClientVO( "
			+ "   cli.cpf "
			+ " , cli.nome "
			+ " , cli.nomeReduzido "
			+ " , cli.sexo "
			+ " , cli.email "
			+ " , cli.telefone )"
			+ " FROM Client cli "
			+ " WHERE cli.cpf = :cpf")ClientVO findByCpf(@Param("cpf") String cpf);

}
