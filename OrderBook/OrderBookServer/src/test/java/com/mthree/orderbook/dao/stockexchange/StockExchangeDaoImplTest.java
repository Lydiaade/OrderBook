package com.mthree.orderbook.dao.stockexchange;

import com.mthree.orderbook.entity.Stock;
import com.mthree.orderbook.entity.StockExchange;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class StockExchangeDaoImplTest {

    @Autowired
    JdbcTemplate jdbc;

    @Autowired
    StockExchangeDao stockExchangeDao;

    @BeforeEach
    public void setUp() throws Exception {
        final String DELETE_TRADES = "DELETE FROM trade";
        jdbc.update(DELETE_TRADES);

        final String DELETE_ORDER_HISTORY = "DELETE FROM orderHistory";
        jdbc.update(DELETE_ORDER_HISTORY);

        final String DELETE_ORDERS = "DELETE FROM `order`";
        jdbc.update(DELETE_ORDERS);

        final String DELETE_PARTIES = "DELETE FROM party";
        jdbc.update(DELETE_PARTIES);

        final String DELETE_STOCKS = "DELETE FROM stock";
        jdbc.update(DELETE_STOCKS);

        final String DELETE_STOCK_EXCHANGES = "DELETE FROM stockExchange";
        jdbc.update(DELETE_STOCK_EXCHANGES);
    }

    @Test
    public void testAddGet() {
        StockExchange stockExchange = new StockExchange();
        stockExchange.setName("TEST");
        stockExchange.setCentralCounterParty("TESTING");
        stockExchangeDao.addStockExchange(stockExchange);

        assertEquals(stockExchange, stockExchangeDao.getStockExchangeById(stockExchange.getId()));
    }

    @Test
    public void testAddGetAll() {
        StockExchange stockExchange = new StockExchange();
        stockExchange.setName("TEST");
        stockExchange.setCentralCounterParty("TESTING");
        stockExchangeDao.addStockExchange(stockExchange);

        StockExchange stockExchange2 = new StockExchange();
        stockExchange2.setName("TEST 2");
        stockExchange2.setCentralCounterParty("TESTING");
        stockExchangeDao.addStockExchange(stockExchange2);

        List<StockExchange> stockExchanges = stockExchangeDao.getAll();

        assertEquals(stockExchanges.get(0), stockExchange);
        assertEquals(stockExchanges.get(1), stockExchange2);
    }

    @Test
    public void testGetAllEmpty() {
        List<StockExchange> stockExchanges = new ArrayList<>();

        assertEquals(stockExchanges, stockExchangeDao.getAll());
    }
}