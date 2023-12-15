package com.example.pension.mappers;

import com.example.pension.dto.NoticeDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface NoticeMapper {

    @Insert("insert into board_notice values(null, #{boardNoticeSubject}, #{boardNoticeWriter}, #{boardNoticeContent}, now(), 0, 1)")
    void setWriteNotice(NoticeDto noticeDto);

    @Select("select * from board_notice ${searchQuery} order by board_notice_id desc limit ${startNum}, ${offset}")
    List<NoticeDto> getNotice(Map<String, Object> map);

    @Select("select ifnull(max(board_notice_grp) + 1, 1) as maxGrp from board_notice")
    int getMaxGrp();

    @Select("select count(*) from board_notice")
    int totalCount();

    @Select("select count(*) from board_notice ${searchQuery}")
    int getListCount(String searchQuery);
}
