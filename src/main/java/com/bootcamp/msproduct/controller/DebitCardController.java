package com.bootcamp.msproduct.controller;

import com.bootcamp.msproduct.dto.DebitCardDto;
import com.bootcamp.msproduct.resource.DebitCardResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/api/product/debit-card")
public class DebitCardController {

    @Autowired
    private DebitCardResource debitCardResource;

    @PostMapping
    public Mono<DebitCardDto> create(@RequestBody DebitCardDto debitCardDto) {
        return debitCardResource.create(debitCardDto);
    }

    @PutMapping
    public Mono<DebitCardDto> update(@RequestBody DebitCardDto debitCardDto) {
        return debitCardResource.update(debitCardDto);
    }

    @DeleteMapping
    public Mono<Void> delete(@RequestBody DebitCardDto debitCardDto) {
        return debitCardResource.delete(debitCardDto);
    }

    @GetMapping
    public Flux<DebitCardDto> findAll() {
        return debitCardResource.findAll();
    }

    @GetMapping("/{id}")
    public Mono<DebitCardDto> findById(@PathVariable String id) {
        return debitCardResource.findById(id);
    }
}
