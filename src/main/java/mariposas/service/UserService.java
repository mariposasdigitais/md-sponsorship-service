package mariposas.service;

import mariposas.model.PaginatedMentees;
import mariposas.model.ResponseModel;
import mariposas.model.SponsorshipModel;

public interface UserService {

    PaginatedMentees getMenteesList(Integer limit, Integer page);

    ResponseModel sponsoringMentee(SponsorshipModel sponsorshipModel);

    ResponseModel cancelSponsorship(String emailMentee, String emailMentor);
}