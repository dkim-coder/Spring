package com.ssafy.controller;

import com.ssafy.model.dto.address.Gugun;
import com.ssafy.model.dto.attraction.Attraction;
import com.ssafy.model.service.address.IGugunService;
import com.ssafy.model.service.address.ISidoService;
import com.ssafy.model.service.attraction.IAttractionService;
import com.ssafy.model.service.attraction.IContentTypeService;
import jakarta.servlet.http.HttpServlet;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/attractions")
public class AttractionController extends HttpServlet {
    // API 키 관리
    private final String KEY_VWORLD = "E13864B1-3D24-333D-84DD-D2B97B734AD9";
    private final String KEY_SGIS_SERVICE_ID = "cfef0ec2689443208b60";
    private final String KEY_SGIS_SECURITY = "df17594dc994493fa696";
    private final String KEY_DATA = "UZywTSTfnQT0nk6ndLh7YN5maZMEFfQVfc3j2MYWjIni/ZvoClmf2idPt6ko0eKimiLqqf6/pHma87Co6+0GsQ==";
    private final IAttractionService attractionService;
    private final IGugunService gugunService;
    private final ISidoService sidoService;
    private final IContentTypeService contentTypeService;

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> addAttraction(@RequestBody Attraction attraction) {
        try {
            int no = attractionService.addAttraction(attraction);
            return ResponseEntity.ok(no);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/{no}")
    @ResponseBody
    public ResponseEntity<?> updateAttraction(@PathVariable int no, @RequestBody Attraction attraction) {
        try {
            attraction.setNo(no);
            boolean updated = attractionService.updateAttraction(attraction) > 0;
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/{no}")
    @ResponseBody
    public ResponseEntity<?> deleteAttraction(@PathVariable int no) {
        try {
            boolean deleted = attractionService.deleteAttraction(no) > 0;
            return ResponseEntity.ok(deleted);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    // --- 헬퍼 메서드 ---

    // 지도 페이지 요청 처리: DB에서 sidos, guguns, contentTypes 데이터를 가져와서 전달
    @GetMapping("/map")
    public String showMapPage(Model model) {
        try {
            model.addAttribute("sidos", sidoService.getAllSidos());
            model.addAttribute("guguns", gugunService.getAllGuguns());
            model.addAttribute("contentTypes", contentTypeService.getAllContentTypes());
        } catch (SQLException e) {
            model.addAttribute("sidos", Collections.emptyList());
            model.addAttribute("guguns", Collections.emptyList());
            model.addAttribute("contentTypes", Collections.emptyList());
        }
        model.addAttribute("keyVworld", KEY_VWORLD);
        model.addAttribute("keySgisServiceId", KEY_SGIS_SERVICE_ID);
        model.addAttribute("keySgisSecurity", KEY_SGIS_SECURITY);
        model.addAttribute("keyData", KEY_DATA);
        return "regionAttraction";
    }

    // 명소 상세 조회 처리
    @GetMapping("/detail/{no}")
    @ResponseBody
    public ResponseEntity<?> getDetail(@PathVariable int no) {
        try {
            Attraction attraction = attractionService.getAttractionDetail(no);
            return attraction != null ? ResponseEntity.ok(attraction)
                    : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }


    // 명소 목록 조회 처리
    @GetMapping
    @ResponseBody
    public ResponseEntity<?> getAttractions(@RequestParam int areaCode, @RequestParam int contentTypeId) {
        try {
            List<Attraction> list = attractionService.getAttractionsByAreaAndType(areaCode, contentTypeId);
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    // 구군 목록 조회 처리: /attractions/guguns?areaCode=...
    @GetMapping("/guguns")
    @ResponseBody
    public ResponseEntity<?> getGuguns(@RequestParam int areaCode) {
        List<Gugun> guguns = gugunService.getGugunsBySidoCode(areaCode);
        return ResponseEntity.ok(guguns);
    }
}
