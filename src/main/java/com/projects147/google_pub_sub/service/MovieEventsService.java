package com.projects147.google_pub_sub.service;

import com.projects147.google_pub_sub.model.MovieMessagePayload;
import com.projects147.google_pub_sub.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.projects147.google_pub_sub.mapper.MovieEntityMapper.MOVIE_ENTITY_MAPPER;

@Service
@RequiredArgsConstructor
@Slf4j
public class MovieEventsService {

    private final MovieRepository movieRepository;

    public void processEvents(String messageId, MovieMessagePayload movieMessage) {
        log.info("Processing messageId: {}", messageId);
        movieRepository.save(MOVIE_ENTITY_MAPPER.map(messageId, movieMessage));
        log.info("Processed messageId: {}", messageId);
    }
}
