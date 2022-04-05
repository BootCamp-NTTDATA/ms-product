package com.bootcamp.msproduct.resource;

import com.bootcamp.msproduct.dto.DebitCardDto;
import com.bootcamp.msproduct.entity.DebitCard;
import com.bootcamp.msproduct.service.DebitCardServiceImpl;
import com.bootcamp.msproduct.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DebitCardResource extends MapperUtil {

    @Autowired
    private DebitCardServiceImpl debitCardService;

    public Mono<DebitCardDto> create(DebitCardDto debitCardDto) {
        DebitCard debitCard = map(debitCardDto, DebitCard.class);
        return debitCardService.save(debitCard)
                .map(x -> map(x, DebitCardDto.class));
    }

    public Mono<DebitCardDto> update(DebitCardDto debitCardDto) {
        DebitCard creditCard = map(debitCardDto, DebitCard.class);
        return debitCardService.findById(debitCardDto.getId())
                .switchIfEmpty(Mono.error(new Exception()))
                .flatMap(x -> debitCardService.save(creditCard).map(y -> map(y, DebitCardDto.class)));
    }

    public Mono<Void> delete(DebitCardDto debitCardDto) {
        return debitCardService.findById(debitCardDto.getId())
                .switchIfEmpty(Mono.error(new Exception()))
                .flatMap(x -> debitCardService.deleteById(debitCardDto.getId()));
    }

    public Flux<DebitCardDto> findAll() {
        return debitCardService.findAll()
                .map(x -> map(x, DebitCardDto.class));
    }

    public Mono<DebitCardDto> findById(String id) {
        return debitCardService.findById(id).map(x -> map(x, DebitCardDto.class));
    }
}
