package com.developerprince.yuppie.chef.review.service.utilites;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class IDGenerator {

    public String uuidGenerate(int length){
        UUID uuid = UUID.randomUUID();
        return Long.toString(uuid.getMostSignificantBits(), length) + '-' + Long.toString(uuid.getLeastSignificantBits(), length);
    }


}
