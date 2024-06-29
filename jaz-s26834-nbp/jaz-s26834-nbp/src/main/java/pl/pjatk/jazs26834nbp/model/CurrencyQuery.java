package pl.pjatk.jazs26834nbp.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalTime;
@Entity
@Schema(description = "Informacja na temat waluty")
public class CurrencyQuery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unikalny numeer ID waluty")

    private Long id;

    @Schema(description = "Symbol waluty")
    private CurrencyType currency;

    @Schema(description = "Liczba_dni")
    private LocalDate startDate;

    @Schema(description = "Aktualny Kurs")
    private LocalDate endDate;

    @Schema(description = "Średnia cena")
    private double calculatedRate;

    @Schema(description = "Data")
    private LocalDate queryDate;

    @Schema(description = "Godzina")
    private LocalTime queryTime;

    public CurrencyQuery() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CurrencyType getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyType currency) {
        this.currency = currency;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public double getCalculatedRate() {
        return calculatedRate;
    }

    public void setCalculatedRate(double calculatedRate) {
        this.calculatedRate = calculatedRate;
    }

    public LocalDate getQueryDate() {
        return queryDate;
    }

    public void setQueryDate(LocalDate queryDate) {
        this.queryDate = queryDate;
    }

    public LocalTime getQueryTime() {
        return queryTime;
    }

    public void setQueryTime(LocalTime queryTime) {
        this.queryTime = queryTime;
    }
}

