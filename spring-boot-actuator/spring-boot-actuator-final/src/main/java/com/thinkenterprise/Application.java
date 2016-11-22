/*
 * Copyright (C) 2016 Thinkenterprise
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 * @author Rafael Kansy
 * @author Michael Schaefer
 */

package com.thinkenterprise;


import com.thinkenterprise.service.RouteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.audit.AuditEvent;
import org.springframework.boot.actuate.audit.AuditEventRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Application {
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    private static ConfigurableApplicationContext context;
    private static AuditEventRepository auditEventRepository;

    public static void main(String[] args) {
        context = SpringApplication.run(Application.class, args);
        auditEventRepository = context.getBean(AuditEventRepository.class);
    }

    @Scheduled(initialDelay = 1000, fixedDelay = 10000)
    public void changeStatus() {
        RouteService service = context.getBean(RouteService.class);
        if (service != null) {
            service.setServiceStatus(!service.getServiceStatus());
        }

        if (auditEventRepository != null && service != null) {
            AuditEvent event = new AuditEvent("unknown", "RouteServiceStatusChanged", String.valueOf(service.getServiceStatus()));
            auditEventRepository.add(event);
        }
    }

    @Scheduled(initialDelay = 1000, fixedDelay = 5000)
    public void showLastEvents() {
        if (auditEventRepository != null) {
            List<AuditEvent> auditEvents = auditEventRepository.find(Date.from(Instant.now().minusSeconds(5)));
            auditEvents.forEach(auditEvent -> LOGGER.info(auditEvent.toString()));
        }
    }
}
