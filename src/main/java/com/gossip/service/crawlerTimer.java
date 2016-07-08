/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gossip.service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;

/**
 *
 * @author gao
 */
public class crawlerTimer {
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    //private TaskScheduler scheduler = new ConcurrentTaskScheduler();
    
    @Scheduled(fixedRate=2*1000)
    public void run(){
        System.out.println("Run by timer");
    }
    
  
}
