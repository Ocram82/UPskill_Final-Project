package pt.iscte.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pt.iscte.hospital.entities.User;
import pt.iscte.hospital.exceptions.ImageSizeException;
import pt.iscte.hospital.exceptions.ImageTypeException;
import pt.iscte.hospital.services.ImageUploadService;
import pt.iscte.hospital.services.UserService;

import java.io.IOException;


@Controller
public class RegistrationController {
    // Attributes
    @Autowired
    UserService userService;

    @Autowired
    ImageUploadService imageUploadService;

    private static final String errorMsgName = "Nome inválido";
    private static final String errorMsgSex = "Escolha uma opção válida";
    private static final String errorMsgBirthday = "Data inválida";
    private static final String errorMsgAddress = "Endereço inválido";
    private static final String errorMsgPostCode = "Código postal inválido";
    private static final String errorMsgCity = "Nome de cidade inválida";
    private static final String errorMsgAccount = "Tipo de conta inválida";
    private static final String errorMsgNationality = "Escolha uma opção válida";
    private static final String errorMsgDocumentType = "Escolha uma opção válida";
    private static final String errorMsgDocumentNumber = "Número de documento inválido";
    private static final String errorMsgNif = "Número de NIF inválido";
    private static final String errorMsgPatientNumber = "Número de utente inválido";
    private static final String errorMsgPhone = "Número de telemóvel inválido";
    private static final String errorMsgEmail = "Este endereço já se encontra em utilização";
    private static final String errorMsgUsername = "Username já existe";
    private static final String errorMsgPassword = "Password inválida";
    private static final String errorMsgPassword2 = "Password não coincide";


    private static final String errorMsgPhotoUpload = "Erro ao fazer upload da imagem";
    private static final String errorMsgImageType = "Formato da imagem inválido. Usar jpg ou png.";
    private static final String errorMsgImageSize = "Tamanho máximo permitido para a foto é de %d MB"; // %d placehoder for an integer or long number


    // Methods
    @GetMapping(value = "/registration")
    public String showRegistrationPage(ModelMap modelMap) {
        modelMap.put("user", new User());

        return "registration";
    }

    @PostMapping(value = "/registrationToLogin")
    public String returnToLoginPage(@ModelAttribute User user,
                                    @RequestParam("file") MultipartFile file,
                                    ModelMap mpError) {

        // TODO verificar elementos do user


        if (file != null || !file.isEmpty()) {
            try {
                String photoURL = imageUploadService.uploadImage(file, user.getUsername());
                user.setPhotoURL(photoURL);
            } catch (IOException e) {
                mpError.put("errorMsgPhotoUpload", errorMsgPhotoUpload);
                return "registration-temp";
            } catch (ImageTypeException e) {
                mpError.put("errorMsgPhotoUpload", errorMsgImageType);
                return "registration";
            } catch (ImageSizeException e) {
                mpError.put("errorMsgPhotoUpload", String.format(errorMsgImageSize, imageUploadService.getImageMaxSize()));
                return "registration";
            }
        }

        // Add user to database
        userService.addUser(user);

        return "redirect:/login";
    }







    // Para testes apenas!
    @GetMapping(value = "/temp")
    public String showRegistrationPagetmp(ModelMap modelMap) {
        // TODO para testes
        modelMap.put("user", new User());

        return "registration-temp";
    }

    @PostMapping(value = "/temp")
    public String returnToLoginPagetmp(@RequestParam("file") MultipartFile file,
                                       ModelMap mpError) {

        try {
            // TODO dar nome de username
            imageUploadService.uploadImage(file, "user1");
        } catch (IOException e) {
            mpError.put("errorMsgPhotoUpload", errorMsgPhotoUpload);
            return "registration-temp";
        } catch (ImageTypeException e) {
            mpError.put("errorMsgPhotoUpload", errorMsgImageType);
            return "registration-temp";
        } catch (ImageSizeException e) {
            mpError.put("errorMsgPhotoUpload", String.format(errorMsgImageSize, imageUploadService.getImageMaxSize()));
            return "registration-temp";
        }

        return "redirect:/login";
    }

}
