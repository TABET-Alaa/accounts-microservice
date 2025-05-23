package com.tabet.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Schema(
        name="Accounts",
        description = "Schema to hold  Account information"
)
@Data
public class AccountsDto {

    @Schema(description = "Account Number of alaa Account",example="33223323")
    @NotEmpty(message="AccountNumber can not be a null or empty")
    @Pattern(regexp="(^$|[0-9](10))", message= "AccountNumber must be 10 digits")
    private Long accountNumber;

    @Schema(description = "Account type of alaa Account", example="Savings")
    @NotEmpty(message="AccountType can not be a null or empty")
    private String accountType;

    @Schema(description = "The branch Address", example="123 CASABLANCA   ")
    @NotEmpty(message="BranchAddress can not be a null or empty")
    private String branchAddress;

}















