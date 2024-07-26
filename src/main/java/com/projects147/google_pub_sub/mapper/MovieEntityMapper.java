package com.projects147.google_pub_sub.mapper;

import com.projects147.google_pub_sub.entity.Movie;
import com.projects147.google_pub_sub.model.MovieMessagePayload;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MovieEntityMapper {

    MovieEntityMapper MOVIE_ENTITY_MAPPER = Mappers.getMapper(MovieEntityMapper.class);

    @Mapping(target = "id", source = "messageId")
    @Mapping(target = "movieName", source = "payload.name")
    @Mapping(target = "releaseYear", source = "payload.releaseYear")
    Movie map(String messageId, MovieMessagePayload payload);
}
