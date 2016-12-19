package com.cardpay.JRService;

import com.cardpay.service.SingerId;
import com.cardpay.service.Song;
import com.cardpay.service.SongList;
import com.cardpay.service.SongService2Grpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Created by JR on 2016/8/25.
 */
public class JRServiceClient {
  private static final Logger logger = Logger.getLogger(JRServiceClient.class.getName());

  private final ManagedChannel channel;
  private final SongService2Grpc.SongService2BlockingStub blockingStub;
  private final SongService2Grpc.SongService2Stub asyncStub;

  public JRServiceClient(String hots, int port) {
    channel = ManagedChannelBuilder.forAddress(hots, port)
        // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
        // needing certificates.
        .usePlaintext(true)
        .build();
    blockingStub = SongService2Grpc.newBlockingStub(channel);
    asyncStub = SongService2Grpc.newStub(channel);
  }

  public void shutdown() throws InterruptedException {
    channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
  }

  public void getSongList() {
    logger.info("call listSongs() method : ");
    SingerId request = SingerId.newBuilder().setId(1).build();
    SongList songList = blockingStub.listSongs2(request);
    for (Song song : songList.getSongsList()) {
      logger.info(song.toString());
    }
    logger.info("finished!");
  }

  public void getSongsUsingStream() {
    logger.info("call getSongs() method : ");
    SingerId request = SingerId.newBuilder().setId(1).build();
    Iterator<Song> iterator = blockingStub.getSongs2(request);
    while (iterator.hasNext()) {
      logger.info(iterator.next().toString());
    }
    logger.info("finished!");
  }

  public void getSongsUsingAsyncStub() throws InterruptedException {
    logger.info("call getSongs() method using asynchronous stub : ");
    SingerId request = SingerId.newBuilder().setId(1).build();
    final CountDownLatch latch = new CountDownLatch(1); // using CountDownLatch

    StreamObserver<Song> responseObserver = new StreamObserver<Song>() {
      @Override
      public void onNext(Song value) {
        logger.info("get song :" + value.toString());
      }

      @Override
      public void onError(Throwable t) {
        Status status = Status.fromThrowable(t);
        logger.info("failed with status : " + status );
        latch.countDown();
      }

      @Override
      public void onCompleted() {
        logger.info("finished!");
        latch.countDown();
      }
    };

    asyncStub.getSongs2(request, responseObserver);
    latch.await();
  }

//  public static void main(String[] args) throws InterruptedException{
//    JRServiceClient client = new JRServiceClient("localhost", 50051);
//    try {
//      client.getSongList();
//      client.getSongsUsingStream();
//      client.getSongsUsingAsyncStub();
//    } finally {
//      client.shutdown();
//    }
//  }
}
