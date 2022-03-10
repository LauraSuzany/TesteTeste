package com.laura.backenddev.repository;

import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.laura.backenddev.entity.Doc;

@Repository
public interface DocRepository extends JpaRepository <Doc, Long> {

	
//	@Modifying
//	@Query("update doc c set d.document = d.tipo_documento ?1 where c.numeroConta = ?2 and c.agencia =?3")
	
	
	@Query("select d from Doc d where d.user.id = :userId and d.id = :docId")
	Optional<Doc> findByUserAndDocId(@Param("userId") Long useId,@Param("docId") Long docId);
//	Page<DocDtoResponse> findAll(Pageable pageable);
	

}
