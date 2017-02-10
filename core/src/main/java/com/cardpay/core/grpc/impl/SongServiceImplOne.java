package com.cardpay.core.grpc.impl;

import com.cardpay.core.grpc.*;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SongServiceImplOne extends SongServiceOneGrpc.SongServiceOneImplBase implements GRPCService {

    @Override
    public void listSongs(SingerId request, StreamObserver<SongList> responseObserver) {
      SongList list = SongList.newBuilder().addAllSongs(genFakeSongs(request)).build();
      responseObserver.onNext(list);
      responseObserver.onCompleted();
    }

    @Override
    public void getSongs(SingerId request, StreamObserver<Song> responseObserver) {
      List<Song> songs = genFakeSongs(request);
      for (Song song : songs) {
        responseObserver.onNext(song);
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          responseObserver.onError(e);
        }
      }
      responseObserver.onCompleted();
    }

    public List<Song> genFakeSongs(SingerId request) {
      Singer pf = Singer.newBuilder().setId(request.getId()).setName("歌手one").build();
      List<Song> songs = new ArrayList<>();
      songs.add(Song.newBuilder().setId(1).setName("歌曲1").setSinger(pf).build());
      songs.add(Song.newBuilder().setId(2).setName("歌曲2").setSinger(pf).build());
      songs.add(Song.newBuilder().setId(3).setName("歌曲3").setSinger(pf).build());
      return songs;
    }
  }