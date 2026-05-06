package com.fitzone.fitzone.controller.user;

import com.fitzone.fitzone.dto.request.AddressRequest;
import com.fitzone.fitzone.dto.request.CreateUserRequest;
import com.fitzone.fitzone.dto.request.UpdateUserRequest;
import com.fitzone.fitzone.entity.UserEntity;
import com.fitzone.fitzone.enums.GenderEnum;
import com.fitzone.fitzone.service.UserService;
import com.fitzone.fitzone.utils.GetUserAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class AccountController {   
    @Autowired
    private GetUserAuthentication getUserAuthentication;

    @Autowired
    private UserService userService;

    @GetMapping("/info")
    public ModelAndView viewUser(){
        ModelAndView mav =  new ModelAndView("/user/information")
                .addObject("genders", GenderEnum.values())
                .addObject("updateUser", new CreateUserRequest())
                .addObject("newAddress", new AddressRequest());
        
        UserEntity user = getUserAuthentication.getUser();
        if(user != null){
            mav.addObject("user", user);
        }

        return mav;
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("updateUser") UpdateUserRequest request,
                             @RequestParam("file") MultipartFile file){
        
        UserEntity user = getUserAuthentication.getUser();

        userService.updateUser(request, user.getId(), file);

        return "redirect:/user/info";
    }

    @PostMapping("/add-address")
    public String updateUser(@ModelAttribute("newAddress") AddressRequest request){
        
        UserEntity user = getUserAuthentication.getUser();

        userService.addAddress(user.getId(), request);

        return "redirect:/user/info";
    }

    @GetMapping("/delete-address/{addressId}")
    public String deleteAddress(@PathVariable Long addressId){
        userService.deleteAddress(addressId);

        return "redirect:/user/info";
    }

}
