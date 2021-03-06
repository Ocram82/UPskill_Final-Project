package pt.iscte.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pt.iscte.hospital.entities.Nationality;
import pt.iscte.hospital.entities.Patient;
import pt.iscte.hospital.entities.User;
import pt.iscte.hospital.exceptions.ImageSizeException;
import pt.iscte.hospital.exceptions.ImageTypeException;
import pt.iscte.hospital.services.ImageUploadService;
import pt.iscte.hospital.services.NationalityService;
import pt.iscte.hospital.services.RegistrationService;
import pt.iscte.hospital.services.UserService;

import java.io.IOException;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ImageUploadService imageUploadService;
    @Autowired
    private RegistrationService registrationService;
    @Autowired
    private NationalityService nationalityService;


    private static final String errorMsgName = "Nome inválido";
    private static final String errorMsgSex = "Escolha uma opção válida";
    private static final String errorMsgBirthday = "Data inválida";
    private static final String errorMsgAddress = "Endereço inválido";
    private static final String errorMsgPostCode = "Código postal inválido";
    private static final String errorMsgCity = "Nome de cidade inválida";
    private static final String errorMsgNationality = "Escolha uma opção válida";
    private static final String errorMsgDocumentType = "Escolha uma opção válida";
    private static final String errorMsgDocumentNumber2 = "Numero de documento já existe";
    private static final String errorMsgDocumentNumber = "Número de documento inválido";
    private static final String errorMsgNif = "NIF inválido";
    private static final String errorMsgNif2 = "NIF já existe";
    private static final String errorMsgPatientNumber2 = "Numero de utente já existe";
    private static final String errorMsgPatientNumber = "Número de utente inválido";
    private static final String errorMsgPhone = "Número de telemóvel inválido";

    private static final String errorMsgPhotoUpload = "Erro ao fazer upload da imagem";
    private static final String errorMsgImageType = "Formato da imagem inválido. Usar jpg ou png.";
    private static final String errorMsgImageSize = "Tamanho máximo permitido para a foto é de %d MB"; // %d placehoder for an integer or long number

    @GetMapping(value = "/user/change-profile-data")
    public String showChangeProfileData(ModelMap modelMap) {
        List<Nationality> nationalities = nationalityService.findAll();

        modelMap.put("nationalities", nationalities);
        modelMap.put("user_logged", userService.currentUser());
        modelMap.put("user", userService.currentUser());

        return "user/change-profile-data";
    }


    @PostMapping(value = "/user/change-profile-data")
    public String returnToUserPage(@ModelAttribute Patient user,
                                   ModelMap modelMap,
                                   @RequestParam("file") MultipartFile file) {

        // Update user info
        boolean isFormValid = true;
        User connectedUser = userService.currentUser();

        if (!registrationService.validName(user)) {
            modelMap.put("errorMsgName", errorMsgName);
            isFormValid = false;
        }
        if (!registrationService.validPhone(user)) {
            modelMap.put("errorMsgPhone", errorMsgPhone);
            isFormValid = false;
        }
        if (!registrationService.validPostCode(user)) {
            modelMap.put("errorMsgPostCode", errorMsgPostCode);
            isFormValid = false;
        }
        if (!registrationService.validSex(user)) {
            modelMap.put("errorMsgSex", errorMsgSex);
            isFormValid = false;
        }
        if (!registrationService.validDocumentType(user)) {
            modelMap.put("errorMsgDocumentType", errorMsgDocumentType);
            isFormValid = false;
        }
        if (!registrationService.validDocumentNumber(user)) {
            modelMap.put("errorMsgDocumentNumber", errorMsgDocumentNumber);
            isFormValid = false;
        }
        if (!user.getDocumentNumber().equals(connectedUser.getDocumentNumber())) {
            if (!registrationService.validDocumentNumberUnique(user)) {
                modelMap.put("errorMsgDocumentNumber", errorMsgDocumentNumber2);
                isFormValid = false;
            }
        }
        if (!registrationService.validPatientNumber(user)) {
            modelMap.put("errorMsgPatientNumber", errorMsgPatientNumber);
            isFormValid = false;
        }
        if (user.getPatientNumber() != connectedUser.getPatientNumber() && user.getPatientNumber() != null) {
            if (!registrationService.validPatientNumberUnique(user)) {
                modelMap.put("errorMsgPatientNumber", errorMsgPatientNumber2);
                isFormValid = false;
            }
        }
        if (!registrationService.validNif(user)) {
            modelMap.put("errorMsgNif", errorMsgNif);
            isFormValid = false;
        }
        if (!user.getNif().equals(connectedUser.getNif())) {
            if (!registrationService.validNifUnique(user)) {
                modelMap.put("errorMsgNif", errorMsgNif2);
                isFormValid = false;
            }

        }
        if (!registrationService.validCity(user)) {
            modelMap.put("errorMsgCity", errorMsgCity);
            isFormValid = false;
        }
        if (!registrationService.validBirthday(user)) {
            modelMap.put("errorMsgBirthday", errorMsgBirthday);
            isFormValid = false;
        }
        if (!registrationService.validNationality(user)) {
            modelMap.put("errorMsgNationality", errorMsgNationality);
            isFormValid = false;
        }
        if (!registrationService.validAddress(user)) {
            modelMap.put("errorMsgAddress", errorMsgAddress);
            isFormValid = false;
        }

        if (file != null && !file.isEmpty() && !file.getContentType().equals("application/octet-stream")) {
            try {
                String photoURL = imageUploadService.uploadImage(file, userService.currentUser().getUsername());
                user.setPhotoURL(photoURL);
            } catch (IOException e) {
                modelMap.put("errorMsgPhotoUpload", errorMsgPhotoUpload);
                isFormValid = false;
            } catch (ImageTypeException e) {
                modelMap.put("errorMsgPhotoUpload", errorMsgImageType);
                isFormValid = false;
            } catch (ImageSizeException e) {
                modelMap.put("errorMsgPhotoUpload", String.format(errorMsgImageSize, imageUploadService.getImageMaxSize()));
                isFormValid = false;
            }
        } else {
            user.setPhotoURL(userService.currentUser().getPhotoURL());
        }


        if (!isFormValid) {
            // case error in info validation
            List<Nationality> nationalities = nationalityService.findAll();

            modelMap.put("nationalities", nationalities);

            modelMap.put("user_logged", userService.currentUser());
            modelMap.put("user", user);
            return "user/change-profile-data";
        }
        user.setUserId(userService.currentUser().getUserId());
        user.setEmail(userService.currentUser().getEmail());
        user.setUsername(userService.currentUser().getUsername());
        user.setPassword(userService.currentUser().getPassword());
        user.setAccount(userService.currentUser().getAccount());

        userService.addUser(user);

        return "redirect:/user/user-profile";
    }

    //change data form
    @GetMapping(value = "/user/user-profile")
    public String showUserProfile(ModelMap modelMap){
        User userLogged = userService.currentUser();

        modelMap.put("user_logged", userLogged);
        return "user/user-profile";
    }
    @GetMapping(value="/userToMain")
    public String showMainPage(){
        return "redirect:/";
    }

}
