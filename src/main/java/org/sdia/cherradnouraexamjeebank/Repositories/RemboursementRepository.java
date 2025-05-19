package org.sdia.cherradnouraexamjeebank.Repositories;


import org.sdia.cherradnouraexamjeebank.entities.Remboursement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RemboursementRepository extends JpaRepository<Remboursement, Long> {}
