package vn.aptech.hello2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.aptech.hello2.dto.AccountDto;
import vn.aptech.hello2.entity.Account;
import vn.aptech.hello2.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountRepository accountRepository;
	
	
	private AccountDto toDto(Account o) {
		return new AccountDto(
					o.getId(), o.getEmail(), o.getPassword(), o.getPhone(), o.getFullname()
				);
	}
	
	private Account fromDto(AccountDto o) {
		return new Account(
					o.getId(), o.getEmail(), o.getPassword(), o.getPhone(), o.getFullname()
						);
	}
	
	public List<AccountDto>	findAll() {
		return accountRepository.findAll().stream().map(this::toDto).toList()	;
		
	}
	
	public void create(AccountDto dto) {
		Account o = fromDto(dto);
		accountRepository.save(o);
	}
	
	@Override
	public Optional<AccountDto> findById(int id){
		Optional<Account> result = accountRepository.findById(id);
		return result.map(this::toDto);
	}
	
}
