package com.bootcamp.msproduct.resource;

import com.bootcamp.msproduct.dto.VirtualCoinDto;
import com.bootcamp.msproduct.entity.VirtualCoin;
import com.bootcamp.msproduct.service.VirtualCoinServiceImpl;
import com.bootcamp.msproduct.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class VirtualCoinResource extends MapperUtil {

    @Autowired
    private VirtualCoinServiceImpl virtualCoinService;

    public Mono<VirtualCoinDto> create(VirtualCoinDto debitCardDto) {
        VirtualCoin virtualCoin = map(debitCardDto, VirtualCoin.class);
        return virtualCoinService.save(virtualCoin)
                .map(x -> map(x, VirtualCoinDto.class));
    }

    public Mono<VirtualCoinDto> update(VirtualCoinDto virtualCoinDto) {
        VirtualCoin virtualCoin = map(virtualCoinDto, VirtualCoin.class);
        return virtualCoinService.findById(virtualCoinDto.getId())
                .switchIfEmpty(Mono.error(new Exception()))
                .flatMap(x -> virtualCoinService.save(virtualCoin).map(y -> map(y, VirtualCoinDto.class)));
    }

    public Mono<Void> delete(VirtualCoinDto virtualCoinDto) {
        return virtualCoinService.findById(virtualCoinDto.getId())
                .switchIfEmpty(Mono.error(new Exception()))
                .flatMap(x -> virtualCoinService.deleteById(virtualCoinDto.getId()));
    }

    public Flux<VirtualCoinDto> findAll() {
        return virtualCoinService.findAll()
                .map(x -> map(x, VirtualCoinDto.class));
    }

    public Mono<VirtualCoinDto> findById(String id) {
        return virtualCoinService.findById(id).map(x -> map(x, VirtualCoinDto.class));
    }
}
