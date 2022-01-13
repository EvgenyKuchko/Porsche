package com.project.porsche.controller;

import com.project.porsche.dto.DealRequestDto;
import com.project.porsche.service.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/deal")
public class DealController {

    @Autowired
    private DealService dealService;

    @GetMapping("/{model}")
    public String showForm(@PathVariable String model, Model mod) {
        mod.addAttribute("deal", new DealRequestDto());
        mod.addAttribute("model", model);
        return "form";
    }

    @PostMapping("/{model}")
    public String saveNewDeal(@PathVariable String model,
                              @Valid DealRequestDto deal,
                              BindingResult bindingResult,
                              Authentication authentication) {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        dealService.saveDeal(deal, model, (UserDetails) authentication.getPrincipal());
        return "redirect:/deal/success";
    }

    @GetMapping("/success")
    public String showDealPage() {
        return "deal";
    }
}