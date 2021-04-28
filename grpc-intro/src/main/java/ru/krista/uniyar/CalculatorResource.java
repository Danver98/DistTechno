package ru.krista.uniyar;

import io.quarkus.calc.CalculatorProto;
import io.quarkus.grpc.runtime.annotations.GrpcService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("calc")
public class CalculatorResource {

    @Inject
    @GrpcService("calculator")
    io.quarkus.calc.CalculatorServiceGrpc.CalculatorServiceBlockingStub client;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String result() {
        return "Result is ";
    }

    @GET
    @Path("/add/{op1}/{op2}")
    double add(@PathParam("op1") double op1, @PathParam("op2") double op2){
        return client.calculate(CalculatorProto.CalculatorRequest.newBuilder().setNumber1(op1).setNumber2(op2).
                setOperation(CalculatorProto.CalculatorRequest.OperationType.ADD).build()).getResult();
    }

    @GET
    @Path("/sub/{op1}/{op2}")
    double subtract(@PathParam("op1") double op1, @PathParam("op2") double op2){
        return client.calculate(CalculatorProto.CalculatorRequest.newBuilder().setNumber1(op1).setNumber2(op2).
                setOperation(CalculatorProto.CalculatorRequest.OperationType.SUBTRACT).build()).getResult();
    }

    @GET
    @Path("/mul/{op1}/{op2}")
    double multiply(@PathParam("op1") double op1, @PathParam("op2") double op2){
        return client.calculate(CalculatorProto.CalculatorRequest.newBuilder().setNumber1(op1).setNumber2(op2).
                setOperation(CalculatorProto.CalculatorRequest.OperationType.MULTIPLY).build()).getResult();
    }

    @GET
    @Path("/div/{op1}/{op2}")
    double divide(@PathParam("op1") double op1, @PathParam("op2") double op2){
        return client.calculate(CalculatorProto.CalculatorRequest.newBuilder().setNumber1(op1).setNumber2(op2).
                setOperation(CalculatorProto.CalculatorRequest.OperationType.DIVIDE).build()).getResult();
    }

    /*@GET
    @Path("/{operand1}/{operand2}/{operation}")
    public double calc(@PathParam("operand1") double op1, @PathParam("operand2") double op2, @PathParam("operation") String op) {

        CalculatorProto.CalculatorRequest.OperationType operation = CalculatorProto.CalculatorRequest.OperationType.ADD;
        switch(op){
            case "a":
                operation = CalculatorProto.CalculatorRequest.OperationType.ADD;
                break;
            case "s":
                operation = CalculatorProto.CalculatorRequest.OperationType.SUBTRACT;
                break;
            case "m":
                operation = CalculatorProto.CalculatorRequest.OperationType.MULTIPLY;
                break;
            case "d":
                operation = CalculatorProto.CalculatorRequest.OperationType.DIVIDE;
                break;
            default:
                break;
        }
        return client.calculate(CalculatorProto.CalculatorRequest.newBuilder().setNumber1(op1).setNumber2(op2).
                setOperation(operation).build()).getResult();
    }*/
}