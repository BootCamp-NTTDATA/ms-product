package com.bootcamp.msproduct.resource;

import com.bootcamp.msproduct.dto.CreditTypeDto;
import com.bootcamp.msproduct.entity.CreditType;
import com.bootcamp.msproduct.service.ICreditTypeService;
import com.bootcamp.msproduct.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class CreditTypeResource extends MapperUtil {
    @Autowired
    ICreditTypeService iCreditTypeService;

    public Mono<CreditTypeDto> create(CreditTypeDto creditTypeDto){
        CreditType creditType = map(creditTypeDto,CreditType.class);
        creditType.setCreatedAt(LocalDateTime.now());
        Mono<CreditType> entity = iCreditTypeService.save(creditType);
        return entity.map(x->map(x,CreditTypeDto.class));
    }

    public Flux<CreditTypeDto> findAll(){
        return iCreditTypeService.findAll().map(x->map(x,CreditTypeDto.class));
    }

    public Mono<CreditTypeDto> update(CreditTypeDto creditTypeDto){
        CreditType creditType = map(creditTypeDto, CreditType.class);
        return iCreditTypeService.findById(creditTypeDto.getId())
                .switchIfEmpty(Mono.error(new Exception()))
                .flatMap(p->iCreditTypeService.save(creditType).map(y->map(y,CreditTypeDto.class)));
    }

    public Mono<CreditTypeDto> findById(String id){
        return iCreditTypeService.findById(id)
                .switchIfEmpty(Mono.error(new Exception()))
                .map(x->map(x,CreditTypeDto.class));
    }

    public Mono<Void> delete(CreditTypeDto creditTypeDto){
        return iCreditTypeService.findById(creditTypeDto.getId())
                .switchIfEmpty(Mono.error(new Exception()))
                .flatMap(x->iCreditTypeService.deleteById(creditTypeDto.getId()));
    }
}
