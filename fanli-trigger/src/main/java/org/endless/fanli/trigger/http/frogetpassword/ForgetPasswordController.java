package org.endless.fanli.trigger.http.frogetpassword;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ForgetPasswordController
 * <p>create 2022/11/17 16:56
 * <p>update 2023/12/30 22:35
 *
 * @author Deng Haozhi
 * @since 0.0.6
 */
@RestController
@RequestMapping("/user/forgetpassword")
public class ForgetPasswordController {

    @GetMapping
    @PostMapping
    public String forgetPassword() {
        return "forgetpassword";
    }

}
