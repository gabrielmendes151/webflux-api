package com.code.webfluxapi.playlist;

import com.code.webfluxapi.playlist.model.Playlist;
import com.code.webfluxapi.playlist.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

//@Component
public class PlaylistHandler {

    @Autowired
    private PlaylistService service;

    public Mono<ServerResponse> findAll(ServerRequest request) {
        return ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(service.findAll(), Playlist.class);
    }

    public Mono<ServerResponse> findById(ServerRequest request) {
        var id = request.pathVariable("id");
        return ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(service.findById(id), Playlist.class);
    }

    public Mono<ServerResponse> save(ServerRequest request) {
        final var playlist = request.bodyToMono(Playlist.class);
        return ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(fromPublisher(playlist.flatMap(service::save), Playlist.class));
    }
}
