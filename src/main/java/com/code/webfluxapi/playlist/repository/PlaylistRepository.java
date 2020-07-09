package com.code.webfluxapi.playlist.repository;

import com.code.webfluxapi.playlist.model.Playlist;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlaylistRepository extends ReactiveMongoRepository<Playlist, String> {
}
