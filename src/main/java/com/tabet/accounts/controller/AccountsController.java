package com.tabet.accounts.controller;

import com.tabet.accounts.constants.AccountsConstants;
import com.tabet.accounts.dto.CustomerDto;
import com.tabet.accounts.dto.ErrorResponseDto;
import com.tabet.accounts.dto.ResponseDto;
import com.tabet.accounts.service.IAccountsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(
        name="CRUD REST APIs for Accounts",
        description="CRUD REST APIs to CREATE,UPDATE,FETCH AND DELETE accounts details"
)
@RestController
@RequestMapping(path="api", produces=(MediaType.APPLICATION_JSON_VALUE))
@Validated
@AllArgsConstructor
public class AccountsController {


    public IAccountsService iAccountsService;

    @Operation(
            summary = "CREATE ACCOUNT REST API",
            description = "REST API to create new Customer & Account "
    )
    @ApiResponse(
            responseCode="201",
            description="HTTP Status CREATED"
    )
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@Valid @RequestBody CustomerDto customerDto){
        iAccountsService.createAccount(customerDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto("201","test"));
    }


    @Operation(
            summary = "Fetch ACCOUNT REST API",
            description = "REST API to fetch  Customer & Account details based on a mobile number"
    )
    @ApiResponse(
            responseCode="200",
            description="HTTP Status OK"
    )
    @GetMapping("/fetch")
    public ResponseEntity<CustomerDto> fetchAccountDetails(@RequestParam
                                                               @Pattern(regexp="(^$|[0-9](10))", message="Mobile number must be 10 digits")
                                                               String mobileNumber){
        CustomerDto customerDto = iAccountsService.fetchAccount(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(customerDto);

    }

    @Operation(
            summary = "UPDATE ACCOUNT Details REST API",
            description = "REST API to update Customer & Account details based on a account number"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode="200",
                    description="HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode="500",
                    description="HTTP Status Internal Server Error",
                    content=@Content(
                            schema=@Schema(implementation= ErrorResponseDto.class)
                    )
            )
    })
    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateAccountDetails(@Valid @RequestBody CustomerDto customerDto){
        boolean isUpdated = iAccountsService.updateAccount(customerDto);
        if(isUpdated){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200
                    ));
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto(AccountsConstants.STATUS_500, AccountsConstants.STATUS_500));
        }
    }


    @Operation(
            summary = "Delete ACCOUNT & Customer Details REST API",
            description = "REST API to delete Customer & Account details based on a account number"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode="200",
                    description="HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode="500",
                    description="HTTP Status Internal Server error"
            )
    })
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteAccountDetails(@RequestParam
                                                            @Pattern(regexp="(^$|[0-9](10))", message= "Mobile Number  must be 10 digits")
                                                            String mobileNumber){
        boolean isDeleted = iAccountsService.deleteAccount(mobileNumber);
        if(isDeleted){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto(AccountsConstants.STATUS_500, AccountsConstants.MESSAGE_500));
        }
    }
}





























