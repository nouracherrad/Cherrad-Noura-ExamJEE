package org.sdia.cherradnouraexamjeebank.Repositories;

import org.sdia.cherradnouraexamjeebank.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {}

