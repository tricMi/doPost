package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{

}
