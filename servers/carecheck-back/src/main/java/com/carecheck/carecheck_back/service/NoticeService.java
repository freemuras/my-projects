package com.carecheck.carecheck_back.service;

import com.carecheck.carecheck_back.dto.request.ReqModifyNoticeDto;
import com.carecheck.carecheck_back.dto.request.ReqNoticeListSearchDto;
import com.carecheck.carecheck_back.entity.NoticeSearch;
import com.carecheck.carecheck_back.dto.request.ReqWriteNoticeDto;
import com.carecheck.carecheck_back.entity.Notice;
import com.carecheck.carecheck_back.entity.User;
import com.carecheck.carecheck_back.repository.NoticeRepository;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NoticeService {
    @Autowired
    private NoticeRepository noticeRepository;
    
    @Transactional(rollbackFor = Exception.class)
    public Notice createNotice(User user, ReqWriteNoticeDto reqWriteNoticeDto) {

        Notice notice = Notice.builder()
                .usercode(user.getUsercode())
                .title(reqWriteNoticeDto.getTitle())
                .content(reqWriteNoticeDto.getContent())
                .build();
        return noticeRepository.saveNotice(notice);
    }

    @Transactional(readOnly = true)
    public List<NoticeSearch> getNoticeListSearchBySearchOption(ReqNoticeListSearchDto dto) {
        int startIndex = (dto.getPage() -1) * dto.getLimitCount();
        return noticeRepository.findNoticeListAllBySearchOption(
                startIndex, dto.getLimitCount(), dto.getOrder(), dto.getSearchText()
        );
    }

    public List<NoticeSearch> getNoticeListSearchByUsercode(String usercode, String searchText, int page, int limitCount, String order) {
        int startIndex = (page - 1) * limitCount;
        int limitSize = limitCount;

        return noticeRepository.findNoticeListSearchByUsercode(usercode, startIndex, limitSize, order, searchText);
    }


    @Transactional(rollbackFor = Exception.class)
    public Boolean modiftyNotice(String usercode, int noticeId, ReqModifyNoticeDto reqModifyNoticeDto) throws NotFoundException {
        return noticeRepository.updateUserById(usercode, reqModifyNoticeDto.toNotice(noticeId), noticeId)
                .orElseThrow(() -> new NotFoundException("해당 게시글이 존재하지 않습니다."));
    }

    @Transactional(rollbackFor = Exception.class)
    public int deleteNoticeById(int noticeId) {
        return  noticeRepository.deleteNoticeById(noticeId);

    }

    @Transactional(rollbackFor = Exception.class)
    public void updateViewCount(int noticeId) {
        noticeRepository.updateViewCount(noticeId);
    }

    @Transactional(readOnly = true)
    public int getNoticeListCountBySearchText(String searchText) {
        return noticeRepository.findNoticeCountAllBySearchText(searchText);
    }

    @Transactional(readOnly = true)
    public int getNoticeListCountUsercodeBySearchText(String usercode, String searchText) {
        return noticeRepository.findNoticeCountUsercodeBySearchText(usercode, searchText);
    }
}
