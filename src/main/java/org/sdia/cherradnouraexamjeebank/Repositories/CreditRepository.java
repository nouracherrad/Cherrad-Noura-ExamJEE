package org.sdia.cherradnouraexamjeebank.Repositories;

import org.sdia.cherradnouraexamjeebank.entities.Credit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditRepository extends JpaRepository<Credit, Long> {}

