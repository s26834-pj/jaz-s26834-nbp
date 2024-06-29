package pl.pjatk.jazs26834nbp.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.pjatk.jazs26834nbp.model.CurrencyQuery;
import pl.pjatk.jazs26834nbp.model.CurrencyType;
import pl.pjatk.jazs26834nbp.service.CurrencyService;

import java.time.LocalDate;

@Tag(name = "Informator ", description = "do przekazywania biezacej informacji na temat waluty")
@RestController

public class CurrencyController {

    private final CurrencyService currencyService;


    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }


    @Operation(summary = "Średni kurs ", description = "Kurs z danego przedzialu czasowego")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Currency ok",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CurrencyQuery.class)) }),
            @ApiResponse(responseCode = "404", description = "Currency found",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content),
            @ApiResponse(responseCode = "502", description = "Currency service error",
                    content = @Content),
            @ApiResponse(responseCode = "504", description = "Gateway timeout",
                    content = @Content),
    })
    @GetMapping("/exchange-rate/{currency}")
    public ResponseEntity<Double> getAverageExchangeRate(
            @PathVariable("currency") CurrencyType currency,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        double averageRate = currencyService.calculateAverageExchangeRate(currency, startDate, endDate);
        return ResponseEntity.ok(averageRate);
    }
}