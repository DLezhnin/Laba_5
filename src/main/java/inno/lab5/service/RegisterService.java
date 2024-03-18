package inno.lab5.service;

import inno.lab5.model.Register;
import inno.lab5.web.model.request.RegisterRequest;
import inno.lab5.web.model.response.RegisterResponse;

import java.util.List;

public interface RegisterService {
    Register requestToRegister(RegisterRequest request);
    RegisterResponse RegisterToResponse(Register register);
    List<RegisterResponse> productRegisterListToResponseList(List<Register> registers);
}
