package com.carecheck.carecheck_back.controller;

import com.carecheck.carecheck_back.dto.request.ReqModifyNoticeDto;
import com.carecheck.carecheck_back.dto.request.ReqNoticeListSearchDto;
import com.carecheck.carecheck_back.dto.response.RespNoticeListSearchDto;
import com.carecheck.carecheck_back.service.NoticeService;
import jakarta.validation.constraints.Min;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.carecheck.carecheck_back.dto.request.ReqWriteNoticeDto;
import com.carecheck.carecheck_back.security.principal.PrincipalUser;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notices")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @Operation(summary = "공지사항 작성", description = "공지사항 작성")
    @PostMapping("")
    public ResponseEntity<?> createNotice(
            @RequestBody ReqWriteNoticeDto reqWriteNoticeDto,
            @AuthenticationPrincipal PrincipalUser principalUser
    ) {
        return ResponseEntity.ok().body(noticeService.createNotice(principalUser.getUser(), reqWriteNoticeDto));
    }

    @Operation(summary = "공지사항 전체 조회", description = "공지사항 전체 조회")
    @GetMapping("")
    public ResponseEntity<?> searchNoticeList(@ModelAttribute ReqNoticeListSearchDto dto) {

        int totalNoticeListCount = noticeService.getNoticeListCountBySearchText(dto.getSearchText());
        int totalPages = totalNoticeListCount % dto.getLimitCount() == 0
                ? totalNoticeListCount / dto.getLimitCount()
                : totalNoticeListCount / dto.getLimitCount() + 1;

        RespNoticeListSearchDto respNoticeListSearchDto =
                RespNoticeListSearchDto.builder()
                        .page(dto.getPage())
                        .limitCount(dto.getLimitCount())
                        .totalPages(totalPages)
                        .totalElements(totalNoticeListCount)
                        .isFirstPage(dto.getPage() == 1)
                        .isLastPage(dto.getPage() == totalPages)
                        .noticeList(noticeService.getNoticeListSearchBySearchOption(dto))
                        .build();

        return ResponseEntity.ok().body(respNoticeListSearchDto);
    }

    @Operation(summary = "공지사항 usecode 조회", description = "공지사항 usercode로 조회")
    @GetMapping("/mylist")
    public ResponseEntity<?> searchNoticeByUsercode(
            @AuthenticationPrincipal PrincipalUser principalUser,
            @ModelAttribute ReqNoticeListSearchDto dto
    ) {
        String usercode = principalUser.getUsercode();
        int totalNoticeListCount = noticeService.getNoticeListCountUsercodeBySearchText(usercode, dto.getSearchText());

        int totalPages = totalNoticeListCount % dto.getLimitCount() == 0
                ? totalNoticeListCount / dto.getLimitCount()
                : totalNoticeListCount / dto.getLimitCount() + 1;

        RespNoticeListSearchDto respNoticeListSearchDto =
                RespNoticeListSearchDto.builder()
                        .page(dto.getPage())
                        .limitCount(dto.getLimitCount())
                        .totalPages(totalPages)
                        .totalElements(totalNoticeListCount)
                        .isFirstPage(dto.getPage() == 1)
                        .isLastPage(dto.getPage() == totalPages)
                        .noticeList(noticeService.getNoticeListSearchByUsercode(usercode, dto.getSearchText(), dto.getPage(), dto.getLimitCount(), dto.getOrder()))
                        .build();

        return ResponseEntity.ok().body(respNoticeListSearchDto);
    }

    @Operation(summary = "공지사항 수정", description = "공지사항 수정")
    @PutMapping("/mylist/{noticeId}")
    public ResponseEntity<?> modifyNotice(
            @Min(value = 1, message = "noticeId는 1이상의 정수입니다.")
            @PathVariable int noticeId,
            @AuthenticationPrincipal PrincipalUser principalUser,
            @RequestBody ReqModifyNoticeDto reqModifyNoticeDto
    ) throws NotFoundException {
        return ResponseEntity.ok().body(noticeService.modiftyNotice(principalUser.getUsercode(), noticeId, reqModifyNoticeDto));
    }
    
    @Operation(summary = "공지사항 삭제", description = "공지사항 삭제")
    @DeleteMapping("/{noticeId}")
    public ResponseEntity<?> deleteNotice(@PathVariable int noticeId) {
        int result = noticeService.deleteNoticeById(noticeId);
        if (result == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("공지사항을 찾을 수 없습니다.");
        }

        return ResponseEntity.ok().body("공지사항이 삭제되었습니다.");
    }

    @Operation(summary = "조회수 증가", description = "조회수 추가")
    @PostMapping("/{noticeId}")
    public ResponseEntity<?> updateViewCount(@PathVariable int noticeId) {
        noticeService.updateViewCount(noticeId);
        return ResponseEntity.ok().build();
    }
}