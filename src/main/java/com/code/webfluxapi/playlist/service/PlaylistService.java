package com.code.webfluxapi.playlist.service;

import com.code.webfluxapi.playlist.model.Playlist;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlaylistService {

    Flux<Playlist> findAll();

    Mono<Playlist> findById(String id);

    Mono<Playlist> save (Playlist playlist);
}
