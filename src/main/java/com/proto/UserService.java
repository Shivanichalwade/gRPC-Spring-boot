package com.proto;

import com.j4u.proto.CreateUserRequestMessage;
import com.j4u.proto.CreateUserResponseMessage;
import com.j4u.proto.UserServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;


@GrpcService
public class UserService extends UserServiceGrpc.UserServiceImplBase {

    /**
     * Unary operation to create user
     *
     * @param request
     * @param responseObserver
     */
    @Override
    public void createUser(CreateUserRequestMessage request, StreamObserver<CreateUserResponseMessage> responseObserver) {

        // We have mocked the employee data.
        // In real world this should be fetched from database or from some other source
        CreateUserResponseMessage empResp = CreateUserResponseMessage.newBuilder().setName(request.getName()).setName("Shivani")
                .setId(1).build();

        // set the response object
        responseObserver.onNext(empResp);

        // mark process is completed
        responseObserver.onCompleted();
    }
}
