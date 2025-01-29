package com.tabet.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(
        name="Customer",
        description = "Schema to hold Customer and Account information"
)
@Data
public class CustomerDto {
    @Schema(description="Name of the customer", example="TABET Alaaddine")
    @NotEmpty(message="Name can not be a null or empty")
    @Size(min=5, max=30, message="The length of the customer name should be between 5 and 30")
    private String name;

    @Schema(description="Email address of the customer", example="alaa@gmail.com")
    @NotEmpty(message="Email address can not be a null or empty")
    private String email;

    @Schema(description="Mobile Number of the customer", example="9345432123")
    @Pattern(regexp="(^$|[0-9](10))", message= "Mobile number must be 10 digits")
    private String mobileNumber;

    @Schema(
            description = "Account details of the Customer"
    )
    private AccountsDto accountsDto;
}



















