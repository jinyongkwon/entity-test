package site.metacoding.entitytest.domain;

import java.util.List;

import org.springframework.stereotype.Repository;

import site.metacoding.entitytest.web.dto.BoardDetailRespDto;

@Repository
public interface BoardJPQLRepository {
    BoardDetailRespDto mFindDetail(Integer id);

    List<BoardDetailRespDto> mFindAll();

    List<BoardDetailRespDto> mFindAllQLRM();
}
