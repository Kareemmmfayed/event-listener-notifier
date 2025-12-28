package com.learning.sse.client;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientBalanceRequest {
    private Long id;
    private BigDecimal newBalance;
}
