package com.cardpay.core.grpc.impl;

import com.cardpay.core.grpc.GRPCService;
import com.cardpay.core.grpc.Singer;
import com.cardpay.core.grpc.SingerId;
import com.cardpay.core.grpc.Song;
import com.cardpay.core.grpc.SongList;
import com.cardpay.core.grpc.SongServiceTwoGrpc;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SongServiceImplTwo extends SongServiceTwoGrpc.SongServiceTwoImplBase implements GRPCService {

    @Override
    public void listSongs2(SingerId request, StreamObserver<SongList> responseObserver) {
      SongList list = SongList.newBuilder().addAllSongs(genFakeSongs(request)).build();
      responseObserver.onNext(list);
      responseObserver.onCompleted();
    }

    @Override
    public void getSongs2(SingerId request, StreamObserver<Song> responseObserver) {
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
        Singer pf = Singer.newBuilder().setId(request.getId()).setName("歌手Two").build();
        List<Song> songs = new ArrayList<>();
        songs.add(Song.newBuilder().setId(1).setName("歌曲4").setSinger(pf).build());
        songs.add(Song.newBuilder().setId(2).setName("歌曲5").setSinger(pf).build());
        songs.add(Song.newBuilder().setId(3).setName("歌曲6").setSinger(pf).build());
      return songs;
    }
  }