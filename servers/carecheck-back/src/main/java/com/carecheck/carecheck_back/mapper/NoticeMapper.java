package com.carecheck.carecheck_back.mapper;

import com.carecheck.carecheck_back.entity.NoticeSearch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.carecheck.carecheck_back.entity.Notice;

import java.util.List;

@Mapper
public interface NoticeMapper {

    int insertNotice(Notice notice);

    int updateNoticeByNoticeId(
            @Param("usercode") String usercode,
            @Param("notice") Notice notice,
            @Param("noticeId") int noticeId);

    int deleteNotice(int noticeId);

    List<NoticeSearch> selectNoticeBySearchOption(
            @Param("startIndex") int startIndex,
            @Param("limitCount") int limitCount,
            @Param("order") String order,
            @Param("searchText") String searchText
    );

    List<NoticeSearch> selectNoticeByUsercode(
            @Param("usercode") String usercode,
            @Param("startIndex") int startIndex,
            @Param("limitCount") int limitCount,
            @Param("order") String order,
            @Param("searchText") String searchText);

    int selectNoticeCountAllBySearchText(@Param("searchText") String searchText);
    int selectNoticeCountUsercodeBySearchText(@Param("usercode") String usercode, @Param("searchText") String searchText);

    int increaseViewCount(int noticeId);

}