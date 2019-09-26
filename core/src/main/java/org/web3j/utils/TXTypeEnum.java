package org.web3j.utils;

public enum TXTypeEnum {
    MPC(Long.valueOf(5)),WASM(Long.valueOf(2)),DEFAULT(null),CNS(Long.valueOf(17));
    public Long type;
    TXTypeEnum(Long type){
        this.type = type;
    }
}
