package com.cardpay.core.grpc;

import com.cardpay.basic.common.log.LogTemplate;
import com.cardpay.basic.util.PropertiesUtil;
import io.grpc.BindableService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * Created by JR on 2016/8/25.
 */
@Component
public class GRPCServer {

  @Autowired
  private ApplicationContext applicationContext;

  /* The port on which the server should run */
  private Server server;
  private int port;

  private void init(){
    port = Integer.parseInt(PropertiesUtil.getProperties("gRPC.port"));
//    server = ServerBuilder.forPort(port).addService(new SongServiceImplTwo()).addService(new SongServiceImplOne()).build();
    ServerBuilder<?> serverBuilder = ServerBuilder.forPort(port);
    Map<String, GRPCService> gRPCServiceMap = applicationContext.getBeansOfType(GRPCService.class);
    for (Map.Entry<String, GRPCService> gRPCServiceEntry : gRPCServiceMap.entrySet()) {
        serverBuilder.addService((BindableService) gRPCServiceEntry.getValue());
    }
    server = serverBuilder.build();
  }

  /**
   * 启动gRPC服务
   *
   * @throws IOException IO异常
   */
  public void start() throws IOException {
    init();
    server.start();
    LogTemplate.info("gRPC server started","listening on " + port);

    Runtime.getRuntime().addShutdownHook(new Thread() {
      @Override
      public void run() {
        // Use stderr here since the logger may have been reset by its JVM shutdown hook.
        LogTemplate.debug("gRPC","shutting down gRPC server since JVM is shutting down");
        GRPCServer.this.stop();
        LogTemplate.debug("gRPC","server shut down");
      }
    });
  }

  private void stop() {
    if (server != null) {
      server.shutdown();
    }
  }

  /**
   * Await termination on the main thread since the gRPC library uses daemon threads.
   */
  public void blockUntilShutdown() throws InterruptedException {
    if (server != null) {
      server.awaitTermination();
    }
  }
}