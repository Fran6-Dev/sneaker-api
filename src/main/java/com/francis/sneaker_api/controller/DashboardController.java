package com.francis.sneaker_api.controller;

import com.francis.sneaker_api.dto.DashboardResponse;
import com.francis.sneaker_api.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dashboard")
@RequiredArgsConstructor
public class DashboardController {

    private final DashboardService dashboardService;

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public DashboardResponse getDashboard() {
        return dashboardService.getDashboard();
    }
}
