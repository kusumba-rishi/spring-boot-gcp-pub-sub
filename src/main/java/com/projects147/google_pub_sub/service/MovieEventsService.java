package com.projects147.google_pub_sub.service;

import com.projects147.google_pub_sub.model.MovieMessagePayload;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MovieEventsService {
    
    public void processEvents(MovieMessagePayload movieMessage) {

    }
}
