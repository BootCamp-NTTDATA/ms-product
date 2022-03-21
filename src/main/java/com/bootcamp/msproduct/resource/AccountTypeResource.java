package com.bootcamp.msproduct.resource;

import com.bootcamp.msproduct.dto.AccountTypeDto;
import com.bootcamp.msproduct.entity.AccountType;
import com.bootcamp.msproduct.service.IAccountTypeService;
import com.bootcamp.msproduct.util.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class AccountTypeResource extends MapperUtil {
    @Autowired
    private IAccountTypeService iAccountTypeService;

    public Mono<AccountTypeDto> create(AccountTypeDto accountTypeDto) {
        log.debug("Create method beggining...");
        AccountType personalAccount = map(accountTypeDto, AccountType.class);
        return iAccountTypeService.save(personalAccount)
                .map(x -> map(x, AccountTypeDto.class));
    }

    public Mono<AccountTypeDto> update(AccountTypeDto accountTypeDto) {
        AccountType accountType = map(accountTypeDto, AccountType.class);
        return iAccountTypeService.findById(accountTypeDto.getId())
                .switchIfEmpty(Mono.error(new Exception()))
                .flatMap(y -> iAccountTypeService.save(accountType).map(x -> map(x, AccountTypeDto.class)));
    }

    public Mono<Void> delete(AccountTypeDto accountTypeDto) {
        return iAccountTypeService.findById(accountTypeDto.getId())
                .switchIfEmpty(Mono.error(new Exception()))
                .flatMap(x -> iAccountTypeService.deleteById(accountTypeDto.getId()));
    }

    public Flux<AccountTypeDto> findAll() {

        return iAccountTypeService.findAll()
                .map(x -> map(x, AccountTypeDto.class));
    }

    public Mono<AccountTypeDto> findById(String id) {
        return iAccountTypeService.findById(id).map(x -> map(x, AccountTypeDto.class));
    }

    public Mono<AccountTypeDto> findByName(String name) {

        return iAccountTypeService.findByName(name)
                .map(x -> map(x, AccountTypeDto.class));
    }

}
