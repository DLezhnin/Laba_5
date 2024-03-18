package inno.lab5.service.impl;

import inno.lab5.model.Agreement;
import inno.lab5.service.AgreementService;
import inno.lab5.web.model.request.AgreementRequest;
import inno.lab5.web.model.response.AgreementResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class DatabaseAgreementService implements AgreementService {

//    @Autowired
//    private final DatabaseAgreementRepository AgreementRepository;
//    private final ProductService databaseProductService;;

    @Override
    public Agreement save(AgreementRequest request) {
        Agreement agreement = new Agreement();
        agreement.setGeneralAgreementId(request.getGeneralAgreementId());
        agreement.setSupplementaryAgreementId(request.getSupplementaryAgreementId());
        agreement.setArrangementType(request.getArrangementType());
        agreement.setShedulerJobId(request.getShedulerJobId());
        agreement.setNumber(request.getNumber());
        agreement.setOpeningDate(request.getOpeningDate());
        agreement.setCancelDate(request.getCancelDate());
        agreement.setValidityDuration(request.getValidityDuration());
        agreement.setCancellationReason(request.getCancellationReason());
        agreement.setInterestCalculationDate(request.getInterestCalculationDate());
        agreement.setInterestRate(request.getInterestRate());
        agreement.setCoefficient(request.getCoefficient());
        agreement.setCoefficientAction(request.getCoefficientAction());
        agreement.setMinimumInterestRate(request.getMinimumInterestRate());
        agreement.setMinimumInterestRateCoefficient(request.getMinimumInterestRateCoefficient());
        agreement.setMinimumInterestRateCoefficientAction(request.getMinimumInterestRateCoefficientAction());

        return agreement;
    }

    @Override
    public AgreementResponse agreementToResponse(Agreement agreement) {
        AgreementResponse agreementResponse = new AgreementResponse();

        agreementResponse.setId(agreement.getId());
        agreementResponse.setGeneralAgreementId(agreement.getGeneralAgreementId());
        agreementResponse.setSupplementaryAgreementId(agreement.getSupplementaryAgreementId());
        agreementResponse.setArrangementType(agreement.getArrangementType());
        agreementResponse.setShedulerJobId(agreement.getShedulerJobId());
        agreementResponse.setNumber(agreement.getNumber());
        agreementResponse.setOpeningDate(agreement.getOpeningDate());
        agreementResponse.setCancelDate(agreement.getCancelDate());
        agreementResponse.setValidityDuration(agreement.getValidityDuration());
        agreementResponse.setCancellationReason(agreement.getCancellationReason());
        agreementResponse.setInterestCalculationDate(agreement.getInterestCalculationDate());
        agreementResponse.setInterestRate(agreement.getInterestRate());
        agreementResponse.setCoefficient(agreement.getCoefficient());
        agreementResponse.setCoefficientAction(agreement.getCoefficientAction());
        agreementResponse.setMinimumInterestRate(agreement.getMinimumInterestRate());
        agreementResponse.setMinimumInterestRateCoefficient(agreement.getMinimumInterestRateCoefficient());
        agreementResponse.setMinimumInterestRateCoefficientAction(agreement.getMinimumInterestRateCoefficientAction());

        return agreementResponse;
    }

    @Override
    public List<AgreementResponse> agreementListToResponseList(List<Agreement> agreements) {
        return agreements.stream()
                .map(this::agreementToResponse)
                .collect(Collectors.toList());
    }
}

