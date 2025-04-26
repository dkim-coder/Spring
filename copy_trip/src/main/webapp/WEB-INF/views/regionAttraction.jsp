<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>지역별 관광정보 - ENJOY_TRIP</title>
    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
          crossorigin="anonymous"/>
    <style>
        #map {
            width: 100%;
            height: 500px;
            margin-top: 20px;
            border: 1px solid #ccc;
        }

        .container {
            padding: 30px;
        }

        .select-box {
            display: flex;
            gap: 10px;
            justify-content: center;
            margin-bottom: 20px;
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
        }
    </style>

</head>
<body>
<%--@ include file="/fragments/header.jsp" --%>
<div class="container">
    <h2>지역별 관광정보</h2>
    <div class="select-box">
        <!-- 시도 선택 -->
        <div class="col-md-4">
            <select id="areaCode" class="form-select">
                <option value="" selected disabled>시도 선택</option>
                <c:forEach var="sido" items="${sidos}">
                    <option value="${sido.sidoCode}">${sido.sidoName}</option>
                </c:forEach>
            </select>
        </div>
        <!-- 시군구 선택: DB의 guguns 데이터를 사용 -->
        <div class="col-md-4">
            <select id="sigunguCode" class="form-select">
                <option value="" selected disabled>시군구 선택</option>
                <c:forEach var="gugun" items="${guguns}">
                    <option value="${gugun.gugunCode}" data-sido="${gugun.sidoCode}">${gugun.gugunName}</option>
                </c:forEach>
            </select>
        </div>
        <!-- 관광타입 선택 -->
        <div class="col-md-4">
            <select id="contentType" class="form-select">
                <option value="" selected disabled>관광타입 선택</option>
                <option value="12">관광지</option>
                <option value="14">문화시설</option>
                <option value="15">축제공연행사</option>
                <option value="25">여행코스</option>
                <option value="28">레포츠</option>
                <option value="32">숙박</option>
                <option value="38">쇼핑</option>
                <option value="39">음식점</option>
            </select>
        </div>
    </div>
    <div class="text-center mb-3">
        <button id="btn_trip_search" class="btn btn-primary">관광지 조회</button>
    </div>
    <!-- 주소 정보 테이블 (회원의 주소 정보를 보여주는 경우) -->
    <!-- <div>
      <table class="table table-bordered" id="table-user-address">
        <thead>
          <tr>
            <th>주소 제목</th>
            <th>주소</th>
            <th>상세 주소</th>
            <th>편집</th>
          </tr>
        </thead>
        <tbody id="address-body"></tbody>
      </table>
    </div>  -->
    <div id="map"></div>
</div>
<%--@ include file="/fragments/footer.jsp" --%>

<!-- Bootstrap JS Bundle -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>

<!-- API 키들을 JavaScript 변수에 할당 (EL 변수명과 동일하게) -->
<script>
    const keyVworld = `${keyVworld}`;
    const keySgisServiceId = `${keySgisServiceId}`;
    const keySgisSecurity = `${keySgisSecurity}`;
    const keyData = `${keyData}`;
</script>
<script type="text/javascript"
        src="https://sgisapi.kostat.go.kr/OpenAPI3/auth/javascriptAuth?consumer_key=cfef0ec2689443208b60"></script>
<script>
    // 지도 생성: sop.map 사용
    let map = sop.map('map');
    // 마커 저장용 배열 초기화 (없으면 forEach에서 에러 발생)
    map.mks = [];
    // 초기 지도 설정: 중심 좌표 및 줌 레벨 설정
    // map.setView([37.58208588280000000, 126.98466168560000000], 7);
    const marker = sop.marker()
    map.setView(sop.utmk(953820, 1953437), 9);
    // 주소 정보 표시 (예: 회원의 주소 정보를 지도 및 테이블에 반영)
    const addrInfos = [];
    <c:forEach var="addr" items="${member.addresses}">
    addrInfos.push({
        ano: "${addr.ano}",
        address: "${addr.address}",
        detailAddress: "${addr.detailAddress}",
        title: "${addr.title}",
        x: "${addr.x}",
        y: "${addr.y}"
    });
    </c:forEach>

    // 시도 선택 시, 해당 구군 옵션만 남기도록 필터링 (클라이언트 측)
    const areaSelect = document.getElementById("areaCode");
    const gugunSelect = document.getElementById("sigunguCode");
    const allGugunOptions = Array.from(gugunSelect.options);
    areaSelect.addEventListener("change", function () {
        const selectedArea = this.value;
        gugunSelect.innerHTML = '<option value="" selected disabled>시군구 선택</option>';
        allGugunOptions.forEach(option => {
            if (option.dataset.sido === selectedArea) {
                gugunSelect.appendChild(option.cloneNode(true));
            }
        });
    });

    // 관광지 조회 함수: 선택한 시도와 관광타입(및 필요하면 시군구)을 파라미터로 Ajax 요청
    function searchAttractions() {
        const areaCode = document.getElementById("areaCode").value;
        const contentType = document.getElementById("contentType").value;
        // 값이 비어있다면 경고 후 함수 종료
        if (!areaCode || !contentType) {
            alert("시도와 관광타입을 선택해 주세요.");
            return;
        }
        // URL 구성
        const url = "${pageContext.request.contextPath}/attractions?areaCode="
            + areaCode + "&contentTypeId=" + contentType;

        fetch(url)
            .then(response => {
                if (!response.ok) {
                    throw new Error("서버 응답 오류");
                }
                return response.json();
            })
            .then(data => {
                // data가 배열인지 확인하고, 마커 추가 함수 호출
                if (Array.isArray(data)) {
                    console.log(data);
                    placeMarkers(data);
                } else {
                    console.error("반환된 데이터가 배열이 아닙니다.", data);
                    alert("관광지 데이터를 가져오는 중 오류가 발생했습니다.");
                }
            })
            .catch(error => {
                alert("조회 실패: " + error.message);
            });
    }

    // 지도에 마커 추가 함수
    function placeMarkers(attractionList) {
        // 기존 마커 제거
        if (map.mks && Array.isArray(map.mks)) {
            map.mks.forEach(marker => marker.remove());
        } else {
            map.mks = [];
        }

        // 각 관광지 데이터에 대해 마커 추가
        attractionList.forEach(a => {
            if (a && a.latitude && a.longitude) {
                // WGS84 좌표 (위도, 경도)를 UTMK 좌표로 변환
                const lat = parseFloat(a.latitude);
                const lon = parseFloat(a.longitude);
                if (!isNaN(lat) && !isNaN(lon)) {
                    // 변환: sop.LatLng를 사용하여 WGS84 -> UTMK 변환
                    const utmkCoord = new sop.LatLng(lat, lon);
                    // 생성된 utmkCoord 객체의 x, y를 배열로 전달
                    const marker = sop.marker([utmkCoord.x, utmkCoord.y]);
                    marker.addTo(map)
                        .bindInfoWindow(`${a.title}<br>${a.addr1 ? a.addr1 : ''} ${a.addr2 ? a.addr2 : ''}`);
                    // "click" 이벤트 등록
                    marker.on("click", () => {
                        alert(`[${a.title}] ${a.addr1 ? a.addr1 : ''} ${a.addr2 ? a.addr2 : ''}`);
                    });
                    map.mks.push(marker);
                }
            }
        });

        // 지도 중심 및 줌 조정: 첫 번째 관광지를 기준으로 설정
        if (attractionList.length > 0) {
            const first = attractionList.find(a => a && a.latitude && a.longitude);
            if (first) {
                const lat = parseFloat(first.latitude);
                const lon = parseFloat(first.longitude);
                if (!isNaN(lat) && !isNaN(lon)) {
                    const utmkCoord = new sop.LatLng(lat, lon);
                    map.setView(sop.utmk(utmkCoord.x, utmkCoord.y), 12);
                }
            }
        }
    }

    // "관광지 조회" 버튼 클릭 이벤트 연결
    document.getElementById("btn_trip_search").addEventListener("click", searchAttractions);


    // showAddress(addrInfos);

    // 주소 추가, 삭제 등 기타 이벤트 처리 (생략)
</script>
</body>
</html>
