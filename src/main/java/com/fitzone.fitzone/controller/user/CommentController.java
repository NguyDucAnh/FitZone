package com.fitzone.fitzone.controller.user;

import com.fitzone.fitzone.entity.CommentEntity;
import com.fitzone.fitzone.service.CommentService;
import com.fitzone.fitzone.utils.GetUserAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private GetUserAuthentication getUserAuthentication;

    @PostMapping("/user/comment/{productId}")
    public String comment(@ModelAttribute("newComment") CommentEntity newComment,
                          @PathVariable Long productId){

        newComment.setUser(getUserAuthentication.getUser());
        commentService.AddComment(newComment, productId);
        
        return "redirect:/home/product/{productId}";
    }
}
