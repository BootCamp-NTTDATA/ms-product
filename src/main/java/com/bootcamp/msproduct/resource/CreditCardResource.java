package com.bootcamp.msproduct.resource;

import com.bootcamp.msproduct.dto.CreditCardDto;
import com.bootcamp.msproduct.entity.CreditCard;
import com.bootcamp.msproduct.service.ICreditCardService;
import com.bootcamp.msproduct.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CreditCardResource extends MapperUtil {
    @Autowired
    private ICreditCardService creditCardService;

    public Mono<CreditCardDto> create(CreditCardDto creditCardDto) {
        CreditCard creditCard = map(creditCardDto, CreditCard.class);
        return creditCardService.save(creditCard)
                .map(x -> map(x, CreditCardDto.class));
    }

    public Mono<CreditCardDto> update(CreditCardDto creditCardDto) {
        CreditCard creditCard = map(creditCardDto, CreditCard.class);
        return creditCardService.findById(creditCardDto.getId())
                .switchIfEmpty(Mono.error(new Exception()))
                .flatMap(x ->creditCardService.save(creditCard).map(y -> map(y, CreditCardDto.class)));
    }

    public Mono<Void> delete(CreditCardDto creditCardDto) {
        return creditCardService.findById(creditCardDto.getId())
                .switchIfEmpty(Mono.error(new Exception()))
                .flatMap(x -> creditCardService.deleteById(creditCardDto.getId()));
    }

    public Flux<CreditCardDto> findAll() {
        return creditCardService.findAll()
                .map(x -> map(x, CreditCardDto.class));
    }

    public Mono<CreditCardDto> findById(String id) {
        return creditCardService.findById(id).map(x -> map(x, CreditCardDto.class));
    }

    public Mono<CreditCardDto> findByName(String name) {
        return creditCardService.findByName(name).map(x -> map(x, CreditCardDto.class));
    }

    public Flux<CreditCardDto> findByClientType(String clientType) {
        return creditCardService.findByClientType(clientType).map(x -> map(x, CreditCardDto.class));
    }
}
