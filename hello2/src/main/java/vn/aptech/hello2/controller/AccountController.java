package vn.aptech.hello2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.aptech.hello2.dto.AccountDto;
import vn.aptech.hello2.service.AccountService;

@Controller
@RequestMapping(value="/account")
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	
	@GetMapping(value="")
	public String index(Model model) {
		model.addAttribute("accounts", accountService.findAll());
		return "index";
	}
	
	@GetMapping(value="/create")
	public String create(Model model) {
		model.addAttribute("account", new AccountDto());
		return "create";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(Model model, @PathVariable("id") int id) {
		model.addAttribute("account", accountService.findById(id));
		return "create";
	}
	
	
	@PostMapping(value = "/save")
	public String save(@ModelAttribute("account") AccountDto account, Model model) {
		accountService.create(account);
		return "redirect:/account";
	}
}
