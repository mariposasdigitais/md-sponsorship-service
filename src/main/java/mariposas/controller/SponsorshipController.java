package mariposas.controller;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import mariposas.exception.BaseException;
import mariposas.model.PaginatedMentees;
import mariposas.model.ResponseModel;
import mariposas.model.SponsorshipModel;
import mariposas.service.JwtService;
import mariposas.service.UserService;

import static mariposas.constant.AppConstant.LOGIN_FAIL;

@Controller
public class SponsorshipController implements SponsorshipApi {
    private final JwtService jwtService;
    private final UserService userService;

    public SponsorshipController(JwtService jwtService, UserService userService) {
        this.jwtService = jwtService;
        this.userService = userService;
    }

    @Override
    public ResponseModel cancelSponsorship(String token, String emailMentee, String emailMentor) {
        if (jwtService.validate(token, emailMentor) && jwtService.isValid(token)) {
            return userService.cancelSponsorship(emailMentee, emailMentor);
        } else {
            throw new BaseException(HttpStatus.UNPROCESSABLE_ENTITY, LOGIN_FAIL);
        }
    }

    @Override
    public PaginatedMentees getMenteesList(String token, String email, Integer limit, Integer page) {
        if (jwtService.validate(token, email) && jwtService.isValid(token)) {
            return userService.getMenteesList(limit, page);
        } else {
            throw new BaseException(HttpStatus.UNPROCESSABLE_ENTITY, LOGIN_FAIL);
        }
    }

    @Override
    public ResponseModel sponsoringMentee(String token, SponsorshipModel sponsorshipModel) {
        if (jwtService.validate(token, sponsorshipModel.getEmailMentor()) && jwtService.isValid(token)) {
            return userService.sponsoringMentee(sponsorshipModel);
        } else {
            throw new BaseException(HttpStatus.UNPROCESSABLE_ENTITY, LOGIN_FAIL);
        }
    }
}