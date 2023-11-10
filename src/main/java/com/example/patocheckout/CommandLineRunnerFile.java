package com.example.patocheckout;

import com.example.patocheckout.entities.ItemSell;
import com.example.patocheckout.service.impl.ItemSellServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class CommandLineRunnerFile implements CommandLineRunner {
    private final ItemSellServiceImpl itemSellService;
    private static final Logger logger = LoggerFactory.getLogger(CommandLineRunnerFile.class);

    @Autowired
    public CommandLineRunnerFile(ItemSellServiceImpl itemSellService) { this.itemSellService = itemSellService; }

    @Override
    public void run(String... args) throws Exception {

    }
}
