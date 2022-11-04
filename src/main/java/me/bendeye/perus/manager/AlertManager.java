package me.bendeye.perus.manager;

import me.bendeye.perus.check.Check;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class AlertManager {
    private final ExecutorService executorService = Executors.newFixedThreadPool(4);
    public void flagAlert(Check check) {
        executorService.submit(() -> {
            check.setViolations(check.getViolations() + 1);


        });
    }
}