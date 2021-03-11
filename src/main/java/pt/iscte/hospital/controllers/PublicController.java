package pt.iscte.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pt.iscte.hospital.entities.User;
import pt.iscte.hospital.services.RegistrationService;
import pt.iscte.hospital.services.user.UserService;

@Controller
public class PublicController {
    @Autowired
    private UserService userService;
    @Autowired
    private RegistrationService registrationService;


    @GetMapping(value = "/public/contacts")
    public String ShowContacts(ModelMap modelMap) {
        User userLogged = userService.currentUser();

        modelMap.put("user_logged", userLogged);
        return "public/contacts";
    }

    @GetMapping(value = {"/public/main", "/", "/public"})
    public String showMainPage(ModelMap modelMap) {
        User user = userService.currentUser();
        String mainPage = userService.getUserMainPage(user);
        modelMap.put("user_logged", user);
        return mainPage;
    }

    @GetMapping(value = "/public/general-information")
    public String showGeneralInformation(ModelMap modelMap) {
        User userLogged = userService.currentUser();

        modelMap.put("user_logged", userLogged);
        return "public/general-information";
    }

    //login
    @GetMapping(value = "/public/login")
    public String showLoginPage() {

        return "public/login";
    }

    //recover password
    @GetMapping(value = "/public/recover-password")
    public String showRecoverPasswordPage(ModelMap modelMap) {
        modelMap.put("username", "");
        modelMap.put("email", "");

        return "public/recover-password";
    }

    @PostMapping(value = "/public/recover-password")
    public String recoverPassword(ModelMap modelMap,
                                  @RequestParam String username,
                                  @RequestParam String email,
                                  @RequestParam String password1,
                                  @RequestParam String password2) {
        if (userService.validateUserMail(username, email)) {
            if (password1.equals(password2)) {
                User user = userService.findUser(username);
                registrationService.changeEncryptPassword(user, password1);
                userService.addUser(user);
                return "redirect:/public/login";
            } else {
                modelMap.put("errorMessage", "Palavras-passe não coincidem");
            }
        } else {
            modelMap.put("errorMessage", "Username/Email inválido");
        }
        modelMap.put("username", username);
        modelMap.put("email", email);
        return "public/recover-password";
    }

}
