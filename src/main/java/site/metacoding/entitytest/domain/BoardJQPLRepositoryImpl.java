package site.metacoding.entitytest.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.qlrm.mapper.JpaResultMapper;

import lombok.RequiredArgsConstructor;
import site.metacoding.entitytest.web.dto.BoardDetailRespDto;

@RequiredArgsConstructor
public class BoardJQPLRepositoryImpl implements BoardJQPLRepository {
    // interface는 변수가 전부 static이라 변수를 만들수가 없다.

    private final EntityManager em;

    // createQuery => DB 모델과 타입이 같아야함 => BoardRepository 사용하면됨;
    // createNativeQuery => 진짜 내맘대로 쿼리 (PrepareStatement)
    // return 값 = 1, 제목1, 내용1, true => Dto에 Board로 받을경우 생긴게 달라서 안들어가짐.
    public BoardDetailRespDto mFindDetail(Integer id) {
        String sql = "SELECT b.*, true FROM board b WHERE id = ?";
        Query query = em.createNativeQuery(sql)
                .setParameter(1, id);
        Object[] result = (Object[]) query.getSingleResult();
        Integer boardId = (Integer) result[0];
        String title = (String) result[1];
        String content = (String) result[2];
        boolean isLove = (boolean) result[3];

        BoardDetailRespDto dto = new BoardDetailRespDto(boardId, title, content, isLove);
        return dto;
    }

    public List<BoardDetailRespDto> mFindAll() {
        String sql = "SELECT b.*, true FROM board b ";
        Query query = em.createNativeQuery(sql);
        List<Object[]> results = (List<Object[]>) query.getResultList();
        List<BoardDetailRespDto> dtos = new ArrayList<>();
        for (Object[] result : results) {
            Integer boardId = (Integer) result[0];
            String title = (String) result[1];
            String content = (String) result[2];
            boolean isLove = (boolean) result[3];
            BoardDetailRespDto dto = new BoardDetailRespDto(boardId, title, content, isLove);
            dtos.add(dto);
        }
        return dtos;
    }

    public List<BoardDetailRespDto> mFindAllQLRM() {
        String sql = "SELECT b.*, true FROM board b ";
        Query query = em.createNativeQuery(sql);
        JpaResultMapper mapper = new JpaResultMapper();
        List<BoardDetailRespDto> dtos = mapper.list(query, BoardDetailRespDto.class);
        return dtos;
    }
}
