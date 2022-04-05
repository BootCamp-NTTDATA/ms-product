package com.bootcamp.msproduct.resource;

import com.bootcamp.msproduct.dto.WalletDto;
import com.bootcamp.msproduct.entity.Wallet;
import com.bootcamp.msproduct.service.WalletServiceImpl;
import com.bootcamp.msproduct.util.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class WalletResource extends MapperUtil {

    @Autowired
    private WalletServiceImpl walletService;

    public Mono<WalletDto> create(WalletDto walletDto){
        Wallet wallet = map(walletDto, Wallet.class);
        return  walletService.save(wallet)
                .map(x -> map(x, WalletDto.class));
    }

    public Mono<WalletDto> update(WalletDto walletDto) {
        Wallet wallet = map(walletDto, Wallet.class);
        return walletService.findById(walletDto.getId())
                .switchIfEmpty(Mono.error(new Exception()))
                        .flatMap(x -> walletService.save(wallet).map(y -> map(y, WalletDto.class)));
    }

    public Mono<Void> delete(WalletDto walletDto) {
        return walletService.findById(walletDto.getId())
                .switchIfEmpty(Mono.error(new Exception()))
                .flatMap(x -> walletService.deleteById(walletDto.getId()));
    }

    public Flux<WalletDto> findAll() {
        return walletService.findAll()
                .map(x -> map(x, WalletDto.class));
    }

    public Mono<WalletDto> findById(String id) {
        return walletService.findById(id).map(x -> map(x, WalletDto.class));
    }
}
