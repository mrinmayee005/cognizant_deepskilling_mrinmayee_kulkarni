package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.repository.StockRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private final StockRepository stockRepository;

    public OrmLearnApplication(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Override
    public void run(String... args) {
        testFacebookStocksInSeptember2019();
        testGoogleStockCloseGreaterThan1250();
        testTop3HighestVolume();
        testNetflixLowest3ClosePrices();
    }

    private void testFacebookStocksInSeptember2019() {
        LOGGER.info("Facebook stock details in September 2019");
        printStocks(stockRepository.findByCodeAndDateBetween(
                "FB",
                LocalDate.of(2019, 9, 1),
                LocalDate.of(2019, 9, 30)));
    }

    private void testGoogleStockCloseGreaterThan1250() {
        LOGGER.info("Google stock details where close price > 1250");
        printStocks(stockRepository.findByCodeAndCloseGreaterThan("GOOGL", new BigDecimal("1250")));
    }

    private void testTop3HighestVolume() {
        LOGGER.info("Top 3 dates with highest transaction volume");
        printStocks(stockRepository.findTop3ByOrderByVolumeDesc());
    }

    private void testNetflixLowest3ClosePrices() {
        LOGGER.info("Three dates when Netflix stock was lowest");
        printStocks(stockRepository.findTop3ByCodeOrderByCloseAsc("NFLX"));
    }

    private void printStocks(List<Stock> stocks) {
        stocks.forEach(stock -> LOGGER.debug("{}", stock));
    }
}

