package inno.lab5.service;

import inno.lab5.model.Agreement;
import inno.lab5.web.model.request.AgreementRequest;
import inno.lab5.web.model.response.AgreementResponse;

import java.util.List;

public interface AgreementService {
    Agreement save(AgreementRequest agreement);
    AgreementResponse agreementToResponse(Agreement agreement);
    List<AgreementResponse> agreementListToResponseList(List<Agreement> agreements);
}
