package com.bootcamp.msproduct.resource;

import com.bootcamp.msproduct.dto.AccountDto;
import com.bootcamp.msproduct.entity.Account;
import com.bootcamp.msproduct.service.AccountServiceImpl;
import com.bootcamp.msproduct.service.IAccountService;
import com.bootcamp.msproduct.util.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class AccountResource extends MapperUtil {
    @Autowired
    private AccountServiceImpl accountService;

    public Mono<AccountDto> create(AccountDto accountDto) {
        log.debug("Create method beggining...");
        Account personalAccount = map(accountDto, Account.class);
        return accountService.save(personalAccount)
                .map(x -> map(x, AccountDto.class));
    }

    public Mono<AccountDto> update(AccountDto accountDto) {
        Account account = map(accountDto, Account.class);
        return accountService.findById(accountDto.getId())
                .switchIfEmpty(Mono.error(new Exception()))
                .flatMap(y -> accountService.save(account).map(x -> map(x, AccountDto.class)));
    }

    public Mono<Void> delete(AccountDto accountDto) {
        return accountService.findById(accountDto.getId())
                .switchIfEmpty(Mono.error(new Exception()))
                .flatMap(x -> accountService.deleteById(accountDto.getId()));
    }

    public Flux<AccountDto> findAll() {
        return accountService.findAll()
                .map(x -> map(x, AccountDto.class));
    }

    public Mono<AccountDto> findById(String id) {
        return accountService.findById(id).map(x -> map(x, AccountDto.class));
    }

    public Mono<AccountDto> findByType(String type) {
        return accountService.findByType(type)
                .map(x -> map(x, AccountDto.class));
    }

}
