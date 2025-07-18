package org.endless.fanli.ui.http.signup;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SignUpController
 *
 * @author Deng Haozhi
 * @date 2022/11/17 17:09
 * @since 0.0.2
 */
@RestController
@RequestMapping("/user/signup1")
public class SignUpController {

    @GetMapping
    @PostMapping
    public String signUp() {
        return "signup";
    }
}
