package com.project.porsche.controller;

import com.project.porsche.entity.Deal;
import com.project.porsche.service.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private DealService dealService;

    @GetMapping("/list")
    public String listDeals(Model model){
        List<Deal> deals = dealService.getDeals();
        model.addAttribute("deals", deals);
        return "manager-list";
    }

    @GetMapping ("/updateForm")
    public String updateCourse(@RequestParam ("dealId") Long dealId, Model model){
        Deal deal = dealService.getDeal(dealId);
        model.addAttribute(deal);
        return "manager-form";
    }

    @PostMapping("/saveDeal")
    public String saveDeal(@ModelAttribute("deal") Deal deal, @RequestParam("dealId") Long dealId){
        Deal dealChanged = dealService.getDeal(dealId);
        dealChanged.setStatus(deal.getStatus());
        dealService.saveDeal(dealChanged);
        return "redirect:/manager/list";
    }
}
