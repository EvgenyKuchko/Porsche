package com.project.porsche.controller;

import com.project.porsche.dto.DealDto;
import com.project.porsche.service.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/deals")
public class ManagerController {

    @Autowired
    private DealService dealService;

    @GetMapping()
    public String listDeals(Model model) {
        List<DealDto> deals = dealService.getDeals();
        model.addAttribute("deals", deals);
        return "manager-list";
    }

    @GetMapping("/{dealId}")
    public String getDealById(@PathVariable long dealId, Model model) {
        DealDto dealDto = dealService.getDeal(dealId);
        model.addAttribute("deal", dealDto);
        return "manager-form";
    }

    @PostMapping("/{dealId}")
    public String saveDeal(@ModelAttribute("deal") DealDto deal, @RequestParam("dealId") long dealId) {
        dealService.update(deal.getStatus(), dealId);
        return "redirect:/deals";
    }
}