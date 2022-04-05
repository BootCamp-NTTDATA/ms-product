package com.bootcamp.msproduct.controller;

import com.bootcamp.msproduct.dto.VirtualCoinDto;
import com.bootcamp.msproduct.resource.VirtualCoinResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/api/product/virtual-coin")
public class VirtualCoinController {

    @Autowired
    private VirtualCoinResource virtualCoinResource;

    @PostMapping
    public Mono<VirtualCoinDto> create(@RequestBody VirtualCoinDto virtualCoinDto) {
        return virtualCoinResource.create(virtualCoinDto);
    }

    @PutMapping
    public Mono<VirtualCoinDto> update(@RequestBody VirtualCoinDto virtualCoinDto) {
        return virtualCoinResource.update(virtualCoinDto);
    }

    @DeleteMapping
    public Mono<Void> delete(@RequestBody VirtualCoinDto virtualCoinDto) {
        return virtualCoinResource.delete(virtualCoinDto);
    }

    @GetMapping
    public Flux<VirtualCoinDto> findAll() {
        return virtualCoinResource.findAll();
    }

    @GetMapping("/{id}")
    public Mono<VirtualCoinDto> findById(@PathVariable String id) {
        return virtualCoinResource.findById(id);
    }
}
