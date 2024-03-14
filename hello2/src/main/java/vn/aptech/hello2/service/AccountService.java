package vn.aptech.hello2.service;

import java.util.List;
import java.util.Optional;

import vn.aptech.hello2.dto.AccountDto;

public interface AccountService {
	List<AccountDto> findAll();
	void create(AccountDto dto);
	Optional<AccountDto> findById(int id);
}
