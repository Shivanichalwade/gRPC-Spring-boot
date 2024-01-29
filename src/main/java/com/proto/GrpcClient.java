package com.proto;

import com.j4u.proto.CreateUserRequestMessage;
import com.j4u.proto.CreateUserResponseMessage;
import com.j4u.proto.UserServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {

    public static void main(String[] args) {
        // Define the server address and port
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext()
                .build();

        // Create a gRPC blocking stub
        UserServiceGrpc.UserServiceBlockingStub stub = UserServiceGrpc.newBlockingStub(channel);

        // Create a request
        CreateUserResponseMessage userResponseMessage = stub.createUser(CreateUserRequestMessage.newBuilder()
                        .setName("Shivani")
                        .build());
        channel.shutdown();
    }
}
