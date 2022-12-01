package net.ict.kiosk.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.ict.kiosk.dto.FoodDTO;
import net.ict.kiosk.dto.RequestDTO;
import net.ict.kiosk.dto.ResponseDTO;
import net.ict.kiosk.service.FoodService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/food")
@Log4j2
@RequiredArgsConstructor
public class FoodController {

    private final FoodService foodService;

    @GetMapping("/register")
    public void registerGET(){

    }

    @PostMapping("/register")
    public String registerPost(@Valid FoodDTO foodDTO, BindingResult bindingResult,
                               RedirectAttributes redirectAttributes){

        log.info("food POST register........");

        if(bindingResult.hasErrors()){
            log.info("register has errors...........");
            redirectAttributes.addFlashAttribute("errors",bindingResult.getAllErrors());
            return "redirect:/food/register";
        }

        log.info(foodDTO);

        String foodName = foodService.register(foodDTO);
        redirectAttributes.addFlashAttribute("result",foodName);

        return "redirect:/food/list";

    }


    @GetMapping({"/read","/modify"})
    public void read(String foodName, RequestDTO requestDTO,Model model){

        FoodDTO foodDTO = foodService.readOne(foodName);
        log.info(foodDTO);
//        System.out.println(foodDTO.getPrice());
        model.addAttribute("dto",foodDTO);
    }

    @GetMapping("/list")
    public void list(RequestDTO requestDTO, Model model) {

        ResponseDTO<FoodDTO> responseDTO = foodService.list(requestDTO);
        log.info("////////////////////////////////");
        log.info(responseDTO);


        model.addAttribute("responseDTO",responseDTO);

    }

    @PostMapping("/modify")
    public String modify(RequestDTO requestDTO,
                         @Valid FoodDTO foodDTO,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes){

        log.info("food modify post.........." + foodDTO);

        if(bindingResult.hasErrors()){

            log.info("has errors............");

            String link = requestDTO.getLink();

            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addAttribute("foodName", foodDTO.getFoodName());

            return "redirect:/food/modify?"+link;
        }

        foodService.modify(foodDTO);

        redirectAttributes.addFlashAttribute("result","modified");
        redirectAttributes.addAttribute("foodName",foodDTO.getFoodName());

        return "redirect:/food/read";
    }

    @PostMapping("/remove")
    public String remove(String foodName, RedirectAttributes redirectAttributes){

        log.info("remove post...."+foodName);

        foodService.remove(foodName);
        redirectAttributes.addFlashAttribute("result","removed");

        return "redirect:/food/list";
    }


}
