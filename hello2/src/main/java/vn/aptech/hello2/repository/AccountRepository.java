package vn.aptech.hello2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.aptech.hello2.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {
	
	Optional<Account> findByEmail(String email);
}
