package inno.lab5.service.impl;

import inno.lab5.model.Register;
import inno.lab5.service.RegisterService;
import inno.lab5.web.model.request.RegisterRequest;
import inno.lab5.web.model.response.RegisterResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DatabaseRegisterService implements RegisterService {

    @Override
    public Register requestToRegister(RegisterRequest request) {
        Register register = new Register();
        register.setType(request.getType());
        register.setAccount(request.getAccount());
        register.setCurrencyCode(request.getCurrencyCode());
        register.setState(request.getState());
        register.setAccountNumber(request.getAccountNumber());

        return register;
    }

    @Override
    public RegisterResponse RegisterToResponse(Register register) {
        RegisterResponse registerResponse = new RegisterResponse();

        registerResponse.setId(register.getId());
        registerResponse.setType(register.getType());
        registerResponse.setAccount(register.getAccount());
        registerResponse.setCurrencyCode(register.getCurrencyCode());
        registerResponse.setState(register.getState());
        registerResponse.setAccountNumber(register.getAccountNumber());

        return registerResponse;
    }

    @Override
    public List<RegisterResponse> productRegisterListToResponseList(List<Register> registers) {
        return registers.stream()
                .map(this::RegisterToResponse)
                .collect(Collectors.toList());
    }
}
