package inno.lab5.mapper;

import inno.lab5.model.Agreement;
import inno.lab5.model.Product;
import inno.lab5.model.Register;
import inno.lab5.service.AgreementService;
import inno.lab5.service.RegisterService;
import inno.lab5.service.impl.DatabaseProductService;
import inno.lab5.web.model.request.AgreementRequest;
import inno.lab5.web.model.request.RegisterRequest;
import inno.lab5.web.model.response.ProductResponse;
import inno.lab5.web.model.request.ProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductMapper {

    @Autowired
    private final RegisterService registerService;
    @Autowired
    private final AgreementService agreementService;
    @Autowired
    private final DatabaseProductService productService;

    public Product requestToProduct(ProductRequest request){

        if (request.getId() != null){
            Product product = productService.findById(request.getId());
            System.out.println("product_id = "+product);
        }

            Product product = new Product();
            List<Register> listReg = new ArrayList<>();
            List<RegisterRequest> listRegReq = request.getProductRegisters();
            for (RegisterRequest lst : listRegReq) {
                Register register = registerService.requestToRegister(lst);
                register.setProductid(product);
                listReg.add(register);
            }
            List<Agreement> listAgr = new ArrayList<>();
            List<AgreementRequest> listAgrReq = request.getAgreements();
            for (AgreementRequest lst : listAgrReq) {
                Agreement agreement = agreementService.save(lst);
                agreement.setProductid(product);
                listAgr.add(agreement);
            }
            product.setProductCodeId(request.getProductCodeId());
            product.setClientid(request.getClient());
            product.setType(request.getType());
            product.setNumber(request.getNumber());
            product.setPriority(request.getPriority());
            product.setDateOfConclusion(request.getDateOfConclusion());
            product.setStartDateTime(request.getStartDateTime());
            product.setEndDateTime(request.getEndDateTime());
            product.setDays(request.getDays());
            product.setPenaltyRate(request.getPenaltyRate());
            product.setNso(request.getNso());
            product.setThresholdAmount(request.getThresholdAmount());
            product.setRequisiteType(request.getRequisiteType());
            product.setInterestRateType(request.getInterestRateType());
            product.setTaxRate(request.getTaxRate());
            product.setReasoneClose(request.getReasonClose());
            product.setState(request.getState());
            product.setRegisters(listReg);
            product.setAgreements(listAgr);

            return product;
    }

    public ProductResponse productToResponse(Product product){
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setProductCodeId(product.getProductCodeId());
        productResponse.setClient(product.getClientid());
        productResponse.setType(product.getType());
        productResponse.setNumber(product.getNumber());
        productResponse.setPriority(product.getPriority());
        productResponse.setDateOfConclusion(product.getDateOfConclusion());
        productResponse.setStartDateTime(product.getStartDateTime());
        productResponse.setEndDateTime(product.getEndDateTime());
        productResponse.setDays(product.getDays());
        productResponse.setPenaltyRate(product.getPenaltyRate());
        productResponse.setNso(product.getNso());
        productResponse.setThresholdAmount(product.getThresholdAmount());
        productResponse.setRequisiteType(product.getRequisiteType());
        productResponse.setInterestRateType(product.getInterestRateType());
        productResponse.setTaxRate(product.getTaxRate());
        productResponse.setReasonClose(product.getReasoneClose());
        productResponse.setState(product.getState());
        productResponse.setProductRegisters(registerService.productRegisterListToResponseList(product.getRegisters()));
        productResponse.setAgreements(agreementService.agreementListToResponseList(product.getAgreements()));
        return productResponse;
    }
}
