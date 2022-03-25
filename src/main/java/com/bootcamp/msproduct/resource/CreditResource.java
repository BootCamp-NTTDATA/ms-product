package com.bootcamp.msproduct.resource;

import com.bootcamp.msproduct.dto.CreditDto;
import com.bootcamp.msproduct.entity.Credit;
import com.bootcamp.msproduct.service.ICreditService;
import com.bootcamp.msproduct.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class CreditResource extends MapperUtil {
    @Autowired
    ICreditService iCreditService;

    public Mono<CreditDto> create(CreditDto creditDto){
        Credit credit = map(creditDto, Credit.class);
        credit.setCreatedAt(LocalDateTime.now());
        Mono<Credit> entity = iCreditService.save(credit);
        return entity.map(x->map(x, CreditDto.class));
    }

    public Flux<CreditDto> findAll(){
        return iCreditService.findAll().map(x->map(x, CreditDto.class));
    }

    public Mono<CreditDto> update(CreditDto creditDto){
        Credit credit = map(creditDto, Credit.class);
        return iCreditService.findById(creditDto.getId())
                .switchIfEmpty(Mono.error(new Exception()))
                .flatMap(p-> iCreditService.save(credit).map(y->map(y, CreditDto.class)));
    }

    public Mono<CreditDto> findById(String id){
        return iCreditService.findById(id)
                .switchIfEmpty(Mono.error(new Exception()))
                .map(x->map(x, CreditDto.class));
    }

    public Mono<Void> delete(CreditDto creditDto){
        return iCreditService.findById(creditDto.getId())
                .switchIfEmpty(Mono.error(new Exception()))
                .flatMap(x-> iCreditService.deleteById(creditDto.getId()));
    }
}
