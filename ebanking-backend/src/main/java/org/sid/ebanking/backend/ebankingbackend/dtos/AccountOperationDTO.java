package org.sid.ebanking.backend.ebankingbackend.dtos;

import lombok.Data;
import org.sid.ebanking.backend.ebankingbackend.enums.OperationType;

import java.util.Date;

@Data
public class AccountOperationDTO {
    private Long id;
    private Date operationDate;
    private double amount;
    private OperationType type;
    private String description;
}