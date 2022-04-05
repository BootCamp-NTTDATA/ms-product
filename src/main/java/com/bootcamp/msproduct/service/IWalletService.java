package com.bootcamp.msproduct.service;

import com.bootcamp.msproduct.entity.Wallet;
import com.bootcamp.msproduct.util.ICrud;
import reactor.core.publisher.Mono;

public interface IWalletService extends ICrud<Wallet, String> {
}
