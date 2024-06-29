package pl.pjatk.jazs26834nbp.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.pjatk.jazs26834nbp.JazS26834NbpResponse;
import pl.pjatk.jazs26834nbp.Rate;
import pl.pjatk.jazs26834nbp.model.CurrencyQuery;
import pl.pjatk.jazs26834nbp.model.CurrencyType;
import pl.pjatk.jazs26834nbp.repository.CurrencyQueryRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class CurrencyService {
    private final CurrencyQueryRepository currencyQueryRepository;
    private final RestTemplate restTemplate;


    public CurrencyService(CurrencyQueryRepository currencyQueryRepository, RestTemplate restTemplate) {
        this.currencyQueryRepository = currencyQueryRepository;
        this.restTemplate = restTemplate;
    }

    public double calculateAverageExchangeRate(CurrencyType currency, LocalDate startDate, LocalDate endDate) {

        String apiUrl = "http://api.nbp.pl/api/exchangerates/rates/a/{currency}/{startDate}/{endDate}/?format=json";
        String url = apiUrl.replace("{currency}", currency.name())
                .replace("{startDate}", startDate.toString())
                .replace("{endDate}", endDate.toString());
        JazS26834NbpResponse jazS26834NbpResponse = restTemplate.getForObject(url, JazS26834NbpResponse.class);

        List<Rate> rates = jazS26834NbpResponse.getRates();
        double sum = rates.stream().mapToDouble(Rate::getMid).sum();
        double averageRate = sum / rates.size();

        CurrencyQuery currencyQuery = new CurrencyQuery();
        currencyQuery.setCurrency(currency);
        currencyQuery.setStartDate(startDate);
        currencyQuery.setEndDate(endDate);
        currencyQuery.setCalculatedRate(averageRate);
        currencyQuery.setQueryDate(LocalDate.now());
        currencyQuery.setQueryTime(LocalTime.now());

        currencyQueryRepository.save(currencyQuery);

        return averageRate;
    }
}