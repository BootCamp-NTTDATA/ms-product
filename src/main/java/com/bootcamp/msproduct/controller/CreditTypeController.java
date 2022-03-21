package com.bootcamp.msproduct.controller;

import com.bootcamp.msproduct.dto.CreditTypeDto;
import com.bootcamp.msproduct.entity.Response;
import com.bootcamp.msproduct.resource.CreditTypeResource;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Slf4j
@RestController
@RequestMapping("/api/credit-type")
public class CreditTypeController {

    private static final String RESILIENCE4J_INSTANCE_NAME = "example";
    private static final String FALLBACK_METHOD = "fallback";

    @Autowired
    private CreditTypeResource creditTypeResource;

    @PostMapping
    public Mono<CreditTypeDto> create(@RequestBody CreditTypeDto creditTypeDto){
        return creditTypeResource.create(creditTypeDto);
    }

    @PutMapping
    public Mono<CreditTypeDto> update(@RequestBody CreditTypeDto creditTypeDto){
        return creditTypeResource.update(creditTypeDto);
    }

    @GetMapping
    public Flux<CreditTypeDto> findAll(){
        return creditTypeResource.findAll();
    }

    @DeleteMapping
    public Mono<Void> delete(@RequestBody CreditTypeDto creditTypeDto){
        return creditTypeResource.delete(creditTypeDto);
    }

    /*
     *  PRUUEBA DE USO DEL CIRCUITBRACKER
     */
    @GetMapping(
            value = "/timeout/{timeout}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @CircuitBreaker(name = RESILIENCE4J_INSTANCE_NAME, fallbackMethod = FALLBACK_METHOD)
    @TimeLimiter(name = RESILIENCE4J_INSTANCE_NAME, fallbackMethod = FALLBACK_METHOD)
    public Mono<Response<Boolean>> timeout(@PathVariable int timeout) {
        return Mono.just(toOkResponse())
                .delayElement(Duration.ofSeconds(timeout));
    }

    @GetMapping(
            value = "/delay/{delay}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @CircuitBreaker(name = RESILIENCE4J_INSTANCE_NAME, fallbackMethod = FALLBACK_METHOD)
    public Mono<Response<Boolean>> delay(@PathVariable int delay) {
        return Mono.just(toOkResponse())
                .delayElement(Duration.ofSeconds(delay));
    }

    @GetMapping(
            value = "/error/{valid}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @CircuitBreaker(name = RESILIENCE4J_INSTANCE_NAME, fallbackMethod = FALLBACK_METHOD)
    public Mono<Response<Boolean>> error(@PathVariable boolean valid) {
        return Mono.just(valid)
                .flatMap(this::toOkResponse);
    }

    public Mono<Response<Boolean>> fallback(Exception ex) {
        return Mono.just(toResponse(HttpStatus.INTERNAL_SERVER_ERROR, Boolean.FALSE))
                .doOnNext(result -> log.warn("fallback executed"));
    }

    private Mono<Response<Boolean>> toOkResponse(boolean valid) {
        if (!valid) {
            return Mono.just(toOkResponse());
        }
        return Mono.error(new RuntimeException("error"));
    }

    private Response<Boolean> toOkResponse() {
        return toResponse(HttpStatus.OK, Boolean.TRUE);
    }

    private Response<Boolean> toResponse(HttpStatus httpStatus, Boolean result) {
        return Response.<Boolean>builder()
                .code(httpStatus.value())
                .status(httpStatus.getReasonPhrase())
                .data(result)
                .build();
    }

}
