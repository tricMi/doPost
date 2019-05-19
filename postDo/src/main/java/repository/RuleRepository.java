package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Account;
import entity.Rule;

public interface RuleRepository extends JpaRepository<Rule, Integer>{

}
