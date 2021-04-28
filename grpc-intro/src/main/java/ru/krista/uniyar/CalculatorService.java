package ru.krista.uniyar;

import io.grpc.stub.StreamObserver;
import io.quarkus.calc.CalculatorProto;

import javax.inject.Singleton;

@Singleton
public class CalculatorService extends io.quarkus.calc.CalculatorServiceGrpc.CalculatorServiceImplBase {

    @Override
    public void calculate(CalculatorProto.CalculatorRequest request, StreamObserver<CalculatorProto.CalculatorResponse> responseObserver) {
        double result = 0;
        switch(request.getOperation()){
            case ADD:
                result = request.getNumber1() + request.getNumber2();
                break;
            case SUBTRACT:
                result = request.getNumber1() - request.getNumber2();
                break;
            case MULTIPLY:
                result = request.getNumber1() * request.getNumber2();
                break;
            case DIVIDE:
                result = request.getNumber1() / request.getNumber2();
                break;
            default:
                break;
        }
        responseObserver.onNext(CalculatorProto.CalculatorResponse.newBuilder().setResult(result).build());
        responseObserver.onCompleted();
    }
}
